package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;
import com.example.application.model.CharacterModel;
import com.example.application.model.TournamentModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TournamentRepository {

    private static TournamentRepository instance;

    public static TournamentRepository getInstance() {
        if (instance == null) {
            instance = new TournamentRepository();
        }
        return instance;
    }

    private final String createTournament = "INSERT INTO tournament(tournament_name) VALUES(?);";
    private final String createTableTournamentToCharacter = "CREATE TABLE tournamentToCharacter (tournament_id int not null, character_id int not null, foreign key(tournament_id) references tournament(tournament_id), foreign key(character_id) REFERENCES Characters(Character_ID));";
    private final String createTableTournament = "CREATE TABLE tournament(tournament_id int auto_increment not null, tournament_name varchar(50), PRIMARY KEY(tournament_id));";

    private final String dropTournamentToCharacter = "DROP TABLE tournamentToCharacter;";
    private final String dropTournament = "DROP TABLE tournament;";

    private final String readTournamentIdByName = "SELECT tournament_id FROM tournament WHERE tournament_name = ?;";
    private final String readTableTournament = "Select * from tournament;";

    private final String insertIntoTournamentToCharacter = "INSERT INTO tournamentToCharacter(tournament_id, character_id) VALUES ( ?, ?);";
    private final String insertIntoTournamentToCharacterHEAD = "INSERT INTO tournamentToCharacter(tournament_id, character_id) VALUES ";

    private final String readTournamentByName = "SELECT * From tournament WHERE tournament_name = ?;";

    private final String readCharacterIdByTournamentId = "SELECT character_id FROM tournamentToCharacter WHERE tournament_id = ?;";

    private final String readCharacterID = "SELECT character_id FROM tournamentToCharacter;";

    private final String addCharacterToTournament = "";


    public List<Integer> readTableTournament(String mode) {
        return DatabaseConnector.getInstance(mode).readTableTournament(readTableTournament);
    }

    public void createTournament() throws SQLException {
        DatabaseConnector.getInstance("main").createTournament(createTournament, "");
    }

    public void createTournament(String mode, String tournamentName, Collection<CharacterModel> characterModels) {
        DatabaseConnector.getInstance(mode).createTournament(createTournament, tournamentName);
        int tournamentID = DatabaseConnector.getInstance(mode).readTournamentIdByName(readTournamentIdByName, tournamentName);
        String query = getValuesByList(tournamentID, characterModels);
        DatabaseConnector.getInstance(mode).queryInsert(query);
        for (CharacterModel characterModel : characterModels) {
            DatabaseConnector.getInstance(mode).insertIntoTournamentToCharacter(insertIntoTournamentToCharacter, tournamentID, characterModel.getId());
        }
    }

    public void createTableTournament() throws SQLException {
        DatabaseConnector.getInstance("main").createTableTournament(createTableTournament);
    }

    public void createTableTournamentToCharacter() throws SQLException {
        DatabaseConnector.getInstance("main").createTableTournamentToTournament(createTableTournamentToCharacter);
    }

    public void dropTableTournament() throws SQLException {
        DatabaseConnector.getInstance("main").dropTableTournament(dropTournament);
    }

    public void dropTableTournamentToCharacter() throws SQLException {
        DatabaseConnector.getInstance("main").dropTableTournamentToCharacter(dropTournamentToCharacter);
    }

    public int readTournamentIdByName(String mode, String name) {
        return DatabaseConnector.getInstance(mode).readTournamentIdByName(readTournamentIdByName, name);
    }

    private List<CharacterModel> readCharacterIdByTournamentId(String mode) {
        List<CharacterModel> collectionOfCharacterModels = new ArrayList<>();
        ResultSet resultSet = DatabaseConnector.getInstance(mode).querySelect(readCharacterID);
        try {
            while (!resultSet.isLast()) {
                if (resultSet.next()) {
                    CharacterModel characterModel = CharacterRepository.getInstance().findCharacterById(resultSet.getInt("character_id"), mode);
                    collectionOfCharacterModels.add(characterModel);
                }
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        return collectionOfCharacterModels;
    }

    private void addCharacterToTournament(String mode ,String tournamentName ,CharacterModel characterModel){
        TournamentModel tournamentModel = TournamentRepository.getInstance().readTournamentByName("test",tournamentName);
        DatabaseConnector.getInstance(mode).insertIntoTournamentToCharacter(insertIntoTournamentToCharacter, tournamentModel.getId(), characterModel.getId());
    }
    private void removeCharacterToTournament(String tournamentName ,CharacterModel characterModel){
        
    }

    private void deleteTournament(String tournamentName){

    }

    public TournamentModel readTournamentByName(String mode, String name) {
        ResultSet resultSet = DatabaseConnector.getInstance(mode).querySelect(readTournamentByName, name);
        TournamentModel tournamentModel = new TournamentModel();
        try {
            if (resultSet.next()) {
                tournamentModel.setId(resultSet.getInt("tournament_id"));
                tournamentModel.setName(resultSet.getString("tournament_name"));
                tournamentModel.setListOfCharacterModels(readCharacterIdByTournamentId(mode));
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
        return tournamentModel;
    }

    public String getValuesByList(int tournamentId, Collection<CharacterModel> characterModels) {
        String joinedIdsInBracets =
        characterModels.stream()
                .map(characterModel -> characterModel.getId())
                .map(id -> String.format("(%d,%d)", tournamentId, id))
                .collect(Collectors.joining(","));
        return insertIntoTournamentToCharacterHEAD + joinedIdsInBracets + ";";
    }
}
