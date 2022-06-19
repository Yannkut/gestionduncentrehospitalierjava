package com.example.demo.model.impressions;




import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Rendezvous;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFExporterRendezvous {
	
  

	private List<Rendezvous> listRendezvous;
	
  
	  public PDFExporterRendezvous(List<Rendezvous> listRendezvous) {
			super();
			this.listRendezvous = listRendezvous;
		}
	

		 
	  
    private void writeTableHeader(PdfPTable collection) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
         Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("id", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("Nom", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("Prenom", font));
        collection.addCell(cell);
       
        cell.setPhrase(new Phrase("Age", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("NumTelephone", font));
        collection.addCell(cell);    
        
        cell.setPhrase(new Phrase("Speciality", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("PlageHoraire", font));
        collection.addCell(cell);
        cell.setPhrase(new Phrase("Message", font));
        collection.addCell(cell);
    }
   
 



	



	private void writeTableData(PdfPTable collection) {
        for (Rendezvous rendezvous : listRendezvous) {
            collection.addCell(String.valueOf(rendezvous.getId()));
            collection.addCell(rendezvous.getNom());
            collection.addCell(rendezvous.getPrenom());
            collection.addCell(String.valueOf(rendezvous.getAge()));
            collection.addCell(String.valueOf(rendezvous.getNumTelephone()));
            collection.addCell(rendezvous.getSpeciality());
            collection.addCell(rendezvous.getPlageHoraire());
            collection.addCell(rendezvous.getMessage());
        }
    }
  
    public void export(HttpServletResponse response) throws DocumentException, IOException {
    	
    	Document document = new Document(PageSize.A4.rotate());
    	
        PdfWriter.getInstance(document,response.getOutputStream());
        
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        font.setColor(Color.BLUE);
      
        Paragraph p = new Paragraph("La Liste des Rendezvous", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
      
        document.add(p);
       
        
        PdfPTable pdft = new PdfPTable(8);
        
        pdft.setWidthPercentage(100f);
        pdft.setWidths(new float[] {0.5f, 2.5f, 3.0f, 1f, 2.0f, 2f,2.5f, 5.0f });
        pdft.setSpacingBefore(8);
       
        writeTableHeader(pdft);
        writeTableData(pdft);
        
        document.add(pdft);
       
        document.close();
       
    }
    
    
}


 


