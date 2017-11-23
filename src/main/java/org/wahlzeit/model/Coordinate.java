package org.wahlzeit.model;

public interface Coordinate {

    CartesianCoordinate asCartesianCoordinate();
    SphericalCoordinate asSphericalCoordinate();
    double getDistance(Coordinate coordinate);
    double getCartesianDistance(Coordinate coordinate);
    double getSphericalDistance(Coordinate coordinate);
    boolean isEqual(Coordinate coordinate);
}
