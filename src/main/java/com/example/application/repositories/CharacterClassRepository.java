package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;
import com.example.application.model.CharacterClassModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class CharacterClassRepository {
    private static CharacterClassRepository instance;

    public static CharacterClassRepository getInstance() {
        if (instance == null){
            instance = new CharacterClassRepository();
        }
        return instance;
    }

    //TODO Create



    //TODO Read

    private final String readCharacterClassByID = "SELECT * FROM characterClass WHERE character_id = ?";
    private final String readCharacterClassByName = "SELECT * FROM characterClass WHERE character_name = ?;";
    private final String readCharacterClassNamesByID = "SELECT character_name FROM characterClass WHERE character_id = ?;";

    private final String readHp = "SELECT character_hp FROM characterClass WHERE character_name = ?;";
    private final String readAp = "SELECT character_ap FROM characterClass WHERE character_name = ?;";
    private final String readLvl = "SELECT character_lvl FROM characterClass WHERE character_name = ?;";
    private final String readXp = "SELECT character_xp FROM characterClass WHERE character_name = ?;";
    private final String readlvlReq = "SELECT character_lvlReq FROM characterClass WHERE character_name = ?;";


    //TODO Update



    //TODO Delete



    //TODO Methodes

    public int readHpFromDb(String fClass) throws SQLException {
        return DatabaseConnector.getInstance("main").getClassHp(readHp , fClass);
    }
    public int readApFromDb(String fClass) throws SQLException {
        return DatabaseConnector.getInstance("main").getClassAp(readAp , fClass);
    }
    public int readLvlFromDb(String fClass) throws SQLException {
        return DatabaseConnector.getInstance("main").getClassLvl(readLvl , fClass);
    }
    public int readXpFromDb(String fClass) throws SQLException {
        return DatabaseConnector.getInstance("main").getClassXp(readXp , fClass);
    }
    public int readLvlReqFromDb(String fClass) throws SQLException {
        return DatabaseConnector.getInstance("main").getClassLvlReq(readlvlReq , fClass);
    }

    public CharacterClassModel readCharacterByName(String characterClassName, String mode) throws SQLException {
        ArrayList<String> rawDataFromDB;
        if (Objects.equals(mode, "test")){
            rawDataFromDB = DatabaseConnector.getInstance(mode).readCharacterClassByName(readCharacterClassByName, characterClassName);
        }
        else {
            rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, characterClassName);
        }
        String name = rawDataFromDB.get(0);
        int hp = Integer.parseInt(rawDataFromDB.get(1));
        int ap = Integer.parseInt(rawDataFromDB.get(2));
        int lvl = Integer.parseInt(rawDataFromDB.get(3));
        int xp = Integer.parseInt(rawDataFromDB.get(4));
        int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
        String hitmes1 = rawDataFromDB.get(6);
        String hitmes2 = rawDataFromDB.get(7);
        String hitmes3 = rawDataFromDB.get(8);
        String specialAttack = rawDataFromDB.get(9);

        return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
    }

    public String getCharacterClass(String name) throws SQLException {
       return CharacterRepository.getInstance().readClass(name);
    }

    public ArrayList<String> readCharacterClassNamesByID() throws SQLException {
        ArrayList<String> listOfClasses = new ArrayList<>();
        int index = 1;
        int maxClasses = 30;

        listOfClasses.add("Random Class");
        while (index <= maxClasses){
            String fClass = DatabaseConnector.getInstance("main").readCharacterClassNameByID(readCharacterClassNamesByID, index);
            listOfClasses.add(fClass);
            index++;
        }
        return listOfClasses;
    }
    public CharacterClassModel getRandomCharacterClass() throws SQLException {
        int randomClassNumber = (int) ((Math.random() * 99) + 1);
        if (randomClassNumber > 0 && randomClassNumber < 9) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Fighter");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack); }
        if (randomClassNumber > 8 && randomClassNumber < 16) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Forest Helper");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 15 && randomClassNumber < 23) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Magic Caster");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }

        if (randomClassNumber > 22 && randomClassNumber < 27){
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Street Fighter");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 26 && randomClassNumber < 31){
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Sword Fighter");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 30 && randomClassNumber < 35) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Gladiator");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 34 && randomClassNumber < 39) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Guardian of the Forest");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 38 && randomClassNumber < 43) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Golem");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 42 && randomClassNumber < 47) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Forest Ranger");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 46 && randomClassNumber < 51) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Arc Mage");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 50 && randomClassNumber < 55) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Scholar of the Academia");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 54 && randomClassNumber < 59) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Exiled Magic User");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }

        if (randomClassNumber > 58 && randomClassNumber < 62) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Master of the Ring");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 61 && randomClassNumber < 65) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Sword Master");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 64 && randomClassNumber < 68) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Champion of the Arena");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 67 && randomClassNumber < 71) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The highest Protector of the Forest");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 70 && randomClassNumber < 74) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Golem of Life Essence");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 73 && randomClassNumber < 77) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The Hero of the Forest");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 76 && randomClassNumber < 79) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "User of forbidden Magic");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 78 && randomClassNumber < 82) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Sage of the Academia");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 81 && randomClassNumber < 85) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Necromancer");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }

        if (randomClassNumber > 84 && randomClassNumber < 87) { ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Samurai");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);

        }
        if (randomClassNumber > 86 && randomClassNumber < 89) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Assassin");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 88 && randomClassNumber < 91) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The Ruler of the Forest");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 90 && randomClassNumber < 93) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The Saviour of the Forest");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 92 && randomClassNumber < 95) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Master of Arcane Magic");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber > 94 && randomClassNumber < 97) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Elder Lic");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }

        if (randomClassNumber == 97) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The Ultimate Warrior");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber == 98) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Sentinel One");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }
        if (randomClassNumber == 99) {
            ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "The Overlord");
            String name = rawDataFromDB.get(0);
            int hp = Integer.parseInt(rawDataFromDB.get(1));
            int ap = Integer.parseInt(rawDataFromDB.get(2));
            int lvl = Integer.parseInt(rawDataFromDB.get(3));
            int xp = Integer.parseInt(rawDataFromDB.get(4));
            int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
            String hitmes1 = rawDataFromDB.get(6);
            String hitmes2 = rawDataFromDB.get(7);
            String hitmes3 = rawDataFromDB.get(8);
            String specialAttack = rawDataFromDB.get(9);

            return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
        }


        ArrayList<String> rawDataFromDB = DatabaseConnector.getInstance("main").readCharacterClassByName(readCharacterClassByName, "Fighter");
        String name = rawDataFromDB.get(0);
        int hp = Integer.parseInt(rawDataFromDB.get(1));
        int ap = Integer.parseInt(rawDataFromDB.get(2));
        int lvl = Integer.parseInt(rawDataFromDB.get(3));
        int xp = Integer.parseInt(rawDataFromDB.get(4));
        int lvlReq = Integer.parseInt(rawDataFromDB.get(5));
        String hitmes1 = rawDataFromDB.get(6);
        String hitmes2 = rawDataFromDB.get(7);
        String hitmes3 = rawDataFromDB.get(8);
        String specialAttack = rawDataFromDB.get(9);

        return new CharacterClassModel(name, hp, ap, lvl, xp, lvlReq, hitmes1, hitmes2, hitmes3, specialAttack);
    }

}
