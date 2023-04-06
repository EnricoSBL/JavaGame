package com.example.application.views.dtos;

import com.example.application.model.CharacterModel;

import java.util.List;

public class TournamentDto {
    private int id;
    private String name;
    private List<CharacterDto> listOfCharacterDtos;

    public int getId() {
        return id;
    }

    public TournamentDto(int id, String name, List<CharacterDto> listOfCharacterDtos){
        this.id = id;
        this.name = name;
        this.listOfCharacterDtos = listOfCharacterDtos;
    }

    public TournamentDto(){}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacterDto> getListOfCharacterDtos() {
        return listOfCharacterDtos;
    }

    public void setListOfCharacterDtos(List<CharacterDto> listOfCharacterDtos) {
        this.listOfCharacterDtos = listOfCharacterDtos;
    }
}
