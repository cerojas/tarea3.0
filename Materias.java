package tarea3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Materias {
		
	public static List<DatosMaterias> listaMaterias = new ArrayList<DatosMaterias>();
	
	
	public static boolean validarMaterias(String nombre)
	{
		boolean existe= false;
		
		for(DatosMaterias a : listaMaterias)
		{
			if(a.nombre.equals(nombre))
			{
				existe = true;
			}
		}
		
		return existe;
	}
	
	
	
	
	public static void AgregarMaterias() throws IOException
	{
		InputStreamReader converte = new InputStreamReader(System.in);
		BufferedReader lee = new BufferedReader(converte);
		
		boolean salirMaterias =true;
		
		
		while(salirMaterias)
		{
			//verifica si el numero de creditos ha pasado el limite
			int contador =0;
			for (DatosMaterias a : listaMaterias) {
				contador += a.creditos;
				if(contador>84)
				{
					System.out.println("\nHa pasado el limites de credito semanal ya que las clases son de lunes a sabado de 8:00 am - 10:00 pm");
					salirMaterias =false;
					break;
				}
			}
			
			
			DatosMaterias datosMateria= new DatosMaterias();
			
			boolean sigue= true;
			
			inicio:
			while(sigue)
			{
				System.out.print("\nEscriba el nombre de la materia o 'S' para salir: ");
				datosMateria.nombre = lee.readLine();
				
				if(Materias.validarMaterias(datosMateria.nombre))
				{
					System.out.println("\nEste nombre ya fue agregado");
					continue inicio;
				}
				else{sigue=false;}
				
				
				if(datosMateria.nombre.toLowerCase().equals("s"))
				{
					salirMaterias= false;
					continue inicio;
				}
				
				System.out.print("Escriba el aula de la materia: o 'S' para salir: ");
				datosMateria.aula = lee.readLine();
				
				if(datosMateria.aula.toLowerCase().equals("s"))
				{
					salirMaterias= false;
					continue inicio;
				}
			}
			
			if(!salirMaterias){break;}
			
			sigue= true;
			while(sigue)
			{
				System.out.print("Escriba los creditos de la materia: o 'S' para salir:");
				String entrada = lee.readLine();
				
				if(entrada.toLowerCase().equals("s"))
				{
					salirMaterias= false;
					break;
				}
				
				if(IsNumero.IsInt(entrada))
				{
					datosMateria.creditos = Integer.parseInt(entrada);
					sigue= false;
				}
				else{System.out.println("\nEl valor debe ser numerico y entero!");}	
			}
			if(!salirMaterias){break;}
			
			
			
			listaMaterias.add(datosMateria);
		}

		
	}
	
	
	
	/*calcula total creditos*/
	public static int totalCreditos()
	{	
		int  total=0;
		for(DatosMaterias m : listaMaterias)
		{
			total += m.creditos;
		}
		
		return total;
	}
	
	
	/*imprime en pantalla las materias*/
	public static void imprimeMaterias()
	{	
		int  contador=1;
		System.out.println("#   Nombre         Aula         Creditos\n");
		
		for(DatosMaterias m : listaMaterias)
		{
			System.out.println(contador +"   "+ m.nombre +".........."+ m.aula +"..........."+ m.creditos);
			 contador++;
		}
		System.out.println("____________________");
		System.out.println("Total Materias: "+ (contador-1));
		System.out.println("Total Creditos: "+ totalCreditos());
	
	}
	
	
	
	public static void eliminarMateria() throws IOException
	{
		
		InputStreamReader converte = new InputStreamReader(System.in);
		BufferedReader lee = new BufferedReader(converte);
		
		boolean salir=true;
		 while(salir)
		 {
			 
			 imprimeMaterias();
			 
			 System.out.println("\nPulse el # de la materia para ELIMINAR o 'S' para SALIR");
			 String entrada= lee.readLine();
			 
			 //salir
			 if(entrada.toLowerCase().equals("s")){salir=false; break;}
			 
			 if(IsNumero.IsInt(entrada))
			 {
				 int n=Integer.parseInt(entrada);
				 if((n-1)<listaMaterias.size() && n>=0)
				 {
					 System.out.println("\nEsta seguro de ELIMINAR "+ listaMaterias.get(n-1).nombre +"?  y/n");
					 String eliminar= lee.readLine();
					 if(eliminar.toLowerCase().equals("y"))
					 {
						 listaMaterias.remove(n-1);
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
