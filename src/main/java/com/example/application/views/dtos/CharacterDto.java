package com.example.application.views.dtos;

import java.util.Objects;
import java.util.Optional;

public class CharacterDto {

    private int id; //name of fighter
    private String name; //name of fighter
    private int healthPoints; // health
    private int attackPoints; // attack
    private int experiencePoints; //Experience Points
    private int level; // Level of Player
    private CharacterClassDto characterClassDto; // name of class
    private LevelDto levelDto;
    public int teamNumber; // Team number
    private int realTeamNumber;
    private int levelRequirement; // number for Level-Up check
    private int classID; // ID of the class
    private int maxHP;
    private WeaponDto weaponDto;
    private int lifeSteal;
    private boolean rageMode;
    private PictureDto pictureDto;

    public CharacterDto() {
        this.characterClassDto = new CharacterClassDto();
        this.levelDto = LevelDto.LEVEL;
        this.weaponDto = new WeaponDto();
        this.pictureDto = new PictureDto();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterClassDto getCharacterClassDto() {
        return characterClassDto;
    }

    public void setCharacterClassDto(CharacterClassDto characterClassDto) {
        this.characterClassDto = characterClassDto;
    }

    public LevelDto getLevelDto() {
        return levelDto;
    }

    public void setLevelDto(LevelDto levelDto) {
        this.levelDto = levelDto;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getRealTeamNumber() {
        return realTeamNumber;
    }

    public void setRealTeamNumber(int realTeamNumber) {
        this.realTeamNumber = realTeamNumber;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public WeaponDto getWeaponDto() {
        return weaponDto;
    }

    public void setWeaponDto(WeaponDto weaponDto) {
        this.weaponDto = weaponDto;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public void setLifeSteal(int lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    public boolean isRageMode() {
        return rageMode;
    }

    public void setRageMode(boolean rageMode) {
        this.rageMode = rageMode;
    }

    public int getId() {
        return id;
    }

    public PictureDto getPictureDto() { return pictureDto; }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getName() + " (" + getId() +")";
    }

    @Override
    public boolean equals(Object anotherObj) {
        if (this == anotherObj) {
            return true;
        }
        if (anotherObj instanceof CharacterDto) {
            CharacterDto anotherDto = (CharacterDto) anotherObj;
            if (this.getId() != anotherDto.getId()) return false;
            if (! Optional.ofNullable(this.getName()).orElse("").equals(anotherDto.getName())) return false;
/*            if (this.getLevel() != anotherDto.getLevel()) return false;
            if (this.getExperiencePoints() != anotherDto.getExperiencePoints()) return false;
            if (! this.getCharacterClassDto().equals(anotherDto.getCharacterClassDto())) return false;*/

            return true;
        }
        return false;
    }

    public <T> T getT(int a) {
        return null;
    }
}
