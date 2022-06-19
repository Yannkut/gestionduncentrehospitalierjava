package com.example.demo.model.impressions;






import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Traitement;
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

public class PDFExporterTraitement {
	
  

	private List<Traitement> listTraitements;
	
  
	  public PDFExporterTraitement(List<Traitement> listTraitements) {
			super();
			this.listTraitements = listTraitements;
		}
	
	
		 
	  
    private void writeTableHeader(PdfPTable collection) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
         Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("id", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("NomPatient", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("NomMedecin", font));
        collection.addCell(cell);
       
        cell.setPhrase(new Phrase("Vaccins", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("Serums", font));
        collection.addCell(cell);    
        
        cell.setPhrase(new Phrase("Analyses", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("Prescription", font));
        collection.addCell(cell);
        cell.setPhrase(new Phrase("Radios", font));
        collection.addCell(cell);
    }
   
 



	



	private void writeTableData(PdfPTable collection) {
        for (Traitement traitement : listTraitements) {
            collection.addCell(String.valueOf(traitement.getId()));
            collection.addCell(traitement.getNomPatient());
            collection.addCell(traitement.getNomMedecin());
            collection.addCell(traitement.getVaccins());
            collection.addCell(traitement.getSerums());
            collection.addCell(traitement.getAnalyseschirurgicales());
            collection.addCell(traitement.getPrescriptionsmedicales());
            collection.addCell(traitement.getRadios());
            
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
      
        Paragraph p = new Paragraph("La Liste des Traitements", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph p2 = new Paragraph("Liste établie par le Médecin", font);
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        document.add(p2);
        
        PdfPTable pdft = new PdfPTable(8);
        
        pdft.setWidthPercentage(100f);
        pdft.setWidths(new float[] {0.5f, 2.5f, 3.0f, 1f, 2.0f, 3f,3f, 3f });
        pdft.setSpacingBefore(8);
       
        writeTableHeader(pdft);
        writeTableData(pdft);
        
        document.add(pdft);
       
        document.close();
       
    }
    
    
}


 



