package com.example.application.model;

public class EffectModel {

    private int effectId;
    private String effectName;
    private int effectTier;
    private int effectNumber;


    public EffectModel(int effectId, String effectName, int effectTier, int effectNumber){
        this.effectId = effectId;
        this.effectName = effectName;
        this.effectTier = effectTier;
        this.effectNumber = effectNumber;
    }

    public int getEffectId() {
        return effectId;
    }

    public String getEffectName() {
        return effectName;
    }

    public int getEffectTier() {
        return effectTier;
    }

    public int getEffectNumber() {
        return effectNumber;
    }
}
