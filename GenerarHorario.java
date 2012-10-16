package tarea3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class GenerarHorario
{
	/*en caso de que falten profesores, si no quiere agregar mas salimos con esta variable salir*/
	public static boolean salir= false;
	
	public static ArrayList<DatosHorario> horario = new ArrayList<DatosHorario>();
	
	public static void horario() throws IOException
	{
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader lee = new BufferedReader(converter);
				
		
		
		
		/*___________________________________________________________*/
		
		// variables 
		int contadorProfesores= Profesores.listaProfesores.size();  
		int veces=0; 
		int hora=8; 
		int cuentadias=0;
		int horasProfesores= Profesores.totalHorasProfesores();
		int creditos=Materias.totalCreditos();
		/*_________________________________________*/
		
		while(creditos>0)
		{
			for(int a=0; a<Materias.listaMaterias.size(); a++)
			{
				if(Materias.listaMaterias.get(a).creditos>0)
				{
					if(Materias.listaMaterias.get(a).creditos>4)
					{
						veces= Materias.listaMaterias.get(a).creditos/2;
					}
					else
					{
						veces= Materias.listaMaterias.get(a).creditos;
					}
					
					for(int v=0; v<veces; v++)
					{
						//guarda los datos del horario
						DatosHorario profesorMateria = new DatosHorario();
						
						profesorMateria.dia= generarDia(cuentadias);
						profesorMateria.hora= hora+":00";
						profesorMateria.aula= Materias.listaMaterias.get(a).aula;
						profesorMateria.nombreMateria = Materias.listaMaterias.get(a).nombre;
						
						profesorMateria.nombreProfesor = Profesores.listaProfesores.get(contadorProfesores-1).nombre;
						
						horario.add(profesorMateria);
						/*______________________________________________________________________________________________________*/
						
						//actualiza los creditos de la materia
						DatosMaterias materiaActualizar = new DatosMaterias();
						materiaActualizar = Materias.listaMaterias.get(a);
						
						materiaActualizar.creditos -=1;
						
						Materias.listaMaterias.set(a, materiaActualizar);
						/*________________________________________________________*/
						
						//actualiza las horas del profesor
						DatosProfesores profesorCambiar = new DatosProfesores();
						
						profesorCambiar = Profesores.listaProfesores.get(contadorProfesores-1);
						profesorCambiar.horas -=1;
						
						Profesores.listaProfesores.set(contadorProfesores-1, profesorCambiar);
						
					
						
						/*________________________________________________________________________*/
						
						
						
								//total de horas de profesores 
						
						 horasProfesores = Profesores.totalHorasProfesores();
						
						/*_____________________________________________________________*/
						
						
						
						if(horasProfesores>0)
						{
						
							if(contadorProfesores>1)
							{ 
								contadorProfesores--;
								contadorProfesores = Profesores.profesorDisponible(contadorProfesores);
								
							}
							else
							{ 
								contadorProfesores=Profesores.listaProfesores.size(); 
							}
						}
						else
						{	
							boolean seguir= true;
							while(seguir)
							{
								 System.out.println("\n\n\nFaltan creditos sin asignar y NO hay PROFESORES con horas disponibles");
								 System.out.print("Desea AGREGAR PROFESORES y/n: ");
								 		
								 String entrada= lee.readLine();
								 if(entrada.toLowerCase().equals("y"))
								 {
									 Profesores.agregarProfesor();
									 horasProfesores= Profesores.totalHorasProfesores();
									 contadorProfesores= Profesores.profesorDisponible(contadorProfesores);
									 seguir = false;
								 }
								 else if(entrada.toLowerCase().equals("n"))
								 {
									 salir=true;
									 seguir = false;
									
								 }
								 else{System.out.println("\n\n\nOpcion invalida !");}
							}
							
							if(salir){break;}
							
						}
						
						/*__________________________________________________________________________*/	
						
						
						//actualiza la hora
						if(hora==22){ hora=8; cuentadias++; }
						else{ hora++; }
						/*_________________________________________*/
						
					}//for veces
					if(salir){break;}
				}//fin if materiasCreditos >0 	
			}//fin for materias
			if(salir){break;}
			//inicializa la hora
			hora=8;
			/*________________________*/
			
			// incrementa los dias
			if(cuentadias==5){ cuentadias=0; }
			else{ cuentadias++; }
			/*___________________________________*/
			
			//CALCULA LOS CREDITOS
			creditos=Materias.totalCreditos();
			
			/*________________________________________________*/
				
		}//fin while
		
		try {
			CrearPdf.crear(horario);
			System.out.println("\n\nGenerado en c:/\n");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Debe cerrar el documento pdf si esta abierto, sino trate de nuevo!");
		}
	
		/*___________________________________________________________________________________________________________________*/
	
			
	}//fin metodo horario()
	
	
	
	
	
	
			//genera el dia del horario
	public static String generarDia(int contadorDia)
	{
		String dia;
		
		switch(contadorDia)
		{
			case 0:
				dia="Lunes";
			break;
			
			case 1:
				dia="Martes";
			break;
			
			case 2:
				dia="Miercoles";
			break;
			
			case 3:
				dia="Jueves";
			break;
			
			case 4:
				dia="Viernes";
			break;
			
			case 5:
				dia="Sabado";
			break;
			
			default:
				dia="Lunes";
			break;	
		}
		
		return dia;
	}
	

}
