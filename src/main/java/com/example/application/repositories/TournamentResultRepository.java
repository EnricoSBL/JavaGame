package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;

public class TournamentResultRepository {

    private static TournamentResultRepository instance;

    public static TournamentResultRepository getInstance() {
        if (instance == null) {
            instance = new TournamentResultRepository();
        }
        return instance;
    }

    private final String readAllOfTournamentResults = "SELECT * FROM tournamentResults;";
    private final String readTournamentId = "";
    private final String readTournamentWinner = "SELECT winner FROM tournamentResults ";

    private final String insertTournamentWinner = "INSERT INTO tournamentResults (winner) VALUES (?);";


    public List readAllWinners() throws SQLException {
        return DatabaseConnector.getInstance("main").readAllWinner(readAllOfTournamentResults);
    }
    public void insertWinner(String name) throws SQLException {
        DatabaseConnector.getInstance("main").insertWinner(insertTournamentWinner, name);
    }

    public List<String> readTournamentWinner() throws SQLException {
        return DatabaseConnector.getInstance("main").readWinner(readTournamentWinner);
    }

}
