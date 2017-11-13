package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    private static final double ACCEPTABLE_IMPRECISION = 0.00001;

    private final CartesianCoordinate cartesianCoordinate1 = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate cartesianCoordinate1Duplicate = new CartesianCoordinate(0, 0, 0);
    private final CartesianCoordinate cartesianCoordinate2 = new CartesianCoordinate(1, 2, 3);
    private final SphericalCoordinate sphericalCoordinate = new SphericalCoordinate(1, 2, 3);

    @Test
    public void isEqual_equalButNotSameCoordinate_true() throws Exception {
        assertTrue(cartesianCoordinate1.isEqual(cartesianCoordinate1Duplicate));
    }

    @Test
    public void isEqual_differentCartesianCoordinate_false() throws Exception {
        assertFalse(cartesianCoordinate1.isEqual(cartesianCoordinate2));
    }

    @Test
    public void isEqual_nonCartesianCoordinate_false_() throws Exception {
        assertFalse(cartesianCoordinate2.isEqual(sphericalCoordinate));
    }

    @Test
    public void equals_equalButNotSameCoordinate_true() throws Exception {
        assertTrue(cartesianCoordinate1.equals(cartesianCoordinate1Duplicate));
    }

    @Test
    public void equals_differentClass_false() throws Exception {
        assertFalse(cartesianCoordinate1.equals(new Object()));
    }

    @Test
    public void equals_differentCartesianCoordinate_false() throws Exception {
        assertFalse(cartesianCoordinate1.equals(cartesianCoordinate2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDistance_nullArgument_illegalArgumentException() throws Exception {
        cartesianCoordinate1.getDistance(null);
    }

    @Test
    public void getDistance_sameCartesianCoordinate_0() throws Exception {
        assertEquals(0, cartesianCoordinate1.getDistance(cartesianCoordinate1), ACCEPTABLE_IMPRECISION);
    }

    @Test
    public void getDistance_differentCartesianCoordinate_correctDistance() throws Exception {
        final double expectedDistance = 3.741657;

        assertEquals(expectedDistance, cartesianCoordinate1.getDistance(cartesianCoordinate2.asSphericalCoordinate()), ACCEPTABLE_IMPRECISION);
    }

    @Test
    public void getDistance_sphericalCoordinate_correctDistance() throws Exception {
        final double expectedDistance = 3.741657;

        assertEquals(expectedDistance, cartesianCoordinate1.getDistance(cartesianCoordinate2), ACCEPTABLE_IMPRECISION);
    }

    @Test
    public void asCartesianCoordinate__returnsItself() throws Exception {
        assertSame(cartesianCoordinate1, cartesianCoordinate1.asCartesianCoordinate());
    }

    @Test
    public void asSphericalCoordinate__correctlyConvertedCoordinate()throws Exception {
        final double expectedRadius = 3.7416573867739;
        final double expectedLongitude = 63.434948822922;
        final double expectedLatitude = 53.30077479951;

        final SphericalCoordinate result = cartesianCoordinate2.asSphericalCoordinate();

        assertEquals(expectedRadius, result.getRadius(), ACCEPTABLE_IMPRECISION);
        assertEquals(expectedLongitude, result.getLongitude(), ACCEPTABLE_IMPRECISION);
        assertEquals(expectedLatitude, result.getLatitude(), ACCEPTABLE_IMPRECISION);
    }
}