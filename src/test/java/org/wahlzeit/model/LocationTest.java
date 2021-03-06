package org.wahlzeit.model;

import org.junit.Test;
import org.wahlzeit.model.coordinate.CartesianCoordinateFactory;
import org.wahlzeit.model.coordinate.Coordinate;

import static org.junit.Assert.assertSame;

public class LocationTest {

    private final Coordinate coordinate1 = CartesianCoordinateFactory.getCartesianCoordinate(0, 0, 0);
    private final Coordinate coordinate2 = CartesianCoordinateFactory.getCartesianCoordinate(1, 1, 1);

    @Test
    public void testConstructor() throws Exception {
        assertSame(coordinate1, new Location(coordinate1).getCoordinate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_nullCoordinate() throws Exception {
        new Location(null);
    }

    @Test
    public void testSetCoordinate() throws Exception {
        final Location location = new Location(coordinate1);
        location.setCoordinate(coordinate2);

        assertSame(coordinate2, location.getCoordinate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCoordinate_nullCoordinate() throws Exception {
        final Location location = new Location(coordinate1);
        location.setCoordinate(null);
    }
}