package org.wahlzeit.model.coordinate;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Factory",
        participants = {
                SphericalCoordinateFactory.class, SphericalCoordinate.class
        }
)
public class SphericalCoordinate extends AbstractCoordinate {
    private final double latitude;

    private final double longitude;
    private final double radius;

    private static final double EARTH_RADIUS = 6_371_000;

    SphericalCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS);
    }

    SphericalCoordinate(double latitude, double longitude, double radius) {
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
        checkClassInvariants();

        final double x = radius * Math.sin(Math.toRadians(90 - latitude)) * Math.cos(Math.toRadians(longitude));
        final double y = radius * Math.sin(Math.toRadians(90 - latitude)) * Math.sin(Math.toRadians(longitude));
        final double z = radius * Math.cos(Math.toRadians(90 - latitude));

        final CartesianCoordinate result = new CartesianCoordinate(x, y, z);

        assert result != null;
        checkClassInvariants();
        return result;
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        checkClassInvariants();
        final SphericalCoordinate result = this;

        assert result != null;
        checkClassInvariants();
        return result;

    }

    double doGetSphericalDistance(SphericalCoordinate sphericalCoordinate) {
        checkClassInvariants();
        sphericalCoordinate.checkClassInvariants();
        if (sphericalCoordinate.radius != radius) {
            throw new UnsupportedOperationException("Spherical distance only between coordinates with same radius supported");
        }

        double latitudeDelta = Math.toRadians(latitude - sphericalCoordinate.latitude);
        double longitudeDelta = Math.toRadians(longitude - sphericalCoordinate.longitude);
        double a = Math.sin(latitudeDelta / 2) * Math.sin(latitudeDelta / 2) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(sphericalCoordinate.latitude)) *
                        Math.sin(longitudeDelta / 2) * Math.sin(longitudeDelta / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        final double result = radius * c;

        checkClassInvariants();
        sphericalCoordinate.checkClassInvariants();
        return result;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        checkClassInvariants();
        assertNotNull(coordinate, "Coordinate must not be null");

        if(!(coordinate instanceof SphericalCoordinate)) {
            return false;
        }
        final SphericalCoordinate sphericalCoordinate = (SphericalCoordinate) coordinate;
        final boolean result = latitude == sphericalCoordinate.latitude && longitude == sphericalCoordinate.longitude && radius == sphericalCoordinate.radius;

        checkClassInvariants();
        return result;
    }

    private void checkClassInvariants() {
        assert latitude >= 0 && latitude <= 90;
        assert latitude >= -180 && latitude <= 180;
        assert radius > 0;
    }

    public static String getKeyString(double latitude, double longitude, double radius) {
        return String.format("latitude=%.10f, longitude=%.10f, radius=%.10f", latitude, longitude, radius);
    }
}
