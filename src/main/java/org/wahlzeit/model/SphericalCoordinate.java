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
    public SphericalCoordinate asSphericalCoordinate() {
        return null;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(!(coordinate instanceof SphericalCoordinate)) {
            return false;
        }
        final SphericalCoordinate sphericalCoordinate = (SphericalCoordinate) coordinate;
        return latitude == sphericalCoordinate.latitude && longitude == sphericalCoordinate.longitude && radius == sphericalCoordinate.radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }
}
