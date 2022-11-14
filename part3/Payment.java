import java.util.HashMap;
import java.util.Map;


public class Payment {
	

	private Map<String, Double> transactions; //Map for transaction history
	
	public Payment (){
		transactions = new HashMap<>(); //initialize map
		//dummy information
		transactions.put("Harry", 15.98);
		transactions.put("Alex", 21.80);
		transactions.put("Rebecca", 5.00);
		transactions.put("Samantha", 7.52);
		
	}
	public void addTransaction (String name, double amount) {
		transactions.put(name, amount); //add to the Map
	}
	public void paymentDetails(double payment, String name) {
		System.out.printf("Payment of $%.2f\n", payment); //prints the amount
		System.out.printf("	Client %s paid in cash.\n", name);	 //Recipt like info
		System.out.print("Thanks for shopping at Black Dragon Tea! Have a wonderful day!\n"); //friendly exit message
		
	}
	public void list () { //print all the transactions
		System.out.println("*Cash Transactions*\n");
		for (Map.Entry<String, Double> list : transactions.entrySet()) {
			
			System.out.printf("Name: %s- 	Total amount for the order: $%.2f\n",list.getKey(), list.getValue());
		}
	}
}
