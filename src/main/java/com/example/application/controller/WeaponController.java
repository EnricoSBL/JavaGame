package com.example.application.controller;

import com.example.application.model.CharacterModel;
import com.example.application.model.WeaponModel;

public class WeaponController {
    public static WeaponController instance;
    private int specialAttack;
    private boolean rageMode;
    public static WeaponController getInstance() {
        if (instance == null) {
            instance = new WeaponController();
        }
        return instance;
    }

    public int useWeapon(CharacterModel fighter, int ap, WeaponModel weapon, boolean hasOutput) {
        int damage = 0;
        int numberForSpecialAbility = (int) (Math.random() * 9 + 1);
        int numberForCrit = (int) (Math.random() * 10 + 1);
        int numberForParry = (int) (Math.random() * 10 + 1);
        int numberForRageMode = (int) (Math.random() * 99 + 1);
        if (weapon.getAmountNormalHits() > 1) {
            int normalHits = weapon.getAmountNormalHits();
            while (normalHits > 0) {
                damage += (int) (Math.random() * ap + 1);
                normalHits--;
                ap /= 2;
            }
        } else {
            damage += (int) (Math.random() * ap + 1);
        }
        if (weapon.getSpecialHits() > 0) {
            int specialHits = weapon.getSpecialHits();
            int decreaseDamage = 3;
            while (specialHits > 0) {
                damage += (int) (Math.random() * ap / decreaseDamage + 1);
                specialHits--;
                if (decreaseDamage > 1) { decreaseDamage--; }
            }
        }
        for (int i = weapon.getChanceOfSuperAbilityToTrigger(); i > 0; i--) {
            if (numberForSpecialAbility == 5) {
                if (fighter.getHealthPoints() > 30 && specialAttack == 0) {
                    damage *= 5;
                    fighter.setHealthPoints(fighter.getHealthPoints() - 30);
                    CharacterController.getInstance().printSpecialAttacMassage(fighter, hasOutput);
                    specialAttack++;
                }
            }
        }
        if (numberForCrit == 1){ damage*=2; }
        if (numberForParry == 10) {
            damage = 0;
            if (hasOutput){
                CharacterController.getInstance().getOutputView().addTextToTextArea("Perfect perry");
            }
         //   CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea("Perfect perry");
        }
        if (numberForParry > 6 && numberForParry < 10) {
            damage /= 2;
            if (hasOutput){
                CharacterController.getInstance().getOutputView().addTextToTextArea("half perry");
            }
         //   CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea("half perry");
        }
        //Rage Mode
        if (fighter.getHealthPoints() <= 35 || fighter.isRageMode() || numberForRageMode == 1) { damage *= 2; }
        specialAttack = 0;
        fighter.setRageMode(false);
        return damage;
    }
}
