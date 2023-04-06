package com.example.application.views.dtos;

public class WeaponDto {

    private String name;
    private int amountNormalHits;
    private int specialHits;
    private int chanceOfSuperAbilityToTrigger;
    private String grade;

    public WeaponDto(String name, int amountNormalHits, int specialHits, int chanceOfSuperAbilityToTrigger, String grade){
        this.name = name;
        this.amountNormalHits = amountNormalHits;
        this.specialHits = specialHits;
        this.chanceOfSuperAbilityToTrigger = chanceOfSuperAbilityToTrigger;
        this.grade = grade;
    }

    public WeaponDto() {

    }

    @Override
    public String toString() {
        return getName();
    }
    public String getName(){ return name; }
    public int getAmountNormalHits(){ return amountNormalHits; }
    public int getSpecialHits() { return specialHits; }
    public int getChanceOfSuperAbilityToTrigger() { return chanceOfSuperAbilityToTrigger; }

    public String getGrade() { return grade; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountNormalHits(int amountNormalHits) {
        this.amountNormalHits = amountNormalHits;
    }

    public void setSpecialHits(int specialHits) {
        this.specialHits = specialHits;
    }

    public void setChanceOfSuperAbilityToTrigger(int chanceOfSuperAbilityToTrigger) {
        this.chanceOfSuperAbilityToTrigger = chanceOfSuperAbilityToTrigger;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
