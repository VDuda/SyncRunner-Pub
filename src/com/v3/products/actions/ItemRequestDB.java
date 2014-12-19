package com.v3.products.actions;

import java.util.ArrayList;
import java.util.List;

import com.v3.actions.ActionFindor;
import com.v3.dto.Shoe;

public class ItemRequestDB implements ItemRequest{

	private List<Item> itemList = new ArrayList<Item>();
	
	public boolean findItem(String upc) {

		System.out.println("Looking for an item");
		ActionFindor finderService = new ActionFindor();
		List<Shoe> shoeList = finderService.findShoeList(upc);
		
		if(shoeList!=null && !shoeList.isEmpty()){
			for(Shoe shoe:shoeList){
				Item item = new Item(shoe);
				/*if(shoe.getBrand()!=null)item.setBrand(shoe.getBrand().getBrand());
				if(shoe.getColor()!=null)item.setColor(shoe.getColor().getColor());
				if(shoe.getGender()!=null)item.setGender(shoe.getGender().getGender());
				if(shoe.getSize()!=null)item.setSize(shoe.getSize().getSize());
				if(shoe.getStyle()!=null)item.setStyle(shoe.getStyle());*/
				itemList.add(item);
			}
			return true;
		}
		//System.out.println("Didn't find DB ITEM");
		return false;
	}

	public Item getItem() {
		return itemList.get(0);
	}

	public List<Item> getItems(){
		return itemList;
	}
}
