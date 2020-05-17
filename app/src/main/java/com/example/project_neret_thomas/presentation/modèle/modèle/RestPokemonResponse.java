package com.example.project_neret_thomas.presentation.modèle.modèle;

import com.example.project_neret_thomas.presentation.modèle.modèle.Pokemon;

import java.util.List;

public class RestPokemonResponse {
    private Integer count;
    private String next;
    private List<Pokemon>results;

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Pokemon> getResults() {
        return results;
    }
}
