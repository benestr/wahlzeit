package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    private final CartesianCoordinate CartesianCoordinate1 = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate CartesianCoordinate1Duplicate = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate CartesianCoordinate2 = new CartesianCoordinate(1, 2, 3);
    private static final double expectedDistance = 3.741657;

    @Test
    public void testIsEqual_equal() throws Exception {
        assertTrue(CartesianCoordinate1.isEqual(CartesianCoordinate1Duplicate));
    }

    @Test
    public void testIsEqual_differentCartesianCoordinates() throws Exception {
        assertFalse(CartesianCoordinate1.isEqual(CartesianCoordinate2));
    }

    @Test
    public void testEquals_equal() throws Exception {
        assertTrue(CartesianCoordinate1.equals(CartesianCoordinate1Duplicate));
    }

    @Test
    public void testEquals_differentClass() throws Exception {
        assertFalse(CartesianCoordinate1.equals(new Object()));
    }

    @Test
    public void testEquals_differentCartesianCoordinates() throws Exception {
        assertFalse(CartesianCoordinate1.equals(CartesianCoordinate2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistance_nullArgument() throws Exception {
        CartesianCoordinate1.getDistance(null);
    }

    @Test
    public void testGetDistance_sameCartesianCoordinate() throws Exception {
        assertEquals(0, CartesianCoordinate1.getDistance(CartesianCoordinate1), 0.00001);
    }

    @Test
    public void testGetDistance_differentCartesianCoordinates() throws Exception {
        assertEquals(expectedDistance, CartesianCoordinate1.getDistance(CartesianCoordinate2), 0.00001);
    }
}