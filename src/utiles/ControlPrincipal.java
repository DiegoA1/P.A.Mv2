package utiles;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControlPrincipal extends Archivo {

	public ControlPrincipal(String usuario) {

		super(usuario);
		ordenar();
		actId();
		actSaldos();
	}

	public void añadir(String fecha, String documento, String fd, String desc, String ing, String egr) {

		int id = 1;
		int saldo = 0;

		String[] arch = entregarProcesado();
		String[] lastRow = arch[arch.length - 1].split(";");
		if(isFiled()){
			
			id = Integer.parseInt(lastRow[0]) + 1;
			saldo = Integer.parseInt(lastRow[lastRow.length - 1]) + Integer.parseInt(ing) - Integer.parseInt(egr);
		}else{
			
			saldo = Integer.parseInt(ing) - Integer.parseInt(egr);
			
		}

		String fila = id + ";" + fecha + ";" + documento + ";" + fd + ";" + desc + ";" + ing + ";" + egr + ";" + saldo;

		escribirArchivo(fila);

	}

	public void modificarFila(String id, String fecha, String documento, String fd, String desc, String ing,
			String egr) {

		String[] arch = entregarProcesado();

		for (int x = 0; x < arch.length; x++) {

			if (arch[x].split(";")[0].equals(id)) {

				arch[x] = id + ";" + fecha + ";" + documento + ";" + fd + ";" + desc + ";" + ing + ";" + egr + ";"
						+ "0";

			}

		}

		actSaldos();
		actArchivo(arch);
	}

	public void eliminarFila(String id) {

		borrarLinea(id);
		actSaldos();

	}

	public void ordenar() {

		String[] arch = entregarProcesado();

		boolean swapped = true;
		int j = 0;
		String tmp;

		while (swapped) {

			swapped = false;
			j++;

			for (int i = 0; i < arch.length - j; i++) {

				Calendar f1 = new GregorianCalendar(Integer.parseInt(arch[i].split(";")[1].split("/")[2]),
						Integer.parseInt(arch[i].split(";")[1].split("/")[1]),
						Integer.parseInt(arch[i].split(";")[1].split("/")[0]));
				Calendar f2 = new GregorianCalendar(Integer.parseInt(arch[i + 1].split(";")[1].split("/")[2]),
						Integer.parseInt(arch[i + 1].split(";")[1].split("/")[1]),
						Integer.parseInt(arch[i + 1].split(";")[1].split("/")[0]));

				if (f1.after(f2)) {

					tmp = arch[i];
					arch[i] = arch[i + 1];
					arch[i + 1] = tmp;
					swapped = true;

				}

			}

		}
		actArchivo(arch);
	}

	public void actSaldos() {

		String[] arch = entregarProcesado();
		if(isFiled()){

			for (int x = 0; x < arch.length; x++) {

				int saldoAnterior = 0;
				int saldo = 0;

				if (x > 0) {

					String[] aux = arch[x - 1].split(";");
					saldoAnterior = Integer.parseInt(aux[aux.length - 1]);

				}

				String textAux = "";
				String[] aux = arch[x].split(";");

				if (arch[x].length() > 1) {

					saldo = saldoAnterior + Integer.parseInt(aux[5]) - Integer.parseInt(aux[6]);

				}

				for (int z = 0; z < aux.length - 1; z++) {

					textAux += aux[z] + ";";

				}

				textAux += saldo;
				arch[x] = textAux;

			}

			actArchivo(arch);
			
		}

	}

	public void actId() {

		String[] arch = entregarProcesado();
		int id = 1;
		for (int x = 0; x < arch.length; x++) {

			String[] aux = arch[x].split(";");
			aux[0] = String.valueOf(id);
			id++;

			String linea = "";
			for (int z = 0; z < aux.length; z++) {

				linea += aux[z] + ";";

			}

			arch[x] = linea;

		}
		actArchivo(arch);
	}

	public String[] getLastRow() {

		String[] arch = entregarProcesado();
		return arch[arch.length - 1].split(";");

	}

	public String[] getRow(int id) {

		String[] arch = entregarProcesado();
		return arch[id].split(";");

	}

	public int getRowCount() {

		String[] arch = entregarProcesado();
		return arch.length;

	}

	public boolean isFiled() {

		return (leerArchivo().length() > 5);

	}

	public String[][] resumenMes() {

		String[][] fin = new String[4][1];

		if (leerArchivo().length() > 5) {

			String[] arch = entregarProcesado();
			ArrayList<String> fechas = new ArrayList<String>();
			ArrayList<String> ings = new ArrayList<String>();
			ArrayList<String> egrs = new ArrayList<String>();

			for (int x = 0; x < arch.length; x++) {

				String fecha = arch[x].split(";")[1].split("/")[2] + "-" + arch[x].split(";")[1].split("/")[1];

				if (!fechas.contains(fecha)) {

					fechas.add(fecha);
					ings.add("0");
					egrs.add("0");

				}

			}

			for (int x = 0; x < arch.length; x++) {

				String fecha = arch[x].split(";")[1].split("/")[2] + "-" + arch[x].split(";")[1].split("/")[1];
				String ing = arch[x].split(";")[5];
				String egr = arch[x].split(";")[6];
				int index = fechas.indexOf(fecha);

				ings.set(index, String.valueOf(Integer.parseInt(ings.get(index)) + Integer.parseInt(ing)));
				egrs.set(index, String.valueOf(Integer.parseInt(egrs.get(index)) + Integer.parseInt(egr)));

			}

			fin = new String[4][fechas.size()];

			for (int x = 0; x < fechas.size(); x++) {

				fin[0][x] = fechas.get(x);
				fin[1][x] = String.valueOf(Integer.parseInt(ings.get(x)) - Integer.parseInt(egrs.get(x)));
				fin[2][x] = ings.get(x);
				fin[3][x] = egrs.get(x);

			}

			fin = ordenarSaldos(fin);

		}

		return fin;

	}

	public String[][] ordenarSaldos(String[][] saldos) {

		boolean swapped = true;
		int j = 0;
		String tmp;
		String tmp1;
		String tmp2;
		String tmp3;

		while (swapped) {

			swapped = false;
			j++;

			for (int i = 0; i < saldos[0].length - j; i++) {

				YearMonth f1 = YearMonth.parse(saldos[0][i]);
				YearMonth f2 = YearMonth.parse(saldos[0][i + 1]);

				if (f1.isAfter(f2)) {

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

	public int[] resumenDoc() {

		String[] arch = entregarProcesado();
		int[] docs = { 0, 0, 0 };

		if (leerArchivo().length() > 5) {

			for (int x = 0; x < arch.length; x++) {

				String[] aux = arch[x].split(";");

				switch (aux[2]) {

				case "Efectivo":

					docs[0] += Integer.parseInt(aux[5]) - Integer.parseInt(aux[6]);
					break;

				case "Transferencia":

					docs[1] += Integer.parseInt(aux[5]) - Integer.parseInt(aux[6]);
					break;

				case "Credito":

					docs[2] += Integer.parseInt(aux[5]) - Integer.parseInt(aux[6]);
					break;

				}

			}

		}

		return docs;

	}

}
