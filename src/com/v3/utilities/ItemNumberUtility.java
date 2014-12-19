package com.v3.utilities;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * Class intended for Base 10 to Base 36 Transformations, as well as vice versa. 
 * Valid transformations are SKU IDs 
 * 
 * @author Volodimir Duda
 *
 */
public class ItemNumberUtility {
	
	private static final Pattern SKU_ITEM_PATTERN = 
			Pattern.compile(
					"^[A-Z0-9]{6}-[A-Z0-9]{3}[0-9]{2}$" // <- String regex
					);
	
	/**
	 * <p>First 6 Chars must be either Capital Letters or 0-9 Digits</p>
	 * <p>Must have a dash - as the 7th Char</p>
	 * <p>Next 3 chars will be ColorMap - Capital letters or 0-9 Digits
	 * <p>Lastly 2 Chars must follow - and only be 0-9 Digits</p>
	 * @param skuItem example String {102AB0-BD524}
	 * @return True if matches rule
	 */
	public static boolean validSkuItem(String skuItem){
		return SKU_ITEM_PATTERN.matcher(skuItem).matches();
	}
	
	/**
	 * <p>Takes Decimal Number and returns a Capital Base 36 Represention</p>
	 * @param base10
	 * @return base36
	 */
	public static String toBase36(int base10){
		return Integer.toString(base10, 36).toUpperCase();
	}
	
	/**
	 * <p>Takes a Base 36 String and returns the Base 10 Integer equivalent</p>
	 * @param base36
	 * @return base10 Integer
	 */
	public static int fromBase36(String base36){
		return Integer.parseInt(base36,36);
	}
	
	/**
	 * <p>Will create a valid skuItem Number using parameters</p>
	 * <p>Method will autofill zeros to match correct length</p>
	 * @param brandId - base 10
	 * @param styleId - base 10
	 * @param colorMapId - base 10
	 * @param sizeId  - base 10
	 * @return A valid SkuItem
	 */
	public static String getSkuItem(int brandId, int styleId, int colorMapId, int sizeId){
		String sku = StringUtils.leftPad(""+toBase36(brandId), 2, '0') + "" 
				+ StringUtils.leftPad(""+toBase36(styleId), 4, '0');
		String itemNo = StringUtils.leftPad(""+toBase36(colorMapId), 3, '0') + ""
				+ StringUtils.leftPad(""+sizeId, 2, '0');
		String skuItem = sku + "-" + itemNo;

		if(!validSkuItem(skuItem))
			throw new IllegalArgumentException("Improper SKU Item");
		
		return skuItem;
	}
	
	/**
	 * <p>Will take a valid SKU item and return an array of the corresponding ID values<br></p>
	 * @param skuItem a valid base36 SkuItem
	 * @return Integer[] containing the following value IDs
	 * <ul>brandId - base10</ul>
	 * <ul>styleId - base10</ul>
	 * <ul>colorMapId - base10</ul>
	 * <ul>sizeId - base10</ul>
	 */
	public static int[] getSkuItem(String skuItem){
		if(!validSkuItem(skuItem))
			throw new IllegalArgumentException("Improper SKU Item");
		return new int[]{ //example: 10|0004|-|B02|01
				fromBase36(skuItem.substring(0, 2)), // brandId
				fromBase36(skuItem.substring(2, 6)), // styleId
				fromBase36(skuItem.substring(7, 10)), // colorMapId
				Integer.parseInt(skuItem.substring(10))	 // sizeId - base10
				};
	}
	
	/**
	 * Will create a valid a SKU from Brand and Style
	 * @param brandId - base 10
	 * @param styleId - base 10
	 * @return String SKU - a string representation of the SKU
	 */
	public static String getSku(int brandId, int styleId){
		String sku = StringUtils.leftPad(""+toBase36(brandId), 2, '0') + "" 
				+ StringUtils.leftPad(""+toBase36(styleId), 4, '0');
		
		return sku;
	}
/*	
	public static void main(String[] args){
		
		ItemNumberUtility utilSKU = new ItemNumberUtility();
		Scanner in = new Scanner(System.in);
		int again = 1;
		
		while(again==1){
			
		/*	System.out.print("Base 10 Number: ");
			int base10 = in.nextInt();
			
			System.out.println();
			System.out.println("Base 16 Number: "+ Integer.toString(base10, 16).toUpperCase());
			System.out.println("Base 36 Number: "+ Integer.toString(base10, 36).toUpperCase());
			
			
			System.out.print("Base 36 Number: ");
			String base36 = in.next();
			
			System.out.println();
			System.out.println("Base 10 Number: "+ Integer.parseInt(base36,36));
			
			System.out.println("Again?");
			again = in.nextInt();
		*
			System.out.print("Base 36 SKU ITEM: ");
			String base36 = in.nextLine();
			System.out.println(utilSKU.validSkuItem(base36));
			
			System.out.print("Base 36 SKU Item: ");
			String skuItem = in.nextLine();
			int[] nums= utilSKU.fromSkuItem(skuItem);
			System.out.println(nums[0]+"-"+nums[1]+"-"+nums[2]+"-"+nums[3]);
		}
	}*/
}
