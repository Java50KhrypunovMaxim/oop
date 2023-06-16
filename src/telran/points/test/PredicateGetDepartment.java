package telran.points.test;

import java.util.function.Predicate;

import telran.points.Employee;

public class PredicateGetDepartment implements Predicate<Employee> {

	private String department;

public PredicateGetDepartment  (String department)
{
	this.department = department;
}

	@Override
	public boolean test (Employee t) {
		
		return t.getDepartment().equals(department);
	}
	
}
