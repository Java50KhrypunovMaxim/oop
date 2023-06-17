package telran.numbers;

import java.util.Map;
import java.util.function.BinaryOperator;


public class Calculator2

{
    public static final char ADDITION = '+';
    public static final char MULTIPLICATION = '*';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';

    public static double calculate(CalcData cd) {
        

        Map<Character, DoubleBinaryOperator> operators = Map.of(
        	    ADDITION, (a, b) -> a + b,
        	    MULTIPLICATION, (a, b) -> a * b,
        	    SUBTRACTION, (a, b) -> a - b,
        	    DIVISION, (a, b) -> a / b
        	);
        
        char operator = cd.getOperation();
        double operand1 = cd.getOp1();
        double operand2 = cd.getOp2();
        DoubleBinaryOperator operation = operators.get(operator);
        return operation.apply(operand1, operand2);
    }
}

