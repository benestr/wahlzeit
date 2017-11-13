package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isEqual(CartesianCoordinate coordinate) {
        return (coordinate.x == this.x) && (coordinate.y == this.y) && (coordinate.z == this.z);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof CartesianCoordinate && isEqual((CartesianCoordinate) object);
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
        //TODO
        final CartesianCoordinate cartesianCoordinate = (CartesianCoordinate) coordinate;
        return Math.sqrt(
                Math.pow(x - cartesianCoordinate.x, 2) + Math.pow(y - cartesianCoordinate.y, 2) + Math.pow(z - cartesianCoordinate.z, 2));
    }
}
