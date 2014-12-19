package com.v3.actions;

import javax.swing.JOptionPane;

import com.v3.GenericCRUD;
import com.v3.dto.Brand;
import com.v3.dto.Category;
import com.v3.dto.ColorMap;
import com.v3.dto.Images;
import com.v3.dto.LinkedSku;
import com.v3.dto.Material;
import com.v3.dto.Product;
import com.v3.dto.Shoe;
import com.v3.dto.ShoeModel;
import com.v3.dto.SizeMap;
import com.v3.dto.Sku;
import com.v3.dto.Style;

/**
 * 
 * Really don't know the repercussions of not telling Hibernate what DTO to deal with.
 * This class creates a GenericCrud which then treats all calls to it as objects, not DTOs. 
 * 
 * @author Volodimir
 *
 */
public class ActionCreator {

	static GenericCRUD<Object> CreateService = new GenericCRUD<Object>();
	
	/**
	 * Testing with General Create Statement; hands off to CRUD service.
	 * Not sure of security issues this may cause.
	 * @param Object
	 */
	public static void create(Object obj){
		CreateService.create(obj);
		CreateService.closeSession();
	}
	
	/**
	 * Create Item, According to business rules
	 * @param product
	 */
	public void createProduct(Product product){
		CreateService.create(product);
		CreateService.closeSession();
	}
	
	/**
	 * Creates Shoe according to Business rules
	 * This is a Broken Method
	 * @param shoe
	 */
	@Deprecated 
	public void createShoe(Shoe shoe, ShoeModel SKU){
		try{
			CreateService.create(shoe);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}
	
	public boolean createShoe(Shoe shoe){
		try{
			//GenericCRUD<Shoe> CreateService = new GenericCRUD<Shoe>();//safety precaution, delete later
			
			boolean r = CreateService.create(shoe);
			CreateService.closeSession();
			return r;
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
		
	}

	public void createModel(ShoeModel shoeModel) {
		try{
			CreateService.create(shoeModel);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createBrand(Brand brand) {
		try{
			CreateService.create(brand);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createStyle(Style style) {
		try{
			CreateService.create(style);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createSku(Sku sku) {
		CreateService.create(sku);
		CreateService.closeSession();
	}

	public void createLinkedSku(LinkedSku linkSku) {
		try{
			CreateService.create(linkSku);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createImage(Images images) {
		try{
			CreateService.create(images);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createColorMap(ColorMap colorMap) {
		try{
			CreateService.create(colorMap);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}

	public void createSizeMap(SizeMap sizeMap) {
		try{
			CreateService.create(sizeMap);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		CreateService.closeSession();
	}
	
	public void clear(){
		CreateService.getSession().clear();
	}

	public void createCategory(Category category) {
		CreateService.create(category);
		CreateService.closeSession();
	}

	public void createMaterial(Material material) {
		CreateService.create(material);	
		CreateService.closeSession();
	}

	
}

class InvalidParameters extends Exception{
	
	public InvalidParameters(){
		super();
	}
	
	public InvalidParameters(String message){
		super(message);
	}
}