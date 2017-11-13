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

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        final double latitude = 90 -Math.atan(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / z) * 180 / Math.PI;
        final double longitude = Math.atan(y / x) * 180 / Math.PI;
        final double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        //TODO
        return new SphericalCoordinate(latitude, longitude, radius);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(!(coordinate instanceof CartesianCoordinate)) {
            return false;
        }
        final CartesianCoordinate cartesianCoordinate = (CartesianCoordinate) coordinate;
        return (cartesianCoordinate.x == this.x) && (cartesianCoordinate.y == this.y) && (cartesianCoordinate.z == this.z);
    }
}