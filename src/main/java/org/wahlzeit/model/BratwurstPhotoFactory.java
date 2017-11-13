package org.wahlzeit.model;

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
        return new BratwurstPhoto(id);
    }

    public BratwurstPhoto createPhoto(BratwurstType bratwurstType) {
        return new BratwurstPhoto(bratwurstType);
    }

    public BratwurstPhoto createPhoto(PhotoId id, BratwurstType bratwurstType) {
        return new BratwurstPhoto(id, bratwurstType);
    }

    public static void initialize() {
        getBratwurstInstance();
    }
}
