import java.util.ArrayList;

abstract class Employee {
	private String name;

	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public abstract double calculateSalary();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", calculateSalary()=" + calculateSalary() + "]";
	}

}

class FullTimeEmployee extends Employee {

	private double monthySalary;

	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return monthySalary;
	}

}

class PartTimeEmployee extends Employee {

	private int hoursWork;
	private double hourlyRate;

	public PartTimeEmployee(String name, int id, int hoursWork, double hourlyRate) {
		super(name, id);
		// TODO Auto-generated constructor stub
		this.hourlyRate = hourlyRate;
		this.hoursWork = hoursWork;
	}

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return hourlyRate * hoursWork;
	}

}

class PayRollSystem {

	// ArrayList<Integer> arr = new ArrayList<>();

	private ArrayList<Employee> employeeList;

	public PayRollSystem() {
		employeeList = new ArrayList<>();

	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		System.out.println("Removing Below Employee");
		displayEmployeeById(id);
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}

		}
		if (employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
	}

	public void displayEmployee() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}

	public void displayEmployeeById(int id) {
		System.out.println("Employee With id " + id + " is: - ");
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				System.out.println(employee);
			}
		}
	}

}

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Payrool Management System");

		PayRollSystem payRollSystem = new PayRollSystem();

		FullTimeEmployee emp1 = new FullTimeEmployee("Karan", 1, 47608.90);

		PartTimeEmployee emp2 = new PartTimeEmployee("Bharat", 2, 40, 1800.90);

		PartTimeEmployee emp3 = new PartTimeEmployee("KT", 3, 45, 1800.90);

		payRollSystem.addEmployee(emp1);
		payRollSystem.addEmployee(emp2);
		payRollSystem.addEmployee(emp3);

		System.out.println("Initial Employeee Details");
		payRollSystem.displayEmployee();

		payRollSystem.displayEmployeeById(1);
		payRollSystem.displayEmployeeById(2);
		payRollSystem.displayEmployeeById(3);
		// payRollSystem.displayEmployeeById(3);

		System.out.println("Removing Employee");
		payRollSystem.removeEmployee(1);
		//
		System.out.println();
		System.out.println("Displaying Employees LEft in the organization");
		payRollSystem.displayEmployee();

	}
}
