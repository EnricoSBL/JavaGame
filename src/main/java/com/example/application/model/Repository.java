package com.example.application.model;

public class Repository {
    private String readCharactersById = "SELECT * FROM Characters WHERE Character_ID = ? ;";
    private String readCharactersByName = "SELECT * FROM Characters WHERE Character_name = ? ;";
    private String readAllCharacters = "SELECT * FROM Characters;";
    private String readCharacterbyNameWithClass = "SELECT * FROM Characters WHERE Character_name = ? AND Character_class = ? ";
    private String insertCharacters = "INSERT INTO Characters (Character_name, Character_class, Character_level, Character_xp, Character_weapon)" + " VALUES(?, ?, ?, ?, ?);";
    private String readName = "Select Character_name FROM Characters; ";
    private String readID = "SELECT Character_ID FROM Characters WHERE Character_name = ?;";
    private String dropTableCharacters = "DROP TABLE Characters;";
    private String dropTableTournament = "DROP TABLE tournamentResults;";
    private String createTableCharacter = "CREATE TABLE Characters (Character_ID int  auto_increment not null, Character_name varchar(50) not null, Character_class varchar(100) not null, Character_level int not null, Character_xp int not null, Character_weapon varchar(100) not null, PRIMARY KEY(Character_ID) );";
    private String createTableTournamentHistory = "CREATE Table tournamentResults (tournament_id int auto_increment not null, winner varchar(50) not null, primary key(tournament_id) );";
    private String getName = "SELECT Character_name FROM Characters WHERE Character_ID = ?;";
    private String getClass = "SELECT Character_class FROM Characters WHERE Character_name = ?;";
    private String deleteCharacter = "DELETE FROM Characters WHERE Character_ID = ?;";
    private String showTables = "SHOW TABLES;";
    private String getPictureSrc = "SELECT picture_src FROM pictureSrc WHERE picture_class = ?;";
    private String getClassHp = "SELECT character_hp FROM characterClass Where character_name = ?;";
    private String getClassAp = "SELECT character_ap FROM characterClass Where character_name = ?;";
    private String getClasslvl = "SELECT character_lvl FROM characterClass Where character_name = ?;";
    private String getClassxp = "SELECT character_xp FROM characterClass Where character_name = ?;";
    private String getClasslvlReq = "SELECT character_lvlReq FROM characterClass Where character_name = ?;";
    private String updateCharacter = "UPDATE characters " + "SET character_name = ?, character_class = ?, character_weapon = ? " + "WHERE character_id = ?;";
    private String insertWinner = "INSERT INTO tournamentResults (winner)" + "VALUES (?);";

    public String getReadCharactersById() { return readCharactersById; }
    public String getReadCharactersByName() { return readCharactersByName; }
    public String getInsertCharacters() { return  insertCharacters; }
    public String getReadCharacterbyNameWithClass() {
        return readCharacterbyNameWithClass;
    }
    public String getDropTableCharacters() { return dropTableCharacters; }
    public String getDropTableTournament() { return dropTableTournament; }
    public String getCreateTableCharacter() { return createTableCharacter; }
    public String getName(){ return getName; }
    public String getDeleteCharacter(){ return deleteCharacter; }
    public String getShowTables(){ return showTables; }
    public String getGetClass(){ return getClass; }
    public String getID() { return readID; }
    public String getReadAllCharacters(){ return readAllCharacters; }
    public String getReadName() {
        return readName;
    }
    public String getGetPictureSrc() { return getPictureSrc; }
    public String getGetClassHp() { return getClassHp; }
    public String getGetClassAp() { return getClassAp; }
    public String getGetClasslvl() { return getClasslvl; }
    public String getGetClassxp() { return getClassxp; }
    public String getGetClasslvlReq() { return getClasslvlReq; }
    public String getUpdateCharacter() { return updateCharacter; }
    public String getInsertWinner() { return insertWinner; }
    public String getCreateTableTournamentHistory() { return createTableTournamentHistory; }
}
