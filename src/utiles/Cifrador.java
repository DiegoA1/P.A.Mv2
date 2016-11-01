package utiles;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author idelcano
 */
@SuppressWarnings("restriction")
public class Cifrador
{
	private static Cifrador instancia;

	private Cifrador()
	{
	};
	public static Cifrador getInstance()
	{
		if (instancia == null)
			instancia = new Cifrador();
		return instancia;
	}

	byte[] iv = new byte[16];

	public String cifrar(String clave, String mensaje)
	{
		try
		{
			byte[] mensajeSinCifrar = mensaje.getBytes();
			SecretKeySpec key = crearSecretKeyUsuarioClave(clave, clave);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
			byte[] mensajeCifrado = cipher.doFinal(mensajeSinCifrar);
			return codificarBase64(mensajeCifrado);
		} catch (Exception e)
		{
			System.out.println("Error en el cifrado");
			e.printStackTrace();
		}
		return null;
	}
	public String descifrar(String clave, String mensaje)
	{
		try
		{
			SecretKeySpec key = crearSecretKeyUsuarioClave(clave, clave);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] mensajeCifrado = decodificarBase64(mensaje);
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			byte[] mensajeDescifrado = cipher.doFinal(mensajeCifrado);
			return new String(mensajeDescifrado);
		} catch (Exception e)
		{
			return "";
		}
	}
	private String codificarBase64(byte[] output)
	{
		return new BASE64Encoder().encode(output);
	}
	private byte[] decodificarBase64(String cadena)
	{
		try
		{
			return new BASE64Decoder().decodeBuffer(cadena);
		} catch (IOException ex)
		{
			System.out.println("Error con la decodificacion en base64");
			ex.printStackTrace();
		}
		return null;
	}
	private SecretKeySpec crearSecretKeyUsuarioClave(String usuario, String clave)
	{
		iv = truncarkey(usuario);
		byte[] key = clave.getBytes();
		key = truncarkey(clave);
		return new SecretKeySpec(key, "AES");
	}
	private byte[] truncarkey(String clave)
	{
		byte[] key = clave.getBytes();
		while (key.length != 16)
		{
			if (key.length < 16)
			{
				clave += "0";
				key = clave.getBytes();
			}
			if (key.length > 16)
			{
				clave = clave.substring(0, 16);
				key = clave.getBytes(); // TODO
			}
		}
		return key;
	}
}
