package telran.points.test;

import java.util.Comparator;

import telran.points.Employee;

public class ComparatorGetSalary implements Comparator<Employee> {

	@Override
	 public int compare(Employee employee1, Employee employee2) 
		{
			 return employee1.getSalary()- employee2.getSalary();
	    }
}
