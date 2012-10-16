package tarea3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Profesores{
	
	public static List<DatosProfesores> listaProfesores = new ArrayList<DatosProfesores>();
	
	public static boolean validarProfesor(String nombre)
	{
		boolean exite= false;
		
		for(DatosProfesores a : listaProfesores)
		{
			if(a.nombre.equals(nombre))
			{
				exite = true;
			}
		}
		
		return exite;
	}
	
	
	public static void agregarProfesor() throws IOException
	{
		
		InputStreamReader converte = new InputStreamReader(System.in);
		BufferedReader lee = new BufferedReader(converte);
		
		boolean salirProfesores =true;
		
		inicio:
		while(salirProfesores)
		{
		
			DatosProfesores datosProfesor= new DatosProfesores();

			boolean sigue= true;
			
			
			while(sigue)
			{
				System.out.print("\n\nEscriba el NOMBRE Y CODIGO del profesor o 'S' para salir: ");
				datosProfesor.nombre= lee.readLine();
				
				if(Profesores.validarProfesor(datosProfesor.nombre))
				{
					System.out.print("\n\n\nEste nombre ya fue agregado");
				}
				else{sigue=false;}
				
				if(datosProfesor.nombre.toLowerCase().equals("s"))
				{
					salirProfesores= false;
					continue inicio;
				}
			
			}
			
			sigue= true;
			while(sigue)
			{
				
				System.out.print("Escriba horas de trabajo del profesor o 'S' para salir: ");
				String entrada = lee.readLine();
				
				if(entrada.toLowerCase().equals("s"))
				{
					salirProfesores= false;
					break;
				}
				
				if(IsNumero.IsInt(entrada))
				{
					if(Integer.parseInt(entrada)<=40)
					{
						
						datosProfesor.horas= Integer.parseInt(entrada);
						sigue= false;
					}
					else
					{
						System.out.println("\n\nEl numero de horas de trabajo debe ser menor de 40 !");
					}
					
				}
				else
				{
					System.out.println("\n\nEl valor debe ser numerico y entero !");
					
				}	
			}
			
			
			 listaProfesores.add(datosProfesor);
		}
		
			
	}


		//calcula total horas profesores
	public static int totalHorasProfesores()
	{
		int total=0;
		for(int s=0; s<Profesores.listaProfesores.size(); s++)
		{
			total += Profesores.listaProfesores.get(s).horas;
		}
		return total;
	}


		//buscar profesor con horas  disponibles
	public static int profesorDisponible(int contador)
	{
		int contadorProfesores=contador;
		while(Profesores.listaProfesores.get(contadorProfesores-1).horas==0)
		{
			if(contadorProfesores>1)
			{ 
				contadorProfesores--;
			}
			
			else
			{ 
				contadorProfesores=Profesores.listaProfesores.size(); 
			}
		}
		return contadorProfesores;
	}
	
	
	
	/*imprime en pantalla los profesores*/
	public static void imprimeProfesores()
	{	
		int  contador=1;
		System.out.println("\n\n\n\n#   Nombre         Horas\n");
		
		for(DatosProfesores m : listaProfesores)
		{
			System.out.println(contador +"   "+ m.nombre +".........."+ m.horas);
			 contador++;
		}
		System.out.println("_______________________");
		System.out.println("Total Profesores: "+ (contador-1));
		System.out.println("Total Horas: "+ totalHorasProfesores());
	
	}
	
	
	
	public static void eliminarProfesor() throws IOException
	{
		
		InputStreamReader converte = new InputStreamReader(System.in);
		BufferedReader lee = new BufferedReader(converte);
		
		boolean salir=true;
		 while(salir)
		 {
			 
			 imprimeProfesores();
			 
			 System.out.println("\nPulse el # del profesor para ELIMINAR o 'S' para SALIR");
			 String entrada= lee.readLine();
			 
			 //salir
			 if(entrada.toLowerCase().equals("s")){salir=false; break;}
			 
			 if(IsNumero.IsInt(entrada))
			 {
				 int n=Integer.parseInt(entrada);
				 if((n-1)<listaProfesores.size() &&  n>=0)
				 {
					 System.out.println("\nEsta seguro de eliminar a "+ listaProfesores.get(n-1).nombre +"?  y/n");
					 String eliminar= lee.readLine();
					 if(eliminar.toLowerCase().equals("y"))
					 {
						 listaProfesores.remove(n-1);
					 }
					 else if(eliminar.toLowerCase().equals("n"))
					 {
						 
					 }
					 else{System.out.println("\nOpcion incorrecta!");}
				 }
				 
			 }
			 else
			 {
				 System.out.println("\nEl dato debe ser numerico o 'S'!");
			 }
				
		 }
	}
}


