package com.example.models;

public class DriverResult {
    private String forename;
    private String surname;
    private int wins;
    private float totalPoints;
    private int seasonRank;

    // Getters and Setters
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public float getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(float totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getSeasonRank() {
        return seasonRank;
    }

    public void setSeasonRank(int seasonRank) {
        this.seasonRank = seasonRank;
    }

    @Override
    public String toString() {
        return "DriverResult{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", wins=" + wins +
                ", totalPoints=" + totalPoints +
                ", seasonRank=" + seasonRank +
                '}';
    }
}
