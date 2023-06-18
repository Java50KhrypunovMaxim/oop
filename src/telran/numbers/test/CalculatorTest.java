package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BinaryOperator;

import org.junit.jupiter.api.Test;

import telran.numbers.AddTask_3_And_4;
import telran.numbers.CalcData;
import telran.numbers.Calculator;
import telran.numbers.Calculator2;

class CalculatorTest {

	@Test
	void test() {
		BinaryOperator<Double> bo = (a,b) -> a + b;
		bo.apply(10.0, 20.0);
		assertEquals(30, bo.apply(10.0, 20.0));
		DoubleBinaryOperator [] operators =
			{
				 (a,b) -> a + b,
				 (a,b) -> a - b,
				 (a,b) -> a * b,
				 (a,b) -> a / b
			};
		double[] res = {30, 10, 200, 2};
		double op1 =20;
		double op2 =10;
		for (int i = 0; i<operators.length;i++)
		{
			assertEquals(res[i],operators[i].apply(op1, op2));
		}
		
	}
	
@Test
void calcilateTest()
{
	assertEquals(20, Calculator.calculate(new CalcData(40,20,'-')));
	assertEquals(60, Calculator.calculate(new CalcData(40,20,'+')));
	assertEquals(800, Calculator.calculate(new CalcData(40,20,'*')));
	assertEquals(2, Calculator.calculate(new CalcData(40,20,'/')));
}
@Test
void calcilate2Test()
{
	assertEquals(20, Calculator2.calculate(new CalcData(40,20,'-')));
	assertEquals(60, Calculator2.calculate(new CalcData(40,20,'+')));
	assertEquals(800, Calculator2.calculate(new CalcData(40,20,'*')));
	assertEquals(2, Calculator2.calculate(new CalcData(40,20,'/')));
}
@Test
void addTask3()
{
	assertTrue(AddTask_3_And_4.isAnagram("MaximMax","axMMixaM"));
	assertFalse(AddTask_3_And_4.isAnagram("MaximMafx","axMMixaM"));
}
@Test
void addTask4()
{
	assertTrue(AddTask_3_And_4.hasValidBrackets("aaaaa (sdfsdfdsf[dfd(f)f] zcvzxcv {{[ghjk]}} asd )"));
	assertFalse(AddTask_3_And_4.hasValidBrackets(")dfgswfgsf("));
	assertFalse(AddTask_3_And_4.hasValidBrackets("[werwert(wertwrtw] wertrt)"));
}

}

 interface DoubleBinaryOperator extends BinaryOperator<Double>
 {
	 
 }


