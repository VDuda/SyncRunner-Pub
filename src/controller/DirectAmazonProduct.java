/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author B2E_2
 */
import API.amazon.advertising.ItemLookupAWS;
import API.amazon.mws.products.actions.GetMatchingProductForIdSample; 
import API.amazon.mws.products.actions.GetProductCategoriesForASINSample;
import API.amazon.mws.products.actions.GetProductCategoriesForSKUSample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DirectAmazonProduct {
    
    
    
    public static void main(String[] args){
        
        //INPUT FROM Amazon unlisted
        File in = new File("C:\\Users\\B2E_2\\workspace\\SyncInventory\\output\\Unlisted_Items.csv");
        File out = new File("csvfiles//directAmznTT.csv");
        
        BufferedReader inData = null;
        BufferedWriter outData = null;
        
        
        try{
            inData = new BufferedReader(new FileReader(in));
            outData = new BufferedWriter(new FileWriter(out));
            //|
            String columnNames = "sku|qty|price|asin|store|websites|type|is_in_stock|visibility|attribute_set" 
                    + "|special_from_date|special_to_date|gender3|category|category_ids"
                    + "|name|productPage|upc|brand"
                    + "|gender2|special_price|retail|description|features|image"
                    + "|small_image|thumbnail|media_gallery|brand2|color_map|color3|gender"
                    + "|style|weight|stylenumba|ProductType|shoe_size_map|shoe_size"
                    + "|width|\n";
            outData.append(columnNames);
            
            String cLine;
            
            while((cLine=inData.readLine())!=null){ //USE FOR PRODUCTION
            //while(!((cLine=inData.readLine()).contains("105638.1"))){//USE FOR DEBUG
                String[] tokensIn = cLine.split(",");
                //System.out.println();
                
                /*USE ONLY FOR DEBUG
                String[] skus = {"105992"};//PASS IN ONLY an ARRAY WITH ONE ELEMENT!!!
                                    // Multiple Array Elements not implemented yet.
                String asin = "B004I5G5U2";
                *///END DEBUG USE
                                                //check by SKU else if not found check by ASIN
                String[] asins = {tokensIn[3]};
                String[] skus = {tokensIn[0]};//PASS IN ONLY an ARRAY WITH ONE ELEMENT!!!
                                           // Multiple Array Elements not implemented yet.
                String[] idType = {"SellerSKU","ASIN"};
                String sku = tokensIn[0];
                String asin = tokensIn[3];
                
                
                GetProductCategoriesForSKUSample grabCat = new GetProductCategoriesForSKUSample(sku);
                GetProductCategoriesForASINSample grabCatASIN;
                ArrayList tablur = new ArrayList();
                Object c[] = null;
                
                
               
                c = grabCat.getData();
                
                if(c[0].toString().equals("Error 503")){
                    grabCatASIN = new GetProductCategoriesForASINSample(asin);
                    c = grabCatASIN.getData();
                    
                    for(int i=0;i<c.length;i++){
                        tablur.add(c[i]);
                    }
                    
                }else{
                    
                    for(int i=0;i<c.length;i++){
                        tablur.add(c[i]);
                    }
                }
                 c = grabAWS(asin);
                
                if(c.length>6&&(c[6].toString().equals("N/A"))){
                    c[6] = c[5];
                }
                
                for(int i=0;i<c.length;i++){
                    tablur.add(c[i]);
                }
                
                c = grabMWS(skus,idType[0]);
                System.out.println(c[0]);
                if(c[0].toString().equals("Error 503")){
                    
                    c = grabMWS(asins,idType[1]);
                    for(int i=0;i<c.length;i++){
                        tablur.add(c[i]);
                    }
                }else{               
                    for(int i=0;i<c.length;i++){
                        tablur.add(c[i]);
                    }
                }
                c = tablur.toArray();

        
                String sItem = c[0].toString();
                //System.out.println(c[2]);
                
                //convert from OBJECT to STRING
                for(int i=1;i<c.length;i++){
                    
                    sItem = sItem +"|"+ c[i].toString();
                }
                sItem = sItem + "|";

                // May use MWS first to check SKU and accuracy of size + color
                //STORE <- these below can be included in the signaling class along with SKU, Asin, Qty
                String store = "admin";
                String websites = "web";
                String type = "simple";
                String inStock = "1";
                String visible = "4";
                String attributeSet = "shoes"; //This may need to change based off the input/category
                String specFrom = "11/30/2010  12:00:00 AM";
                String specTo = "11/30/2020  12:00:00 AM";
                //<-------------------

                String intro = tokensIn[0]+"|"+tokensIn[1]+"|"+tokensIn[2]+"|"+tokensIn[3]+"|"
                        +store+"|"+websites+"|"+type+"|"+inStock+"|"
                        +visible+"|"+attributeSet+"|"+specFrom+"|"+specTo;

                sItem = intro + "|"+ sItem +"\n";
        
                
                outData.append(sItem);
                
                //PRINTING TEST
                System.out.println("\nPRINTING TEST\n");
                System.out.print(sItem);
                
                Thread.sleep(12000);
                c = null;
                sItem=null;

                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                if(inData!=null)inData.close();
                if(outData!=null)outData.close();
            } catch (IOException ex) {
                Logger.getLogger(DirectAmazonProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        


        
        
        
        
        
        
    }
    
    //OUTPUT TO CSVFILE
    private static void write(Object[] items) throws IOException {
        
        

    }
    
    private static Object[] grabAWS(String asin){
        
        //ADVERTISING - images & feats
        ItemLookupAWS asinAtt = new ItemLookupAWS(asin);
        
        Object[] c;
        
        // AMZN ADVERTISING IMAGES & FEATURES & some attributes ONLY INPUT ASIN
        c = asinAtt.getData();
        /**/
        System.out.println("Title , Product Page, UPC, Brand, Gender, Lowest Price, Retail Price, Description, Features, Prime Img, Small Img, Thumb Img, Gallery");
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+",");
        }
        /**/
        
        return c;
    }
    
    private static Object[] grabMWS(String[] skus, String idType){
        //MWS - attributes
        GetMatchingProductForIdSample skuAtt = new GetMatchingProductForIdSample(skus,idType);
        
        Object[] c;
        
        
        // MWS SKU ATTRIBUTES DEBUG
        c = skuAtt.getData();
        /**/
        System.out.println("Brand , Color, Gender, Style, Weight, StyleNumber, Product Type, Shoe Size, Size, Shoe width");
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+",");
        }
        System.out.println("\n");
        /**/
        
        // MWS SKU PRICE DEBUG
        //c = skuAtt.getData(); //DO NOT NEED PRICING, IT WILL BE IN THE INPUT FILE 
        /*
        System.out.println("Brand , Color, Gender, Style, Weight, StyleNumber, Product Type, Shoe Size, Size, Shoe width");
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+",");
        }
        */
        
        return c;
    }
}
