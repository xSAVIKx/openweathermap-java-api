package org.openweathermap.api.model;

public class WindDirection extends AbstractModel {
    private int degree;

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
