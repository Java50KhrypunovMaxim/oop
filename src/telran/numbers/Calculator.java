package telran.numbers;

import java.util.function.BinaryOperator;


public class Calculator {
    public static final char ADDITION = '+';
    public static final char MULTIPLICATION = '*';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';

    public static double calculate(CalcData cd) {
        char operator = cd.getOperation();
        double operand1 = cd.getOp1();
        double operand2 = cd.getOp2();

        DoubleBinaryOperator[] operators = {
            (a, b) -> a + b,
            (a, b) -> a * b,
            (a, b) -> a - b,
            (a, b) -> a / b
        };

        char[] signs = {ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION};
        double res = 0;

        for (int i = 0; i < signs.length; i++) {
            if (operator == signs[i]) {
                res = operators[i].apply(operand1, operand2);
                break;
            }
        }

        return res;
    }
}

interface DoubleBinaryOperator extends BinaryOperator<Double> {

}


