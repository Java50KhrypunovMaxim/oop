package telran.points;

import java.util.Comparator;

public class Employee implements Comparable<Employee>
{
	private final int id;
	private final String name;
	private final int birthYear;
	private final String department;
	private final int salary;
	
	public Employee(int id, String name, int birthYear, String department, int salary)
	{
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.department =  department;
		this.salary = salary;
	}
	public int compareTo(Employee employee) 
	{
		int res = 0;
		if (this.id < employee.id) res = -1;
		else if (this.id > employee.id) res = 1;
		else if (this.id == employee.id) res = 0;
		return res;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}
	public static Comparator<Employee> employeeBirthYearComparator = new Comparator<Employee>() 
	{
	    @Override
	    public int compare(Employee employee1, Employee employee2) {
	        int birthYear1 = employee1.getBirthYear();
	        int birthYear2 = employee2.getBirthYear();
	        
	        if (birthYear1 < birthYear2) {
	            return -1;
	        } else if (birthYear1 > birthYear2) {
	            return 1;
	        } else {
	            return 0;
	        }
	    }
	};

	@Override
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", department=" + department
				+ ", salary=" + salary + "]";
	}
	@Override
	public boolean equals(Object emplObj)
	{
		Employee employee = (Employee)emplObj;
		return this.id == employee.id;
	}

}
