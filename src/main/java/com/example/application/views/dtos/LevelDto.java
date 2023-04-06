package com.example.application.views.dtos;

public enum LevelDto {
    LEVEL(1,0,100);
    LevelDto(int level, int xp, int levelRequirement){
        this.level = level;
        this.xp = xp;
        this.levelRequirement = levelRequirement;
    }
    private int level;
    private int xp;
    private int levelRequirement;

    //ToDo Level
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int setLevel() { return level; }

    //ToDo XP
    public int getXp() { return xp; }

    public void setXp(int xp) { this.xp = xp; }
    public int setXp() { return xp; }

    //TODO Level Requirement
    public int getLevelRequirement() { return levelRequirement; }

    public void setLevelRequirement(int levelRequirement) { this.levelRequirement = levelRequirement; }
    public int setLevelRequirement() { return levelRequirement; }



}
