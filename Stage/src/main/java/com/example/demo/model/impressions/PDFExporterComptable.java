package com.example.demo.model.impressions;



import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Comptable;
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

public class PDFExporterComptable {
	
  

	
	private List<Comptable> listComptables;
	
  
	  public PDFExporterComptable(List<Comptable> listComptables) {
			super();
			this.listComptables = listComptables;
		}
	
	
		 
	  
    private void writeTableHeader(PdfPTable collection) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
         Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("id", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("name", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("sexe", font));
        collection.addCell(cell);
       
        cell.setPhrase(new Phrase("salaire", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("date d'embauche", font));
        collection.addCell(cell);
     
    }
   
 



	



	private void writeTableData(PdfPTable collection) {
        for (Comptable comptable : listComptables) {
            collection.addCell(String.valueOf(comptable.getId()));
            collection.addCell(comptable.getName());
            collection.addCell(comptable.getSexe());
            collection.addCell(String.valueOf(comptable.getSalaire()));
            collection.addCell(String.valueOf(comptable.getDatedembauche()));
           
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
      
        Paragraph p = new Paragraph("La Liste des Comptables", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph p2 = new Paragraph("Liste établie par l'Administrateur", font);
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        document.add(p2);
        
        PdfPTable pdft = new PdfPTable(5);
        
        pdft.setWidthPercentage(100f);
        pdft.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f,5.0f});
        pdft.setSpacingBefore(8);
       
        writeTableHeader(pdft);
        writeTableData(pdft);
        
        document.add(pdft);
       
        document.close();
       
    }
    
    
}


 





