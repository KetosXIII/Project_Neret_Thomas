package com.example.project_neret_thomas.data;

import com.example.project_neret_thomas.presentation.modèle.modèle.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApi {
    @GET("/api/v2/pokemon")
Call<RestPokemonResponse> getPokemonResponse();
    @GET("/api/v2/ability")
    Call<RestPokemonResponse> getAbility();
}
