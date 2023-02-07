package org.example.pdfFile;

import com.google.gson.Gson;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.example.pdfFile.Album;

import java.io.*;

public class Main {
    public static void main(String[] args)  {

        Gson gson = new Gson();
            // Creating a PdfDocument
        try(PdfWriter writer = new PdfWriter( "src/main/resources/firstFile.pdf")) {
            // Creating a PdfWriter
            PdfDocument pdfDoc = new PdfDocument(writer);
            // Adding a new page
            pdfDoc.addNewPage();
            // Creating a Document
            Document document = new Document(pdfDoc);
            Paragraph paragraph=new Paragraph("List of Albums");
            document.add(paragraph);

            // gson file read
            File sours = new File("src/main/resources/package.json");
            BufferedReader reader = new BufferedReader(new FileReader(sours));
            Album[] albums = gson.fromJson(reader,Album[].class);


            // for bn aylanib jadval ichiga tashlaymiz
            // Creating a table
            float [] pointColumnWidths = {30F, 30, 300F};
            Table table = new Table(pointColumnWidths);
            // Adding cells to the table
            table.addCell("Id");
            table.addCell("User id");
            table.addCell("Title");

            for (Album album : albums) {
                table.addCell(album.getId().toString());
                table.addCell(album.getUserId());
                table.addCell(album.getTitle());
            }
            document.add(table);

            // Closing the document
            document.close();



        } catch (IOException ignored){
            System.out.println(ignored.getMessage());
        }


        System.out.println("PDF Created");

    }
}