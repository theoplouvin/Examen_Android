package com.eilco.examen.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataPilote {

    private int position;
    private float points;
    private int season;
    @SerializedName("driver")
    private Pilote pilote;
    private Team team;

    public DataPilote(int position, float points, int season, Pilote pilote, Team team) {
        this.position = position;
        this.points = points;
        this.season = season;
        this.pilote = pilote;
        this.team = team;
    }

    public int getPosition() {
        position = position + 1;
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
