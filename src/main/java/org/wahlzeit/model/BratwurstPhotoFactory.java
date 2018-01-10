package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Factory",
        participants = {
                BratwurstPhotoFactory.class, BratwurstPhoto.class
        }
)
public class BratwurstPhotoFactory {

    private static BratwurstPhotoFactory instance;

    public static synchronized BratwurstPhotoFactory getBratwurstInstance() {
        if (instance == null) {
            setInstance(new BratwurstPhotoFactory());
        }

        return instance;
    }

    private static void setInstance(BratwurstPhotoFactory instance) {
        BratwurstPhotoFactory.instance = instance;
    }

    public BratwurstPhoto createPhoto() {
        return new BratwurstPhoto();
    }

    public BratwurstPhoto createPhoto(PhotoId id) {
        if(id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        return new BratwurstPhoto(id);
    }

    public BratwurstPhoto createPhoto(Bratwurst bratwurst) {
        return new BratwurstPhoto(bratwurst);
    }

    public BratwurstPhoto createPhoto(PhotoId id, Bratwurst bratwurst) {
        return new BratwurstPhoto(id, bratwurst);
    }

    public static void initialize() {
        getBratwurstInstance();
    }
}
