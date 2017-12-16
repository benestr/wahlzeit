package org.wahlzeit.model.coordinate;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        checkClassInvariants();

        final CartesianCoordinate result = this;

        checkClassInvariants();
        return result;
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        checkClassInvariants();

        final double latitude = 90 - Math.toDegrees(Math.atan(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / z));
        final double longitude = Math.toDegrees(Math.atan(y / x));
        final double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        final SphericalCoordinate result = new SphericalCoordinate(latitude, longitude, radius);

        checkClassInvariants();
        return result;
    }

    double doGetCartesianDistance(CartesianCoordinate cartesianCoordinate) {
        checkClassInvariants();

        final double result = Math.sqrt(
                Math.pow(x - cartesianCoordinate.x, 2) + Math.pow(y - cartesianCoordinate.y, 2) + Math.pow(z - cartesianCoordinate.z, 2));

        checkClassInvariants();
        return result;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        checkClassInvariants();
        assertNotNull(coordinate, "Coordinate must not be null");

        if(!(coordinate instanceof CartesianCoordinate)) {
            return false;
        }
        final CartesianCoordinate cartesianCoordinate = (CartesianCoordinate) coordinate;
        final boolean result = (cartesianCoordinate.x == this.x) && (cartesianCoordinate.y == this.y) && (cartesianCoordinate.z == this.z);

        checkClassInvariants();
        return result;
    }

    @Override
    public boolean equals(Object object) {
        checkClassInvariants();

        final boolean result = object instanceof CartesianCoordinate && isEqual((CartesianCoordinate) object);

        checkClassInvariants();
        return result;
    }

    private void checkClassInvariants() {
        assert x != Double.NEGATIVE_INFINITY && x != Double.POSITIVE_INFINITY && x != Double.NaN ;
        assert y != Double.NEGATIVE_INFINITY && y != Double.POSITIVE_INFINITY && y != Double.NaN ;
        assert z != Double.NEGATIVE_INFINITY && z != Double.POSITIVE_INFINITY && z != Double.NaN ;
    }
}
