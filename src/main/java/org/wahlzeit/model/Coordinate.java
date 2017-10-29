package org.wahlzeit.model;

public class Coordinate {

    private final double x;
    private final double y;
    private final double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isEqual(Coordinate coordinate) {
        return (coordinate.x == this.x) && (coordinate.y == this.y) && (coordinate.z == this.z);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Coordinate && isEqual((Coordinate) object);
    }

}
