package com.example.demo.model.impressions;


import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.example.demo.model.User;
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

public class PDFExporterUser {
	
  

	private List<User> listUsers;
	
  
	  public PDFExporterUser(List<User> listUsers) {
			super();
			this.listUsers = listUsers;
		}
	
		 
	  
    private void writeTableHeader(PdfPTable collection) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
         Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("id", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("username", font));
        collection.addCell(cell);
      
        cell.setPhrase(new Phrase("password", font));
        collection.addCell(cell);
       
        cell.setPhrase(new Phrase("active", font));
        collection.addCell(cell);
        
        cell.setPhrase(new Phrase("roles", font));
        collection.addCell(cell);    
        
        cell.setPhrase(new Phrase("permissions", font));
        collection.addCell(cell);
    }
   
 



	



	private void writeTableData(PdfPTable collection) {
        for (User user : listUsers) {
            collection.addCell(String.valueOf(user.getId()));
            collection.addCell(user.getUsername());
            collection.addCell(user.getPassword());
            collection.addCell(String.valueOf(user.getActive()));
            collection.addCell(user.getRoles());
            collection.addCell(user.getPermissions());
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
      
        Paragraph p = new Paragraph("La Liste des Utilisateurs", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph p2 = new Paragraph("Liste établie par l'Administrateur", font);
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        document.add(p2);
        
        PdfPTable pdft = new PdfPTable(6);
        
        pdft.setWidthPercentage(100f);
        pdft.setWidths(new float[] {1.5f, 3.5f, 3.5f, 3.0f, 1.5f, 2f});
        pdft.setSpacingBefore(8);
       
        writeTableHeader(pdft);
        writeTableData(pdft);
        
        document.add(pdft);
       
        document.close();
       
    }
    
    
}


 

