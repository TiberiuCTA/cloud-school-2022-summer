package Lectia5;

public class ShoppingCart {
   private int id;
   Product[] list = new Product[5];
   
   public int computePrice() {
	   int totalPrice = 0;
	   for(int i = 0; i < list.length; i++) {
		   totalPrice += list[i].getPrice();
	   }
	   return totalPrice;
   }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Product[] getList() {
	return list;
}

public void setList(Product[] list) {
	this.list = list;
}
   
   
}
