package com.example.demo.model.impressions;




import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Consultation;
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

public class PDFExporterConsultation {
	
  

	private List<Consultation> listConsultations;
	
  
	  public PDFExporterConsultation(List<Consultation> listConsultations) {
			super();
			this.listConsultations = listConsultations;
		}
	
	
		 
	  
    private void writeTableHeader(PdfPTable collection) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
         Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("id", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("Taille", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("Poids", font));
        collection.addCell(cell);
       
        cell.setPhrase(new Phrase("Allergie", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("Antecedants", font));
        collection.addCell(cell);    
        
        cell.setPhrase(new Phrase("Contres Indications", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("Température", font));
        collection.addCell(cell);
  
    }
   
 



	



	private void writeTableData(PdfPTable collection) {
        for (Consultation consultation : listConsultations) {
            collection.addCell(String.valueOf(consultation.getId()));
            collection.addCell(String.valueOf(consultation.getTaille()));
            collection.addCell(String.valueOf(consultation.getPoids()));
            collection.addCell(consultation.getAllergie());
            collection.addCell(consultation.getAntecedants());
            collection.addCell(consultation.getContresindications());
            collection.addCell(String.valueOf(consultation.getTemperature()));
        }
    }
  
    public void export(HttpServletResponse response) throws DocumentException, IOException {
    	//document.setPageSize(Rectangle.A4.rotate());
    	//document.newPage();
    	Document document = new Document(PageSize.A4.rotate());
    	
        PdfWriter.getInstance(document,response.getOutputStream());
        
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        font.setColor(Color.BLUE);
      
        Paragraph p = new Paragraph("La Liste des Consultations", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph p2 = new Paragraph("Liste établie par les Médecins", font);
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        document.add(p2);
        
        PdfPTable pdft = new PdfPTable(7);
        
        pdft.setWidthPercentage(100f);
        pdft.setWidths(new float[] {0.5f, 2.5f, 3.0f, 1f, 2.0f, 2f,2.5f});
        pdft.setSpacingBefore(7);
       
        writeTableHeader(pdft);
        writeTableData(pdft);
        
        document.add(pdft);
       
        document.close();
       
    }
    
    
}


 


