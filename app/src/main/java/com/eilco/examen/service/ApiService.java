package com.eilco.examen.service;

import com.eilco.examen.models.DataPilote;
import com.eilco.examen.models.ListTeams;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    public static final String URL = "https://busin.fr/";

    @GET("drivers.json")
    Call<ArrayList<DataPilote>> listPilote();

    @GET("teams.json")
    Call<ListTeams> listTeams();
}
