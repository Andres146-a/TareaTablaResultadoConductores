package com.example.models;

public class ConstructorResult {
    private int constructorResultsId;
    private int raceId;
    private int constructorId;
    private float points;

    public ConstructorResult(int constructorResultsId, int raceId, int constructorId, float points) {
        this.constructorResultsId = constructorResultsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
    }

    public int getConstructorResultsId() {
        return constructorResultsId;
    }

    public void setConstructorResultsId(int constructorResultsId) {
        this.constructorResultsId = constructorResultsId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    // Getters y Setters
}
