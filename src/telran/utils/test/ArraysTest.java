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
 void additionalTask1Test()
 {
	 int [] arr = {1,3,3,2,8,8,8,5,6,6};
	 assertEquals (3,maxSubsequenceLength(arr));
	 int [] arr1 = {1,3,3,2,8,8,8,5,6,6,4,1,1,1,1};
	 assertEquals (4,maxSubsequenceLength(arr1));
	 int [] arr2 = {1,2,3,4,5,6,7};
	 assertEquals (0,maxSubsequenceLength(arr2));
 }
 
 void additionalTask2Test()
 {
	 int number = 170289;
	 assertEquals (Integer.toBinaryString(number),toBinaryStr(number)); 
	 number = 0;
	 assertEquals (Integer.toBinaryString(number),toBinaryStr(number));
 }
 
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
Integer [] expected1= {4, 6, 8, 10, 5, 1};
Integer [] array1 = {6, 8, 1, 4, 5, 10};
bubbleSort(array1, new EvenOddComparator());
assertArrayEquals(expected1,array1);
Integer [] expected2= {-4, 2, 2, 2, 3, 3};
Integer [] array2 = {2,3, 2, 3, 2, -4};
bubbleSort(array2, new EvenOddComparator());
assertArrayEquals(expected2,array2);
}

@Test
void bubbleSortComparatorTestLambda() 
{
Integer [] expected= {10, 100, 200, 5, -5};
Integer [] array = {10, 5,-5, 100, 200};
//bubbleSort(array, (a,b)->compare(a,b));
//bubbleSort(array, (o1,o2) ->
//{
//	int res = 1;
//	if (o1%2==0 && o2%2==0)
//	{res = o1-o2;}
//	else if (o1%2!=0 && o2%2!=0)
//	{res = o2-o1;}
//	else if (o1%2==0 && o2%2!=0)
//	{res = -1;}
//	return res;
//}	);
bubbleSort(array, ArraysTest::compare);
assertArrayEquals(expected,array);


}
static private int compare(Integer o1, Integer o2) 
{
	int res = 1;
	if (o1%2==0 && o2%2==0)
	{res = o1-o2;}
	else if (o1%2!=0 && o2%2!=0)
	{res = o2-o1;}
	else if (o1%2==0 && o2%2!=0)
	{res = -1;}
	return res;
}	

}