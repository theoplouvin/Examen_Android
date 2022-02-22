package com.eilco.examen.models;

import java.util.List;

public class Teams {

    private int position;
    List<Team> team;
    private int points;
    private String season;
    private String website;

    public Teams(int position, List<Team> team, int points, String season, String website) {
        this.position = position;
        this.team = team;
        this.points = points;
        this.season = season;
        this.website = website;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
