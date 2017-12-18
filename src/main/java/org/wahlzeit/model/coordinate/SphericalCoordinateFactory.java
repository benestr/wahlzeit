package org.wahlzeit.model.coordinate;

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;
import java.util.Map;

@PatternInstance(
		patternName = "Factory",
		participants = {
				SphericalCoordinateFactory.class, SphericalCoordinate.class
		}
)

public class SphericalCoordinateFactory {

	private static Map<String, SphericalCoordinate> storage = new HashMap<>();

	private SphericalCoordinateFactory() {
	}

	public static SphericalCoordinate getSphericalCoordinate(double latitude, double longitude, double radius) {
		String keyString = SphericalCoordinate.getKeyString(latitude, longitude, radius);
		synchronized (SphericalCoordinateFactory.class) {
			if (storage.containsKey(keyString)) {
				return storage.get(keyString);
			} else {
				SphericalCoordinate result = new SphericalCoordinate(latitude, longitude, radius);
				storage.put(keyString, result);
				return result;
			}
		}
	}

}
