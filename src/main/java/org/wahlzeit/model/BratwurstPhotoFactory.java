package org.wahlzeit.model;

public class BratwurstPhotoFactory extends PhotoFactory {
    @Override
    public BratwurstPhoto createPhoto() {
        return new BratwurstPhoto();
    }

    @Override
    public BratwurstPhoto createPhoto(PhotoId id) {
        return new BratwurstPhoto(id);
    }

    public BratwurstPhoto createPhoto(BratwurstType bratwurstType) {
        return new BratwurstPhoto(bratwurstType);
    }

    public BratwurstPhoto createPhoto(PhotoId id, BratwurstType bratwurstType) {
        return new BratwurstPhoto(id, bratwurstType);
    }
}
