package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape, Iterable<Shape> {
    private Shape[] shapes = new Shape[0];
    private Shape[] trashCan = new Shape[0];
    
    public Shape [] toArray() {
    	
        	Shape  newShape [] = new Shape[Short.MAX_VALUE];
    		int index = 0;
    		for(Shape element: this) {
    			newShape[index++] = element;
    		}
    		return Arrays.copyOf(newShape, index);
    	}
    
    private class CanvasIterator implements Iterator<Shape> {
       
        int current = containsInRemoved(shapes[0]) ? getCurrent(0) : 0;
        boolean flNext = false;
        int previous = 0;
        
        @Override
        public boolean hasNext() {
            return current < shapes.length;
        }

        @Override
        public Shape next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int res = current;
            previous = current;
            current = getCurrent(current);
            flNext = true;
            return shapes[res];
        }

        @Override
        public void remove() {
        	
        	if (!flNext){
                throw new IllegalStateException();
            }
        	flNext = false;
        	trashCan = Arrays.copyOf(trashCan, trashCan.length + 1);
        	trashCan[trashCan.length - 1] = shapes[previous];
          
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

    private int getCurrent(int current) {
        current++;
        while (current < shapes.length && containsInRemoved(shapes[current])) {
            current++;
        }
        return current;
    }

    private boolean containsInRemoved(Shape shape) {
        boolean res = false;
        int index = 0;
        while (index < trashCan.length && !res) {
            if (trashCan[index].equals(shape)) {
                res = true;
            }
            index++;
        }
        return res;
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
    public Shape [] getRemovedShapes() {
		return trashCan;
	}
}