package com.v3.products.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.WordUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import API.amazon.mws.products.MarketplaceWebServiceProductsException;
import API.amazon.mws.products.actions.ProductsConfig;
import API.amazon.mws.products.model.AttributeSetList;
import API.amazon.mws.products.model.GetMatchingProductForIdRequest;
import API.amazon.mws.products.model.GetMatchingProductForIdResponse;
import API.amazon.mws.products.model.GetMatchingProductForIdResult;
import API.amazon.mws.products.model.IdListType;
import API.amazon.mws.products.model.Product;
import API.amazon.mws.products.model.ProductList;
import API.amazon.mws.products.model.ProductsUtil;

public class ItemRequestAMZ implements ItemRequest{
	
	//Local Variables
	private List<Item> amznItems = new ArrayList<Item>();
	
	/**
	 * Creates the basic client and request requirements to the MWS service
	 * 
	 * @param args
	 * @param idType
	 * @return response, the jaxb container of objects
	 */
	private GetMatchingProductForIdResponse startService(String[] args,String idType){
		
		
		 GetMatchingProductForIdRequest request = new GetMatchingProductForIdRequest();
         request.setSellerId(ProductsConfig.SELLER_ID);
         request.setMarketplaceId(ProductsConfig.MARKETPLACE_ID);
         request.setIdType(idType);
         request.setIdList(new IdListType(Arrays.asList(args)));
         
         GetMatchingProductForIdResponse response = null;
         
         try {
			response = ProductsConfig.service.getMatchingProductForId(request);
         } catch (MarketplaceWebServiceProductsException e) {
			JOptionPane.showMessageDialog(null, "We have a problem in AmznResult.class");
			e.printStackTrace();
		 }
         
         return response;
	}
	
	/**
	 * THIS is a future method, Will need lots of work - currently not enough time.
	 * Will implement unmarshalling later on in the project, once the basic structures are working
	 * This method provides an elegant and more accurate solution to the basic exhaustive solution.
	 * @param obj
	 * @throws JAXBException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void unmarshal(String obj) throws JAXBException, ParserConfigurationException, SAXException, IOException{
		JAXBContext jc = JAXBContext.newInstance( "com.v3" );
		Unmarshaller u = jc.createUnmarshaller();
 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(obj);

		Object o = u.unmarshal( doc );
	}
	
	/**
	 * <p>
	 * Creates a callout to MWS, using a given UPC
	 * Responsible for populating the data for the List
	 * Will make a call to the method that refreshes model data
	 * It is possible to implement multiple UPCs for a single call (probably will not do this thought only 5 max UPC per call)
	 * </p>
	 * <p><b>Make sure to call rebuildModel() after this method call</b></p>
	 * @param upc
	 * @throws JAXBException 
	 */
	public boolean findItem(String upc){
		amznItems.removeAll(amznItems);
		String[] upcList = {upc};
		GetMatchingProductForIdResponse response = startService(upcList,"UPC");
//		System.out.println(response.toXML());
//		System.out.println("---------------------------");
		List<GetMatchingProductForIdResult> resultList = response.getGetMatchingProductForIdResult();
		
		for(GetMatchingProductForIdResult result: resultList){
//			System.out.println(result.toXMLFragment());
//			System.out.println("-----------------------------");
		
			if(result.isSetProducts()) {
				ProductList  products = result.getProducts();
				List<Product> productList = products.getProduct();
				/*System.out.println(result.toXMLFragment());
				System.out.println("--------------------- --------");
				try{
					XMLFeed.getUnmarshaller().unmarshal(new ByteArrayInputStream(result.toXMLFragment().getBytes()));
				}catch(JAXBException e){
					e.printStackTrace();
					throw new IllegalStateException(e);
				}*/
				System.out.println("Found on Amazon: "+productList.size());
				
				for (Product product : productList) {
	//?? - Was trying to setup marshalling; found out MWS Products is terrible for this;
	//    MWS Products does not give definitive XSD, treats all elements as Objects.
	// 	  Forcing developer to manually unmarshall specific elements
//					StringBuffer sb = new StringBuffer();
//					sb.append("<Product>");
//					sb.append(product.toXMLFragment());
//					sb.append("</Product>");
//					System.out.println(sb.toString());
//					System.out.println("-----------------------------");
//					
//					try{
//						API.amazon.mws.xml.JAXB.Product p = (API.amazon.mws.xml.JAXB.Product) XMLFeed.getUnmarshaller().unmarshal(new ByteArrayInputStream(sb.toString().getBytes()));
//						System.out.println(p.g);
//						System.out.println(p.getProductData().getShoes().getClassificationData().getSizeMap());
//					}catch(JAXBException e){
//						e.printStackTrace();
//						throw new IllegalStateException(e);
//					}
//					
//					/***** SLEEEEEEEPP **///
//					try {
//						Thread.sleep(10000L);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					/***** END SLEEEEEEEPP **///
					
					if(product.isSetAttributeSets()){
						AttributeSetList attributeSetList = product.getAttributeSets();
						for (Object obj : attributeSetList.getAny()) {
							Node attribute = (Node) obj;
/*DEVELOPER*/					System.out.println(ProductsUtil.formatXml(attribute));
/**/						String brand = "N/A";
							String title = "N/A";
 							String img = "";
                             String colorMap = "N/A";
                             String color = "N/A";
                             String gender = "N/A";
                             String style = "N/A";
                             String weight = "2";
                             String styleNum = "N/A";
                             String productGroup = "N/A";
                             String material = "N/A";
                             String sizeShoe = "N/A";
                             String size = "N/A";
                             String width = "N/A";
                             
                             Item item = new Item();//create a item holder
                             
                 fileLoop: for(int i = 0; i < attribute.getChildNodes().getLength();i++){
                                Node node = attribute.getChildNodes().item(i);
                            	String nodeName = node.getNodeName();
                               //System.out.println(nodeName);
                               //System.out.println("V3:"+attribute.getChildNodes().item(i).getFirstChild().getNodeValue());
                               
	                        	//FEATURES
	                            if(nodeName.equals("ns2:Feature")){
	                                item.addFeature(node.getFirstChild().getNodeValue());
	                                continue fileLoop;
	                            }
                            	
                                
                               //BRAND
                               if(nodeName.equals("ns2:Brand")){
                                   brand = node.getFirstChild().getNodeValue();
                                   continue fileLoop;
                               }
                               
                               //COLOR MAP
                               if(nodeName.equals("ns2:Color")){
                                   colorMap = node.getFirstChild().getNodeValue();
                                   
                                   String c = colorMap.toUpperCase();
                                   if(c.contains("BLACK")){
                                       color = "Black";
                                   }else if(c.contains("BLUE")){
                                       color = "Blue";
                                   }else if(c.contains("BROWN")){
                                       color = "Brown";
                                   }else if(c.contains("GRAY")){
                                       color = "Gray";
                                   }else if(c.contains("GREEN")){
                                       color = "Green";
                                   }else if(c.contains("BEIGE")){
                                       color = "Beige";
                                   }else if(c.contains("IVORY")){
                                       color = "Ivory";
                                   }else if(c.contains("WHITE")){
                                       color = "White";
                                   }else if(c.contains("PINK")){
                                       color = "Pink";
                                   }else if(c.contains("PURPLE")){
                                       color = "Purple";
                                   }else if(c.contains("RED")){
                                       color = "Red";
                                   }else if(c.contains("ORANGE")){
                                       color = "Orange";
                                   }else if(c.contains("YELLOW")||c.contains("GOLD")){
                                       color = "Yellow";
                                   }else{
                                       color = "N/A";
                                   }
                                   continue fileLoop;
                               }
                               
                               //IMAGE
                               if(nodeName.equals("ns2:SmallImage")){
    
                                   for(int x = 0;x<node.getChildNodes().getLength();x++){
                                       if(node.getChildNodes().item(x).getNodeName().contains("ns2:URL")){
                                           img = attribute.getChildNodes().item(i).getChildNodes().item(x).getFirstChild().getNodeValue();
                                       }else{
                                           //System.out.println("Couldn't get img!");
                                       }
                                   }
                                   continue fileLoop;
                               }
                               
                               //TITLE
                               if(nodeName.equals("ns2:Title")){
                            	   title = node.getFirstChild().getNodeValue();
                            	   continue fileLoop;
                               }
                               
                               //GENDER
                               if(nodeName.equals("ns2:Department")){
                                   gender = node.getFirstChild().getNodeValue();
                                   gender = gender.substring(0,1).toUpperCase()+gender.substring(1,gender.length()-1);
                                   continue fileLoop;
                               }
                               
                               //STYLE
                               if(nodeName.equals("ns2:Model")){
                                   style = node.getFirstChild().getNodeValue();
                                   continue fileLoop;
                               }
                               
                               //WEIGHT
                               if(nodeName.equals("ns2:PackageDimensions")){
    
                                   for(int x = 0;x<node.getChildNodes().getLength();x++){
                                       if(node.getChildNodes().item(x).getNodeName().contains("ns2:Weight")){
                                           weight = node.getChildNodes().item(x).getFirstChild().getNodeValue();
                                       }else{
                                           //System.out.println("Couldn't get weight!");
                                       }
                                   }
                                   continue fileLoop;
                               }
                               
                               //STYLE NUMB
                               if(nodeName.equals("ns2:PartNumber")){
                                   styleNum = node.getFirstChild().getNodeValue();
                                   continue fileLoop;
                               }
                               
                               //PRODUCT GROUP
                               if(nodeName.equals("ns2:ProductGroup")){
                                   productGroup = node.getFirstChild().getNodeValue();
                                   continue fileLoop;
                               }
                               
                               //MATERIAL
                               if(nodeName.equals("ns2:MaterialType")){
                            	   material = node.getFirstChild().getNodeValue();
                            	   continue fileLoop;
                               }
                               
                               //SIZE
                               if(nodeName.equals("ns2:Size")){
                                   
                                   sizeShoe = node.getFirstChild().getNodeValue();
                                   StringBuffer sizeBuffer = new StringBuffer(sizeShoe);
                                   int c = 1;
                                   boolean keepChecking = true;
                                   String possibleMedium = "^.*[BDM]+.*$";//possible Medium representation
                                   String possibleNarrow = "^.*[N]+.*$";//possible Narrow representation
                                   String possibleWide = "^.*[W]+.*$";//possible Wide representation
                                   do{
                                	   //9.5 B(M) US   - B D M = Medium , W = Wide  N = Narrow
                                	   keepChecking = sizeBuffer.substring(0, c).matches("^(\\d{1,2}\\.?5?)");//definition of a size
                                	   if(!keepChecking){//when keepChecking is false, so we have our size
                                		   String widthString = sizeBuffer.substring(c);//check for width now
                                		   String widthChar = "M";//default to M if no match found
                                		   if(widthString.matches(possibleMedium)){
                                			   //do nothing already at default                                		
                                		   }else if(widthString.matches(possibleWide)){
                                			   widthChar = "W";                                
                                		   }else if(widthString.matches(possibleNarrow)){
                                			   widthChar = "N";
                                		   }//else use default
                                		   size = sizeBuffer.substring(0,c-1) + widthChar;//grab & assign the previous True
                                	   }
                                	   
                                	   c++;
                                   }while(keepChecking);
                                   continue fileLoop;
                               }
                            	   
                               //MATERIAL
                             /*  if(nodeName.equals("ns2:MaterialType")){
                            	   material = node.getFirstChild().getNodeValue();
                            	   continue fileLoop;
                               }
                               */
                               
                            }
                            
                            
                            item.setBrand(brand);
                            /*System.out.println(title.length());
                            System.out.println(title.length()>60? 61: title.length());
                            System.out.println(title.length()>60? true: false);
                            System.out.println(title);*/
                            item.setTitle(title.substring(
                            		0,
                            		title.length()>80? 80: title.length()
                            		));
                            item.setColorMap(colorMap,color);
                            item.setGender(gender);
                            item.setImgThumb(img);
                            item.setProductGroup(productGroup);
                            item.setSizeMap(sizeShoe,size);
                            item.setStyle(style);
                            item.setWeight(weight);
                            item.setMaterial(WordUtils.capitalizeFully(material));
                            //item.setWidth(width);
                            item.setOnAmazon(true);
                            item.setAsin(product.getIdentifiers().getMarketplaceASIN().getASIN());
                            
                            amznItems.add(item);
//                            throw new IllegalStateException("End there");
                            
						}
					}
				}
				return true;
			}
		}
		return false;
		//rebuildListModel();
	}
	
//	public static void main(String[] args){
//		ItemRequestAMZ request = new ItemRequestAMZ();
//		request.findItem("883419314940");
//	}

	/**
	 * Returns first item in the list
	 */
	public Item getItem(){
		return amznItems.get(0);
	}
	
	/**
	 * A list of items
	 * @return
	 */
	public List<Item> getItems(){
		return amznItems;
	}
}
