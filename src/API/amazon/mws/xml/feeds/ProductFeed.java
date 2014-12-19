package API.amazon.mws.xml.feeds;

import java.io.File;

import API.amazon.mws.xml.JAXB.AmazonEnvelope;
import API.amazon.mws.xml.JAXB.AmazonEnvelope.Message;
import API.amazon.mws.xml.JAXB.ConditionInfo;
import API.amazon.mws.xml.JAXB.Product;
import API.amazon.mws.xml.JAXB.Product.ProductData;
import API.amazon.mws.xml.JAXB.Shoes;
import API.amazon.mws.xml.JAXB.StandardProductID;

import com.v3.products.actions.Item;

public class ProductFeed extends XMLFeed<Item>{
	
	
	private static final String FEED_TYPE = "_POST_PRODUCT_DATA_";
	private static final String MSG_TYPE = "Product";
	
	public ProductFeed(){
		super();
	}
	
//	public static void main(String[] args) throws Exception{
//		long start = System.currentTimeMillis();
//		long end;
//		XMLFeed<Item> feed = new ProductFeed();
//		
//		File xml = new File(ProductFeed.class.getClassLoader().getResource("xmlSamples/SampleProductCreate.xml").getFile());
//		AmazonEnvelope amazonEnvelope = (AmazonEnvelope) XMLFeed.getUnmarshaller().unmarshal(xml);	
//		feed.setEnvelope(amazonEnvelope);
//		feed.createMarshaller().write();
//		
//		//DEBUGG
//		end = System.currentTimeMillis();
//		System.out.println(end-start);
//		////
//		ProductFeed feedTwo = new ProductFeed();
//		Item item = new Item();
//		item.setTitle("This is a product We are about to add");
//		
//		Message msg = feedTwo.createMessage(item);
//		msg.setMessageID(1);
//		
//		feedTwo.getEnvelope().getMessage().add(msg);
////		feedTwo.getEnvelope().getMessage().get(0).getProduct().getProductData().getShoes().get
//		System.out.println("\n\n\nCreating Number 2: \n");
//		feedTwo.createMarshaller().write();
//
//		//DEBUGG
//		end = System.currentTimeMillis();
//		System.out.println(end-start);
//		////
//	}
	
/*	public Message createMessage(final Item item){
		Message msg = new Message();
		Product product = new Product();
		product.setCondition(
				new ConditionInfo(){{
					setConditionType("New");
				}});
		product.setSKU("One-More-Item-542");
		product.setStandardProductID(new StandardProductID(){{
			setType("UPC");
			setValue("123456789012");
		}});
		product.setDescriptionData(new DescriptionData(){{
			setTitle(item.getTitle());
		}});
		msg.setProduct(product);
		msg.setOperationType("Update");
		return msg;
	}
*/

	@Override
	public String getFeedType() {
		return FEED_TYPE;
	}

	@Override
	public String getEnvelopeMessageType() {
		return MSG_TYPE;
	}

	/**
	 * Will use the item to create the JAXB object; automatically adding the Message to the Envelope
	 */
	@Override
	public Message createMessage(final Item dataObject, boolean isBasic) {		
		Message msg = new Message();
//		Product product = null;
		Product product = new Product();
		
		
		if(isBasic){
			product.setCondition(
					new ConditionInfo(){{
						setConditionType("New");
					}});
			product.setSKU(dataObject.getItemSku());
			product.setStandardProductID(new StandardProductID(){{
				setType("UPC");
				setValue(dataObject.getShoe().getId().getUpc());
			}});
//			product.setProductData(new ProductData(){{
//				setShoes(new Shoes(){{
//					shoes.setClothingType("Shoes");
//					shoes.setVariationData(new VariationData(){{
//						variationData.setParentage("child");
//						variationData.setVariationTheme("SizeColor");
//						variationData.setColor(dataObject.getColorMap().getColorMap());
//						variationData.setSize(dataObject.getSizeMap().getSizeMap());
//					}});
//					shoes.setClassificationData(new ClassificationData(){{
//						classificationData.setDepartment(value);
//						classificationData.setSizeMap(dataObject.getSizeMap().getSizeMap());
//						classificationData.setColorMap(dataObject.getColorMap().getColorMap());
//					}});
//				}});
//			}}
//			);
	/*
			product.setDescriptionData(new DescriptionData(){{
				setTitle(dataObject.getTitle());
			}});
	*/	
		}
		
		//Default Product
		msg.setProduct(product);
		msg.setOperationType("Update");
		msg.setMessageID(incrementMsgCount());
		this.getEnvelope().getMessage().add(msg);
//		System.out.println("Current Count: "+getMsgCount());
		return msg;
	}
}
