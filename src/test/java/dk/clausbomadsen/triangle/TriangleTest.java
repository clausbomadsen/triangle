package dk.clausbomadsen.triangle;

import junit.framework.TestCase;

public class TriangleTest extends TestCase {
    Triangle equilateral = new Triangle(3.0, 3.0, 3.0);
    Triangle isosceles = new Triangle(3.0, 3.0, 7.0);
    Triangle scalene = new Triangle(4.0, 5.0, 3.0);

    public void testGetType() {
        assertEquals(Triangle.TriangleType.EQUILATERAL, equilateral.getType());
        assertEquals(Triangle.TriangleType.ISOSCELES, isosceles.getType());
        assertEquals(Triangle.TriangleType.SCALENE, scalene.getType());

    }
}