package org.wahlzeit.model;

public class Bratwurst {

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
