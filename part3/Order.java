import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Order {
 
    private LinkedList<String> itemName;
    private double price;
    private final double tax = 0.07; //tax we charge
    private double gTotal;
    private Object employee;
    private Map<Integer, String> menu;
    private Map<Integer, Double> pricedMenu;
    //constructor
    public Order()
    {
    	pricedMenu = new HashMap<>(); //Map for menu price
    	menu = new HashMap<>(); //Map menu items
        itemName = new LinkedList<String>(); //item names for each order
        price = 0.0;
        gTotal = 0.0;
        employee = null; //not being used yet
    }
    public void addItem(Integer i) 
    {
        price+=pricedMenu.get(i); //add prices together
    }
    public void addItemName (Integer j) {
    	itemName.add(menu.get(j)); //get item name that was ordered and pass to the map
    }
    public void getItemName () { //displays all the items after the customer is done ordering
    	System.out.printf("Items: %s",itemName );
    	
    }
    public void reset() {
    	itemName.clear(); //clear the linked list for the new order
  
    	
    }
    public void resetPrice() { //reset price so it doesn't keep adding to each order
    	price = 0.0;
    }
    public void addEmployee (Object o)//not being used right now
    {
        employee = o;
    }
    public double gTotal() //grand total (after tax)
    {
        return gTotal = (price * tax) + price;
    }
    
    public void pDetails()
    { //method to show details (more refined will hopefully look like a receipt)
        
        System.out.printf("\nTotal before tax is $%.2f\n ",price);
        System.out.printf("Grand total with tax is $%.2f\n",gTotal());
    }
    public void menu() {
    	System.out.println("~~~~~~~~~~~~~~~Order Menu~~~~~~~~~~~~~~~");
    	//menu items
    	menu.put(1, "1. Original");
    	menu.put(2, "2. Dragon's Breath");
    	menu.put(3, "3. Light Flame");
    	menu.put(4, "4. Black Scales");
    	menu.put(5, "5. Plain");
    	menu.put(6, "6. Sweet Dragoness");
    	menu.put(7, "7. Herbal");
    	menu.put(8, "8. Sleepy Dragon");
    	menu.put(9, "9. Cracked Out Creature");
    	menu.put(10, "10. Green Dragon");
    	menu.put(11, "11. Ultimate Flight");
    	menu.put(12, "12. Tail Whiplash");
    	//menu prices
    	pricedMenu.put(1, 3.99);
    	pricedMenu.put(2, 4.99);
    	pricedMenu.put(3, 2.99);
    	pricedMenu.put(4, 1.99);
    	pricedMenu.put(5, 5.99);
    	pricedMenu.put(6, 6.99);
    	pricedMenu.put(7, 7.99);
    	pricedMenu.put(8, 8.99);
    	pricedMenu.put(9, 9.99);
    	pricedMenu.put(10, 4.59);
    	pricedMenu.put(11, 3.49);
    	pricedMenu.put(12, 3.89);
    	
    	
    	
			// menu to print
    		System.out.println("\n");
			System.out.printf("*%s %.2f*		",menu.get(1),pricedMenu.get(1));
			System.out.printf("*%s %.2f*		",menu.get(2),pricedMenu.get(2));
			System.out.printf("*%s %.2f*		",menu.get(3),pricedMenu.get(3));
			System.out.printf("*%s %.2f*		",menu.get(4),pricedMenu.get(4));
			System.out.println("\n\n");
			System.out.printf("*%s %.2f*		",menu.get(5),pricedMenu.get(5));
			System.out.printf("*%s %.2f*		",menu.get(6),pricedMenu.get(6));
			System.out.printf("*%s %.2f*		",menu.get(7),pricedMenu.get(7));
			System.out.printf("*%s %.2f*		",menu.get(8),pricedMenu.get(8));
			System.out.println("\n\n");
			System.out.printf("*%s %.2f*		",menu.get(9),pricedMenu.get(9));
			System.out.printf("*%s %.2f*		",menu.get(10),pricedMenu.get(10));
			System.out.printf("*%s %.2f*		",menu.get(11),pricedMenu.get(11));
			System.out.printf("*%s %.2f*		",menu.get(12),pricedMenu.get(12));
			System.out.println("\n\n");
			
    
    }
}
