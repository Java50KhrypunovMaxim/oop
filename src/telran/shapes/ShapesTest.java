package telran.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapesTest {
    int height = 5;
    int width = 3;
    Canvas canvas;
    Canvas generalCanvas;
    Rectangle rect;
    Square sq;
    Predicate<Shape> predicate = shape -> true ;
    Predicate<Shape> predicate2 = shape -> shape instanceof Square;
    
    @BeforeEach
    void setUp() {
    	{
            rect = new Rectangle(height, width);
            sq = new Square(height);
            canvas = new Canvas();
            generalCanvas = new Canvas();
            canvas.addShape(rect);
            canvas.addShape(sq);
            generalCanvas.addShape(rect);
            generalCanvas.addShape(sq); 
            generalCanvas.addShape(canvas);
        }
    }

    @Test
    void testPerimeter() {
        int expected = ((height*4) + (height * 2) + (width * 2))*2;
        int actual =  generalCanvas.perimeter();
        assertEquals(expected, actual);
    }
    @Test
    void testSquare() {
        int expected = ((height*height) + (height * width))*2;
        int actual =  generalCanvas.square();
        assertEquals(expected, actual);
    }
    
    @Test
    void addShapeTest() {        
        Shape[] expected = {rect, sq, canvas};
        assertArrayEquals(expected,  generalCanvas.getShapes());
    }
    @Test
    void removeTest()
    
    {
    generalCanvas.removeNestedCanvases();
    Shape[] expected = {rect, sq};
    assertArrayEquals(expected, generalCanvas.toArray());
    }
    

    @Test
    void removeIfTest()
    {	
    	generalCanvas.removeIf(predicate);
    	Shape[] expected = {};
    	assertArrayEquals(expected,generalCanvas.toArray());
    }
    @Test
    void removeTest3()
    {
    	generalCanvas.removeIf(predicate);
    	generalCanvas.addShape(rect);
        generalCanvas.addShape(sq); 
    	generalCanvas.removeIf(predicate2);
    	Shape[] expected = {rect};
    	assertArrayEquals(expected,generalCanvas.toArray());
    }
}
