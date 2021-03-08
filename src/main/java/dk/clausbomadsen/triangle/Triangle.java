package dk.clausbomadsen.triangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  A Class to represent objects of valid triangles and appropriate related methods for those.
 *  Side lengths provided for the constructor must be valid for a triangle or it will throw an
 *  IllegalArgumentException.
 */
public class Triangle {

    enum TriangleType {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    private final double [] sideLengths;

    public double[] getSideLengths() {
        return sideLengths;
    }

    public Triangle(double lengthOfSideA, double lengthOfSideB, double lengthOfSideC) throws IllegalArgumentException {
        sideLengths = new double[] {lengthOfSideA, lengthOfSideB, lengthOfSideC};
        verifySideLengths(sideLengths);
    }

    /**
     * Verify that the provided lengths corresponds to a valid triangle.
     * Any two sides combined must be larger than the third.
     */
    private void verifySideLengths (double [] sideLengths) throws IllegalArgumentException {
        double [] orderedSides = sideLengths.clone();
        Arrays.sort(orderedSides);
        if (orderedSides[0] + orderedSides[1] <= orderedSides[2]){
            throw new IllegalArgumentException("Invalid side lengths for a triangle: " + Arrays.toString(sideLengths));
        }
    }

    /**
     *  Get the type of triangle represented by the enum TriangleType.
     *  The type of the triangle is governed by how many equal sides it has.
     *
     *      TriangleType
     *          EQUILATERAL - All sides are equal length
     *          ISOSCELES   - Two sides are equal length
     *          SCALENE     - All sides have different length
     */
    public TriangleType getType(){
        Set<Double> uniqueSideLengths = new HashSet<Double>(
                Arrays.asList(new Double[]{this.sideLengths[0], this.sideLengths[1], this.sideLengths[2]})
        );

        switch (uniqueSideLengths.size()){
            case 1:
                return TriangleType.EQUILATERAL;
            case 2:
                return TriangleType.ISOSCELES;
            default:
                return TriangleType.SCALENE;
        }
    }
}
