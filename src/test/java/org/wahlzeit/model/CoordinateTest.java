package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    private final Coordinate coordinate1 = new Coordinate(0, 0, 0);
    private final Coordinate coordinate1Duplicate = new Coordinate(0, 0, 0);
    private final Coordinate coordinate2 = new Coordinate(1, 2, 3);
    private static final double expectedDistance = 3.741657;

    @Test
    public void testIsEqual_equal() throws Exception {
        assertTrue(coordinate1.isEqual(coordinate1Duplicate));
    }

    @Test
    public void testIsEqual_differentCoordinates() throws Exception {
        assertFalse(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testEquals_equal() throws Exception {
        assertTrue(coordinate1.equals(coordinate1Duplicate));
    }

    @Test
    public void testEquals_differentClass() throws Exception {
        assertFalse(coordinate1.equals(new Object()));
    }

    @Test
    public void testEquals_differentCoordinates() throws Exception {
        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistance_nullArgument() throws Exception {
        coordinate1.getDistance(null);
    }

    @Test
    public void testGetDistance_sameCoordinate() throws Exception {
        assertEquals(0, coordinate1.getDistance(coordinate1), 0.00001);
    }

    @Test
    public void testGetDistance_differentCoordinates() throws Exception {
        assertEquals(expectedDistance, coordinate1.getDistance(coordinate2), 0.00001);
    }
}