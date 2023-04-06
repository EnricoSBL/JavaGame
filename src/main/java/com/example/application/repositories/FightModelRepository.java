package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;

import java.sql.SQLException;

public class FightModelRepository {

    public static FightModelRepository instance;

    public static FightModelRepository getInstance(){
        if (instance == null){
            instance = new FightModelRepository();
        }
        return instance;
    }

    private String createTournamentResults = "CREATE Table tournamentResults (tournament_id int auto_increment not null, winner varchar(50) not null, primary key(tournament_id));";
    private String dropTournamentResults = "DROP TABLE tournamentResults;";



    public boolean createTableTournamentResult() throws SQLException {
        DatabaseConnector.getInstance("main").createTableTournamentResults(createTournamentResults);
        return true;
    }

    public boolean dropTableTournamentResults() throws SQLException {
       DatabaseConnector.getInstance("main").dropTableTournamentResults(dropTournamentResults);
       return true;
    }

}
