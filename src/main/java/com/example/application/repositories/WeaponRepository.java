package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;
import com.example.application.model.WeaponModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class WeaponRepository {
    private static WeaponRepository instance;

    public static WeaponRepository getInstance() {
        if (instance == null) {
            instance = new WeaponRepository();
        }
        return instance;
    }

    //TODO Create

    private final String createWeapon = "INSERT INTO Weapons (Weapon_name, Weapon_normalHits, Weapon_specialHits, Weapon_chanceForSuperAbility, Weapon_rarity) VALUES(?, ?, ?, ?, ?);";

    //TODO Read

    private final String readWeaponByID = "SELECT * FROM Weapons WHERE Weapon_ID = ?;";
    private final String readWeaponByName = "SELECT * FROM Weapons WHERE Weapon_name = ?;";

    private final String readWeaponName = "SELECT Weapon_name FROM Weapons WHERE Weapon_ID = ?;";
    private final String readWeaponRarity = "SELECT Weapon_rarity FROM Weapons WHERE Weapon_ID = ?;";
    private final String readWeaponNormalHits = "SELECT Weapon_normalHits FROM Weapons WHERE Weapon_ID = ?;";
    private final String readWeaponSpecialHits = "SELECT Weapon_specialHits FROM Weapons WHERE Weapon_ID = ?;";
    private final String readWeaponChanceOfSuperAbility = "SELECT Weapon_chanceForSuperAbility FROM Weapons WHERE Weapon_ID = ?;";


    //TODO Update

    private final String updateWeaponName = "UPDATE Weapons SET Weapon_name = ? WHERE Weapon_id = ?;";

    //TODO Delete


    //TODO Methodes


    public String getWeaponNameByCharacterClass(String characterClass) {
        int numberForRandomWeapon = (int) (Math.random() * 99 + 1);
        String name;

        if (Objects.equals(characterClass, "Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 1, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 4, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Forest Helper")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 2, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 7, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Magic Caster")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 3, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 11, "Weapon_name"); }
        }
        // -----------------------------------------------------------------------------------------------------
        if (Objects.equals(characterClass, "Street Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 4, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 13, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Sword Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 5, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 14, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Gladiator")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 6, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 15, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Guardian of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 7, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 16, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Golem")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 8, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 17, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Forest Ranger")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 9, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 18, "Weapon_name"); }
       }

        if (Objects.equals(characterClass, "Arc Mage")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 10, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 19, "Weapon_name"); }
        }
            
        
        if (Objects.equals(characterClass, "Scholar of the Academia")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 11, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 20, "Weapon_name"); }
         }
        if (Objects.equals(characterClass, "Exiled Magic User")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 12, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 21, "Weapon_name"); }
        }
        // ---------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterClass, "Master of the Ring")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {  return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 4, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 13, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Sword Master")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 5, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 14, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Champion of the Arena")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 6, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 15, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "The highest Protector of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 7, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 16, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Golem of Life Essence")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 8, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 17, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "The Hero of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 9, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 18, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "User of forbidden Magic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 10, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 19, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Sage of the Academia")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 11, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 20, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Necromancer")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 12, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 21, "Weapon_name"); }
        }
        // -----------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterClass, "Samurai")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 14, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 22, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Assassin")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 15, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 23, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "The Ruler of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 17, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 24, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "The Saviour of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 18, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 26, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Master of Arcane Magic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 20, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 26, "Weapon_name"); }
        }
        if (Objects.equals(characterClass, "Elder Lic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 21, "Weapon_name"); }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 27, "Weapon_name"); }
        }
            // -----------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterClass, "The Ultimate Warrior")) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 28, "Weapon_name"); }
        if (Objects.equals(characterClass, "Sentinel One")) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 29, "Weapon_name"); }
        if (Objects.equals(characterClass, "The Overlord")) { return DatabaseConnector.getInstance("main").readWeaponInformationByID(readWeaponName, 30, "Weapon_name"); }

        return "Dagger";
    }



    public String getReadWeaponByName() {
        return readWeaponByName;
    }

    public WeaponModel readWeaponByName(String weaponName) throws SQLException {
        ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, weaponName);
        String name = rawDataFromDB.get(0);
        String rarity = rawDataFromDB.get(1);
        int normalHits = Integer.parseInt(rawDataFromDB.get(2));
        int specialHits = Integer.parseInt(rawDataFromDB.get(3));
        int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));

        return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
    }

    public WeaponModel setWeapon(String characterModel) throws SQLException {
        int numberForRandomWeapon = (int) (Math.random() * 99 + 1);
        // -------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterModel, "Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Dagger");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));

                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Brass Nuckles");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Forest Helper")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Bow");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Leaf Sword");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Magic Caster")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook from the Akademia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        // -----------------------------------------------------------------------------------------------------


        if (Objects.equals(characterModel, "Street Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Brass Nuckles");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Fist of the Ring");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Sword Fighter")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Practice Katana");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Katana from Tokyo");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Gladiator")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Iron Sword");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Sword of the Champion");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }


        if (Objects.equals(characterModel, "Guardian of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Leaf Sword");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Lance of the Forest");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Golem")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Roots");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Fracture of the Life Essence");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Forest Ranger")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Forest Bow");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "The Sword of the Forest");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }


        if (Objects.equals(characterModel, "Arc Mage")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook of Fire");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Scroll of the Academia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Scholar of the Academia")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook from the Akademia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Scroll of the Academia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Exiled Magic User")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Book of the Exiled");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Orb of the Dead");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }


        // ---------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterModel, "Master of the Ring")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Brass Nuckles");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Fist of the Ring");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Sword Master")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Practice Katana");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Katana from Tokyo");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Champion of the Arena")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Iron Sword");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Sword of the Champion");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }


        if (Objects.equals(characterModel, "The highest Protector of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Leaf Sword");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Lance of the Forest");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Golem of Life Essence")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Roots");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Fracture of the Life Essence");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "The Hero of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Forest Bow");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "The Sword of the Forest");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }


        if (Objects.equals(characterModel, "User of forbidden Magic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook of Fire");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook of Forbidden Knowledge");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Sage of the Academia")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Spellbook from the Akademia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Scroll of the Academia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Necromancer")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Book of the Exiled");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Orb of the Dead");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        // -----------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterModel, "Samurai")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Katana from Tokyo");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Katana from the Shougen");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Assassin")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Sword of the Champion");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Assassins Blade");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "The Ruler of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Fracture of the Life Essence");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Life Essence");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "The Saviour of the Forest")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "The Sword of the Forest");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Sword of the Life Essence");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Master of Arcane Magic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Scroll of the Academia");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Staff of the Ancient");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }
        if (Objects.equals(characterModel, "Elder Lic")) {
            if (numberForRandomWeapon > 0 && numberForRandomWeapon < 76) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Orb of the Dead");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
            if (numberForRandomWeapon > 75 && numberForRandomWeapon < 101) {
                ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Orb of Wisdom");
                String name = rawDataFromDB.get(0);
                String rarity = rawDataFromDB.get(1);
                int normalHits = Integer.parseInt(rawDataFromDB.get(2));
                int specialHits = Integer.parseInt(rawDataFromDB.get(3));
                int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
                return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
            }
        }

        // -----------------------------------------------------------------------------------------------------------
        if (Objects.equals(characterModel, "The Ultimate Warrior")) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Excalibur");
            String name = rawDataFromDB.get(0);
            String rarity = rawDataFromDB.get(1);
            int normalHits = Integer.parseInt(rawDataFromDB.get(2));
            int specialHits = Integer.parseInt(rawDataFromDB.get(3));
            int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
            return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
        }
        if (Objects.equals(characterModel, "Sentinel One")) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Rules of the Heavenly Principals");
            String name = rawDataFromDB.get(0);
            String rarity = rawDataFromDB.get(1);
            int normalHits = Integer.parseInt(rawDataFromDB.get(2));
            int specialHits = Integer.parseInt(rawDataFromDB.get(3));
            int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
            return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
        }
        if (Objects.equals(characterModel, "The Overlord")) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Staff of Ainz Oawl Gown");
            String name = rawDataFromDB.get(0);
            String rarity = rawDataFromDB.get(1);
            int normalHits = Integer.parseInt(rawDataFromDB.get(2));
            int specialHits = Integer.parseInt(rawDataFromDB.get(3));
            int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
            return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
        }

        ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readWeaponByName(readWeaponByName, "Dagger");
        String name = rawDataFromDB.get(0);
        String rarity = rawDataFromDB.get(1);
        int normalHits = Integer.parseInt(rawDataFromDB.get(2));
        int specialHits = Integer.parseInt(rawDataFromDB.get(3));
        int chanceForSuperAbility = Integer.parseInt(rawDataFromDB.get(4));
        return new WeaponModel(name, normalHits, specialHits, chanceForSuperAbility, rarity);
    }

}
