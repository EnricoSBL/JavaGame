package com.example.application.controller;

import com.example.application.model.CharacterModel;
import com.example.application.model.FightModel;
import com.example.application.repositories.TournamentResultRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Logger;

public class Tournament16Controller {

    private ArrayList<CharacterModel> firstRound = new ArrayList<>();
    private  ArrayList<CharacterModel> secondRound = new ArrayList<>();
    private static final Logger LOGGER = CharacterController.getInstance().getLogger();
    private static Tournament16Controller instance;
    private boolean hasOutput = true;

    public static Tournament16Controller getInstance() {
        if (instance == null) {
            instance = new Tournament16Controller();
        }
        return instance;
    }

    public void addFighters(CharacterModel fighter) { firstRound.add(fighter); }
    public void addFighterToQuarterFinals(CharacterModel fighter) { secondRound.add(fighter); }

    public CharacterModel getFighter(int i){ return firstRound.get(i); }

    public CharacterModel getFighter(String name){
        for (CharacterModel cm : firstRound){
            if (cm.getName().equals(name)){
                return cm;
            }
        }
        return null;
    }
    //TODO newRoundForFight

    protected void newRoundForFight() {
        ArrayList<CharacterModel> tmp = new ArrayList<>();
        firstRound = secondRound;
        secondRound = tmp;
    }

    //TODO fightGame
    public void fightGame() throws InterruptedException, SQLException {

        if (CharacterController.getInstance().getOutputView() == null){
            hasOutput = false;
        }
        for (CharacterModel characterModel : firstRound){
            if (hasOutput){
                CharacterController.getInstance().getOutputView().addTextToTextArea("Name: " + characterModel.getName() + "\n" +
                        "Level: " + characterModel.getLevel() + "\n" +
                        "Class: " + characterModel.getCharacterClassName() + "\n" +
                        "HP: " + characterModel.getHealthPoints() + "\n" +
                        "AP: " + characterModel.getAttackPoints() + "\n" +
                        "Weapon: " + characterModel.getWeaponName());
                CharacterController.getInstance().getOutputView().addTextToTextArea("--- ---");
            }
        }
        int i = firstRound.size();
        while (firstRound.size() > 1) {
            while (firstRound.size() >= 2) {
                if (hasOutput){
                    CharacterController.getInstance().getOutputView().addTextToTextArea("---New round---");
                    CharacterController.getInstance().getOutputView().addTextToTextArea("");
                }
                Collections.shuffle(firstRound);
                CharacterModel player1FirstRound = firstRound.get(0);
                CharacterModel player2FirstRound = firstRound.get(1);
                FightModel fight = new FightModel(player1FirstRound, player2FirstRound);
                fight(fight);
                CharacterModel winner = getWinner(fight);
                CharacterModel looser = getLooser(fight);
                CharacterController.getInstance().addXp(winner);
                CharacterController.getInstance().levelUp(winner);
                CharacterController.getInstance().refreshHP(winner);
                if (hasOutput){
                    CharacterController.getInstance().getOutputView().addTextToTextArea(looser.getName() + " has lost and got eliminated.");
                }

                firstRound.remove(looser);
                addFighterToQuarterFinals(winner);
                firstRound.remove(winner);
            }
            if (firstRound.size() == 1) {
                Collections.shuffle(firstRound);
                CharacterModel characterModel = firstRound.get(0);
                int fighterPosition = 0;
                boolean repeat = true;
                addFighterToQuarterFinals(characterModel);
                while (repeat) {
                    if (Objects.equals(characterModel.getName(), firstRound.get(fighterPosition).getName())) {
                        firstRound.remove(fighterPosition);
                        repeat = false;
                    }
                }
                newRoundForFight();
            }
            else {
                newRoundForFight();
            }
        }
        if (firstRound.size() == 1) {
            if (hasOutput){
                CharacterController.getInstance().getOutputView().addTextToTextArea(firstRound.get(0).getName() + " won the competition.");
            }
            TournamentResultRepository.getInstance().insertWinner(firstRound.get(0).getName());
            firstRound.clear();
        }
    }
    //TODO fight
    public void fight(FightModel fightModel) throws SQLException {
        if (fightModel.getPlayed()){
            fightModel.setPlayedFalse();
        }
        if (hasOutput){
            CharacterController.getInstance().getOutputView().addTextToTextArea(fightModel.getPlayer1().getName() + " vs " + fightModel.getPlayer2().getName());
        }
        while (fightModel.getPlayer1().getHealthPoints() > 0 && fightModel.getPlayer2().getHealthPoints() > 0) {
            CharacterController.getInstance().fightPhase(fightModel.getPlayer1(), fightModel.getPlayer2(), hasOutput);
            this.newRound(fightModel);
            if (hasOutput){
                CharacterController.getInstance().getOutputView().addTextToTextArea("---");
            }
        }
        fightModel.setPlayedTrue();
    }

    //TODO newRound
    protected void newRound(FightModel fightModel) {
        CharacterModel tmp = fightModel.getPlayer1();
        fightModel.setPlayer1(fightModel.getPlayer2());
        fightModel.setPlayer2(tmp);
    }
    public void setSwitch(CharacterModel fighter){
        firstRound.add(fighter);
        secondRound.remove(fighter);
    }

    //TODO getWinner
    public CharacterModel getWinner(FightModel fightModel) {
        if (fightModel.getPlayed()) {
            if (fightModel.getPlayer1().getHealthPoints() > 0) {
                return fightModel.getPlayer1();
            } else {
                return fightModel.getPlayer2();
            }
        }
        return null;
    }

    //TODO getLooser
    public CharacterModel getLooser(FightModel fightModel) {
        if (fightModel.getPlayed()) {
            if (fightModel.getPlayer1().getHealthPoints() == 0) {
                return fightModel.getPlayer1();
            } else {
                return fightModel.getPlayer2();
            }
        }
        return null;
    }
}
