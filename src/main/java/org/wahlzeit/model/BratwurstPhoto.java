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

    private Bratwurst bratwurst;

    private static final BratwurstTypeObject defaultBratwurstType = BratwurstManager.getInstance().createBratwurstTypeObject(BratwurstTypeObject.BratwurstType.DEFAULT, 0);
    private static final Bratwurst defaultBratwurst = BratwurstManager.getInstance().createBratwurst(defaultBratwurstType, false);

    public BratwurstPhoto() {
        this(defaultBratwurst);
    }

    public BratwurstPhoto(Bratwurst bratwurst) {
        super();

        this.bratwurst = bratwurst != null ? bratwurst : defaultBratwurst;
    }

    public BratwurstPhoto(PhotoId id) {
        this(id, defaultBratwurst);
    }

    public BratwurstPhoto(PhotoId id, Bratwurst bratwurst) {
        super(id);

        this.bratwurst = bratwurst != null ? bratwurst : defaultBratwurst;
    }

    public Bratwurst getBratwurst() {
        return bratwurst;
    }

}

