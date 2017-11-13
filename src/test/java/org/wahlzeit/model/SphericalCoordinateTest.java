package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SphericalCoordinateTest {

    private static final double ACCEPTABLE_IMPRECISION = 0.00001;

    private final SphericalCoordinate sphericalCoordinate1 = new SphericalCoordinate(45, 45, 100);
    private final SphericalCoordinate sphericalCoordinate1Duplicate = new SphericalCoordinate(45, 45, 100);
    private final SphericalCoordinate sphericalCoordinate2 = new SphericalCoordinate(60, 30, 200);
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

}