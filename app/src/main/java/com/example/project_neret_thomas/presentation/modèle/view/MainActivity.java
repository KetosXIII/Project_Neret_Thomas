package com.example.project_neret_thomas.presentation.modèle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project_neret_thomas.Constant;
import com.example.project_neret_thomas.R;
import com.example.project_neret_thomas.Singletons;
import com.example.project_neret_thomas.data.PokeApi;
import com.example.project_neret_thomas.presentation.modèle.controleur.MainController;
import com.example.project_neret_thomas.presentation.modèle.modèle.Pokemon;
import com.example.project_neret_thomas.presentation.modèle.modèle.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapteur mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())

        );
        controller.onStart();

       }



 public void showList(List<Pokemon>pokemonList){


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapteur(pokemonList);
        recyclerView.setAdapter(mAdapter);
    }



    public void showError(){
        Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_SHORT).show();

    }
}
