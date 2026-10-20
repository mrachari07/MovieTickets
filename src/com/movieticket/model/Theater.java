package com.movieticket.model;

public class Theater {
	private final int id;
    private final String name;
    private final String location;

    public Theater(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return id + ". " + name + " - " + location;
    }
}
