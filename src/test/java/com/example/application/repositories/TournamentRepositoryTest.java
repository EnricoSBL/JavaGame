package com.example.application.repositories;

import com.example.application.controller.ViewController;
import com.example.application.model.CharacterModel;
import com.example.application.model.TournamentModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentRepositoryTest {

    public static final String TEST_FOR_TOURNAMENT = "testForTournament";
    private static final int ATTACKER_ID = 1;
    private static final int DEFENDER_ID = 2;
    private static final int TOURNAMENT_ID = 1;

    static Collection<CharacterModel> listOfCharacterModels;
    @BeforeAll
    public static void setUp(){
        try {
            TournamentRepository.getInstance().dropTableTournamentToCharacter();
            TournamentRepository.getInstance().dropTableTournament();
            CharacterRepository.getInstance().dropTableCharacter();

            CharacterRepository.getInstance().createTableCharacter();
            TournamentRepository.getInstance().createTableTournament();
            TournamentRepository.getInstance().createTableTournamentToCharacter();

            ViewController.getInstance().insertFighterIntoDB("Enrico", "The Overlord", "test");
            ViewController.getInstance().insertFighterIntoDB("Carlos","The Ultimate Warrior", "test");

            listOfCharacterModels = (CharacterRepository.getInstance().findAll("test"));
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    @Test
    public void createTournament() throws SQLException, ClassNotFoundException {



        TournamentRepository.getInstance().createTournament("test", TEST_FOR_TOURNAMENT, listOfCharacterModels );

        TournamentModel tournamentModel = TournamentRepository.getInstance().readTournamentByName("test",TEST_FOR_TOURNAMENT);

        assertEquals(TOURNAMENT_ID, tournamentModel.getId());
        assertEquals(ATTACKER_ID, tournamentModel.getListOfCharacterModels().get(0).getId());
        assertEquals(DEFENDER_ID, tournamentModel.getListOfCharacterModels().get(1).getId());
    }

    @Test
    public void testArbitraryAmountOfCharacterIds() {
        String actualInsertQuery = TournamentRepository.getInstance().getValuesByList(1, listOfCharacterModels);
        String EXPECTED_INSERT_QUERY = "INSERT INTO tournamentToCharacter(tournament_id, character_id) VALUES (1,1),(1,2);";
        assertEquals(actualInsertQuery, EXPECTED_INSERT_QUERY);
    }

}