package com.example.application.model;

import java.util.List;

public class TournamentModel {

    private int id;
    private String name;
    private List<CharacterModel> listOfCharacterModels;

    public int getId() {
        return id;
    }

    public TournamentModel(int id, String name, List<CharacterModel> listOfCharacterModels){
        this.id = id;
        this.name = name;
        this.listOfCharacterModels = listOfCharacterModels;
    }

    public TournamentModel(){}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacterModel> getListOfCharacterModels() {
        return listOfCharacterModels;
    }

    public void setListOfCharacterModels(List<CharacterModel> listOfCharacterModels) {
        this.listOfCharacterModels = listOfCharacterModels;
    }
}
