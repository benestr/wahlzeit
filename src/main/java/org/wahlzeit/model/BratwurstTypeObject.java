package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Serialize;
import org.wahlzeit.services.DataObject;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BratwurstTypeObject extends DataObject {

	public enum BratwurstType {
		DEFAULT, NUERNBERGER, THUERINGER;
	}

	@Id
	Long bratwurstTypeId;

	@Serialize
	BratwurstTypeObject superType = null;
	@Serialize
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
