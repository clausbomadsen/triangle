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

    public Triangle(double lengthOfSideA, double lengthOfSideB, double lengthOfSideC) throws Exception {
        this.sideLengths = new double[] {lengthOfSideA, lengthOfSideB, lengthOfSideC};
        verifySideLengths(sideLengths.clone());
    }

    private void verifySideLengths (double [] sideLengths) throws Exception {
        Arrays.sort(sideLengths);
        if (sideLengths[0] + sideLengths[1] <= sideLengths[2]){
            throw new Exception("Invalid side lengths: " + sideLengths.toString());
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
