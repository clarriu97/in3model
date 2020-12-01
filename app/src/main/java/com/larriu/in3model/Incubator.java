package com.larriu.in3model;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Incubator {

    private boolean fav, active;
    private float temp, hum, ppm;
    private int id;

    public Incubator(boolean isActive, float temp, float ppm, boolean fav) {
        this.active = isActive;
        this.temp = temp;
        this.ppm = ppm;
        this.fav = fav;
        hum = 0;
        id = 0;
    }

    public Incubator(DataInputStream dis) {
        // TODO: make this constructor
    }

    public boolean isFav() {
        return fav;
    }

    public boolean isActive() {
        return active;
    }

    public float getTemp() {
        return temp;
    }

    public float getHum() {
        return hum;
    }

    public float getPpm() {
        return ppm;
    }

    public int getId() {
        return id;
    }

    public void write(DataOutputStream dos) {
        //TODO: make this method
    }
}
