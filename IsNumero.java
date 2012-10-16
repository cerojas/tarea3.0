package tarea3;

public class IsNumero
{
	public static boolean IsInt(String cadena)
	{
		
		try
		{
			Integer.parseInt(cadena);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		
	}
	
	public static boolean IsDouble(String cadena)
	{
		try
		{
			Double.parseDouble(cadena); 
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}