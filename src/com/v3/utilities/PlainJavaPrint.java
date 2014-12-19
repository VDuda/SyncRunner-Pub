package com.v3.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

public class PlainJavaPrint {
	
	public static void main(String[] args) throws PrintException, IOException {
	    DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
	    PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
	    //patts.add(Sides.DUPLEX);
	    PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
	    if (ps.length == 0) {
	        throw new IllegalStateException("No Printer found");
	    }
	    System.out.println("Available printers: " + Arrays.asList(ps));

	    PrintService myService = null;
	    for (PrintService printService : ps) {
	        if (printService.getName().equals("UPS Thermal 2844")) {
	            myService = printService;
	            break;
	        }
	    }

	    if (myService == null) {
	        throw new IllegalStateException("Printer not found");
	    }

	    FileInputStream fis = new FileInputStream("C:\\Users\\B2E_2\\workspace\\QuickInventory\\barcodes.pdf");
	    Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
	    DocPrintJob printJob = myService.createPrintJob();
	    printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
	    fis.close();        
	}
}
