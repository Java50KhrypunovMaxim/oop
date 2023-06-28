package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape, Iterable<Shape> {
   
	private Shape[] shapes = new Shape[0];

    public Shape [] toArray() 
    	{
        	Shape  newShape [] = new Shape[Short.MAX_VALUE];
    		int index = 0;
    		for(Shape element: this) {
    			newShape[index++] = element;
    		}
    		return Arrays.copyOf(newShape, index);
    	}
    
    private class CanvasIterator implements Iterator<Shape> {
       
        int current = 0;
        
        @Override
        public boolean hasNext() {
            return current < shapes.length;
        }

        public Shape next() {
        	   
        	   while(!hasNext()) {
        	    throw new NoSuchElementException();
        	   }
        	   Shape newShape = shapes[current];
        	   current++;
        	   return newShape;
        }

        @Override
        public void remove() {
        	   if (current <= 0) {
        	          throw new IllegalStateException();
        	      }
        	      int removeCurrent = current - 1;
        	      Shape[] newShapes = new Shape[shapes.length - 1];
        	      System.arraycopy(shapes, 0, newShapes, 0, removeCurrent);
        	      System.arraycopy(shapes, removeCurrent + 1, newShapes, removeCurrent, shapes.length - removeCurrent - 1);
        	      shapes = newShapes;
        	      current--;
        	  }}

    

    @Override
    public int perimeter() {
        int sum = 0;
        for (Shape shape : this) {
            sum += shape.perimeter();
        }
        return sum;
    }

    @Override
    public int square() {
        int sum = 0;
        for (Shape shape : this) {
            sum += shape.square();
        }
        return sum;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new CanvasIterator();
    }

    public void addShape(Shape shape) {
        Shape[] newShapes = new Shape[shapes.length + 1];
        System.arraycopy(shapes, 0, newShapes, 0, shapes.length);
        newShapes[shapes.length] = shape;
        shapes = newShapes;
    }

    public boolean removeIf(Predicate<Shape> predicate) {
        int oldLength = shapes.length;
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            Shape shape = it.next();
            if (predicate.test(shape)) {
                it.remove();
            }
        }
        return oldLength > shapes.length;
    }

    public boolean removeNestedCanvases() {
        return removeIf(shape -> shape instanceof Canvas);
    }

    public Shape[] getShapes() {
        return shapes;
    }
   
}