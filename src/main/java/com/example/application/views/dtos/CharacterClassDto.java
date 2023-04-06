package com.example.application.views.dtos;

public class CharacterClassDto {

    private String className;
    private int hp;
    private int ap;
    private int level;
    private int xp;
    private int levelUpRequirement;
    private String hitMessage1;
    private String hitMessage2;
    private String hitMessage3;
    private String specialAttackMessage;
    public CharacterClassDto() {
        this.className = "";
    }

    public String getClassName(){ return className; }
    public int getHp(){ return hp; }
    public int getAp(){ return ap; }
    public int getLevel(){ return level; }
    public int getXp(){ return xp; }
    public int getLevelUpRequirement(){ return levelUpRequirement; }
    public String getHitMessage1() { return hitMessage1; }
    public String getHitMessage2() { return hitMessage2; }
    public String getHitMessage3() { return hitMessage3; }
    public String getSpecialAttackMessage(){ return specialAttackMessage; }
    public String getHitMessage(){
        int randomNumberMagicCaster = (int) (Math.random() * 3 + 1);
        if (randomNumberMagicCaster == 1) {  return getHitMessage1(); }
        if (randomNumberMagicCaster == 2) { return getHitMessage2(); }
        return getHitMessage3();
    }

    @Override
    public String toString() {
        return getClassName();
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLevelUpRequirement(int levelUpRequirement) {
        this.levelUpRequirement = levelUpRequirement;
    }

    public void setHitMessage1(String hitMessage1) {
        this.hitMessage1 = hitMessage1;
    }

    public void setHitMessage2(String hitMessage2) {
        this.hitMessage2 = hitMessage2;
    }

    public void setHitMessage3(String hitMessage3) {
        this.hitMessage3 = hitMessage3;
    }

    public void setSpecialAttackMessage(String specialAttackMessage) {
        this.specialAttackMessage = specialAttackMessage;
    }
}
