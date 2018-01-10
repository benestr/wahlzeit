package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        patternName = "Factory",
        participants = {
                BratwurstPhotoFactory.class, BratwurstPhoto.class
        }
)
@Subclass
public class BratwurstPhoto extends Photo {

    private transient Bratwurst bratwurst;

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
