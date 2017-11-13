package org.wahlzeit.model;

public class SphericalCoordinate implements Coordinate {

    private final double latitude;
    private final double longitude;
    private final double radius;

    public SphericalCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object object) {
        //TODO
        return false;
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        //TODO
        return 0;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        //TODO
        return null;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        //TODO
        return false;
    }
}
