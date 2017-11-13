package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class BratwurstPhoto extends Photo {

    private BratwurstType bratwurstType;

    public BratwurstPhoto() {
        this(BratwurstType.DEFAULT);
    }

    public BratwurstPhoto(BratwurstType bratwurstType) {
        super();
        this.bratwurstType = bratwurstType;
    }

    public BratwurstPhoto(PhotoId id) {
        this(id, BratwurstType.DEFAULT);
    }

    public BratwurstPhoto(PhotoId id, BratwurstType bratwurstType) {
        super(id);
        this.bratwurstType = bratwurstType;
    }

    public BratwurstType getBratwurstType() {
        return bratwurstType;
    }

    public void setBratwurstType(BratwurstType bratwurstType) {
        this.bratwurstType = bratwurstType;
    }
}
