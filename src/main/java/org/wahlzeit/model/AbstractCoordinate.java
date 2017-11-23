package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    @Override
    public double getDistance(Coordinate coordinate) {
        return getCartesianDistance(coordinate);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
        return asCartesianCoordinate().doGetCartesianDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public double getSphericalDistance(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
        return asSphericalCoordinate().doGetSphericalDistance(coordinate.asSphericalCoordinate());
    }

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate();

    @Override
    public abstract SphericalCoordinate asSphericalCoordinate();

    @Override
    public abstract boolean isEqual(Coordinate coordinate);
}
