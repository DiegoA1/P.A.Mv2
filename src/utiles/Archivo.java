package utiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo
{
	File archivo;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;

	public Archivo(String archivo)
	{
		String ruta = getRuta(archivo);
		try
		{
			this.archivo = new File(ruta);
			if (!this.archivo.exists())
			{
				this.archivo.createNewFile();
			}
		} catch (Exception e)
		{
		}
	}
	public String getRuta(String archivo)
	{
		String ruta = "";
		String os = System.getProperty("os.name");
		if (os.contains("Windows"))
		{
			ruta = "C:\\P.A.M\\" + archivo;
		} else if (os.contains("Linux"))
		{
			ruta = System.getProperty("user.home") + "/P.A.M/" + archivo;
		}
		return ruta;
	}
	public String leerArchivo()
	{
		abrirLeer();
		String cadena = "";
		String cadenaFinal = "";
		try
		{
			while ((cadena = br.readLine()) != null)
			{
				cadenaFinal += cadena;
			}
		} catch (IOException e)
		{
			System.out.println("Error en br.readLine()");
		}
		cerrarLeer();
		return cadenaFinal;
	}
	public void escribirArchivo(String texto)
	{
		abrirEscribir();
		try
		{
			fw.append(texto + "*!");
		} catch (IOException e)
		{
			System.out.println("Error en fw.write(texto)");
		}
		cerrarEscribir();
	}
	public String[] entregarProcesado()
	{
		String[] datos;
		datos = leerArchivo().split("\\*!");
		return datos;
	}
	public void borrarLinea(String id)
	{
		String[] arch = entregarProcesado();
		for (int x = 0; x < arch.length; x++)
		{
			if (arch[x].split(";")[0].equals(id))
			{
				arch[x] = "";
				break;
			}
		}
		String[] nArch = new String[arch.length - 1];
		int z = 0;
		for (int x = 0; x < arch.length; x++)
		{
			if (arch[x].length() > 1)
			{
				nArch[z] = arch[x];
				z++;
			}
		}
		actArchivo(nArch);
	}
	public void actArchivo(String[] texto)
	{
		clearFile();
		abrirEscribir();
		for (int x = 0; x < texto.length; x++)
		{
			try
			{
				fw.append(texto[x] + "*!");
			} catch (IOException e)
			{
			}
		}
		cerrarEscribir();
	}
	public void clearFile()
	{
		try
		{
			fw = new FileWriter(archivo, false);
			fw.write("");
			fw.close();
		} catch (IOException e)
		{
			System.out.println("Error al instanciar FileWriter");
		}
	}
	private void abrirLeer()
	{
		try
		{
			fr = new FileReader(archivo);
		} catch (FileNotFoundException e)
		{
			System.out.println("Error al instanciar FileReader");
		}
		br = new BufferedReader(fr);
	}
	private void cerrarLeer()
	{
		try
		{
			fr.close();
		} catch (IOException e)
		{
			System.out.println("Error en fr.close()");
		}
		try
		{
			br.close();
		} catch (IOException e)
		{
			System.out.println("Error en br.close()");
		}
	}
	private void abrirEscribir()
	{
		try
		{
			fw = new FileWriter(archivo, true);
		} catch (IOException e)
		{
			System.out.println("Error al instanciar FileWriter");
		}
	}
	private void cerrarEscribir()
	{
		if (fw != null)
		{
			try
			{
				fw.close();
			} catch (IOException e)
			{
				System.out.println("No deberia ocurrir, pero weno\nError en fw.close()");
			}
		}
	}
}
