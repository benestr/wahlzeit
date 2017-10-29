package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    private final Coordinate coordinate1 = new Coordinate(0, 0, 0);
    private final Coordinate coordinate1Duplicate = new Coordinate(0, 0, 0);
    private final Coordinate coordinate2 = new Coordinate(1, 2, 3);

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

}