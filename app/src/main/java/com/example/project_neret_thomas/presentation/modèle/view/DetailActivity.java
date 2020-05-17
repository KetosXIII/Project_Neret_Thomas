package com.example.project_neret_thomas.presentation.modèle.view;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.project_neret_thomas.R;
import com.example.project_neret_thomas.Singletons;
import com.example.project_neret_thomas.presentation.modèle.modèle.Pokemon;



public class DetailActivity extends AppCompatActivity {


private TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }


}
