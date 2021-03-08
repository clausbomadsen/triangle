package dk.clausbomadsen.triangle;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    public void testIllegalArguments(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(2.0, 3.0, 7.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(14.0, 9.1, 4.9);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(5.1, 11.3, 6.1);
        });
    }

    public void testGetSideLengths(){
        double [] sideLengths = new double [] {3.0, 7.1, 5.1};
        assertArrayEquals(
                sideLengths,
                new Triangle(sideLengths[0], sideLengths[1], sideLengths[2]).getSideLengths()
        );
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