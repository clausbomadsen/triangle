package dk.clausbomadsen.triangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Triangle {
    enum TriangleType {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    private Double [] sideLengths;

    public Triangle(double lengthOfSideA, double lengthOfSideB, double lengthOfSideC){
        this.sideLengths = new Double[] {lengthOfSideA, lengthOfSideB, lengthOfSideC};
    }

    public TriangleType getType(){

        Set<Double> equalSides = new HashSet<Double>();
        equalSides.addAll(Arrays.asList(this.sideLengths));

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
