package com.cglia.si.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cglia.si.model.Student;
import com.cglia.si.service.StudentService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class PDFController {

    @Autowired
    private StudentService service;

    @GetMapping("/getpdf")
    public void downloadPDF(HttpServletResponse response) {
        // Setting the response content type as PDF
        response.setContentType("application/pdf");
        // Setting the response header for file download
        response.setHeader("Content-Disposition", "attachment; filename=Student_List.pdf");

        try {
            // Creating an object of Document to represent PDF
            Document document = new Document();
            // Obtaining a PdfWriter object in connection with HttpServletResponse's OutputStream
            PdfWriter.getInstance(document, response.getOutputStream());
            // Opening the document
            document.open();

            // Defining font style, size, color for the title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.RED);
            //creating paragraph for the title 
            Paragraph title = new Paragraph("Student List", titleFont);
            //setting title alignment to center of PDF
            title.setAlignment(Element.ALIGN_CENTER);
            // Adding title to the document(PDF)
            document.add(title);

            // Adding a new line after title
            document.add(Chunk.NEWLINE);

            // getting all students from DB
            List<Student> students = service.show();

            if (!students.isEmpty()) {
                // Creating a Table with 8 columns
                PdfPTable table = new PdfPTable(8);
                // Defining column widths
                float[] columnWidths = {1f, 3f, 4f, 2f, 3f, 3f, 3f, 6f};
                table.setWidths(columnWidths);

                // Adding header cells to the table (headings row)
                table.addCell(createHeaderCell("ID"));
                table.addCell(createHeaderCell("Name"));
                table.addCell(createHeaderCell("Email"));
                table.addCell(createHeaderCell("Gender"));
                table.addCell(createHeaderCell("Father Name"));
                table.addCell(createHeaderCell("Mother Name"));
                table.addCell(createHeaderCell("Mobile No"));
                table.addCell(createHeaderCell("Address"));

                // Setting student data to the table cells
                for (Student student : students) {
                    table.addCell(createCell(String.valueOf(student.getId())));
                    table.addCell(createCell(student.getName()));
                    table.addCell(createCell(student.getEmail()));
                    table.addCell(createCell(student.getGender()));
                    table.addCell(createCell(student.getFatherName()));
                    table.addCell(createCell(student.getMotherName()));
                    table.addCell(createCell(String.valueOf(student.getMobile())));
                    table.addCell(createCell(student.getAddress()));
                }

                // Adding the table to the document(PDF)
                document.add(table);
            } else {
                // Adding a message for no records found
                document.add(new Paragraph("No Student records found."));
            }

            // Closing the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to create a header cell with specified content
    private PdfPCell createHeaderCell(String content) {
        //creates a table cell with given content/data
        PdfPCell cell = new PdfPCell(new Phrase(content));
        //aligning to center
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //setting background color
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        return cell;
    }

    // Method to create a cell with specified content
    private PdfPCell createCell(String content) {
        //creates a table cell with given content/data
        PdfPCell cell = new PdfPCell(new Phrase(content));
        //aligning to left
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }
}
