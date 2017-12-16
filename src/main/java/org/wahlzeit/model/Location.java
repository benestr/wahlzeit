package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.Coordinate;

public class Location {

    private Coordinate coordinate;

    public Location(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
        this.coordinate = coordinate;
    }
}
