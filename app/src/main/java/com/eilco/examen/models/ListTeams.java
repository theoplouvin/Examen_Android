package com.eilco.examen.models;

import java.util.List;

public class ListTeams {

    public List<Teams> teamsList;

    public ListTeams(List<Teams> pilotesList) {
        this.teamsList = pilotesList;
    }

    public List<Teams> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Teams> teamsList) {
        this.teamsList = teamsList;
    }
}
