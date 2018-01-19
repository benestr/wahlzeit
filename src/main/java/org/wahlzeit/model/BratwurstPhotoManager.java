package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

public class BratwurstPhotoManager extends PhotoManager {

	protected static final BratwurstPhotoManager instance = new BratwurstPhotoManager();

	public static final BratwurstPhotoManager getInstance() {
		return instance;
	}

	public Photo createPhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		Photo result = PhotoUtil.createBratwurstPhoto(filename, id, uploadedImage);
		addPhoto(result);
		return result;
	}

	public Photo createPhoto(String filename, Image uploadedImage, Bratwurst bratwurst) throws Exception {
		PhotoId id = PhotoId.getNextId();
		Photo result = PhotoUtil.createBratwurstPhoto(filename, id, uploadedImage, bratwurst);
		addPhoto(result);
		return result;
	}

}
