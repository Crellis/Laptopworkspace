package rectangle;

import java.awt.Rectangle;

public class Rectangle{
	
	public static void main(String args[]){
		
		box = new Rectangle(5, 10, 20, 30);
		
		box.translate(15, 25);
		
		System.out.println("After moving, the top left corner is: ");
		System.out.println(box.getX());
		System.out.println(box.getY());
	}
}