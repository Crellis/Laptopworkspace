package tesco.android;

import java.util.List;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	
	private static List<Product> catalog;
	private static List<Product> cart;
	
	public static List<Product> getCatalog(Resources res){
		if(catalog == null) {
			catalog = new Vector<Product>();
			catalog.add(new Product("Apple", res.getDrawable(R.drawable.ic_launcher), "Pink Lady delicious Apple", 0.99));
			catalog.add(new Product("Coke", res.getDrawable(R.drawable.ic_launcher), "Vintage Coca Cola Bottle", 2.75));
			catalog.add(new Product("Coconut Oil", res.getDrawable(R.drawable.ic_launcher), "Healthy Coconut Oil", 3.24));
		}
		
		return catalog;
	}
	
	public static List<Product> getCart() {
		if(cart == null) {
			cart = new Vector<Product>();
		}
		
		return cart;
	}

}
