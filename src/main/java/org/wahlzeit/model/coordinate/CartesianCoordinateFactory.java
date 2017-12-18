package org.wahlzeit.model.coordinate;

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;
import java.util.Map;

@PatternInstance(
		patternName = "Factory",
		participants = {
				CartesianCoordinateFactory.class, CartesianCoordinate.class
		}
)
public class CartesianCoordinateFactory {

	private static Map<String, CartesianCoordinate> storage = new HashMap<>();

	private CartesianCoordinateFactory() {
	}

	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		String keyString = CartesianCoordinate.getKeyString(x, y, z);
		synchronized (CartesianCoordinateFactory.class) {
			if (storage.containsKey(keyString)) {
				return storage.get(keyString);
			} else {
				CartesianCoordinate result = new CartesianCoordinate(x, y, z);
				storage.put(keyString, result);
				return result;
			}
		}
	}

}
