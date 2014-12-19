package com.v3.products.actions;

import java.util.List;

public interface ItemRequest {

	public boolean findItem(String upc);
	public Item getItem();
	public List<Item> getItems();
}
