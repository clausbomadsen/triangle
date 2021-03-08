package dk.clausbomadsen.triangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Triangle {
    enum TriangleType {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    private double [] sideLengths;

    public double[] getSideLengths() {
        return sideLengths;
    }

    public Triangle(double lengthOfSideA, double lengthOfSideB, double lengthOfSideC) throws IllegalArgumentException {
        sideLengths = new double[] {lengthOfSideA, lengthOfSideB, lengthOfSideC};
        verifySideLengths(sideLengths);
    }

    private void verifySideLengths (double [] sideLengths) throws IllegalArgumentException {
        double [] orderedSides = sideLengths.clone();
        Arrays.sort(orderedSides);
        if (orderedSides[0] + orderedSides[1] <= orderedSides[2]){
            throw new IllegalArgumentException("Invalid side lengths for a triangle: " + Arrays.toString(sideLengths));
        }
    }

    public TriangleType getType(){
        Set<Double> equalSides = new HashSet<Double>();
        equalSides.addAll(Arrays.asList(new Double [] {this.sideLengths[0], this.sideLengths[1], this.sideLengths[2]}));

        switch (equalSides.size()){
            case 1:
                return TriangleType.EQUILATERAL;
            case 2:
                return TriangleType.ISOSCELES;
            default:
                return TriangleType.SCALENE;
        }
    }
}
