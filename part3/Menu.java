import java.util.Scanner;

public class Menu {
	

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) { //use for user inputs
			Employees employment = new Employees(); // create the objects here so they don't keep resetting
			Order customer = new Order();
			CreditCardPayment card = new CreditCardPayment();
			Payment cash = new Payment ();
			Inventory warehouse = new Inventory();
			
			
				while (true) {
				System.out.println("~~~~~~~~~~~~~~~Welcome to the Black Dragon Tea Shop!~~~~~~~~~~~~~~~"); //inital menu
				System.out.println("Are you a Customer or Employee?"); //split to two menus
				System.out.println("Enter 'C' for Customer or 'E' for Employee. (Enter Quit to exit)");
				String choice = input.next();
				boolean customerVal = true; //keeps the portal going until the user decides to quit
				if(choice.toUpperCase().equals("C")) { //customer 'portal'
					while (customerVal) {
					System.out.println("~~~~~~~~~~~~~~~Customer Menu~~~~~~~~~~~~~~~");
					System.out.println("*MENU*		*ORDER*"); //options
					System.out.println("\n\nEnter 'Menu' to the view the menu and 'Order' to place an order (Enter Quit to exit to Main Menu)");
					String customerChoice = input.next(); 
					  if (customerChoice.toUpperCase().equals("ORDER")) {
						  customer.menu(); //display menu and order prompt 
						  
							System.out.println("To place an order, enter each number you would like. When you are finished, enter 0");
							System.out.println("Please provide a name for the order: "); //store the name
							String name = input.next();
							System.out.println("Order: ");
							boolean placeOrder = true;
							while (placeOrder) {
							int order  = 0;
							order = input.nextInt();
							if (order == 0) {
								placeOrder = false;
								customer.gTotal(); //gets total price
								customer.getItemName(); //gets a list of the items ordered
								customer.pDetails(); //gets the details (total before and grand total)
								customer.reset(); //reset the list of item names
								
							} else if (order <0 || order > 13) {
								System.out.println("Sorry, not a valid menu item number, Please try again.");
							} 
							else {
								customer.addItem(order); //this will continue to get the order input until the user is done (enters 0)
								customer.addItemName(order); //adds the name of the item to the order
							}
							}
							boolean payment = true;
							while (payment) {
							System.out.println("Are you paying with cash or card?"); //payment method prompt
							String paymentMethod = input.next();
							
							if (paymentMethod.toUpperCase().equals("CARD")) {
								System.out.println("Please enter the last four digits of your card: ");
								int cardNumber = input.nextInt();
								System.out.println("Please enter the expiration Date (Format XX/XX)");
								String cardExpiration = input.next();
								card.addTransaction(name, customer.gTotal()); //pass to credit card class
								card.paymentDetails(customer.gTotal(), name, cardExpiration, cardNumber); //pass everything to get payment details back
								customer.resetPrice(); //resets the price of the order to 0 for the new order
								payment = false;
							} else if (paymentMethod.toUpperCase().equals("CASH")) {
								cash.addTransaction(name, customer.gTotal()); //pass to cash class
								cash.paymentDetails(customer.gTotal(), name); //pass to get overall payment details
								customer.resetPrice(); //resets the price of the order to 0 for the new order
								payment = false;
							} else {
								System.out.println("Not a valid input, try again!\n");
							}
						
							}
					
						}
					 else if (customerChoice.toUpperCase().equals("MENU")) {
					customer.menu(); //will only display the menu, then go back to the customer 'portal'
				
					} else if (customerChoice.toUpperCase().equals("QUIT")) {
					customerVal = false;  //gets out of the customer menu, goes back to main page
				}
					else {
					System.out.println("Invalid input, try again"); //catch invalid input from customer menu
				}}}
				else if (choice.toUpperCase().equals("QUIT")) {
					System.out.println("~~~~~~~~~~~~~~~Have a great day!~~~~~~~~~~~~~~~");
					System.exit(0); //exits the entire program
				}
				else if (choice.toUpperCase().equals("E")) { //management 'portal'
					System.out.println("Please enter your password: "); //login password
					String password = "admin123";
					String passwordInput = input.next();
					
					if (password.equals(passwordInput)) {
						boolean manageVal = true; //same while loop as customer to keep it going until user decides to quit
						while (manageVal) {
						System.out.println("~~~~~~~~~~~~~~~Management Menu~~~~~~~~~~~~~~~");
						System.out.println("*INVENTORY*      *EMPLOYEE*      *TRANSACTIONS*"); //three options so far
						System.out.println("\n\nEnter '1' for Inventory, '2' for Employee, and '3' for Transactions (Enter '4' to Quit to Main Menu)");
						int choice2 = input.nextInt(); //wanted to try number based, but I can change it to string if it'll help the look of the program
						if (choice2 == 1) {
							warehouse.menu();
							warehouse.list();
						}else if (choice2 == 2) {   //employee option
							boolean statement = true;
							
							while (statement) {
							employment.employeeMenu();
							System.out.println("Add, Remove, Modify, Info, List, Quit: "); //list of options
							String pick = input.next();
							if (pick.toUpperCase().equals("ADD")) { //create employees
							System.out.println("Enter the last four digits of the Employee's SSN: ");
							int ssn = input.nextInt();
							if (employment.check(ssn) == false) {
								System.out.println("Sorry, employee already exists!"); //check
							}else { //enter general info
								System.out.println("Enter the Employee's first name: ");
								String firstname = input.next();
								System.out.println("Enter the Employee's last name: ");
								String lastname = input.next();
								System.out.println("Enter the Employee's yearly salary: ");
								double wage = input.nextDouble();
								employment.addEmployees(ssn, firstname, lastname, wage);
							}	
							}else if (pick.toUpperCase().equals("REMOVE")) { //remove employees
								System.out.println("Enter the last four digits of the Employee's SSN: ");
								int removeEmployee = input.nextInt();
								if (employment.check(removeEmployee) == false) { // check for valid employees
									employment.removeEmployee(removeEmployee);
								}else {
									System.out.println("Sorry, employee cannot be found.");
								}
							} else if (pick.toUpperCase().equals("MODIFY"))  { //modify employee information
								System.out.print("Would you like to modify the Name or Salary?");
								String modify = input.next();
								if (modify.toUpperCase().equals("NAME")) { // block to modify just the name
									System.out.print("Enter the last four digits of the Employee's SSN: ");
									int modifyName = input.nextInt();
									if (employment.check(modifyName) == true) { //another check
										System.out.print("Sorry, Employee cannot be found.");
									} else {
										System.out.println("Enter the new first name: ");
										String newfirstName = input.next();
										System.out.println("Enter the new last name: ");
										String newlastName = input.next();
										
										employment.modifyName(modifyName, newfirstName, newlastName); //pass to modify name method
									}
								} else if (modify.toUpperCase().equals("SALARY")) { //modify their wage
									System.out.print("Enter the last four digits of the Employee's SSN: ");
									int modifysalary = input.nextInt();
									if (employment.check(modifysalary) == true) {//antoher check
										System.out.print("Sorry, Employee cannot be found.");
									} else {
										System.out.println("Enter the new wage for the employee: ");
										double modifywage = input.nextDouble();
										employment.modifyWage(modifysalary, modifywage);//pass to mehtod to modify wage
									}
									}
								}
							else if (pick.toUpperCase().endsWith("INFO")) { //prints the info of an employee
								System.out.println("Which Employee's info would you like to view?");
								System.out.println("Enter last four of SSN: ");
								int viewInfo = input.nextInt();
								if (employment.check(viewInfo) == true) { //check
									System.out.print("Sorry, Employee cannot be found."); //failed check
								} else {
									employment.info(viewInfo);//pass to method
								}
								
							} else if (pick.toUpperCase().equals("LIST")) { //prints all the employees
								employment.list();
							}
							else if (pick.toUpperCase().equals("QUIT")) { //quit to manager menu
								statement = false;
							} else {
								System.out.println("Sorry, not a valid input"); //catch invclaid inputs from employee menu
							}
							}
					}else if (choice2 == 3) {
						cash.list(); //print cash transactions
						card.list(); //print credit transactions
					}
					else if (choice2 == 4) { //quit to main menu
						manageVal = false;
					}
					else {
						System.out.println("Sorry, not a valid input"); //catch invalid input from manager mener
					}}}
				else {
						System.out.println("Password incorrect, please try again"); //catches wrong password
					}
				}
				else {
						System.out.println("Not a valid input");
				}
}
		}}
	}
