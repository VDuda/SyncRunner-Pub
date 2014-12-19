package com.v3.actions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.v3.GenericCRUD;
import com.v3.dto.Brand;
import com.v3.dto.Category;
import com.v3.dto.Color;
import com.v3.dto.ColorMap;
import com.v3.dto.Descriptions;
import com.v3.dto.Gender;
import com.v3.dto.Images;
import com.v3.dto.LinkedSku;
import com.v3.dto.Lot;
import com.v3.dto.Material;
import com.v3.dto.Product;
import com.v3.dto.Shoe;
import com.v3.dto.ShoeId;
import com.v3.dto.ShoeType;
import com.v3.dto.Size;
import com.v3.dto.SizeMap;
import com.v3.dto.Sku;
import com.v3.dto.Style;
import com.v3.dto.SyncAmznProducts;
import com.v3.products.actions.Item;
import com.v3.utilities.ItemNumberUtility;

/**
 * 
 * @author Volodimir Duda
 *
 */
public class ActionFindor {

	//CRUD Service
	private GenericCRUD<Object> FinderService = new GenericCRUD<Object>();
	
	//clear Session data
	public void clear(){
		FinderService.getSession().clear();
	}
	
	public void close(){
		FinderService.closeSession();
	}
	
	/**********************\
	 * 					  *
	 *     QUERY		  *
	 * 					  *
	\**********************/
	
	/**
	 * SQL query the database
	 * @param query
	 * @return Result list
	 */
	@SuppressWarnings("rawtypes")
	public List createSQLqueryList(String query){
		List r= FinderService.findMany(
					FinderService.getSession().createSQLQuery(query)
				);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     ITEM			  *
	 * 					  *
	\**********************/ 
	
	/**
	 * 
	 * @param {@link Item}
	 * @return {@link boolean}
	 */
	public boolean existsInDB(Item item){
		List<Product> list = findProduct(item);
		close();
		return ((list != null) && (!list.isEmpty()));
	}
	
	/**
	 * 
	 * @param {@link Item}
	 * @return {@link boolean}
	 */
	public boolean existsInAmznDB(Item item){
		List<SyncAmznProducts> list = findSyncAmznProduct(item);
		System.out.println("Checking existInAmznDB "+ list != null);
		System.out.println(!list.isEmpty());
		close();
		return ((list != null) && (!list.isEmpty()));
	}
	
	/**********************\
	 * 					  *
	 *     SYNC_AMZN	  *
	 * 					  *
	\**********************/
	
	/**
	 * <p>Finds a single SyncItem based on ID</p>
	 * @param id
	 * @return Product
	 */
	public SyncAmznProducts findSyncAmznProduct(int id){
		SyncAmznProducts r = (SyncAmznProducts)FinderService.findByID(SyncAmznProducts.class, id);
		close();
		return r;
	}
	
	/**
	 * <p>Finds a single SyncItem based on the POJO Item class</p>
	 * @param item
	 * @return Product
	 */
	@SuppressWarnings("unchecked")
	public List<SyncAmznProducts> findSyncAmznProduct(Item item){
		List<SyncAmznProducts> r= (List<SyncAmznProducts>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"From SyncAmznProducts S WHERE "
						+ " S.id.sku = :sku"
						).setParameter("sku", item.getItemSku())
				);
		close();
		return r;
	}
	
	/**
	 * <p>Finds a single UNIQUE SyncItem based on the POJO Item class</p>
	 * @param item
	 * @return Product
	 */
	public SyncAmznProducts findSyncAmznProductOne(Item item){
		SyncAmznProducts r=(SyncAmznProducts) FinderService.findOne(
				FinderService.getSession().createQuery(
						"From SyncAmznProducts S WHERE "
						+ " S.id.sku = :sku"
						).setParameter("sku", item.getItemSku())
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<SyncAmznProducts> findAllSyncAmznProducts(){
		List<SyncAmznProducts> r= (List<SyncAmznProducts>)(Object) FinderService.findAll(SyncAmznProducts.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     PRODUCTS		  *
	 * 					  *
	\**********************/ 
	
	/**
	 * <p>Finds a single product based on ID</p>
	 * @param id
	 * @return Product
	 */
	public Product findProduct(int id){
		Product r= (Product)FinderService.findByID(Product.class, id);
		close();
		return r;
	}
	
	/**
	 * <p>Finds a single product based on the POJO Item class</p>
	 * @param item
	 * @return Product
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProduct(Item item){
		ShoeId id= item.getShoe().getId();
		List<Product> r= (List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE "
						+ "P.shoe.id.upc = :upc and "
						+ "P.shoe.id.idBrand = :brand and "
						+ "P.shoe.id.idStyle = :style"
						)
						.setParameter("upc", id.getUpc())
						.setParameter("brand", id.getIdBrand())
						.setParameter("style",id.getIdStyle())
						
				);
		close();
		return r;
	}

	/**
	 * <p>Finds all Products based off ID, will need to cast (Product) to each item in list</p>
	 * @param id
	 * @return List of Objects
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductList(int id){
		List<Product> r= (List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE P.idProduct = ?"
						).setInteger(0, id)
				);
		close();
		return r;
	}
	
	/**
	 * <p>Will grab List of Products based off BinRack</p>
	 * @param binRack - a String representation of the bin i.e A54
	 * @return List of Products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductListByBin(String binRack){
		List<Product> r = (List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE P.binRack = ?"
						).setString(0, binRack)
				);
		close();
		return r;
	}
	
	/**
	 * <p>Will grab List of Products based off UPC</p>
	 * @param UPC - a String representation of the UPC i.e 885922947837
	 * @return List of Products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductListByUPC(String upc){
		List<Product> r =(List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE P.shoe.id.upc = ?"
						).setString(0, upc)
				);
		close();
		return r;
	}
	
	/**
	 * <p>Will grab List of Products based off Linked SKU</p>
	 * @param LinkSku - a String representation of the Linked SKU i.e 115660
	 * @return List of Products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductListByLinked(String linkSku){
		List<LinkedSku> linkList = findLinkedSkuList(linkSku);
		List<Product> holderList = new ArrayList<Product>();
		
		for(LinkedSku link : linkList){
		 holderList.addAll((List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE P.shoe.id.idBrand = ? "
						+ "and P.shoe.id.idStyle = ?"
						).setInteger(0, link.getSku().getId().getIdBrand())
						.setInteger(1, link.getSku().getId().getIdStyle())
				));
		}
		close();
		return holderList;
	}
	
	/**
	 * <p>Will grab List of Products based off SKU</p>
	 * @param SKU - a String representation of the SKU i.e B00229-D0810
	 * @return List of Products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductListBySKU(String sku){
		int[] skuInts = ItemNumberUtility.getSkuItem(sku);

		List<Product> r= (List<Product>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Product P WHERE P.shoe.id.idBrand = ? "
						+ "and P.shoe.id.idStyle = ? "
						+ "and P.shoe.colorMap.idColorMap = ? "
						+ "and P.shoe.sizeMap.size.idSize = ?"
						).setInteger(0, skuInts[0])
						.setInteger(1, skuInts[1])
						.setInteger(2, skuInts[2])
						.setInteger(3, skuInts[3])
				);
		close();
		return r;
	}
	
	/**
	 * <p>Will grab List of Products based off BinRacks</p>
	 * Method calls the single findProductListByBin(String bin), adds lists
	 * @param binRacks - a String[] representation of the bin i.e A54,A5
	 * @return List of Products
	 */
	public List<Product> findProductListByBin(String[] binRack){
		List<Product> list = new ArrayList<Product>();
		for(String bin : binRack){
			list.addAll(findProductListByBin(bin));
		}
		close();
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public String[] findAllBinsUnique() {
		Query q = FinderService.getSession().createQuery(
					"SELECT DISTINCT P.binRack FROM Product P where NULLIF(P.binRack, '') IS NOT NULL"
					);
		List<String> prods = q.list();
		close();
		return prods.toArray(new String[0]);
	}
	
	/**********************\
	 * 					  *
	 *     LOTS			  *
	 * 					  *
	\**********************/ 
	
	/**
	 * <p>Finds a single product based on ID</p>
	 * @param id
	 * @return Product
	 */
	public Lot findLot(int id){
		Lot r= (Lot) FinderService.findByID(Lot.class, id);
		close();
		return r;
	}

	
	/**********************\
	 * 					  *
	 *     SHOES		  *
	 * 					  *
	\**********************/ 
	
	/**
	 * <p><b>SQL INJECTION VULNERABLE METHOD**</b></p>
	 * Finds a single Shoe based on UPC
	 * @param upc
	 * @return Shoe object
	 */
	public Shoe findShoe(ShoeId shoeId){
		Shoe r = (Shoe) FinderService.getSession().get(Shoe.class, shoeId);
		close();
		return r;
	}
	
	/**
	 * <p><b>SQL INJECTION VULNERABLE METHOD**</b></p>
	 * Finds items with this UPC - This method should search the Shoes_Has_Skus in case of multiple SKU - UPC variations
	 * @param upc
	 * @return List, may be empty if none found
	 */
	@SuppressWarnings("unchecked")
	public List<Shoe> findShoeList(ShoeId shoeId){
		List<Shoe> r= (List<Shoe>)(Object)FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Shoe S WHERE S.id = :sku"
						).setParameter("sku", shoeId)
				);	
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Shoe> findShoeList(String upc){
		List<Shoe> r= (List<Shoe>)(Object)FinderService.findMany(
				FinderService.getSession().createQuery(
						"FROM Shoe S WHERE S.id.upc = :upc"
						).setParameter("upc", upc)
				);	
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     SKU			  *
	 * 					  *
	\**********************/ 
/*	public Sku findSku(SkuId skuId) {
		JOptionPane.showMessageDialog(null, "This Method throws an error " + skuId.getIdBrand() + " - " + skuId.getIdStyle());
		return null;
/*		return (Sku) FinderService.findOne(
				FinderService.getSession().createQuery(		
					"FROM Sku B WHERE B.brand = :idBrand"
					+ " and B.style = :idStyle"
						).setParameter("idBrand", skuId.getIdBrand()).setParameter("idStyle", skuId.getIdStyle())
				);*
	}*///Method does not work since brand does not match up to idBrand
	
	public Sku findSku(Brand brand, Style style){
		Sku r= (Sku) FinderService.findOne(
				FinderService.getSession().createQuery(
						"FROM Sku B WHERE B.brand = :brand"
						+ " and B.style = :style"
						).setParameter("brand", brand).setParameter("style", style)
				);
		close();
		return r;
	}

	/**********************\
	 * 					  *
	 *     LinkedSku	  *
	 * 					  *
	\**********************/ 
	public LinkedSku findLinkedSku(LinkedSku linkSku) {
		LinkedSku r= (LinkedSku) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM LinkedSku B WHERE B = :linkSku"
						).setParameter("linkSku", linkSku)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<LinkedSku> findLinkedSkuList(String linkSku) {
		List<LinkedSku> r= (List<LinkedSku>)(Object) FinderService.findMany(
				FinderService.getSession().createQuery(		
						"FROM LinkedSku B WHERE B.linkedSku = :linkSku"
						).setParameter("linkSku", linkSku)
				);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     BRAND		  *
	 * 					  *
	\**********************/ 

	public Brand findBrand(String brand) {
		Brand r= (Brand) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Brand B WHERE B.brand = :brand"
						).setParameter("brand", brand)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Brand> findAllBrand(){
		List<Brand> r= (List<Brand>)(Object) FinderService.findAll(Brand.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     STYLE		  *
	 * 					  *
	\**********************/ 

	public Style findStyle(String style) {
		Style r= (Style) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Style B WHERE B.style = :style"
						).setParameter("style", style)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Style> findAllStyle(){
		List<Style> r= (List<Style>)(Object) FinderService.findAll(Style.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     COLOR		  *
	 * 					  *
	\**********************/ 
	
	public Color findColor(int id){
		Color r= (Color) FinderService.findByID(Lot.class, id);
		close();
		return r;
	}
	
	public Color findColor(String color){
		Color r= (Color) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Color S WHERE S.color = :color"
						).setParameter("color", color)
				);
		close();
		return r;
	}

	@SuppressWarnings("unchecked")
	public List<Color> findAllColor(){
		List<Color> r=(List<Color>)(Object) FinderService.findAll(Color.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     COLORMAP		  *
	 * 					  *
	\**********************/ 

	public ColorMap findColorMap(String color) {
		ColorMap r= (ColorMap) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM ColorMap B WHERE B.colorMap = :color"
						).setParameter("color", color)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<ColorMap> findAllColorMap(){
		List<ColorMap> r= (List<ColorMap>)(Object) FinderService.findAll(ColorMap.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     SIZE			  *
	 * 					  *
	\**********************/ 
	
	public Size findSize(int id){
		Size r= (Size) FinderService.findByID(Size.class, id);
		close();
		return r;
	}
	
	public Size findSize(String size){
		Size r= (Size) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Size S WHERE S.size = :size"
						).setParameter("size", size)
				);
		close();
		return r;
	}

	@SuppressWarnings("unchecked")
	public List<Size> findAllSize(){
		List<Size> r= (List<Size>)(Object) FinderService.findAll(Size.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     SIZEMAP		  *
	 * 					  *
	\**********************/ 

	public SizeMap findSizeMap(String color) {
		SizeMap r=(SizeMap) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM SizeMap B WHERE B.sizeMap = :color"
						).setParameter("color", color)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<SizeMap> findAllSizeMap(){
		List<SizeMap> r= (List<SizeMap>)(Object) FinderService.findAll(SizeMap.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     Descriptions	  *
	 * 					  *
	\**********************/ 

	public Descriptions findDescriptions(int id){
		Descriptions r= (Descriptions) FinderService.findByID(Descriptions.class, id);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     Gender		  *
	 * 					  *
	\**********************/ 

	public Gender findGender(String gender) {
		Gender r= (Gender) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Gender B WHERE B.gender = :gender"
						).setParameter("gender", gender)
				);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Gender> findAllGender(){
		List<Gender> r= (List<Gender>)(Object) FinderService.findAll(Gender.class);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     Images		  *
	 * 					  *
	\**********************/ 

	public Images findImages(int id) {
		Images r= (Images) FinderService.findByID(Images.class, id);
		close();
		return r;
	}
	
	public Images findImagesThumb(String url){
		Images r= (Images) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Images B WHERE B.thumb = :url"
						).setParameter("url", url)
				);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     Material		  *
	 * 					  *
	\**********************/ 

	public Material findMaterial(int id){
		Material r =(Material) FinderService.findByID(Descriptions.class, id);
		close();
		return r;
	}
	
	public Material findMaterial(String material){
		Material r= (Material) FinderService.findOne(
				FinderService.getSession().createQuery(
						"From Material B WHERE B.material = :material"
						).setParameter("material", material)
				);
		close();
		return r;
	}
	
	/**********************\
	 * 					  *
	 *     ShoeType		  *
	 * 					  *
	\**********************/ 

	public ShoeType findShoeType(int id){
		ShoeType r= (ShoeType) FinderService.findByID(ShoeType.class, id);
		close();
		return r;
	}

	/**********************\
	 * 					  *
	 *     Category		  *
	 * 					  *
	\**********************/ 
	
	public Category findCategory(int id) {
		Category r= (Category) FinderService.findByID(Category.class, id);
		close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategory() {
		List<Category> r= (List<Category>)(Object) FinderService.findAll(Category.class);
		close();
		return r;
	}

	public Category findCategory(String productGroup) {
		Category r= (Category) FinderService.findOne(
				FinderService.getSession().createQuery(		
						"FROM Category B WHERE B.category = :productGroup"
						).setParameter("productGroup", productGroup)
				);
		close();
		return r;
	}

	

}
