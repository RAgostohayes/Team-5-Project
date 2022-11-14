import java.util.HashMap;
import java.util.Map;


public class Employees {

	private Map<Integer, String> employee; // both use the same key, one value holds the name, the other holds the wage
	private Map<Integer, Double> salary;
	public Employees() {
		employee = new HashMap<>(); //initialize maps
		salary = new HashMap<>();
		//dummy information
		employee.put(6278, "Antonio Aldaz");
		employee.put(5903, "Ryan Hayes");
		employee.put(4521, "Bill Gates");
		salary.put(4521, 100000000.67);
		salary.put(6278, 34659.63);
		salary.put(5903, 39154.36);
		
	}
	
	
	public void addEmployees (int SSN, String firstName, String lastName, double wage) {
		
		employee.put(SSN, firstName +" "+ lastName); // add the ending of the SSN and full name to a map
		salary.put(SSN, wage); //SSN and wage adds to the map
	}
	public void removeEmployee (int SSN) {
		employee.remove(SSN); //remove from both maps
		salary.remove(SSN);
	}
	public void modifyName (int SSN, String newName, String newlastName) {
		employee.put(SSN, newName +" "+ newlastName); //only to modify name. Pass new info to the map
	}
	public void modifyWage (int SSN, double wageChange) { //only to modify wage. Pass new info to the map
		salary.put(SSN, wageChange);
	}
	public boolean check(int ssn) { //checks for the SSN. If it exists, it returns false
		if (employee.containsKey(ssn)) {
		return false;
		}else {
			return true;
		}
		
	}
	public void info (int SSN) { //prints the specific employee from the SSN
	
	
			System.out.println("Name: " +employee.get(SSN) + "\nSalary: $" + salary.get(SSN));
	}
	
	public void list () { // prints the list of employees
		for (Map.Entry<Integer, String> list : employee.entrySet()) {
			
			System.out.printf("Employee SSN: XXXXXXX%s	Employee Name: %s	Employee Salary: $%s\n",list.getKey(), list.getValue(), salary.get(list.getKey()));
		}
	}
	public void employeeMenu () {
		
		
		//Just the top of the menu to identify where the user is.
		System.out.println("~~~~~~~~~~~~~~~Employee Menu~~~~~~~~~~~~~~~");
		
		
		}
			}
			
		
