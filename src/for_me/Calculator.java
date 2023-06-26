package for_me;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
static char [] operators = {'+', '-', '*', '%','/'};

static DoubleBinaryOperator[] operation = {
		(a, b) -> a + b,
		(a, b) -> a - b,
		(a, b) -> a * b,	
		(a, b) -> a * 100/b,
		(a, b) -> {
			if(b == 0) {
				throw new ArithmeticException("division on 0");
			}
			return a / b;
		}};
		
static public double calculate(CalcData cd)  
{
 int res = -1;
 char simpol = cd.getOperation();
 for (int i = 0; i < operators.length; i++)
 {
	 if  (operators[i] == simpol)
     {res = i;
     break;}
 }
 if (res == -1)
 {
	 throw new UnsupportedOperationException(" operation " + cd.operation);
 }
return operation[res].applyAsDouble(cd.op1, cd.op2);
}

}

