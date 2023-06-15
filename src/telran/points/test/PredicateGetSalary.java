package telran.points.test;

import java.util.function.Predicate;

import telran.points.Employee;

public class PredicateGetSalary implements Predicate<Employee> {

	private int salaryFrom;
	private int salaryTo;

public PredicateGetSalary  (int salaryFrom, int salaryTo)
{
	this.salaryFrom = salaryFrom;
	this.salaryTo = salaryTo;
}

	@Override
	public boolean test (Employee t) {
		
		return t.getSalary() >= salaryFrom && t.getSalary()<= salaryTo;
	}
	

}

