package dk.clausbomadsen.triangle;

import junit.framework.TestCase;

public class TriangleTest extends TestCase {

    Triangle [] equilateral_triangles = {
            new Triangle(3.0, 3.0, 3.0),
            new Triangle(8.5, 8.5, 8.5)
    };

    Triangle [] isosceles_triangles = {
            new Triangle(3.7, 3.7, 5.0),
            new Triangle(7.0, 4.0, 4.0),
            new Triangle(5.0, 9.5, 5.0)
    };

    Triangle [] scalene_triangles = {
            new Triangle(4.1, 5.6, 3.0),
            new Triangle(4.3, 5.7, 3.0),
            new Triangle(4.0, 6.0, 3.1)
    };

    public TriangleTest() throws Exception {
    }

    public void testGetType() {
        for (Triangle triangle: equilateral_triangles){
            assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.getType());
        }
        for (Triangle triangle: isosceles_triangles){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType());
        }
        for (Triangle triangle: scalene_triangles){
            assertEquals(Triangle.TriangleType.SCALENE, triangle.getType());
        }
    }
}