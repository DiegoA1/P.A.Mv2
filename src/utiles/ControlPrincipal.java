package utiles;

import java.time.YearMonth;
import java.util.ArrayList;

public class ControlPrincipal
{
	private String ruta;
	private String usuario;
	private Archivo archivo;

	public ControlPrincipal(String usuario)
	{
		this.usuario = usuario;
		getRuta();
		archivo = new Archivo(ruta);
	}
	public void añadir(String fecha, String documento, String fd, String desc, String ing, String egr)
	{
		int id = 1;
		int saldo = 0;
		String[] arch = archivo.entregarProcesado();
		String[] lastRow = arch[arch.length - 1].split(";");
		try
		{
			id = Integer.parseInt(lastRow[0]) + 1;
			saldo = Integer.parseInt(lastRow[lastRow.length - 1]) + Integer.parseInt(ing) - Integer.parseInt(egr);
		} catch (Exception e)
		{
		}
		String fila = id + ";" + fecha + ";" + documento + ";" + fd + ";" + desc + ";" + ing + ";" + egr + ";" + saldo;
		archivo.escribirArchivo(fila);
	}
	public void modificarFila(String id, String fecha, String documento, String fd, String desc, String ing, String egr)
	{
		String[] arch = archivo.entregarProcesado();
		for (int x = 0; x < arch.length; x++)
		{
			if (arch[x].split(";")[0].equals(id))
			{
				arch[x] = id + ";" + fecha + ";" + documento + ";" + fd + ";" + desc + ";" + ing + ";" + egr + ";"
						+ "0";
			}
		}
		actSaldos();
		archivo.actArchivo(arch);
	}
	public void eliminarFila(String id)
	{
		archivo.borrarLinea(id);
		actSaldos();
	}
	public void actSaldos()
	{
		String[] arch = archivo.entregarProcesado();
		for (int x = 0; x < arch.length; x++)
		{
			int saldoAnterior = 0;
			int saldo = 0;
			if (x > 0)
			{
				String[] aux = arch[x - 1].split(";");
				saldoAnterior = Integer.parseInt(aux[aux.length - 1]);
			}
			String textAux = "";
			String[] aux = arch[x].split(";");
			if (arch[x].length() > 1)
			{
				saldo = saldoAnterior + Integer.parseInt(aux[5]) - Integer.parseInt(aux[6]);
			}
			for (int z = 0; z < aux.length - 1; z++)
			{
				textAux += aux[z] + ";";
			}
			textAux += saldo;
			arch[x] = textAux;
		}
		archivo.actArchivo(arch);
	}
	public String[] getLastRow()
	{
		String[] arch = archivo.entregarProcesado();
		return arch[arch.length - 1].split(";");
	}
	public String[] getRow(int id)
	{
		String[] arch = archivo.entregarProcesado();
		return arch[id].split(";");
	}
	public int getRowCount()
	{
		String[] arch = archivo.entregarProcesado();
		return arch.length;
	}
	public boolean isFiled()
	{
		return (archivo.leerArchivo().length() > 1);
	}
	public String[][] resumenMes()
	{
		String[][] fin = new String[4][1];
		if (archivo.leerArchivo().length() > 5)
		{
			String[] arch = archivo.entregarProcesado();
			ArrayList<String> fechas = new ArrayList<String>();
			ArrayList<String> ings = new ArrayList<String>();
			ArrayList<String> egrs = new ArrayList<String>();
			for (int x = 0; x < arch.length; x++)
			{
				String fecha = arch[x].split(";")[1].split("/")[2] + "-" + arch[x].split(";")[1].split("/")[1];
				if (!fechas.contains(fecha))
				{
					fechas.add(fecha);
					ings.add("0");
					egrs.add("0");
				}
			}
			for (int x = 0; x < arch.length; x++)
			{
				String fecha = arch[x].split(";")[1].split("/")[2] + "-" + arch[x].split(";")[1].split("/")[1];
				String ing = arch[x].split(";")[5];
				String egr = arch[x].split(";")[6];
				int index = fechas.indexOf(fecha);
				ings.set(index, String.valueOf(Integer.parseInt(ings.get(index)) + Integer.parseInt(ing)));
				egrs.set(index, String.valueOf(Integer.parseInt(egrs.get(index)) + Integer.parseInt(egr)));
			}
			fin = new String[4][fechas.size()];
			for (int x = 0; x < fechas.size(); x++)
			{
				fin[0][x] = fechas.get(x);
				fin[1][x] = String.valueOf(Integer.parseInt(ings.get(x)) - Integer.parseInt(egrs.get(x)));
				fin[2][x] = ings.get(x);
				fin[3][x] = egrs.get(x);
			}
			fin = ordenarSaldos(fin);
		}
		return fin;
	}
	public String[][] ordenarSaldos(String[][] saldos)
	{
		boolean swapped = true;
		int j = 0;
		String tmp;
		String tmp1;
		String tmp2;
		String tmp3;
		while (swapped)
		{
			swapped = false;
			j++;
			for (int i = 0; i < saldos[0].length - j; i++)
			{
				YearMonth f1 = YearMonth.parse(saldos[0][i]);
				YearMonth f2 = YearMonth.parse(saldos[0][i + 1]);
				if (f1.isAfter(f2))
				{
					tmp = saldos[0][i];
					tmp1 = saldos[1][i];
					tmp2 = saldos[2][i];
					tmp3 = saldos[3][i];
					saldos[0][i] = saldos[0][i + 1];
					saldos[1][i] = saldos[1][i + 1];
					saldos[2][i] = saldos[2][i + 1];
					saldos[3][i] = saldos[3][i + 1];
					saldos[0][i + 1] = tmp;
					saldos[1][i + 1] = tmp1;
					saldos[2][i + 1] = tmp2;
					saldos[3][i + 1] = tmp3;
					swapped = true;
				}
			}
		}
		return saldos;
	}
	public int[] resumenDoc()
	{
		String[] arch = archivo.entregarProcesado();
		int[] docs = { 0, 0, 0};
		if (archivo.leerArchivo().length() > 5)
		{
			for (int x = 0; x < arch.length; x++)
			{
				String[] aux = arch[x].split(";");
				switch(aux[2])
				{
				case "Efectivo":
					docs[0] += Integer.parseInt(aux[5])-Integer.parseInt(aux[6]);
					break;
				case "Transferencia":
					docs[1] += Integer.parseInt(aux[5])-Integer.parseInt(aux[6]);
					break;
				case "Credito":
					docs[2] += Integer.parseInt(aux[5])-Integer.parseInt(aux[6]);
					break;
				}
			}
		}
		return docs;
	}
	public void getRuta()
	{
		String os = System.getProperty("os.name");
		if (os.contains("Windows"))
		{
			this.ruta = "C:\\P.A.M\\archivo";
		} else if (os.contains("Linux"))
		{
			this.ruta = System.getProperty("user.home") + "/P.A.M/" + this.usuario;
		}
	}
}
