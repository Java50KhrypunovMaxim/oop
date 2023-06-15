package telran.points.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.utils.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.points.Point;
import telran.points.Space;
import telran.utils.DigitsSumComporator;
import telran.utils.EvenOddComparator;


class SpaceTest {
	Space space;
	Point [] points = {new Point (10,10), new Point (3,4),new Point (0,0)};

@BeforeEach
void setUp() throws Exception
{
	space = new Space(points);
}

@Test
void getAllPointsTest()
{
	Point[] expected = {new Point(0,0), new Point (3,4),new Point (10,10)};
	assertArrayEquals(expected,space.getAllPoints(Comparator.naturalOrder()));
}
@Test
void addPointTest()
{
	Point[] expected = {new Point(0,0), new Point (3,4), new Point (10,10), new Point (20,20)};
	space.addPoint(new Point(20,20));
	assertArrayEquals(expected,space.getAllPoints(Comparator.naturalOrder()));
}
@Test
void removePointTest()
{
	Point[] expected = {new Point (3,4)};
	assertTrue(space.removePointsByPredicate(new XyEquals()));
	assertArrayEquals(expected,space.getAllPoints(Comparator.naturalOrder()));
}
@Test
void getPointByPredicateTest()
{
	Point[] expected = {new Point(0,0),new Point (10,10)};
	assertArrayEquals(expected,space.getPointsByPredicate(new XyEquals(), Comparator.naturalOrder()));
}

}
