package telran.points.test;

import java.util.function.Predicate;

import telran.points.Employee;

public class PredicateGetAge implements Predicate<Employee> {

	private int  yearFrom;
	private int  yearTo;
	
public PredicateGetAge 	(int yearFrom, int yearTo)
{
	this.yearFrom = yearFrom;
	this.yearTo = yearTo;
}


	@Override
	public boolean test(Employee t) {
		
		return t.getBirthYear() >= yearFrom && t.getBirthYear()<= yearTo;
	
	}
}
