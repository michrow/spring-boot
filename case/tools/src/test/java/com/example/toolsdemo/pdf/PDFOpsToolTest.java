package com.example.toolsdemo.pdf;

import org.junit.Test;

import static org.junit.Assert.*;

public class PDFOpsToolTest {

    @Test
    public void createPDF() {
        PDFOpsTool pdfOpsTool = new PDFOpsTool();
        pdfOpsTool.createPDF("D:/temp/test.pdf");

    }
}