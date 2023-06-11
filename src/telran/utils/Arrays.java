package telran.utils;
import static java.util.Arrays.*;

import java.util.Comparator;
import telran.utils.EvenOddComparator;

public class Arrays {
///////////////////////Additional Task 1
	
public static int maxSubsequenceLength(int[] arr)
{
int maxLenth= 1;
int counter = 1;
for (int i = 0; arr.length-1 > i; i++)
{
	if (arr[i]==arr[i+1])
	{
	counter++;
	if (counter>maxLenth)
		{maxLenth = counter;}
	}
	else counter = 1;
}
return maxLenth >1 ?maxLenth:0;
}
///////////////////////Additional Task 2	
public static String toBinaryStr(int number) {
    
	if (number == 0) {
        return "0";}
     String stringBinary = "";
     while (number >0)
     {
    	 stringBinary = (number%2) + stringBinary;
    	 number/=2;
     }
     return stringBinary;
    }	

	
	
	
////////////////////////////////////////
 public static <T> T[] addObject(T[] array,T obj){
  T[] res = copyOf(array, array.length +1);
  res[array.length] = obj;
  return res;
 }
 public static <T> T[] insertObject(T[]array,int index, T obj) {
  T[] res = copyOf(array, array.length+1);
  System.arraycopy(array, 0, res, 0,index);
  System.arraycopy(array, index, res, index+1, array.length-index);
  res[index] = obj;
  return res;
 }
 public static <T> void bubbleSort(T[] array, Comparator<T> comp) {
	  boolean flSorted = false;
	  int length = array.length;  
	  do {
	   flSorted = true;
	   length--;
	   for (int i = 0; i < length; i++) {
	    if (comp.compare(array[i], array[i + 1]) > 0) {
	     swap(array, i, i + 1);
	     flSorted = false;
	    }
	   }
	  } while (!flSorted);
	 }
 
 private static <T> void swap(T[] array, int i, int j)
 {
	 T tmp = array [i];
	 array [i] = array [j];
	 array [j] =tmp;
 }

}