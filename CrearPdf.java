package tarea3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


public class CrearPdf {
	
	public static void crear(ArrayList<DatosHorario> listaHorario) throws IOException, DocumentException 
	{	
		String dia ="";
		
		for(int a=0; a<Profesores.listaProfesores.size(); a++ )
		{

			 Document document =  new Document();

			 PdfWriter.getInstance(document,new FileOutputStream("c:/"+ Profesores.listaProfesores.get(a).nombre+".pdf"));
			 
			 document.open();
			
			 
			  Chunk titulo = new Chunk( Profesores.listaProfesores.get(a).nombre+"\n", FontFactory.getFont(FontFactory.COURIER, 30, BaseColor.BLUE));
			  document.add(titulo);
			  document.add(Chunk.NEWLINE);
			  
			  
			  Phrase phraseNormal0 = new Phrase(" ");
			  document.add(phraseNormal0);
			 
			  Phrase phraseNormal00 = new Phrase(" ");
			  document.add(phraseNormal00);
			  
			 for(int s=0; s<listaHorario.size(); s++)
			 {
				 if(listaHorario.get(s).nombreProfesor.equals(Profesores.listaProfesores.get(0).nombre))
				 {
					 
					if(listaHorario.get(s).dia.equals(dia))
					{}
					else
					{

						  document.add(Chunk.NEWLINE);
						  
						  Phrase phraseNormal = new Phrase(listaHorario.get(s).dia+"\n");
						  document.add(phraseNormal);

					}
					
					
					dia= listaHorario.get(s).dia;
					  
					
					document.add(Chunk.NEWLINE);
					  
					  Phrase phraseNormal1 = new Phrase(listaHorario.get(s).hora+"\n");
					  document.add(phraseNormal1);

					
					  
					  Phrase phraseNormal2 = new Phrase(listaHorario.get(s).nombreMateria+"  "+listaHorario.get(s).aula+"\n");
					  document.add(phraseNormal2);
  
				 }
			 }
			 
			 document.close();
		}
		
		
		
	}
}
