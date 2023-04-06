package com.example.application.controller;

import com.example.application.model.CharacterModel;
import com.example.application.model.FightModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamFightController extends Tournament16Controller{

    Map<Integer, List<CharacterModel>> mapOfTeams = new HashMap<>();

    Map<Integer, List<CharacterModel>> mapIfTeamsSecondRound = new HashMap<>();
    private boolean newRound = false;
    private int indexOfSecondRound = 0;
    CharacterModel player1;
    CharacterModel player2;

    private static TeamFightController instance;
    public static TeamFightController getInstance() {
        if (instance == null) {
            instance = new TeamFightController();
        }
        return instance;
    }
    public CharacterModel getFighterTeam(int i){
        int integerForGetFighter;
        if (i < 7){
            integerForGetFighter=0;
        }else {
            integerForGetFighter=1;
        }
        return mapOfTeams.get(i % mapOfTeams.size()).get(integerForGetFighter);
    }

    public CharacterModel getFighter(int i){
        return mapOfTeams.get(i % 8).get(0);
    }
    @Override
    public CharacterModel getFighter(String name){
        int i = 0;
        for (CharacterModel cm : mapOfTeams.get(i % 8)){
            if (cm.getName().equals(name)){
                return cm;
            }
            i++;
        }
        return null;
    }
    public void addFighterToTeamList(int teamNumber, CharacterModel fighter1) {
        List<CharacterModel> listOfTeam = mapOfTeams.getOrDefault(teamNumber, new ArrayList<>());
        listOfTeam.add(fighter1);
        mapOfTeams.put(teamNumber, listOfTeam);
        fighter1.setTeamNumber(teamNumber);
        fighter1.setRealTeamNumber(teamNumber);
    }

    public CharacterModel getPlayer() {
        int randomNumber = (int) (Math.random() * mapOfTeams.size());
        return mapOfTeams.get(randomNumber).get(0);

    }

    public void cleatMapofTeams(){
        mapOfTeams.clear();
    }

    public int getTeamSize(int number) {
        return mapOfTeams.getOrDefault(number, null).size();
    }


    public CharacterModel fight() throws InterruptedException {
        int finished = 0;
        while (mapOfTeams.size() != 0 && finished != 3) {
            if (!newRound) {
                for (int key = 0; key <= mapOfTeams.size() -1; key++){
                    mapOfTeams.put(key, mapOfTeams.get(key));
                    int counter = 1;
                    while (mapOfTeams.get(key) == null){
                        mapOfTeams.remove(key);
                        mapOfTeams.put(key, mapOfTeams.get(key+counter));
                        mapOfTeams.remove(key+counter);
                        counter++;
                    }
                    int playerNumber = 0;
                    for (CharacterModel fighter : mapOfTeams.get(key)){
                        mapOfTeams.get(key).get(playerNumber).setTeamNumber(key);
                        playerNumber++;
                    }
                }
                player1 = getPlayer();
                player2 = getPlayer();
                if (player1 == player2){
                    while (player1 == player2){
                        player2 = getPlayer();
                    }
                }
            }
            System.out.println("---New round---");
            FightModel f = new FightModel(player1, player2);

           // super.fight(f);
            CharacterModel winner = super.getWinner(f);
            CharacterModel looser = super.getLooser(f);
            CharacterController.getInstance().addXp(winner);
            CharacterController.getInstance().levelUp(winner);
            CharacterController.getInstance().refreshHP(winner);
            System.out.println(looser.getName() + " has lost and got eliminated.");
            mapOfTeams.get(looser.getTeamNumber()).remove(looser);
            if (mapOfTeams.get(looser.getTeamNumber()).size() == 0) {
                mapOfTeams.remove(looser.getTeamNumber());
                mapIfTeamsSecondRound.put(indexOfSecondRound, mapOfTeams.get(winner.getTeamNumber()));
                mapOfTeams.remove(winner.getTeamNumber());
                newRound = false;
                indexOfSecondRound++;
            } else {
                newRound = true;
                player1 = mapOfTeams.get(winner.getTeamNumber()).get(0);
                player2 = mapOfTeams.get(looser.getTeamNumber()).get(0);
            }

            if (mapOfTeams.isEmpty()) {
                indexOfSecondRound = 0;
                newRoundForTeam();
                finished++;
            }
            if (mapOfTeams.size() == 1 && finished == 3){
                return winner;
            }
        }
        return null;
    }

    protected void newRoundForTeam() {
        Map<Integer, List<CharacterModel>> tmp = new HashMap<>();
        mapOfTeams = mapIfTeamsSecondRound;
        mapIfTeamsSecondRound = tmp;
    }
}
