package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;

public class BratwurstManager {

	private static BratwurstManager instance = new BratwurstManager();

	private List<Bratwurst> bratwursts = new ArrayList<>();
	private List<BratwurstTypeObject> bratwurstTypes = new ArrayList<>();

	private BratwurstManager() {
	}

	public static BratwurstManager getInstance() {
		return instance;
	}

	public Bratwurst createBratwurst(BratwurstTypeObject bratwurstTypeObject, boolean eaten) {
		Bratwurst bratwurst = new Bratwurst(bratwurstTypeObject, eaten);
		if(bratwursts.contains(bratwurst)) {
			return bratwursts.get(bratwursts.indexOf(bratwurst));
		} else {
			bratwursts.add(bratwurst);
			return bratwurst;
		}
	}

	public BratwurstTypeObject createBratwurstTypeObject(BratwurstTypeObject.BratwurstType bratwurstType, double length) {
		BratwurstTypeObject bratwurstTypeObject = new BratwurstTypeObject(bratwurstType, length);
		if(bratwurstTypes.contains(bratwurstTypeObject)) {
			return bratwurstTypes.get(bratwurstTypes.indexOf(bratwurstTypeObject));
		} else {
			bratwurstTypes.add(bratwurstTypeObject);
			return bratwurstTypeObject;
		}
	}
}
