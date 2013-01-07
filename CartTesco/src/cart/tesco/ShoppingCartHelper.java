package cart.tesco;

import java.util.List;
import java.util.Vector;

import cart.tesco.R;
import cart.tesco.R.drawable;

import android.content.res.Resources;

public class ShoppingCartHelper {
	
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	
	private static List<Product> catalog;
	private static List<Product> cart;
	
	public static List<Product> getCatalog(Resources res){
		if(catalog == null) {
			catalog = new Vector<Product>();
			catalog.add(new Product("Apple", res.getDrawable(R.drawable.apple), "Pink Lady juicy Red Apple", 0.99));
			catalog.add(new Product("Coca Cola", res.getDrawable(R.drawable.coke), "Vintage Coca Cola Bottle, 250ml", 2.49));
			catalog.add(new Product("Coconut Oil", res.getDrawable(R.drawable.oil), "Organic Coconut Oil, rich in vitamins and minerals 200ml", 1.78));
			catalog.add(new Product("Orange", res.getDrawable(R.drawable.orange), "A juicy Orange from Florida", 0.35));
			catalog.add(new Product("Banana", res.getDrawable(R.drawable.banana), "Ripe Banana from Jamaica", 0.42));
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
