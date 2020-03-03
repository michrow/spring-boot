package com.example.toolsdemo.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFOpsTool {
    private Document document = null;
    private PdfWriter writer = null;
    private BaseFont simfangFont = null;
    private Font font=null;


    public void createPDF(String filePath){
        try {
            this.document = new Document(PageSize.A4, 50, 50, 50, 50);
            this.writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            simfangFont=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            font = new Font(simfangFont, 14, Font.BOLD);

            /***添加页脚、水印***/
            PdfEventHandler eventHandler = PdfEventHandler.getInstance(font,simfangFont);
            writer.setPageEvent(eventHandler);

            document.open();
            Paragraph infoTitle = new Paragraph("验证PDF", font);
            document.add(infoTitle);
            writer.flush();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (document.isOpen()){
                    document.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (writer!=null && writer.isCloseStream()){
                    writer.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
