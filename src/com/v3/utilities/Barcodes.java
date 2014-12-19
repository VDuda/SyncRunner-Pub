package com.v3.utilities;

/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 * 
 * Redesigned by Volodimir Duda to fit specific needs
 */

import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Barcodes { // Should probably make this more thread safe by making it only STATIC

    /** The resulting PDF. */
    private static final String RESULT = "barcodes2.pdf";
    
    /** PAGE SIZES */ // 1 inch = 72
    private static final float WIDTH = 144f;
    private static final float HEIGHT = 144f;
    
    /** Key Barcode Variables */
    private static String upc = "000000000000";
    private static String sku = "000000-00000";
    private static String binRack = "";

    /** - This may be changed
     * Generates a PDF file with different types of barcodes.
     * 
     * @param UPC , SKU , BinRack
     *            no arguments needed here
     * @throws DocumentException
     * @throws IOException
     * @throws PrinterException 
     * @throws IllegalArgumentException 
     * @throws NullPointerException 
     */
    public Barcodes(String RESULT,String upc, String sku, String binRack) throws IOException,
            DocumentException, NullPointerException, IllegalArgumentException, PrinterException {
        createPdf(RESULT, upc, sku, binRack);
        
        print();
    }
    
/** *DEMO*
    public static void main(String[] args) 
    		throws NullPointerException, IllegalArgumentException, 
    		IOException, DocumentException, PrinterException{
    	new Barcodes(RESULT,"759451367919","1N00NO-03419","");
    	System.out.println("Done");
    }
*/

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document, UPC SKU BinRack
     * Can be null, Default values set statically
     * @throws    DocumentException 
     * @throws    IOException
     */
    public static void createPdf(String filename, String upc, String sku, String binRack) 
    		throws IOException, DocumentException {
    	if(filename==null || filename.isEmpty())
    		filename = RESULT;
    	if(upc==null || upc.isEmpty()){
    		upc = getUpc();
    	}else{
    		setUpc(upc);
    	}
    	if(sku==null || sku.isEmpty()){
    		sku = getSku();
    	}else{
    		setSku(sku.toUpperCase());
    	}
    	if(binRack==null || binRack.isEmpty()){
    		getBinRack();
    	}
    	else{
    		setBinRack(binRack);
    	}
    	
        // step 1
    	// 1 inch = 72
    	// thus 2.25" x 1.25" = 162 x 90 
        Document document = new Document();
        
        document.setPageSize(new Rectangle(WIDTH,HEIGHT));

        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();

        // UPC A
        
        //Generate Image of UPC-A
        Image barImage = generateUPC(cb,upc);
        //barImage.setRotationDegrees(90f);
        barImage.setAbsolutePosition(7,10);
        barImage.setRotationDegrees(90f);
        //Add this Image to Document
        document.add(barImage);
        
        //Coda128
        barImage = generate128(cb,sku);
        //barImage.setRotationDegrees(90f);
        barImage.setAbsolutePosition(37,10);
        barImage.setRotationDegrees(90f);
        //Add this Image to Document
        document.add(barImage);
        
        //Text - BinRack
        BaseFont bf = BaseFont.createFont();
        cb.beginText();
        cb.setFontAndSize(bf, 24);
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT, binRack, 27, 90, 90f);
        cb.endText();
        
        
        // step 5
        document.close();
        
    }
    
    /*private void PlaceChunk(PdfContentByte cb,String text, int x, int y) {
        try{
    	BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.saveState();
        cb.beginText();
        
        cb.moveText(x, y);
        cb.setFontAndSize(bf, 12);
        cb.showText(text);
        cb.endText();
        cb.restoreState();
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
    
    /**
     * The Config method to creating the desired UPC-A
     * @param cb - PdfContentByte
     * @param upc - A 12 digit String representation of the UPC
     * @return An Image of the UPC
     */
    private static Image generateUPC(PdfContentByte cb, String upc){
    	BarcodeEAN codeEAN = new BarcodeEAN();
        codeEAN.setCodeType(Barcode.UPCA);
        codeEAN.setCode(upc);
        codeEAN.setSize(7);
        codeEAN.setBaseline(6f);
        codeEAN.setBarHeight(20f);
        codeEAN.setX(.7f);
        
        return codeEAN.createImageWithBarcode(cb, null, null);
    }
    
    private static Image generate128(PdfContentByte cb, String sku){
    	Barcode128 code128 = new Barcode128();
    	code128.setCodeType(Barcode128.CODE_A);
    	code128.setGuardBars(true);
        code128.setCode(sku);
        code128.setSize(7);
        code128.setBaseline(6f);
        code128.setBarHeight(27f);
        code128.setX(.70f);
        
        return code128.createImageWithBarcode(cb, null, null);
    }
    
    //THIS WORKS, BUT it will only print one direction, you are unable to change this. 
    public static void print() throws IOException, NullPointerException, IllegalArgumentException, PrinterException{
    	/*PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        pf.setOrientation(PageFormat.PORTRAIT);
        Paper paper = new Paper();
        paper.setSize(WIDTH,HEIGHT);
        double margin = 0;
        System.out.println("PAPER Width: "+paper.getWidth());
        paper.setImageableArea(margin, margin, paper.getWidth()  - margin, paper.getHeight() - margin);
        System.out.println("Width: "+paper.getImageableWidth());
        System.out.println(paper.getImageableHeight());
        System.out.println("Orientation:" +pf.getOrientation());
        pf.setPaper(paper);*/
        
        //i suspect that these pageformats are being ignored

        // PDFBox
        PDDocument document = PDDocument.load(RESULT);
        //document.silentPrint(job);
        
        document.silentPrint();
        document.close();
        /*PDPageable p = new PDPageable(document, job);
        
        System.out.println("Printing");
        System.out.println("Before "+p.getPageFormat(0).getWidth());
        System.out.println("Before "+p.getPageFormat(0).getImageableWidth());
        System.out.println("Before "+p.getPageFormat(0).getOrientation());
        p.getPageFormat(0).setPaper(paper);
        System.out.println("Test P: "+paper.getWidth());
        System.out.println("Test P: "+p.getPageFormat(0).getPaper().getWidth());
        System.out.println("Test P: "+p.getPageFormat(0).getWidth());
        p.getPageFormat(0).setOrientation(PageFormat.PORTRAIT);
        System.out.println("AFTER "+p.getPageFormat(0).getWidth());
        System.out.println("After "+p.getPageFormat(0).getImageableWidth());
        System.out.println("After "+p.getPageFormat(0).getOrientation());
        job.setJobName("Functioning");
        job.setPageable(p);
        try {
            job.print();
        } catch (PrinterException e) {
            System.out.println(e);
        }*/
    }

	/**
	 * @return the upc
	 */
	public static String getUpc() {
		return upc;
	}

	/**
	 * @param upc the upc to set
	 */
	public static void setUpc(String upc) {
		Barcodes.upc = upc;
	}

	/**
	 * @return the sku
	 */
	public static String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public static void setSku(String sku) {
		Barcodes.sku = sku;
	}

	/**
	 * @return the binRack
	 */
	public static String getBinRack() {
		return binRack;
	}

	/**
	 * @param binRack the binRack to set
	 */
	public static void setBinRack(String binRack) {
		Barcodes.binRack = binRack;
	}
   
}
