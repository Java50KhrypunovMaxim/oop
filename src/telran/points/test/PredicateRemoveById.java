package telran.points.test;

import java.util.function.Predicate;

import telran.points.Employee;

public class PredicateRemoveById implements Predicate<Employee> {

	private int id;
		
	public  PredicateRemoveById  (int id)
	{
		this.id = id;
	}

		@Override
	
		public boolean test (Employee t) {
			
			return t.getId() == id;
		}
		
		
		

	}
	
		
	