package com.example.application.controller;

import com.example.application.model.CharacterModel;
import com.example.application.model.LevelModel;

public class CharacterLvlController {

    private final int lvlRequirement = 100;
    private final int xp = 50;
    private static CharacterLvlController instance;
    private CharacterModel characterModel;
    private LevelModel levelModel;

    public static CharacterLvlController getInstance(){
        if (instance == null){
            instance = new CharacterLvlController();
        }
        return instance;
    }

    public int getLevel() {
        return 1;
    }

    public int getLvlRequirement() {
        return lvlRequirement;
    }

    public int getXp() {
        return xp;
    }

    /*public int addXp(CharacterModel characterModel){
      return characterModel.getXp() + xp;
    }*/

    public int getAdditionalHp(int level){
        if (level == 2){
            return 10;
        }
        if (level == 3){
            return 20;
        }
        if (level == 4){
            return 30;
        }
        if (level == 5){
            return 40;
        }
        return 0;
    }
    public int getAdditionalAp(int level){
        if (level == 2){
            return 5;
        }
        if (level == 3){
            return 10;
        }
        if (level == 4){
            return 15;
        }
        if (level == 5){
            return 20;
        }
        return 0;
    }
    public void levelUp(CharacterModel characterModel){
        if (characterModel.getExperiencePoints() >= this.lvlRequirement){
            characterModel.setLvl();
            characterModel.setExperiencePoints(characterModel.getExperiencePoints() - this.lvlRequirement);
            characterModel.setAttackPoints(characterModel.getAttackPoints() + getAdditionalAp(characterModel.getLevel()));
            characterModel.setHealthPoints(characterModel.getMaxHP() + getAdditionalHp(characterModel.getLevel()));
            characterModel.setMaxHP(characterModel.getHealthPoints());
        }

    }
    public LevelModel getLevelModel(){
        return LevelModel.LEVEL;
    }
}
