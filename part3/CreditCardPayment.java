import java.util.HashMap;
import java.util.Map;


public class CreditCardPayment extends Payment{
	

	private Map<String, Double> creditTransactions; // map for transaction history
	/*I will eventually expand this to contain another map 
	 * to hold more information. As of now, it is just the name
	 * of the customer and their total.
	 */
	
	public CreditCardPayment (){
		creditTransactions = new HashMap<>(); //initialize
		//dummy information
		creditTransactions.put("Ariana", 3.54);
		creditTransactions.put("Wendy", 7.98);
		creditTransactions.put("Andrew", 18.45);
		creditTransactions.put("Henry", 2.90);
		
	}
	public void addTransaction (String name, double amount) {
		creditTransactions.put(name, amount); // add the transactions into the map
	}
	public void paymentDetails(double payment, String name, String cardExpiration, int cardNumber) {
		System.out.printf("Payment of $%.2f\n",payment); //prints the amount
		System.out.printf("	Client %s paid with card ending in XXXXXXXXXXXX%d with the expiration date %s .\n", name, cardNumber, cardExpiration); //describe how they paid	
		System.out.print("Thanks for shopping at Black Dragon Tea! Have a wonderful day!\n"); //friendly exit message
		
	}
	public void list () {
		System.out.println("\n*Card Transactions*\n");
		for (Map.Entry<String, Double> list : creditTransactions.entrySet()) { //convert to entry set
			
			System.out.printf("Name: %s- 	Total amount for the order: $%.2f\n",list.getKey(), list.getValue()); //prints transaction history
		}
		System.out.println("\n");
}}
