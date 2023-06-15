package telran.points.test;

import java.util.Comparator;

import telran.points.Employee;

public class ComparatorGetAge implements Comparator<Employee> {

	@Override
	 public int compare(Employee employee1, Employee employee2) 
	{
		 return employee2.getBirthYear()-employee1.getBirthYear();
    }


}

