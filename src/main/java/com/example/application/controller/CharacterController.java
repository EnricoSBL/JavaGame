package com.example.application.controller;

import com.example.application.model.CharacterClassModel;
import com.example.application.model.CharacterModel;
import com.example.application.repositories.CharacterClassRepository;
import com.example.application.repositories.CharacterRepository;
import com.example.application.repositories.WeaponRepository;
import com.example.application.views.dtos.*;
import com.example.application.views.OutPut.OutputView;
import org.springframework.beans.BeanUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CharacterController {
    private static CharacterController instance;
    private int amountOfTeams = 8;


    private OutputView outputView;

    public static CharacterController getInstance() {
        if (instance == null) {
            instance = new CharacterController();
        }
        return instance;
    }

    private static final Logger LOGGER = Logger.getLogger((Logger.GLOBAL_LOGGER_NAME));
    private static final Handler HANDLER = new ConsoleHandler();

    // static initialisation
    static {
        HANDLER.setLevel(Level.ALL);
        LOGGER.setLevel(Level.ALL);
        LOGGER.addHandler(HANDLER);
        LOGGER.setUseParentHandlers(false);
    }

    public Logger getLogger() {
        return LOGGER;
    }

    public void levelUp(CharacterModel characterModel) {
        CharacterLvlController.getInstance().levelUp(characterModel);
    }

    public void refreshHP(CharacterModel characterModel) {
        characterModel.setHealthPoints(characterModel.getMaxHP());
    }

    public void addXp(CharacterModel characterModel) {
        characterModel.setExperiencePoints(characterModel.getExperiencePoints() + CharacterLvlController.getInstance().getXp());
    }

    public void prepPhase(CharacterModel attacker, CharacterModel enemy, boolean hasOutput) throws SQLException {
        boolean canUseEffect = false;

        int numberForEffectUsage = 1;
        int randomNumberForEffectUsage = (int) (Math.random() * 3 + 1);

        if (numberForEffectUsage == randomNumberForEffectUsage) {
            int healingNumber = 0;
            int strengthNumber = 0;
            int lifeStealNumber = 0;
            String weaponGrade = attacker.getWeapon().getGrade();
            int effectGrade = (int) (Math.random() * 9 + 1);

            if (Objects.equals(weaponGrade, "Common")) {
                healingNumber = 70;
                strengthNumber = 30;
                lifeStealNumber = 0;
            }
            if (Objects.equals(weaponGrade, "Uncommon")) {
                healingNumber = 55;
                strengthNumber = 45;
                lifeStealNumber = 0;
            }
            if (Objects.equals(weaponGrade, "Rare")) {
                healingNumber = 45;
                strengthNumber = 45;
                lifeStealNumber = 10;
            }
            if (Objects.equals(weaponGrade, "Elite")) {
                healingNumber = 40;
                strengthNumber = 40;
                lifeStealNumber = 20;
            }
            if (Objects.equals(weaponGrade, "Special")) {
                healingNumber = 33;
                strengthNumber = 34;
                lifeStealNumber = 33;
            }

            int chosenNumberOfEffect = (int) (Math.random() * 99 + 1);

            if (chosenNumberOfEffect > 0 && chosenNumberOfEffect <= healingNumber) {
                int healNumber = 0;
                if (effectGrade > 0 && effectGrade <= 5) {
                    healNumber = EffectController.getInstance().readEffectNumber("Heal");
                    attacker.setHealthPoints(attacker.getHealthPoints() + healNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is healing with " + healNumber + " Hp.");
                    }
                }
                if (effectGrade > 5 && effectGrade <= 8) {
                    healNumber = EffectController.getInstance().readEffectNumber("Greater Healing");
                    attacker.setHealthPoints(attacker.getHealthPoints() + healNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is healing with " + healNumber + " Hp.");
                    }
                }
                if (effectGrade > 8 && effectGrade <= 10) {
                    healNumber = EffectController.getInstance().readEffectNumber("Maximise Heal");
                    attacker.setHealthPoints(attacker.getHealthPoints() + healNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is healing with " + healNumber + " Hp.");
                    }
                }
            }
            if (chosenNumberOfEffect > healingNumber && chosenNumberOfEffect <= healingNumber + strengthNumber) {
                int strenghtNumber = 0;
                if (effectGrade > 0 && effectGrade <= 5) {
                    strenghtNumber = EffectController.getInstance().readEffectNumber("Strength");
                    attacker.setAttackPoints(attacker.getAttackPoints() + strenghtNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is strengthening himself with " + strenghtNumber + " Ap.");
                    }
                }
                if (effectGrade > 5 && effectGrade <= 8) {
                    strenghtNumber = EffectController.getInstance().readEffectNumber("Greater Strength");
                    attacker.setAttackPoints(attacker.getAttackPoints() + strenghtNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is strengthening himself with " + strenghtNumber + " Ap.");
                    }
                }
                if (effectGrade > 8 && effectGrade <= 10) {
                    strenghtNumber = EffectController.getInstance().readEffectNumber("Maximise Strength");
                    attacker.setAttackPoints(attacker.getAttackPoints() + strenghtNumber);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " is strengthening himself with " + strenghtNumber + " Ap.");
                    }
                }
            }
            if (chosenNumberOfEffect > healingNumber + strengthNumber && chosenNumberOfEffect <= healingNumber + strengthNumber + lifeStealNumber) {
                int lifeSteal = 0;
                if (effectGrade > 0 && effectGrade <= 5) {
                    lifeSteal = EffectController.getInstance().readEffectNumber("Life Steal");
                    attacker.setLifeSteal(lifeSteal);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " has Life Steal.");
                    }
                }
                if (effectGrade > 5 && effectGrade <= 8) {
                    lifeSteal = EffectController.getInstance().readEffectNumber("Greater Life Steal");
                    attacker.setLifeSteal(lifeSteal);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " has Life Steal.");
                    }
                }
                if (effectGrade > 8 && effectGrade <= 10) {
                    lifeSteal = EffectController.getInstance().readEffectNumber("Maximise Life Steal");
                    attacker.setLifeSteal(lifeSteal);
                    if (hasOutput){
                        getOutputView().addTextToTextArea(attacker.getName() + " has Life Steal.");
                    }
                }
            }
        }
    }

    public void fightPhase(CharacterModel attacker, CharacterModel enemy, boolean hasOutput) throws SQLException {
        prepPhase(attacker, enemy, hasOutput);
        int hit = WeaponController.getInstance().useWeapon(attacker, attacker.getAttackPoints(), attacker.getWeapon(), hasOutput);
        enemy.setHealthPoints(enemy.getHealthPoints() - hit);
        printHitMessage(attacker, enemy, hit, hasOutput);
        if (hit > 100) {
            enemy.setRageMode(true);
            if (hasOutput){
                getOutputView().addTextToTextArea(enemy.getName() + " is entering RAGE MODE!!!");
            }
            //  CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea(enemy.getName() + " is entering RAGE MODE!!!");
        }
        if (hasOutput){
            getOutputView().addTextToTextArea(attacker.log());
            getOutputView().addTextToTextArea(enemy.log());
        }
        // CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea(attacker.log());
        // CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea(enemy.log());
        endPhase(attacker, enemy, hit, hasOutput);
    }

    public void endPhase(CharacterModel attacker, CharacterModel enemy, int hitDamage, boolean hasOutput) {
        if (attacker.getLifeSteal() > 0) {
            attacker.setHealthPoints(attacker.getHealthPoints() + (hitDamage / 100 * attacker.getLifeSteal()));
            if (hasOutput){
                getOutputView().addTextToTextArea(attacker.getName() + " heals " + hitDamage / 100 * attacker.getLifeSteal() + " Hp himself with Life Steal");
            }
        }
        attacker.setLifeSteal(0);
    }


    public void setAmountOfTeams(int amountOfTeams) {
        this.amountOfTeams = amountOfTeams;
    }

    private void printHitMessage(CharacterModel fighter, CharacterModel enemy, int hit, boolean hasOutput) {
        CharacterClassModel fighterCharacterClass = fighter.getCharacterClass();
        String hitMessage = fighterCharacterClass.getHitMessage();
        String message = String.format(hitMessage, fighter.getName(), enemy.getName(), hit, fighter.getWeaponName());
        if (hasOutput){
            getOutputView().addTextToTextArea(message);
        }
        //CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea(message);
    }

    public void updateFighter(int oldNameId, String newName, String newClass) throws SQLException {
        String weapons = WeaponRepository.getInstance().getWeaponNameByCharacterClass(newClass);
        CharacterRepository.getInstance().updateFighter(oldNameId, newName, newClass, weapons);
    }

    public void printSpecialAttacMassage(CharacterModel fighter, boolean hasOutput) {
        CharacterClassModel fighterCharacterClass = fighter.getCharacterClass();
        String specialAttackMessage = fighterCharacterClass.getSpecialAttackMessage();
        String message = String.format(specialAttackMessage, fighter.getName());
        if (hasOutput){
            getOutputView().addTextToTextArea(message);
        }
        //CharacterController.getInstance().getGameSwingMainFrame().printOutToTextArea(message);
    }

    public int readID(String name) throws SQLException {
        return CharacterRepository.getInstance().readID(name);
    }

    public CharacterModel findCharacter(int i) throws SQLException {
        return CharacterRepository.getInstance().findCharacterById(i, "main");
    }

    public void dropTableCharacter() throws SQLException {
        CharacterRepository.getInstance().dropTableCharacter();
    }

    public void createTableCharacter() throws SQLException {
        CharacterRepository.getInstance().createTableCharacter();
    }

    public ArrayList<String> getCharacterClassNamesForComboBox() throws SQLException {
        return CharacterClassRepository.getInstance().readCharacterClassNamesByID();
    }

    public String readCharactername(int i) throws SQLException {
        return CharacterRepository.getInstance().readCharacterName(i);
    }

    public String readCharacterFromName(String name) throws SQLException {
        return CharacterRepository.getInstance().readClass(name);
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public CharacterDto getCharacterDtoById(int id) {
        return this.getCharacterDtoById(id, "main");
    }

    public CharacterDto getCharacterDtoById(int id, String mode) {
        try {
            CharacterModel characterModel = CharacterRepository.getInstance().findCharacterById(id, mode);
            return getCharacterDto(characterModel);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
            e.printStackTrace();
            //Dem Debugger sagen was Sache
            //DEm Anwender "Alternativen" aufzeigen.
        }
        return new CharacterDto();
    }

    private CharacterDto getCharacterDto(CharacterModel characterModel) {
        CharacterDto characterDto = new CharacterDto();
        BeanUtils.copyProperties(characterModel, characterDto, CharacterDto.class);
        CharacterClassModel characterClass = characterModel.getCharacterClass();
        CharacterClassDto characterClassDto = new CharacterClassDto();
        BeanUtils.copyProperties(characterClass, characterClassDto, CharacterClassDto.class);
        BeanUtils.copyProperties(characterModel.getCharacterClass(), characterDto.getCharacterClassDto(), CharacterClassDto.class);
        BeanUtils.copyProperties(characterModel.getWeapon(), characterDto.getWeaponDto(), WeaponDto.class);
        BeanUtils.copyProperties(characterModel.getLevelModel(), characterDto.getLevelDto(), LevelDto.class);
        BeanUtils.copyProperties(characterModel.getPictureModel(), characterDto.getPictureDto(), PictureDto.class);
        return characterDto;
    }

    public Collection<CharacterDto> getAllCharacters() {
        return getAllCharacters("main");
    }
    public Collection<CharacterDto> getAllCharacters(String mode) {
        return CharacterRepository.getInstance().findAll(mode)
                .stream()
                .map(this::getCharacterDto)
                .collect(Collectors.toList());
    }

    public void deleteFighter(int id) throws SQLException {
        CharacterRepository.getInstance().deleteCharacter(id);
    }

}
