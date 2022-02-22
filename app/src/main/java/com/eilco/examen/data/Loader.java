package com.eilco.examen.data;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eilco.examen.DetailPilote;
import com.eilco.examen.MainActivity;
import com.eilco.examen.R;
import com.eilco.examen.adapter.FormulaOneAdapter;
import com.eilco.examen.models.DataPilote;
import com.eilco.examen.models.ListTeams;
import com.eilco.examen.models.Teams;
import com.eilco.examen.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loader {

    private ApiService formulaOneService;
    private MainActivity activity;
    private RecyclerView rvPilotes;
    private ArrayList<DataPilote> dataArrayList = new ArrayList<>();
    private FormulaOneAdapter.ReclyclerViewClickListener listener;

    public Loader( MainActivity activity) {
        formulaOneService = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        this.activity = activity;
        this.rvPilotes = (RecyclerView) activity.findViewById(R.id.rvPilotes);
    }

    public void dataPilote(){
        formulaOneService.listPilote().enqueue(new Callback<ArrayList<DataPilote>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<DataPilote>> call, @NonNull Response<ArrayList<DataPilote>> response) {

                dataArrayList = response.body();
                setOnClickListner(dataArrayList);

                FormulaOneAdapter adpater = new FormulaOneAdapter(dataArrayList, listener);
                rvPilotes.setAdapter(adpater);
                rvPilotes.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<DataPilote>> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void dataTeam(){
        formulaOneService.listTeams().enqueue(new Callback<ListTeams>() {
            @Override
            public void onResponse(@NonNull Call<ListTeams> call, @NonNull Response<ListTeams> response) {

                assert response.body() != null;
                List<Teams> allTeams = response.body().getTeamsList();
                setOnClickListner(dataArrayList);

            }

            @Override
            public void onFailure(@NonNull Call<ListTeams> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void setOnClickListner(ArrayList<DataPilote> dataArrayList) {
        listener = new FormulaOneAdapter.ReclyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(activity.getApplicationContext(), DetailPilote.class);
                intent.putExtra("id", dataArrayList.get(position).getPosition());
                intent.putExtra("name",dataArrayList.get(position).getPilote().getName());
                intent.putExtra("points",dataArrayList.get(position).getPoints());
                intent.putExtra("image",dataArrayList.get(position).getPilote().getImage());
                intent.putExtra("equipe_image",dataArrayList.get(position).getTeam().getLogo());
                intent.putExtra("equipe_nom",dataArrayList.get(position).getTeam().getName());
                activity.startActivity(intent);
            }
        };
    }
}
