package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class BratwurstPhotoFactoryTest {

    @Test
    public void getInstance_calledTwice_sameInstanceEveryTime() throws Exception {
        final BratwurstPhotoFactory instance1 = BratwurstPhotoFactory.getBratwurstInstance();
        final BratwurstPhotoFactory instance2 = BratwurstPhotoFactory.getBratwurstInstance();

        assertSame(instance1, instance2);
    }
}