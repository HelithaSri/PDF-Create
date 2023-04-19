package lk.homies.pdf.controller;

import com.itextpdf.text.DocumentException;
import lk.homies.pdf.service.PDFService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Helitha Sri
 * @created 4/19/2023 - 2:05 PM
 * @project pdf
 */

@RestController
@RequestMapping("pdf")
public class PDFController {
    private final PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> generatePdf(){
        try {
            return pdfService.create();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
