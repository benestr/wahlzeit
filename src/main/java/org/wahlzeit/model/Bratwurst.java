package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;

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
