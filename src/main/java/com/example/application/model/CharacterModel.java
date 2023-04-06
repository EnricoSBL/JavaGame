package com.example.application.model;

public class CharacterModel {

    private int id;
    private String name; //name of fighter
    private int healthPoints; // health
    private int attackPoints; // attack
    private int experiencePoints; //Experience Points
    private int level; // Level of Player
    private CharacterClassModel characterClassModel; // name of class
    private LevelModel levelModel;
    public int teamNumber; // Team number
    private int realTeamNumber;
    private int levelRequirement; // number for Level-Up check
    private int classID; // ID of the class
    private int maxHP;
    private WeaponModel weapon;
    private int lifeSteal;
    private PictureModel pictureModel;
    private boolean rageMode;

    //ToDO Constructors

    /**
     * @param name name of the character
     * @param characterClassModel characterClass for Character
     */
    public CharacterModel(String name, CharacterClassModel characterClassModel, LevelModel levelModel, WeaponModel weapon) {
        this.name = name;
        this.characterClassModel = characterClassModel;
        this.healthPoints = characterClassModel.getHp();
        this.maxHP = characterClassModel.getHp();
        this.attackPoints = characterClassModel.getAp();
        this.levelModel = levelModel;
        this.experiencePoints = levelModel.getXp();
        this.level = levelModel.getLevel();
        this.levelRequirement = levelModel.getLevelRequirement();
        this.weapon = weapon;
        this.rageMode = false;
        this.lifeSteal = 0;

    }
    public CharacterModel(int id, String name, CharacterClassModel characterClassModel, LevelModel levelModel, int level, int xp, WeaponModel weapon) {
        this.id = id;
        this.name = name;
        this.characterClassModel = characterClassModel;
        this.healthPoints = characterClassModel.getHp();
        this.maxHP = characterClassModel.getHp();
        this.attackPoints = characterClassModel.getAp();
        this.levelModel = levelModel;
        this.experiencePoints = xp;
        this.level = level;
        this.levelRequirement = levelModel.getLevelRequirement();
        this.weapon = weapon;
        this.rageMode = false;
    }
    public CharacterModel(int id, String name, CharacterClassModel characterClassModel, LevelModel levelModel, int level, int xp, WeaponModel weapon, PictureModel pictureModel) {
        this.id = id;
        this.name = name;
        this.characterClassModel = characterClassModel;
        this.healthPoints = characterClassModel.getHp();
        this.maxHP = characterClassModel.getHp();
        this.attackPoints = characterClassModel.getAp();
        this.levelModel = levelModel;
        this.experiencePoints = xp;
        this.level = level;
        this.levelRequirement = levelModel.getLevelRequirement();
        this.weapon = weapon;
        this.pictureModel = pictureModel;
        this.rageMode = false;
    }

    // TODO name
    public String getName() { return name; }
    public void setName(String name){ this.name = name; }

    // ToDO hp

    public WeaponModel getWeapon(){ return weapon; }
    public String getWeaponName(){  return weapon.getName(); }
    public void setWeapon(WeaponModel weapon){this.weapon = weapon;}

    public int getMaxHP() { return maxHP; }

    public void setMaxHP(int maxHP) { this.maxHP = maxHP; }

    public int getHealthPoints() { return this.healthPoints; }
    public void setHealthPoints(int healthPoints) { this.healthPoints = Math.max(healthPoints, 0); }

    //ToDo ap
    public int getAttackPoints() { return attackPoints; }
    public void setAttackPoints(int attackPoints){ this.attackPoints = attackPoints; }


    //ToDo xp

    public int getExperiencePoints() { return experiencePoints; }
    public void setExperiencePoints(int experiencePoints) { this.experiencePoints = experiencePoints; }



    //ToDo lvl
    public int getLevel() { return this.level; }

    public void setLvl(){ this.level = levelModel.getLevel()+1; }

    public int getLevelRequirement() { return this.levelRequirement; }

    //ToDO teamNumber
    public void setTeamNumber(int teamNumber) { this.teamNumber = teamNumber; }

    public int getTeamNumber() { return teamNumber; }
    public void setRealTeamNumber(int teamNumber){this.realTeamNumber = teamNumber; }
    public int getRealTeamNumber(){ return realTeamNumber; }

    //ToDO Character Class


    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterClassModel getCharacterClassModel() {
        return characterClassModel;
    }

    public void setCharacterClassModel(CharacterClassModel characterClassModel) {
        this.characterClassModel = characterClassModel;
    }

    public LevelModel getLevelModel() {
        return levelModel;
    }

    public void setLevelModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public boolean isRageMode() {
        return rageMode;
    }

    public void setRageMode(boolean rageMode) {
        this.rageMode = rageMode;
    }

    public CharacterClassModel getCharacterClass(){ return characterClassModel; }
    public String getCharacterClassName() { return characterClassModel.getClassName(); }
    public String  log() {
        return this.getName() + ": " + "hp=" + this.getHealthPoints();
    }


    public int getLifeSteal() {
        return lifeSteal;
    }

    public void setLifeSteal(int lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PictureModel getPictureModel() {
        return pictureModel;
    }

    public void setPictureModel(PictureModel pictureModel) {
        this.pictureModel = pictureModel;
    }
}
