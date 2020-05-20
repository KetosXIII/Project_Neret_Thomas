package com.example.project_neret_thomas.presentation.modèle.modèle;

public class Pokemon {
    private String name;
    private String url;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public int getNumber(){
        String[] urlPart = url.split("/");
        return Integer.parseInt(urlPart[urlPart.length - 1]);}
}
