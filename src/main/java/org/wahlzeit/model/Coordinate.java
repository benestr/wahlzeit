package org.wahlzeit.model;

public interface Coordinate {

    double getDistance(Coordinate coordinate);
    CartesianCoordinate asCartesianCoordinate();
    boolean isEqual(Coordinate coordinate);
}
