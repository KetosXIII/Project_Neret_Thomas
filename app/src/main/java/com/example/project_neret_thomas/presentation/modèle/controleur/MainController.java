package com.example.project_neret_thomas.presentation.modèle.controleur;

import android.content.SharedPreferences;

import com.example.project_neret_thomas.Constant;
import com.example.project_neret_thomas.Singletons;
import com.example.project_neret_thomas.presentation.modèle.modèle.Pokemon;
import com.example.project_neret_thomas.presentation.modèle.modèle.RestPokemonResponse;
import com.example.project_neret_thomas.presentation.modèle.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity,Gson gson,SharedPreferences sharedPreferences){
this.gson=gson;
this.sharedPreferences = sharedPreferences;
this.view = mainActivity;

    }
    public void onStart()
    {
        List<Pokemon> pokemonList =getDataFromCache();
        if(pokemonList !=null){

            view.showList(pokemonList);

        }else {
            makeApiCall();
        }

    }
    private void makeApiCall(){





        Call<RestPokemonResponse> call = Singletons.getPokeApi().getPokemonResponse();
        Call<RestPokemonResponse> call2 = Singletons.getPokeApi().getAbility();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                if(response.isSuccessful()&& response.body()!=null){
                    List<Pokemon>pokemonList=response.body().getResults();
                    saveList(pokemonList);
                    view.showList(pokemonList);
                }else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                view.showError();
            }
        });
    }

    private void saveList(List<Pokemon> pokemonList) {
        String jsonString = gson.toJson(pokemonList);
        sharedPreferences
                .edit()
                .putString(Constant.KEY_POKEMON_LIST, jsonString)
                .apply();

    }
    private List<Pokemon> getDataFromCache() {
        String jsonPokemon= sharedPreferences.getString(Constant.KEY_POKEMON_LIST, null);
        if (jsonPokemon==null) {
            return null;}else {
            Type listType = new TypeToken<List<Pokemon>>(){}.getType();
            return gson.fromJson(jsonPokemon,listType);
        }


    }
    public  void onItemClick(Pokemon pokemon)
    {
     view.navigateToDetails(pokemon);

    }
    public  void onButtonBClick (){

    }
}
