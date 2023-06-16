package telran.points;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Firm {
private Employee [] myFirmEmployes;
public Firm(Employee [] myFirmEmployes)
{
	this.myFirmEmployes = Arrays.copyOf(myFirmEmployes, myFirmEmployes.length);
}

public Employee[] getAllEmployees (Comparator<Employee> comp) 
{
	 Employee[]res = Arrays.copyOf(myFirmEmployes, myFirmEmployes.length);
	 Arrays.sort(res,comp);
	 return res;
}

public Employee[] getBy (Predicate<Employee> predicate, Comparator<Employee>comp)
{
	Employee[]res = Arrays.copyOf(myFirmEmployes, myFirmEmployes.length);
	res = new Employee[myFirmEmployes.length];
	int index = 0;
	for (int i = 0; i<myFirmEmployes.length; i++)
	{
		if(predicate.test(myFirmEmployes[i]))
		{
			res [index++] = myFirmEmployes[i];
		}
	}
	res = Arrays.copyOf(res, index);
	Arrays.sort(res,comp);
	return res;	
}

public Employee[] getEmployeesByAge (Predicate<Employee> predicate, Comparator<Employee>comp)
{
	Employee[] res = getBy (predicate,comp);
	return res;
}

public Employee[] getEmployeesBySalary (Predicate<Employee> predicate, Comparator<Employee>comp)
{
	Employee[] res = getBy (predicate,comp);
	return res;
}

public Employee[] getEmployeesByDepartment (Predicate<Employee> predicate, Comparator<Employee>comp)
{
	Employee[] res = getBy (predicate,comp);
	return res;
}

public void addEmployee(Employee myEmployee)
{
	myFirmEmployes = Arrays.copyOf(myFirmEmployes, myFirmEmployes.length+1);
	myFirmEmployes[myFirmEmployes.length-1] = myEmployee;
}


public boolean removeEmployeeByPredicate(Predicate<Employee> predicate)
{
	int oldSize = myFirmEmployes.length;
	Employee [] tmp = new Employee [oldSize];
	int index = 0;
	for (int i = 0; i<oldSize; i++)
	{
		if(!predicate.test(myFirmEmployes[i]))
		{
			tmp [index++] = myFirmEmployes[i];
		}
	}
	this.myFirmEmployes = Arrays.copyOf(tmp, index);
	return oldSize>myFirmEmployes.length;
}

public Employee getEmployee(int id) {
	Employee res = null;
	int index = 0;
	while(index < myFirmEmployes.length && res == null) {
		if(myFirmEmployes[index].getId() == id) {
			res = myFirmEmployes[index];
		}
		index++;
	}
	return res;
}}
