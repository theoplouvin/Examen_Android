package com.eilco.examen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class DetailPilote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pilote);

        String position = Integer.toString((getIntent().getIntExtra("position", 0)));
        String name = getIntent().getStringExtra("name");
        String points = Float.toString(getIntent().getFloatExtra("points", 0));
        String image = getIntent().getStringExtra("image");
        String equipe_image = getIntent().getStringExtra("equipe_image");
        String nomequipe = getIntent().getStringExtra("equipe_nom");

        TextView nameText = findViewById(R.id.name);
        TextView positionText = findViewById(R.id.classement);
        TextView pointsText = findViewById(R.id.position);
        TextView nomequipeText = findViewById(R.id.nomEquipe);

        nameText.setText(name);
        positionText.setText("Position au classement : " + position);
        pointsText.setText("Nb Points : " + points);
        nomequipeText.setText(nomequipe);

        ImageView imagePilote = findViewById(R.id.imagePilote);
        Glide.with(getApplicationContext())
                .load(image)
                .apply(new RequestOptions().override(320, 240))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(1000)))
                .into(imagePilote);

        ImageView imageEquipe = findViewById(R.id.imageEquipe);
        Glide.with(getApplicationContext())
                .load(equipe_image)
                .apply(new RequestOptions().override(500, 400))
                .into(imageEquipe);
    }
}
