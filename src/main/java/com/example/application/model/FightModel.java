package com.example.application.model;

public class FightModel {
    protected CharacterModel player1;

    protected CharacterModel player2;
    protected boolean played = false;
    public void FightModel(){

    }

    public CharacterModel getPlayer1() {return player1;}

    public void setPlayer1(CharacterModel player1) {this.player1 = player1;}

    public CharacterModel getPlayer2() {return player2;}

    public void setPlayer2(CharacterModel player2) {this.player2 = player2;}

    public void setPlayedFalse(){ this.played = false; }
    public void setPlayedTrue(){ this.played = true; }
    public boolean getPlayed(){  return this.played; }
    public FightModel() {}
    public FightModel(CharacterModel player1, CharacterModel player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
