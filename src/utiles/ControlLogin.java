package utiles;

public class ControlLogin extends Archivo
{
	public ControlLogin()
	{
		super("userData");
	}
	public boolean añadirUsuario(String user, String pass, String pass2)
	{
		if (!isUser(user))
		{
			if (user.length() > 4)
			{
				if (pass.equals(pass2))
				{
					if (pass.length() > 6)
					{
						escribirArchivo(user + ";" + pass);
						return true;
					} else
					{
						javax.swing.JOptionPane.showMessageDialog(null, "La contraseña es muy corta", null,
								javax.swing.JOptionPane.ERROR_MESSAGE);
						return false;
					}
				} else
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", null,
							javax.swing.JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} else
			{
				javax.swing.JOptionPane.showMessageDialog(null, "El usuario es muy corto", null,
						javax.swing.JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else
		{
			javax.swing.JOptionPane.showMessageDialog(null, "El usuario ya existe ", null,
					javax.swing.JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	public boolean isUser(String user)
	{
		String[] arch = entregarProcesado();
		for (int x = 0; x < arch.length; x++)
		{
			if (arch[x].split(";")[0].equals(user))
			{
				return true;
			}
		}
		return false;
	}
	public boolean isUserPass(String user,String pass)
	{
		String[] arch = entregarProcesado();
		for(int x = 0; x < arch.length; x++)
		{
			if(arch[x].split(";")[0].equals(user)&&arch[x].split(";")[1].equals(pass))
			{
				return true;
			}
		}
		return false;
	}
}
