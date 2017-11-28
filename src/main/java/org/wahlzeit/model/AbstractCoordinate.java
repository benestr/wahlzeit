package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

    @Override
    public double getDistance(Coordinate coordinate) {
        return getCartesianDistance(coordinate);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assertNotNull(coordinate, "Coordinate must not be null");
        final double result = asCartesianCoordinate().doGetCartesianDistance(coordinate.asCartesianCoordinate());

        assert result >= 0;
        return result;
    }

    private void assertNotNull(Object object, String message) {
        if(object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public double getSphericalDistance(Coordinate coordinate) {
        assertNotNull(coordinate, "Coordinate must not be null");

        final double result = asSphericalCoordinate().doGetSphericalDistance(coordinate.asSphericalCoordinate());

        assert result >= 0;
        return result;
    }

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate();

    @Override
    public abstract SphericalCoordinate asSphericalCoordinate();

    @Override
    public abstract boolean isEqual(Coordinate coordinate);
}
