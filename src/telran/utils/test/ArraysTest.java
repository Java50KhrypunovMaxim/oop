package telran.utils.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.utils.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.utils.DigitsSumComporator;
import telran.utils.EvenOddComparator;


class ArraysTest {
 Integer[] numbers = {10,5,-5,100,200};
 String[] strings = {"lmn","a","ab","abc","b","ba"};
 @Test
 void addObjectTest() {
  Integer[]expectedNumbers = {10,5,-5,100,200,50};
  assertArrayEquals(expectedNumbers,addObject(numbers,50));
  String[] expectedStrings = {"lmn","a","ab","abc","b","ba","bb"};
  assertArrayEquals(expectedStrings, addObject(strings,"bb"));
  
 }
@Test
void insertObjectTest(){
 Integer[]expectedLast = {10,5,-5,100,200,50};
 Integer[]expectedFirst = {50,10,5,-5,100,200};
 Integer[]expectedMidle = {10,5,50,-5,100,200};
 assertArrayEquals(expectedLast,insertObject(numbers,5, 50));
 assertArrayEquals(expectedFirst,insertObject(numbers,0, 50));
 assertArrayEquals(expectedMidle,insertObject(numbers,2, 50));
}
@Test
void digitsSumComparator()
{
    Comparator<Integer> comp = new  DigitsSumComporator();
	assertTrue(comp.compare(9, 66)<0);
	assertTrue(comp.compare(9, 1111)>0);
	assertTrue(comp.compare(3, -111)==0);
}
@Test
void standardSortComparatorTest() 
{
	Integer [] array = {10, 5, 110, 9, 22, 33};
	Integer [] expected = {10, 110, 22, 5, 33, 9};
	Arrays.sort(array, new  DigitsSumComporator());
	assertArrayEquals(expected,array);
}
@Test
void bubbleSortComparatorTest() {
Integer [] expected= {10, 100, 200, 5, -5};
Integer [] array = {10, 5,-5, 100, 200};
bubbleSort(array, new EvenOddComparator());
assertArrayEquals(expected,array);
Integer [] expected1= {4, 6, 8, 10, 1, 5};
Integer [] array1 = {6, 8, 1, 4, 5, 10};
bubbleSort(array1, new EvenOddComparator());
assertArrayEquals(expected1,array1);
Integer [] expected2= {-4, 2, 2, 2, 3, 3};
Integer [] array2 = {2,3, 2, 3, 2, -4};
bubbleSort(array2, new EvenOddComparator());
assertArrayEquals(expected2,array2);



}

}