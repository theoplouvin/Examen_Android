package com.eilco.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eilco.examen.data.Loader;
import com.eilco.examen.models.Pilote;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loader loader = new Loader(this);
        loader.dataPilote();
    }
}