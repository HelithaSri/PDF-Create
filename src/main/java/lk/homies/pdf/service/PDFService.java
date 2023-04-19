package lk.homies.pdf.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;


/**
 * @author Helitha Sri
 * @created 4/19/2023 - 2:06 PM
 * @project pdf
 */
@Service
public class PDFService {

    public ResponseEntity<String> create() throws DocumentException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,outputStream);
        document.open();

        Paragraph paragraph  = new Paragraph("Test Document");
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        document.addAuthor("HelithaSri");


        document.add(new Paragraph("Date : 2023-04-19"));
        document.add(new Paragraph("Name : Helitha Sri"));
        document.add(new Paragraph("City : Nawalapitiya"));

        ListItem elements = new ListItem();
        elements.add(0,new Paragraph("Sri"));
        elements.add(1,new Paragraph("Sri Max"));
        document.add(elements);


        document.close();

        // Set the response headers and body for the PDF document
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("test.pdf").build());

        byte[] pdfBytes = outputStream.toByteArray();

        return new ResponseEntity(pdfBytes, headers, HttpStatus.OK);

    }
}
