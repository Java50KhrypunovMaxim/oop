package telran.points.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.points.Employee;
import telran.points.Firm;
import telran.points.Point;
import telran.points.Space;

class FirmTest {
Firm firm;
Employee [] myEmployes = {
		new Employee (13300,"Maxim",1989,"Software",15000), 
		new Employee (12450,"Anatoliy",1991,"Software",12000), 
		new Employee (12550,"Alex",1985,"QA",10000),
		new Employee (12650,"Dan",1987,"Manadger",18000),
		new Employee (12750,"Gosha",1991,"Clining",8000),
		new Employee (12850,"Margo",1999,"Clining",8000)};


@BeforeEach
void setUp() throws Exception
{
	firm = new Firm (myEmployes);
}
@Test
void getAllEmployeeTest()
{
	Employee[] expected = {
			 
			new Employee (12450,"Anatoliy",1991,"Software",12000), 
			new Employee (12550,"Alex",1985,"QA",10000),
			new Employee (12650,"Dan",1987,"Manadger",18000),
			new Employee (12750,"Gosha",1991,"Clining",8000),
			new Employee (12850,"Margo",1999,"Clining",8000),
			new Employee (13300,"Maxim",1989,"Software",15000)};
	
	assertArrayEquals(expected,firm.getAllEmployees(Comparator.naturalOrder()));
}
@Test
void addEmployeeTest()
{
			Employee[] expected = {
			 
			new Employee (12450,"Anatoliy",1991,"Software",12000), 
			new Employee (12550,"Alex",1985,"QA",10000),
			new Employee (12650,"Dan",1987,"Manadger",18000),
			new Employee (12750,"Gosha",1991,"Clining",8000),
			new Employee (12850,"Margo",1999,"Clining",8000),
			new Employee (13300,"Maxim",1989,"Software",15000),
			new Employee (13400,"Irina",1989,"QA",12000)};
	firm.addEmployee(new Employee (13400,"Irina",1989,"QA",12000));
	assertArrayEquals(expected,firm.getAllEmployees(Comparator.naturalOrder()));
}
@Test
void getEmployeesByAgeTest()
{
			Employee[] expected = {
					new Employee (12450,"Anatoliy",1991,"Software",12000), 
					new Employee (12750,"Gosha",1991,"Clining",8000),
					new Employee (13300,"Maxim",1989,"Software",15000)};
			assertArrayEquals(expected,firm.getEmployeesByAge(new PredicateGetAge(1988, 1991), new ComparatorGetAge()));
}

@Test
void getEmployeesBySalaryTest() 
{
Employee [] expected  = {
		new Employee (12750,"Gosha",1991,"Clining",8000),
		new Employee (12850,"Margo",1999,"Clining",8000),
		new Employee (12550,"Alex",1985,"QA",10000),
		new Employee (12450,"Anatoliy",1991,"Software",12000), 
		new Employee (13300,"Maxim",1989,"Software",15000),
		};
assertArrayEquals(expected,firm.getEmployeesBySalary(new PredicateGetSalary(8000, 15000), 
		new ComparatorGetSalary()));
}

@Test
void getEmployeesByDepartmentTest()
{
Employee [] expected = {
		new Employee (12450,"Anatoliy",1991,"Software",12000), 
		new Employee (13300,"Maxim",1989,"Software",15000)};
assertArrayEquals(expected,firm.getEmployeesByDepartment(new PredicateGetDepartment("Software"), 
		Comparator.naturalOrder()));
}

void removeByIDTest()
{
	Employee[] expected = {
			 
			new Employee (12450,"Anatoliy",1991,"Software",12000), 
			new Employee (12550,"Alex",1985,"QA",10000),
			new Employee (12650,"Dan",1987,"Manadger",18000),
			new Employee (12850,"Margo",1999,"Clining",8000),
			new Employee (13300,"Maxim",1989,"Software",15000)};
	assertTrue (firm.removeEmployeeByPredicate(new PredicateRemoveById(12750), Comparator.naturalOrder()));
	assertArrayEquals(expected,firm.getAllEmployees(Comparator.naturalOrder()));
}

void removeByDepartmentTest()
{
	Employee[] expected = {
	new Employee (12450,"Anatoliy",1991,"Software",12000), 
	new Employee (12550,"Alex",1985,"QA",10000),
	new Employee (12650,"Dan",1987,"Manadger",18000),
	new Employee (13300,"Maxim",1989,"Software",15000)};
	
	assertTrue (firm.removeEmployeeByPredicate(new PredicateGetDepartment("Clining"), Comparator.naturalOrder()));
	assertArrayEquals(expected,firm.getAllEmployees(Comparator.naturalOrder()));
}
void removeBySalaryTest()
{
	Employee[] expected = {
			 
			new Employee (12650,"Dan",1987,"Manadger",18000),
			new Employee (13300,"Maxim",1989,"Software",15000)};
	assertTrue (firm.removeEmployeeByPredicate(new PredicateGetSalary(8000, 14000), Comparator.naturalOrder()));
	assertArrayEquals(expected,firm.getAllEmployees(Comparator.naturalOrder()));
}

}