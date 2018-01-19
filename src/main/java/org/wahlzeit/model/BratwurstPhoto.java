package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.utils.PatternInstance;

/**
 *  <h3>How a BratwurstPhoto is created:</h3>
 *  <ol>
 *  	<li>To create a BratwurstPhoto, first the client has to call one of the createPhoto() methods of the {@link BratwurstPhotoManager} which is a Singleton and a subclass of {@link PhotoManager}.<br>
 *  	Optionally a {@link Bratwurst} object can be passed. See the documentation of that class for a description of how those are created.</li>
 *  	<li>The {@link BratwurstPhotoManager} than calls one of the static createBratwurstPhoto methods in {@link PhotoUtil} which forwards the creation request and configures some fields on the created object afterwards.</li>
 *  	<li>PhotoUtils calls one of the createPhoto() methods of {@link BratwurstPhotoFactory} which is a singleton subclass of {@link PhotoFactory}.</li>
 *  	<li>BratwurstPhotoFactory then calls the actual constructors of {@link BratwurstPhoto}, creating and then returning the object.</li>
 *  	<li>The {@link BratwurstPhoto} either receives a {@link Bratwurst} object to associate with the Photo or, if not, uses a defaultBratwurst object of a defaultBratwurstType.</li>
 *  </ol>
 *
 *  <h3>The creation process in the solution space:</h3>
 *  <ul>
 *      <li>Delegation: seperate-object</li>
 *      <li>Selection: sub-classing</li>
 *      <li>Configuration: in-code</li>
 *      <li>Instantiation: in-code</li>
 *      <li>Initialization: in-second-step</li>
 *      <li>Building: default</li>
 *  </ul>
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

