package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericalCoordinateTest {

    private static final double ACCEPTABLE_IMPRECISION = 0.00001;

    private final SphericalCoordinate sphericalCoordinate1 = new SphericalCoordinate(45, 45, 100);
    private final SphericalCoordinate sphericalCoordinate1Duplicate = new SphericalCoordinate(45, 45, 100);
    private final SphericalCoordinate sphericalCoordinate2 = new SphericalCoordinate(53.30077479951, 63.434948822922, 3.7416573867739);
    private final CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(45, 45, 100);

    @Test
    public void isEqual_equalButNotSameCoordinate_true() throws Exception {
        assertTrue(sphericalCoordinate1.isEqual(sphericalCoordinate1Duplicate));
    }

    @Test
    public void isEqual_differentSphericalCoordinate_false() throws Exception {
        assertFalse(sphericalCoordinate1.isEqual(sphericalCoordinate2));
    }

    @Test
    public void isEqual_nonSphericalCoordinate_false() throws Exception {
        assertFalse(sphericalCoordinate1.isEqual(cartesianCoordinate));
    }

    @Test
    public void equals_equalButNotSameCoordinate_true() throws Exception {
        assertTrue(sphericalCoordinate1.equals(sphericalCoordinate1Duplicate));
    }

    @Test
    public void equals_differentClass_false() throws Exception {
        assertFalse(sphericalCoordinate1.equals(new Object()));
    }

    @Test
    public void equals_differentCartesianCoordinate_false() throws Exception {
        assertFalse(sphericalCoordinate1.equals(sphericalCoordinate2));
    }

    @Test
    public void asSphericalCoordinate__returnsItself()throws Exception {
        assertEquals(sphericalCoordinate1, sphericalCoordinate1.asSphericalCoordinate());
    }

    @Test
    public void asCartesianCoordinate__correctlyConvertedCoordinate() throws Exception {
        final double expectedX = 1;
        final double expectedY = 2;
        final double expectedZ = 3;

        final CartesianCoordinate result = sphericalCoordinate2.asCartesianCoordinate();

        assertEquals(expectedX, result.getX(), ACCEPTABLE_IMPRECISION);
        assertEquals(expectedY, result.getY(), ACCEPTABLE_IMPRECISION);
        assertEquals(expectedZ, result.getZ(), ACCEPTABLE_IMPRECISION);
    }

}