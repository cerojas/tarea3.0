package tarea3;

import java.io.*;
import java.util.*;

public class Main
{
	
	public static void main(String[] args) throws IOException
	{

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader lee = new BufferedReader(converter);
  
		boolean salir1=true;
		while(salir1)
		{
			System.out.println("\n\n 1  Agregar Profesor");
			System.out.println(" 2  Agregar Materia");
			System.out.println(" 3  Lista de Materias ");
			System.out.println(" 4  Lista de Profesores ");
			System.out.println(" 5  Generar Horario");
			System.out.println("'S' Salir");
			
			System.out.print("\nEscriba la opcion deseada: ");
			String entrada= lee.readLine();
			
			if(entrada.toLowerCase().equals("s"))
			{
				salir1= false;
				break;
			}
			
			if(IsNumero.IsInt(entrada))
			{
				int opcion = Integer.parseInt(entrada);
				
				switch(opcion)
				{
					case 1:
						Profesores.agregarProfesor();
					break;
					
					
					case 2:
						 Materias.AgregarMaterias();
					break;
					
					case 3:
						Materias.eliminarMateria();
					break;
					
					case 4:
						Profesores.eliminarProfesor();
					break;
					
					case 5:
						GenerarHorario.horario();
				
					break;
					
					
					default:
						System.out.println("\n\nOpcion incorrecta!");
					break;
				}
			}
			else
			{
				System.out.println("\n\nEl valor debe ser numerico");
			}
				
		}
				
	}
}
















