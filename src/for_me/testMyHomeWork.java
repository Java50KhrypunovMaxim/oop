package for_me;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testMyHomeWork {

	@Test
		void bubbleSortComparatorTest() {
		Integer [] expected = {8, 10, 22, 100, 200, 7, 5, 3, 1, -5};
		Integer [] array = {10, 5,-5, 1, 7, 8, 22, 100, 200,3};
		forMyHomeWork.bubbleSort(array,new EvenOddComparator());
		assertArrayEquals(expected,array);
	}
	@Test
	void calculateTest() {
		assertEquals(20, Calculator.calculate(new CalcData(40, 20, '-')));
		assertEquals(0.5, Calculator.calculate(new CalcData(1, 2, '/')));
		assertEquals(1, Calculator.calculate(new CalcData(0.5, 2, '*')));
		assertEquals(0.74, Calculator.calculate(new CalcData(0.5, 0.24, '+')));
		assertThrows(UnsupportedOperationException.class, () -> Calculator.calculate(new CalcData(0.5, 0.24, '?')));
		assertThrows(ArithmeticException.class, () -> Calculator.calculate(new CalcData(10, 0, '/')));
	}

}
