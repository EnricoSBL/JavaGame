package com.example.application.model;

public class WeaponModel {

    private String name;
    private int amountNormalHits;
    private int specialHits;
    private int chanceOfSuperAbilityToTrigger;
    private String grade;

    public WeaponModel(String name, int amountNormalHits, int specialHits, int chanceOfSuperAbilityToTrigger, String grade){
        this.name = name;
        this.amountNormalHits = amountNormalHits;
        this.specialHits = specialHits;
        this.chanceOfSuperAbilityToTrigger = chanceOfSuperAbilityToTrigger;
        this.grade = grade;
    }

    public String getName(){ return name; }
    public int getAmountNormalHits(){ return amountNormalHits; }
    public int getSpecialHits() { return specialHits; }
    public int getChanceOfSuperAbilityToTrigger() { return chanceOfSuperAbilityToTrigger; }

    public String getGrade() { return grade; }
}
