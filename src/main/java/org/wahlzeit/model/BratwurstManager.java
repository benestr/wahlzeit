package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;
import java.util.List;

public class BratwurstManager extends ObjectManager {

	private static BratwurstManager instance = new BratwurstManager();

	private List<Bratwurst> bratwursts = new ArrayList<>();
	private List<BratwurstTypeObject> bratwurstTypes = new ArrayList<>();
	private boolean initialized = false;

	private BratwurstManager() {
	}

	public static BratwurstManager getInstance() {
		return instance;
	}

	private void initialize() {
		readObjects(bratwursts, Bratwurst.class);
		readObjects(bratwurstTypes, BratwurstTypeObject.class);
	}

	public Bratwurst createBratwurst(BratwurstTypeObject bratwurstTypeObject, boolean eaten) {
		if(!initialized) {
			initialize();
		}
		Bratwurst bratwurst = new Bratwurst(bratwurstTypeObject, eaten);
		if(bratwursts.contains(bratwurst)) {
			return bratwursts.get(bratwursts.indexOf(bratwurst));
		} else {
			bratwursts.add(bratwurst);
			writeObject(bratwurst);
			return bratwurst;
		}
	}

	public BratwurstTypeObject createBratwurstTypeObject(BratwurstTypeObject.BratwurstType bratwurstType, double length) {
		if(!initialized) {
			initialize();
		}
		BratwurstTypeObject bratwurstTypeObject = new BratwurstTypeObject(bratwurstType, length);
		if(bratwurstTypes.contains(bratwurstTypeObject)) {
			return bratwurstTypes.get(bratwurstTypes.indexOf(bratwurstTypeObject));
		} else {
			bratwurstTypes.add(bratwurstTypeObject);
			writeObject(bratwurstTypeObject);
			return bratwurstTypeObject;
		}
	}
}
