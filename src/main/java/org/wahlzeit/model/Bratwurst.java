package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

/**
 *  <h3>How a Bratwurst is created:</h3>
 *  <ol>
 *  	<li>To create a Bratwurst, first the client has to call the createBratwurst() method of the {@link BratwurstManager} which is a Singleton and a subclass of {@link ObjectManager}.<br>
 *  		This methods requires a Bratwurst TypeObject as well as all attributes concerning the specific Bratwurst object to be passed as arguments.<br>
 *  		If no instance of {@link BratwurstTypeObject} is available, this too has to be created with the {@link BratwurstManager}.</li>
 *  	<li>The {@link BratwurstManager} then checks if the specified Bratwurst object already exists.<br>
 *  	    If yes, it will be returned. If no, a new Bratwurst object is created by calling the constructor of {@link Bratwurst}, persisted in Datastore and then returned.</li>
 *  	<li>The {@link Bratwurst} class receives all necessary information as arguments in the constructor. No further initialization is required.</li>
 *  </ol>
 *
 *  <h3>The creation process in the solution space:</h3>
 *  <ul>
 *      <li>Delegation: seperate-object</li>
 *      <li>Selection: on-the-spot (arguably by-subclassing as {@link BratwurstManager} is a subclass of {@link ObjectManager} selecting {@link Bratwurst} as a concrete class implementing {@link Persistent}, however semantically I would not consider Bratwurst to be a concrete class implementing Persistent but rather an independent class that just happens to require persisting in the Datastore.</li>
 *      <li>Configuration: in-code</li>
 *      <li>Instantiation: in-code</li>
 *      <li>Initialization: default</li>
 *      <li>Building: default</li>
 *  </ul>
 */
@Entity
public class Bratwurst extends DataObject {

	@Id
	Long bratwurstId;

	BratwurstTypeObject bratwurstTypeObject;

	boolean eaten;

	public Bratwurst(BratwurstTypeObject bratwurstTypeObject, boolean eaten) {
		this.bratwurstTypeObject = bratwurstTypeObject;
		this.eaten = eaten;
	}

	public BratwurstTypeObject getBratwurstTypeObject() {
		return bratwurstTypeObject;
	}

	public boolean isEaten() {
		return eaten;
	}
}
