package for_me;

import java.util.Comparator;

public class forMyHomeWork {
	
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
