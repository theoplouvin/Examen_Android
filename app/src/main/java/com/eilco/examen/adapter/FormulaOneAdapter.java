package com.eilco.examen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.eilco.examen.R;
import com.eilco.examen.models.DataPilote;
import com.eilco.examen.models.Pilote;

import java.util.ArrayList;
import java.util.List;

public class FormulaOneAdapter extends RecyclerView.Adapter<FormulaOneAdapter.ViewHolder> {
    private final ArrayList<DataPilote> mPilote;
    private ReclyclerViewClickListener listener;

    public FormulaOneAdapter(ArrayList<DataPilote> pilote, ReclyclerViewClickListener listener) {
        this.mPilote = pilote;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FormulaOneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View PiloteView = inflater.inflate(R.layout.activity_item, parent, false);

        return new ViewHolder(PiloteView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView nom = holder.nom;
        TextView prenom = holder.prenom;
        TextView points = holder.points;
        nom.setText(mPilote.get(position).getPilote().getName());

        points.setText(Float.toString(mPilote.get(position).getPoints()));

    }

    @Override
    public int getItemCount() {
        return mPilote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nom;
        public TextView prenom;
        public TextView points;


        public ViewHolder(View itemView){
            super(itemView);

            nom = itemView.findViewById(R.id.nom);
            points = itemView.findViewById(R.id.points);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

    public interface ReclyclerViewClickListener{
        void onClick(View v, int position);
    }

}
