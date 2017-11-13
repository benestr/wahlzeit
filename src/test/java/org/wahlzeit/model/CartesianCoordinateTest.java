package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    private final CartesianCoordinate cartesianCoordinate1 = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate cartesianCoordinate1Duplicate = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate cartesianCoordinate2 = new CartesianCoordinate(1, 2, 3);
    private static final double expectedDistanceCoordinate1to2 = 3.741657;

    @Test
    public void testIsEqual_equal() throws Exception {
        assertTrue(cartesianCoordinate1.isEqual(cartesianCoordinate1Duplicate));
    }

    @Test
    public void testIsEqual_differentCartesianCoordinates() throws Exception {
        assertFalse(cartesianCoordinate1.isEqual(cartesianCoordinate2));
    }

    @Test
    public void testEquals_equal() throws Exception {
        assertTrue(cartesianCoordinate1.equals(cartesianCoordinate1Duplicate));
    }

    @Test
    public void testEquals_differentClass() throws Exception {
        assertFalse(cartesianCoordinate1.equals(new Object()));
    }

    @Test
    public void testEquals_differentCartesianCoordinates() throws Exception {
        assertFalse(cartesianCoordinate1.equals(cartesianCoordinate2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistance_nullArgument() throws Exception {
        cartesianCoordinate1.getDistance(null);
    }

    @Test
    public void testGetDistance_sameCartesianCoordinate() throws Exception {
        assertEquals(0, cartesianCoordinate1.getDistance(cartesianCoordinate1), 0.00001);
    }

    @Test
    public void testGetDistance_differentCartesianCoordinates() throws Exception {
        assertEquals(expectedDistanceCoordinate1to2, cartesianCoordinate1.getDistance(cartesianCoordinate2), 0.00001);
    }

    @Test
    public void asCartesianCoordinate__returnsItself() throws Exception {
        assertSame(cartesianCoordinate1, cartesianCoordinate1.asCartesianCoordinate());
    }
}