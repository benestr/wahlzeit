package org.wahlzeit.model;

public class SphericalCoordinate extends AbstractCoordinate {
    private final double latitude;

    private final double longitude;
    private final double radius;

    private static final double EARTH_RADIUS = 6_371_000;

    public SphericalCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS);
    }

    public SphericalCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        checkClassInvariants();
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

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        final double x = radius * Math.sin(Math.toRadians(90 - latitude)) * Math.cos(Math.toRadians(longitude));
        final double y = radius * Math.sin(Math.toRadians(90 - latitude)) * Math.sin(Math.toRadians(longitude));
        final double z = radius * Math.cos(Math.toRadians(90 - latitude));

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        return this;
    }

    double doGetSphericalDistance(SphericalCoordinate sphericalCoordinate) {
        if (sphericalCoordinate.radius != radius) {
            throw new UnsupportedOperationException("Spherical distance only between coordinates with same radius supported");
        }
        double latitudeDelta = Math.toRadians(latitude - sphericalCoordinate.latitude);
        double longitudeDelta = Math.toRadians(longitude - sphericalCoordinate.longitude);
        double a = Math.sin(latitudeDelta / 2) * Math.sin(latitudeDelta / 2) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sphericalCoordinate.latitude)) *
                        Math.sin(longitudeDelta / 2) * Math.sin(longitudeDelta / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radius * c;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(!(coordinate instanceof SphericalCoordinate)) {
            return false;
        }
        final SphericalCoordinate sphericalCoordinate = (SphericalCoordinate) coordinate;
        return latitude == sphericalCoordinate.latitude && longitude == sphericalCoordinate.longitude && radius == sphericalCoordinate.radius;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof SphericalCoordinate && isEqual((SphericalCoordinate) object);
    }

    private void checkClassInvariants() {
        assert latitude >= 0 && latitude <= 90;
        assert latitude >= -180 && latitude <= 180;
        assert radius > 0;
    }
}
