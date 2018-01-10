package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;

public class BratwurstTypeObject {

	public enum BratwurstType {
		DEFAULT, NUERNBERGER, THUERINGER;
	}

	BratwurstTypeObject superType = null;
	List<BratwurstTypeObject> subTypes = new ArrayList<>();

	BratwurstType bratwurstType;
	double length;

	public BratwurstTypeObject(BratwurstType bratwurstType, double length) {
		this.bratwurstType = bratwurstType;
		this.length = length;
	}

	public BratwurstTypeObject getSuperType() {
		return superType;
	}
	public boolean isSubType() {
		return superType != null;
	}
	public void addSubType(BratwurstTypeObject subType) {
		subTypes.add(subType);
	}
	public List<BratwurstTypeObject> getSubTypes() {
		return new ArrayList<>(subTypes);
	}


	public BratwurstType getBratwurstType() {
		return bratwurstType;
	}
	public double getLength() {
		return length;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof BratwurstTypeObject)) {
			return false;
		}
		BratwurstTypeObject bratwurstTypeObj = (BratwurstTypeObject) obj;
		return bratwurstType == bratwurstTypeObj.bratwurstType && length == bratwurstTypeObj.length;
	}
}
