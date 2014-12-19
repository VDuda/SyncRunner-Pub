package com.v3.actions;

import com.v3.GenericCRUD;
import com.v3.dto.Product;
import com.v3.dto.Shoe;
import com.v3.dto.Sku;

public class ActionUpdator {

	//CRUD Service
	private static final GenericCRUD<Object> UPDATE_SERVICE = new GenericCRUD<Object>();
	/**********************\
	 * 					  *
	 *     	GENERAL		  *
	 * 					  *
	\**********************/
	/**
//	 * General Hibernate merge. Will call CRUD service to update DB object.
	 * @param obj
	 */
	public static void update(Object obj){
		UPDATE_SERVICE.update(obj);
		UPDATE_SERVICE.closeSession();
	}
	
	/**********************\
	 * 					  *
	 *     	SHOES		  *
	 * 					  *
	\**********************/ 
	public void updateShoes(Shoe shoe){
		UPDATE_SERVICE.update(shoe);
		UPDATE_SERVICE.closeSession();
	}
	
	/**********************\
	 * 					  *
	 *     	SKU 		  *
	 * 					  *
	\**********************/ 
	public void updateSku(Sku sku){
		UPDATE_SERVICE.update(sku);
		UPDATE_SERVICE.closeSession();
	}
	
	/**********************\
	 * 					  *
	 *     	PRODUCT		  *
	 * 					  *
	\**********************/ 
	public void updateProduct(Product product){
		UPDATE_SERVICE.update(product);
		UPDATE_SERVICE.closeSession();
	}
}
