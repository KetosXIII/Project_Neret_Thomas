package com.example.project_neret_thomas.presentation.modèle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.project_neret_thomas.R;
import com.example.project_neret_thomas.Singletons;
import com.example.project_neret_thomas.presentation.modèle.controleur.MainController;
import com.example.project_neret_thomas.presentation.modèle.modèle.Pokemon;

import java.security.Policy;
import java.util.List;

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
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAdapter = new ListAdapteur(pokemonList, new ListAdapteur.OnItemClickListener(){
            @Override
            public void  onItemClick(Pokemon item){
                controller.onItemClick(item);

        }

        });
        recyclerView.setAdapter(mAdapter);
    }



    public void showError(){
        Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_SHORT).show();

    }

    public void navigateToDetails(Pokemon pokemon) {
        Toast.makeText(getApplicationContext(),"TODO NAVIGATE",Toast.LENGTH_SHORT).show();
    }
}
