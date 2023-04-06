package com.example.application.controller;

import com.example.application.model.MyPropertiesWrapper;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class DatabaseConnector {

    private final Connection con;
    private static DatabaseConnector instance;

    public static DatabaseConnector getInstance(String mode) {
        if (instance == null) {
            try {
                instance = new DatabaseConnector(mode);
            } catch (SQLException e) {
                //TODO LOGGER
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return instance;
    }


    private DatabaseConnector(String mode) throws IOException, SQLException {
        MyPropertiesWrapper propertiesWrapper = null;
            propertiesWrapper = new MyPropertiesWrapper(mode);
            con = DriverManager.getConnection(propertiesWrapper.getDBUrl(), propertiesWrapper.getUser(), propertiesWrapper.getPass());
    }

    public int readTournamentIdByName(String query, String name){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){ return resultSet.getInt("tournament_id"); }
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        return 0;
    }

    public List<Integer> readTableTournament(String query) {
        List<Integer> listOfTournaments = new ArrayList<>();
        Statement statement;
        try {
            statement = con.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                while (resultSet.next()) {
                    listOfTournaments.add(resultSet.getInt("tournament_id"));
                }
            }
        } catch (SQLException e) { Logger.getAnonymousLogger().severe((Supplier<String>) e); }
        return listOfTournaments;
    }

    public void createTournament(String query, String name) {

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    public void insertIntoTournamentToCharacter(String query, int tournament_id, int character_id){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, tournament_id);
            statement.setInt(2, character_id);
            statement.executeUpdate(); }
        catch (SQLException e) { Logger.getAnonymousLogger().severe(e.getMessage()); }
    }

    public int readTournamentIDByCharacterID(String query, int character_id){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, character_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){ return resultSet.getInt("tournament_id"); }
        }
        catch (SQLException e) { Logger.getAnonymousLogger().severe(e.getMessage()); }
        return 0;
    }
    public int readCharacterIDByTournamentID(String query, int tournament_id){
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, tournament_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){ return resultSet.getInt("character_id"); }
        }
        catch (SQLException e) { Logger.getAnonymousLogger().severe(e.getMessage()); }
        return 0;
    }
    public void createTableTournament(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void createTableTournamentToTournament(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }



    public void dropTableTournament(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void dropTableTournamentToCharacter(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void insertWinner(String query, String winner) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, winner);
        statement.executeUpdate();
    }

    public List<String> readWinner(String query) throws SQLException {
        List<String> listOfWinners = new ArrayList<>();
        Statement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            listOfWinners.add(resultSet.getString("winner"));
        }
        return listOfWinners;
    }

    public List readAllWinner(String query) throws SQLException {
        List listOfWinners = new ArrayList<>();
        Statement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            listOfWinners.add(resultSet.getInt("tournament_id"));
            listOfWinners.add(resultSet.getString("winner"));
        }
        return listOfWinners;
    }

    public void deleteCharacter(String query, int id) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void insertFighterIntoDB(String query, String name, String fClass, int lvl, int xp, String weapon) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, fClass);
        statement.setInt(3, lvl);
        statement.setInt(4, xp);
        statement.setString(5, weapon);
        statement.executeUpdate();
    }

    public String getCharacterName(String query, int i) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, i);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getString("Character_name");
        }
        return null;
    }

/*
    public String testForTable(String name) throws SQLException {
        Statement statement = con.createStatement();
        String queryString = rep.getShowTables();
        ResultSet rs = statement.executeQuery(queryString);
        if (rs.next()){
            String tableName = rs.getString("Tables_in_testforappli");
            if (name.equals(tableName)){
                return tableName;
            }
        }
        return null;
    }*/

    public String readEffectName(String query, int id) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getString("effect_name");
        }
        return null;
    }

    public int readEffectTier(String query, String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("effect_tier");
        }
        return 0;
    }

    public int readEffectNumber(String query, String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("effect_number");
        }
        return 0;
    }


    public ResultSet getPictureSrc(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        return statement.executeQuery();

    }

    public ArrayList<String> createFighterFromDB(String query, int i) throws SQLException {
        String name = null, characterClass = null, weapon = null;
        int level = 0, xp = 0, id = 0;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, i);
        ArrayList<String> fighterData = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            id = rs.getInt("Character_ID");
            name = rs.getString("Character_name");
            characterClass = rs.getString("Character_class");
            level = rs.getInt("Character_level");
            xp = rs.getInt("Character_xp");
            weapon = rs.getString("Character_weapon");
        }
        fighterData.add(name);
        fighterData.add(characterClass);
        fighterData.add(String.valueOf(level));
        fighterData.add(String.valueOf(xp));
        fighterData.add(weapon);
        fighterData.add(String.valueOf(id));
        return fighterData;
    }

    public void dropTableCharacter(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void createTableCharacter(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void dropTableTournamentResults(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }

    public void createTableTournamentResults(String query) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
    }


    public ArrayList<String> readWeaponByName(String query, String weaponName) throws SQLException {
        ArrayList<String> dataFromDB = new ArrayList<>();
        String name = "", rarity = "", normalHits = "", specialHits = "", chanceOfSuperAbility = "";

        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, weaponName);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            name = rs.getString("Weapon_name");
            rarity = rs.getString("Weapon_rarity");
            normalHits = rs.getString("Weapon_normalHits");
            specialHits = rs.getString("Weapon_specialHits");
            chanceOfSuperAbility = rs.getString("weapon_chanceForSuperAbility");
        }
        dataFromDB.add(name);
        dataFromDB.add(rarity);
        dataFromDB.add(normalHits);
        dataFromDB.add(specialHits);
        dataFromDB.add(chanceOfSuperAbility);
        return dataFromDB;
    }

    public String readWeaponInformationByID(String query, int id, String rowName) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String dataFromDB = resultSet.getString(rowName);
                return dataFromDB;
            }

        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        return null;
    }

    public ArrayList<String> readCharacterClassByName(String query, String charachterClass) throws SQLException {
        ArrayList<String> dataFromDB = new ArrayList<>();
        String name = "", hp = "", ap = "", lvl = "", xp = "", lvlReq = "", hitmes1 = "", hitmes2 = "", hitmes3 = "", specialAttack = "";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, charachterClass);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            name = rs.getString("character_name");
            hp = rs.getString("character_hp");
            ap = rs.getString("character_ap");
            lvl = rs.getString("character_lvl");
            xp = rs.getString("character_xp");
            lvlReq = rs.getString("character_lvlReq");
            hitmes1 = rs.getString("character_hitmes1");
            hitmes2 = rs.getString("character_hitmes2");
            hitmes3 = rs.getString("character_hitmes3");
            specialAttack = rs.getString("character_specialatt");
        }
        dataFromDB.add(name);
        dataFromDB.add(hp);
        dataFromDB.add(ap);
        dataFromDB.add(lvl);
        dataFromDB.add(xp);
        dataFromDB.add(lvlReq);
        dataFromDB.add(hitmes1);
        dataFromDB.add(hitmes2);
        dataFromDB.add(hitmes3);
        dataFromDB.add(specialAttack);

        return dataFromDB;
    }

    public String readCharacterClassNameByID(String query, int index) throws SQLException {
        String fClass = "";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, index);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            fClass = rs.getString("character_name");
        }
        return fClass;
    }

    /*
        public void insertWinner(String weapon) throws SQLException {
            PreparedStatement statement = con.prepareStatement(rep.getInsertWinner());
            statement.setString(1,weapon);
            statement.executeUpdate();
        }*/
    public int getClassHp(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("character_hp");
        }
        return 0;
    }

    public int getClassAp(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("character_ap");
        }
        return 0;
    }

    public int getClassLvl(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("character_lvl");
        }
        return 0;
    }

    public int getClassXp(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("character_xp");
        }
        return 0;
    }

    public int getClassLvlReq(String query, String fClass) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, fClass);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("character_lvlReq");
        }
        return 0;
    }

    public void updateFighter(String query, int oldNameId, String newName, String newClass, String weapons) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, newName);
        statement.setString(2, newClass);
        statement.setString(3, weapons);
        statement.setInt(4, oldNameId);
        statement.executeUpdate();
    }

    public String getCharacterClass(String query, String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getString("Character_class");
        }
        return null;
    }


    public int getID(String query, String name) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("Character_ID");
        }
        return 0;
    }

    public ResultSet querySelect(String selectQuery) {
        try {
            PreparedStatement statement = con.prepareStatement(selectQuery);
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet querySelect(String selectQuery, int id) {
        try {
            PreparedStatement statement = con.prepareStatement(selectQuery);
            statement.setInt(1, id);
            return statement.executeQuery();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
        return null;
    }
    public ResultSet querySelect(String selectQuery, String name) {
        try {
            PreparedStatement statement = con.prepareStatement(selectQuery);
            statement.setString(1, name);
            return statement.executeQuery();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
        return null;
    }

    public void queryInsert(String query) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

/*    public ResultSet querySelect(String selectQuery) {
        try {
            Statement statement = con.createStatement();
            return statement.executeQuery(selectQuery);
        }
        catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
        return null;
    }*/
}
