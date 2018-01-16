package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;

/**
 * How a BratwurstPhoto is created:
 *
 *
 * {@link BratwurstPhotoFactory} calls one of the constructors of BratwurstPhoto.
 * If a Bratwurst object is passed, it will be referenced by the object.
 * Otherwise a default Bratwurst with a default BratwurstType, which is defined in this file as a constant.
 */
@PatternInstance(
        patternName = "Factory",
        participants = {
                BratwurstPhotoFactory.class, BratwurstPhoto.class
        }
)
@Subclass
public class BratwurstPhoto extends Photo {

    private Bratwurst bratwurst;

    private static final BratwurstTypeObject defaultBratwurstTypeObject = BratwurstManager.getInstance().createBratwurstTypeObject(BratwurstTypeObject.BratwurstType.DEFAULT, 0);
    private static final Bratwurst defaultBratwurst = BratwurstManager.getInstance().createBratwurst(defaultBratwurstTypeObject, false);

    public BratwurstPhoto() {
        this(defaultBratwurst);
    }

    public BratwurstPhoto(Bratwurst bratwurst) {
        super();

        if(bratwurst == null) {
            throw new IllegalArgumentException("bratwurst must not be null");
        }

        this.bratwurst = bratwurst;
    }

    public BratwurstPhoto(PhotoId id) {
        this(id, defaultBratwurst);
    }

    public BratwurstPhoto(PhotoId id, Bratwurst bratwurst) {
        super(id);

        if(bratwurst == null) {
            throw new IllegalArgumentException("bratwurst must not be null");
        }

        this.bratwurst = bratwurst;
    }

    public Bratwurst getBratwurst() {
        return bratwurst;
    }

}

