package com.example.application.model;

import javax.imageio.plugins.tiff.TIFFDirectory;
import java.util.Objects;

public class CharacterClassModel {

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
    public CharacterClassModel(String name, int hp, int ap, int level, int xp, int levelUpRequirement, String hitMessage1, String hitMessage2, String hitMessage3, String specialAttackMessage){
        this.className = name; this.hp = hp; this.ap = ap;
        this.level = level; this.xp = xp; this.levelUpRequirement = levelUpRequirement;
        this.hitMessage1 = hitMessage1; this.hitMessage2 = hitMessage2; this.hitMessage3 = hitMessage3;
        this.specialAttackMessage = specialAttackMessage;
    }

    public CharacterClassModel(){}
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

}
