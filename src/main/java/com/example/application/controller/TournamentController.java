package com.example.application.controller;

import com.example.application.model.TournamentModel;
import com.example.application.repositories.TournamentRepository;
import com.example.application.repositories.TournamentResultRepository;
import com.example.application.views.dtos.CharacterDto;
import com.example.application.views.dtos.TournamentDto;
import org.springframework.beans.BeanUtils;

import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class TournamentController {
    private static TournamentController instance;

    public static TournamentController getInstance() {
        if (instance == null){
            instance = new TournamentController();
        }
        return instance;
    }

    private TournamentController(){}


    public void createTournament() throws SQLException {
        TournamentRepository.getInstance().createTournament();
    }

    public void dropTableTournamentToCharacter()  {
        try {
            TournamentRepository.getInstance().dropTableTournamentToCharacter();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe((Supplier<String>) e);
        }
    }

    public void dropTableTournament() throws SQLException {
        TournamentRepository.getInstance().dropTableTournament();
    }

    public void createTableTournament() throws SQLException {
        TournamentRepository.getInstance().createTableTournament();
    }

    public void createTableTournamentToCharacter() throws SQLException {
        TournamentRepository.getInstance().createTableTournamentToCharacter();
    }

    private TournamentDto getTournamentDto(TournamentModel tournamentModel){
        TournamentDto tournamentDto = new TournamentDto();
        BeanUtils.copyProperties(tournamentModel, tournamentDto, TournamentDto.class);
        return tournamentDto;
    }
}
