import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private String item;
    protected Double price;
    private int quantity;
    private Map<String, Double> inventoryOrder;
    private Map<String, Integer> inventoryQuantity;
    
    public Inventory()
    {
    	//dummy information
    	inventoryOrder = new HashMap<>();
    	inventoryQuantity = new HashMap<>();
    	inventoryOrder.put("Cups", 14.99);
    	inventoryQuantity.put("Cups", 10);
    	inventoryOrder.put("Straws", 7.99);
    	inventoryQuantity.put("Straws", 20);
    	inventoryOrder.put("Filters", 15.99);
    	inventoryQuantity.put("Filters", 15);
    	inventoryOrder.put("Tea Bags", 25.99);
    	inventoryQuantity.put("Tea Bags", 15);
    }
    public void modifyPrice(Double price) //these methods are going to be to add inventory when I work on it more
    {
        this.price = price;
    }
    public void modifyQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public String PrintInvItem()
    {
        return "Item name: " +item+ ". Price: " + price + ". Quantity: " + quantity;
    }
    public void list () { // prints the list of inventory
		for (Map.Entry<String, Double> list : inventoryOrder.entrySet()) { //create entry set, then set up list of items
			
			System.out.printf("Inventory Item: %s		Price per Unit: $%.2f			Quantity: %d Case(s)\n",list.getKey(), list.getValue(), inventoryQuantity.get(list.getKey()));
		}
	}
    public void menu() { //shows what menu you are in
    	System.out.println("~~~~~~~~~~~~~~~Inventory Menu~~~~~~~~~~~~~~~");
    }
}
