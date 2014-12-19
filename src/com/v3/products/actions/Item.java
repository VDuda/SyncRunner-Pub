package com.v3.products.actions;

import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.lang.WordUtils;

import com.v3.actions.ActionCreator;
import com.v3.actions.ActionFindor;
import com.v3.actions.ActionUpdator;
import com.v3.dto.Brand;
import com.v3.dto.Category;
import com.v3.dto.Color;
import com.v3.dto.ColorMap;
import com.v3.dto.Images;
import com.v3.dto.LinkedSku;
import com.v3.dto.Lot;
import com.v3.dto.Material;
import com.v3.dto.Product;
import com.v3.dto.Shoe;
import com.v3.dto.ShoeId;
import com.v3.dto.Size;
import com.v3.dto.SizeMap;
import com.v3.dto.Sku;
import com.v3.dto.SkuId;
import com.v3.dto.Style;
import com.v3.utilities.ItemNumberUtility;


/**
 * The POJO class for an Item
 *  This sort of acts as an Unmarshaller; brand, color etc.. are dependent on DTO Shoe, Color.
 *   
 * @author Volodimir Duda
 *
 */
public class Item{

	//Item specifics
	/*private String brand ="";
	private String title = "";
	private String img = "";
    private String colorMap = "";
    private String color = "";
    private String gender = "";
    private String style = "";
    private String weight = "";
    private String styleNum = "";
    private String productGroup = "";
    private String sizeShoe = "";
    private String size = "";
    private String width = "";
    private boolean onAmazon = false;*/
	private boolean brandFound;
	private boolean styleFound;
	private boolean colorFound;
	private boolean genderFound;
	private boolean materialFound;
	private boolean imgFound;
	private boolean sizeFound;
	private boolean categoryFound;
	
	
	//DB specifics
	private static final String FEAT_DEL = "~|~"; 
	private StringBuffer sbFeat = new StringBuffer(300);
	
	//Test pricing
	private double price = 99.67;

	//The end result
	private String itemSku = null;
    
    //DTO classes
    private Shoe shoe = null;
    private SkuId skuId = null;
    private Sku sku = null;
    
    //DB Action Classes
    private ActionFindor findService = new ActionFindor();
    private ActionCreator createService = new ActionCreator(); 
    private ActionUpdator updateService = new ActionUpdator();
    
    //DTO Specific Methods
    public void setShoe(Shoe shoeDTO){
    	this.shoe = shoeDTO;
    }
    
    public Shoe getShoe(){
    	return shoe;
    }
    
    /**
     * CONSTRUCTORS
     */
    
    public Item(){//default constructor
    	this.shoe = new Shoe();
    	this.skuId = new SkuId();
    	this.sku = new Sku(); // we will check if it exists later, create new as value holder
    	//newShoe = true;
    	
    }
    
    public Item(Shoe shoe){
    	this.shoe = shoe; // assign the shoe
    	this.skuId = shoe.getSku()!=null? shoe.getSku().getId(): new SkuId(); // assign if existing
    	this.sku =  shoe.getSku()!=null? shoe.getSku(): new Sku();
    }
    
    //Item Specific Methods
	/**
	 * @return the brand or Empty string
	 */
	public String getBrand() {
		return sku.getBrand()!=null ? sku.getBrand().getBrand() : "";
	}
	/**
	 * @param brand the brand to set
	 * Checks DB for Brands when called.
	 */
	
	public void setBrand(String brand) {
		if(brand==null) //end execution if null
			throw new IllegalArgumentException("Null Value given for Brand");
		
		if(!brand.isEmpty()){//do operation if not empty
			Brand obj = findService.findBrand(brand.trim());//we need to find if this Brand exists
			brandFound = obj!=null;
			if(brandFound){//check if Brand exists
				
		//MOVED TO CREATE		skuId.setIdBrand(obj.getIdBrand());//if exists set in skuInfo
				sku.setBrand(obj);//if exists set in SKU
			}else{//doesn't exist
				
				obj = new Brand(brand.trim()); //Initialize new Brand
				//createService.createBrand(obj); //Push to DB the new Brand
		//MOVED TO CREATE		skuId.setIdBrand(obj.getIdBrand());//set in skuInfo
				sku.setBrand(obj);//set in SKU
			}
		}
	}
	
	/**
	 * @return the style or an Empty String
	 */
	public String getStyle() {
		return sku.getStyle() !=null ? sku.getStyle().getStyle() : "";
	}
	/**
	 * @param style the style to set
	 * Checks DB for Styles when called.
	 */
	public void setStyle(String style) {
		if(style==null) //end execution if null
			throw new IllegalArgumentException("Null Value given for Brand");
		
		if(!style.isEmpty()){//do operation if not empty
			Style obj = findService.findStyle(WordUtils.capitalizeFully(style.trim()));//we need to find if this Brand exists
			
			styleFound = obj!=null;
			if(styleFound){//check if Brand exists
		//MOVED TO CREATE	skuId.setIdStyle(obj.getIdStyle());//if exists set in skuInfo
				sku.setStyle(obj);//if exists set in SKU
			}else{//doesn't exist
				obj = new Style(WordUtils.capitalizeFully(style.trim())); //Initialize new Brand
				//createService.createStyle(obj); //Push to DB the new Brand
		//MOVED TO CREATE		//skuId.setIdStyle(obj.getIdStyle());//set in skuInfo
				sku.setStyle(obj);//set in SKU
			}
		}
	}
	
	
	/**
	 * Title is formatted based on (Brand) (Style) 
	 * @return the title
	 */
	public String getTitle() {
		if(shoe.getTitle()!=null){
			return shoe.getTitle();
		}else{
			return "";
		}
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		shoe.setTitle(title);
	}
	/**
	 * @return the img
	 */
	public String getImgThumb() {
		if(shoe.getImages()!=null){
			//imgFound = true;
			return shoe.getImages().getThumb();
		}else{
			return "";
		}
	}
	/**
	 * @param img the img to set
	 */
	public void setImgThumb(String img) {
		//we need to find if this ImgThumb exists
		if(img==null)
			throw new IllegalArgumentException("Null Value for Image String");
		if(!img.isEmpty()){
			Images obj = findService.findImagesThumb(img);
			imgFound = obj!=null;
			if(imgFound){
				shoe.setImages(obj);
			}else{//we have to use the createService here
				obj = new Images(img);
				createService.createImage(obj);
				shoe.setImages(obj);
			}
		}
	}
	/**
	 * @return the colorMap
	 */
	public ColorMap getColorMap() {
		if(shoe.getColorMap()!=null){
			//colorFound = true;
			return shoe.getColorMap();
		}else{
			return null;
		}
	}
	/**
	 * @param colorMap the colorMap to set
	 */
	public void setColorMap(String colorMap, String color) {
		//we need to find if this ColorMap exists
		colorMap = WordUtils.capitalizeFully(colorMap);
		if(colorMap==null)
			throw new IllegalArgumentException("Null Value for ColorMap String");
		if(!colorMap.isEmpty()){//don't need to check for color, MySql Default is '1' 
			
			ColorMap obj = findService.findColorMap(colorMap);
			Color objC = findService.findColor(color);
			colorFound = obj!=null;
			//JOptionPane.showMessageDialog(null, "Found all my items");
			if(colorFound){
				obj.setColor(objC);
				shoe.setColorMap(obj);
			}else{//we have to use the createService here
				obj = new ColorMap(objC,colorMap.trim());
				//createService.createColorMap(obj);
				shoe.setColorMap(obj);
			}
		}
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		if(shoe.getGender()!=null){
			//genderFound = true;
			return shoe.getGender().getGender();
		}else{
			return "";
		}
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		
		if(gender==null)
			throw new IllegalArgumentException("Null Value for gender String");
		System.out.println("Setting gender"+ gender);
		shoe.setGender(findService.findGender(gender));
		genderFound = true;//we don't want to create genders
	}
	
	/**
	 * @return the weight
	 */
	public String getWeight() {
		if(shoe.getGender()!=null){
			return shoe.getGender().getGender();
		}else{
			return "";
		}
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		if(shoe.getColorMap()!=null){
			//shoe.setColorMap(finderService.findColorMap(colorMap));
		}else{
			//shoe.setColorMap(new ColorMap(colorMap));
		}
	}

	/**
	 * @return the productGroup
	 */
	public String getProductGroup() {
		if(sku.getCategory()!=null){
			return sku.getCategory().toString();
		}else{
			return "";
		}
	}
	/**
	 * @param productGroup the productGroup to set
	 */
	public void setProductGroup(String productGroup) {		
		if(productGroup==null)
			throw new IllegalArgumentException("Null Value for productGroup String");
		if(!productGroup.isEmpty()){//don't need to check for color, MySql Default is '1' 
			
			Category obj = findService.findCategory(productGroup);
			categoryFound = obj!=null;
			if(categoryFound){
				System.out.println(obj.getCategory().toString());
				sku.setCategory(obj);
			}else{//we have to use the createService here
				obj = new Category(WordUtils.capitalizeFully(productGroup.trim()));
				//createService.createCategory(obj);//should be moved to create class
				sku.setCategory(obj);
			}
		}
	}
	/**
	 * @return the sizeShoe
	 */
	public SizeMap getSizeMap() {
		if(shoe.getSizeMap()!=null){
			//sizeFound = true;
			return shoe.getSizeMap();
		}else{
			return null;
		}
	}
	/**
	 * @param sizeShoe the sizeShoe to set
	 */
	public void setSizeMap(String sizeMap, String size) {
		//This is similar to SizeMap
		if(sizeMap==null)
			throw new IllegalArgumentException("Null Value for ColorMap String");
		if(!sizeMap.isEmpty()){//don't need to check for color, MySql Default is '1' 
			
			SizeMap obj = findService.findSizeMap(sizeMap);
			Size objC = findService.findSize(size);//<- Will always be found
			sizeFound = obj!=null;
			if(sizeFound){
				obj.setSize(objC);
				shoe.setSizeMap(obj);
			}else{//we have to use the createService here
				obj = new SizeMap(objC,sizeMap.trim());
				//createService.createSizeMap(obj);
				shoe.setSizeMap(obj);
			}
		}
	}
	
	public void setMaterial(String material){
		if(material == null)
			throw new IllegalArgumentException("Null Value for Material String");
		if(!material.isEmpty()){
			Material obj = findService.findMaterial(material);
			materialFound = obj != null;
			
			if(materialFound){//if found attach found material
				sku.setMaterial(obj);
			}else{//else create new material
				obj = new Material(material);
				sku.setMaterial(obj);
			}
		}
		
	}
	
	public String getMaterial(){
		if(sku.getMaterial()!=null){
			//materialFound = true;
			return sku.getMaterial().getMaterial();
		}else{
			return "N/A";
		}
	}
/**
	 * @return the width
	 *
	public String getWidth() {
		if(shoe.getGender()!=null){
			return shoe.getGender().getGender();
		}else{
			return "";
		}
	}
**
	 * @param width the width to set
	 *
	public void setWidth(String width) {
		if(shoe.getColorMap()!=null){
			//shoe.setColorMap(finderService.findColorMap(colorMap));
		}else{
			//shoe.setColorMap(new ColorMap(colorMap));
		}
	}
**/
	/**
	 * @return the onAmazon
	 */
	public boolean isOnAmazon() {
		return shoe.isOnAmazon();
	}

	/**
	 * @param onAmazon the onAmazon to set
	 */
	public void setOnAmazon(boolean onAmazon) {
		shoe.setOnAmazon(onAmazon);
	}
	
	/**
	 * @return the asin
	 */
	public String getAsin() {
		return shoe.getAsin();
	}

	/**
	 * @param asin the asin to set
	 */
	public void setAsin(String asin) {
		shoe.setAsin(asin);
	}

	/**
	 * Used to add features to SKU holder, will add delimiter ~|~
	 * @param feature - String to add to SKU features
	 */
	public void addFeature(String feature) {
		sbFeat.append(feature);
		sbFeat.append(FEAT_DEL);
	}
	
	/**
	 * A helper method to create or find existing data
	 */
	private void createAttributes(){
		//JOptionPane.showMessageDialog(null, "Creating attributes");
		if(!brandFound)
			createService.createBrand(sku.getBrand());
		if(!styleFound)
			createService.createStyle(sku.getStyle());
		if(!colorFound)
			createService.createColorMap(shoe.getColorMap());
		if(!sizeFound)
			createService.createSizeMap(shoe.getSizeMap());
		if(!categoryFound)
			createService.createCategory(sku.getCategory());
		if(!materialFound)
			createService.createMaterial(sku.getMaterial());
	/*	if(!imgFound)
			createService.createImage(shoe.getImages());*/
	//	if(!genderFound)//not implemented yet
	//		createService.createBrand(sku.getBrand());
	}

	/**
	 * Creates item based on 
	 * @param upc
	 * @param sku
	 * @param bin
	 * @return SKU - String representation of SKU
	 */
	public String create(String upc, String linkedSku, String bin) {
		
		createAttributes();
		//skuId is sort of useless, we may need to phase it out eventually
		skuId.setIdStyle(sku.getStyle().getIdStyle());//set in skuInfo
		skuId.setIdBrand(sku.getBrand().getIdBrand());//set in skuInfo
		Lot lotItem = findService.findLot(1);
		
		ShoeId shoeId = new ShoeId(upc,skuId);//creates the PK for shoe
		shoe.setId(shoeId); // add PK to holder
		
		Shoe shoeDB = findService.findShoe(shoeId);// check DB for this UPC/SKU
		Sku skuDB = findService.findSku(sku.getBrand(),sku.getStyle());// check in DB for this SKU ID
		//Add final Required values
		sku.setId(skuId); //
		if(sbFeat.length()>2)
			sku.setFeatures(sbFeat.substring(0,sbFeat.length()-3));
		//shoe.setSku(sku);
		//shoe.setUpc(upc);
		//System.out.println("This is my UPC "+shoe.getUpc());
		//sku.getShoes().add(getShoe());// I don't seem to understand the point of this.
		//Check and Retain a valid Linked SKU

		//May not even need to use SKU ID, just use SKU
		boolean validSkuId = ((skuId.getIdBrand() > 0) && (skuId.getIdStyle()>0));//validity of skuId
		//JOptionPane.showMessageDialog(null, "Our ID is " + validSkuId); // <- returns true
		
		/*** SKU CREATION * * */
		if(skuDB==null){ // Doesn't exist in DB, thus create using current instance
			skuDB=sku;
			if(validSkuId){//check validity of SKU
				//JOptionPane.showMessageDialog(null, "SKU Going to be Created, "+ sku.getId().getIdBrand() + " - "+ sku.getId().getIdStyle());
				//JOptionPane.showMessageDialog(null, "SKU Going to be Created, "+ skuDB.getId().getIdBrand() + " - "+ skuDB.getId().getIdStyle());
				createService.createSku(skuDB);//Push New SKU to DB
				//JOptionPane.showMessageDialog(null, "Created a SKU");
				
			}else{//invalid SKU ID
				//do not do anything with SKU
			}
		}//else does exist in DB
		/*** END SKU CREATION * * */
		//JOptionPane.showMessageDialog(null, "About to create a shoe");
		/*** SHOE CREATION * * */
		shoe.setSku(skuDB); // safety precaution, can delete later
		boolean shoeThrewError = false;
		if(shoeDB==null){
			//JOptionPane.showMessageDialog(null,"We creating a shoe :: "+ shoe.getSku()//.getBrand().getBrand()
			//		+" :: " + shoe.getSku()//.getStyle().getStyle() 
			//		+" :: " + shoe.getUpc());
			//JOptionPane.showMessageDialog(null, "Creating a new Shoe");
			shoeThrewError = !createService.createShoe(shoe);	
			//JOptionPane.showMessageDialog(null, "Done Creating shoe");
		}//else
		//	Shoe already exists
		
		/*JOptionPane.showMessageDialog(null, "Doing some Shoe Checks");
		if(shoeDB!=null&&!sku.getShoes().contains(shoe)){ //check if this Set doesn't contain this Shoe
			//sku.getShoes().add(shoe); // Lets add it to the Set
			
		} else{// Set contains that Shoe
			//Don't do anything this UPC has this SKU
		}*/
		/*** END SHOE CREATION * * */
		
		//Finally make sure to push any changes to DB for SHOE
		if(shoeDB!=null && !shoeDB.equals(shoe)){//we have a matching SKU by ID, now compare DB to Value Holder	
			//JOptionPane.showMessageDialog(null, "Updating DB SHOE");
			updateService.updateShoes(shoe);//not equal then update using Value Holder SKU
			//JOptionPane.showMessageDialog(null, "Updated DB SHOE");
		}
		
		/*** ALWAYS create a PRODUCT * * *?*/
		if(!shoeThrewError){
			JOptionPane.showMessageDialog(null,"Created product");
			Product product = new Product(lotItem,shoe,bin,new Date(),true);
			createService.createProduct(product);
		}else{
			JOptionPane.showMessageDialog(null, "Can't Create Product!");
		}
		JOptionPane.showMessageDialog(null,"Done");
		/*** END PRODUCT CREATION */
		
		/*** LINKED SKU CREATION * * *?*/			//must contain at least one or more
		if(linkedSku!=null && !linkedSku.isEmpty() &&linkedSku.matches("^[\\w-]+$")){
			
			LinkedSku linkSku = new LinkedSku(linkedSku); // Create a new SKU link Holder
			linkSku.setSku(skuDB);// will reference this SKU in DB
			createService.createLinkedSku(linkSku);
			//JOptionPane.showMessageDialog(null, "Added Linked SKU");
		}
		/*** END LINKED SKU CREATION * * */
		//JOptionPane.showMessageDialog(null, "Just checking if it works");
		//Finally make sure to push any changes to DB for SKU
		
/*ALWAYS EXECUTING*/
		if(skuDB!=null && !skuDB.equals(sku)){//we have a matching SKU by ID, now compare DB to Value Holder		
			updateService.updateSku(sku);//not equal then update using Value Holder SKU
			//JOptionPane.showMessageDialog(null, "Just checking if it works");
			//JOptionPane.showMessageDialog(null, "Updated DB SKU");
		}
		/***/
		createService.clear();
		findService.clear();
		/*JOptionPane.showMessageDialog(null, "Done with all execution");
		try {
			Thread.sleep(10000000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		itemSku =  ItemNumberUtility.getSkuItem(
				sku.getBrand().getIdBrand(), 
				sku.getStyle().getIdStyle(), 
				shoe.getColorMap().getIdColorMap(),
				(int)shoe.getSizeMap().getSize().getIdSize()
				);
		return itemSku;
/*		
		
		/*
		//check if SKU exists
		JOptionPane.showMessageDialog(null, "Creating Shoe-Model Link");
		System.out.println(sku);
		
		if(sku!=null && !sku.isEmpty() &&sku.matches("[A-Z0-9]+")){
			System.out.println("Creating a new SKU");			
			model = findService.findShoeModel(Integer.parseInt(sku));
			
			//create a shoeHasModels when we create a SKU
			createService.createShoeHasModels(new ShoeHasModels(getShoe(),model));
		}else{ // going to have to change this later on
			model = new ShoeModel();
			System.out.println("We have to create a SKU MODEL");
			createService.createModel(model);
		}
		
		//create a shoeHasModels when we create a SKU
		shoeHasModels.setShoeModel(model);
		
		//Check if such a ShoeHasModel exists
		if(findService.findShoeHasModels(shoeHasModels)==null){
			createService.createShoeHasModels(shoeHasModels);
		}
		*/
			
		//System.out.println("Waiting");
		//Thread.sleep(20000L);
		//System.out.println("Going");
		/*
		
		ShoeModel shoeModel = new ShoeModel();
		if(!sku.equals("(Optional)")){
			shoeModel.setIdModel(Integer.parseInt(sku));					
		}
		CreateService.createModel(shoeModel);
		CreateService.createShoeHasModels(new ShoeHasModels(item.getShoe(),shoeModel));
		*/
		
	}
	
	/**
	 * Gets the ItemSku created with createItem
	 * @return
	 */
	public String getItemSku() {
		if(itemSku ==null)
			return ItemNumberUtility.getSkuItem(
						sku.getBrand().getIdBrand(), 
						sku.getStyle().getIdStyle(), 
						shoe.getColorMap().getIdColorMap(),
						(int)shoe.getSizeMap().getSize().getIdSize()
						);
		return itemSku;
	}

	public void setPrice(Double price){
		this.price= price;
	}
	
	public Double getPrice(){
		return price;
	}

}
