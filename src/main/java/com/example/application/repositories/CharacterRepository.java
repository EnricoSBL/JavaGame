package com.example.application.repositories;

import com.example.application.controller.CharacterLvlController;
import com.example.application.controller.DatabaseConnector;
import com.example.application.model.CharacterClassModel;
import com.example.application.model.CharacterModel;
import com.example.application.model.PictureModel;
import com.example.application.model.WeaponModel;
import org.springframework.boot.autoconfigure.web.ErrorProperties;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;

public class CharacterRepository {
    private static CharacterRepository instance;

    private final String readCharactersByName = "SELECT * FROM Characters WHERE Character_name = ? ;";
    private final String readCharactersById = "SELECT * FROM Characters WHERE Character_ID = ?;";
    private final String readAllCharacters = "SELECT * FROM Characters;";
    private final String readCharacterByNameWithClass = "SELECT * FROM Characters WHERE Character_name = ? AND Character_class = ? ";
    private final String insertCharacters = "INSERT INTO Characters (Character_name, Character_class, Character_level, Character_xp, Character_weapon)" + " VALUES(?, ?, ?, ?, ?);";

    private final String readName = "Select Character_name FROM Characters; ";
    private final String deleteCharacter = "DELETE FROM Characters WHERE Character_ID = ?;";

    public static CharacterRepository getInstance() {
        if (instance == null) {
            instance = new CharacterRepository();
        }
        return instance;
    }

    public void deleteCharacter(int id) throws SQLException {
        DatabaseConnector.getInstance("main").deleteCharacter(deleteCharacter, id);
    }

    public String readClassFromFighter(String name) throws SQLException {
        String readClass = "SELECT Character_class FROM Characters WHERE Character_name = ?;";
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).getCharacterClass(readClass, name);
    }

    public String readClass(String name) throws SQLException {
        String readClassFromFighter = "SELECT Character_class FROM Characters WHERE Character_name = ?;";
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).getCharacterClass(readClassFromFighter, name);
    }

    public CharacterModel findCharacterById(int id, String mode) throws SQLException {
        return convertAllResultsToModel(DatabaseConnector.getInstance(mode).querySelect(readCharactersById, id), mode)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void insertFighterIntoDB(String name, String fClass, int lvl, int xp, String weapon, String mode) throws SQLException {
        Objects.requireNonNull(DatabaseConnector.getInstance(mode)).insertFighterIntoDB(insertCharacters, name, fClass, lvl, xp, weapon);
    }

    public String getInsertCharacters() {
        return insertCharacters;
    }

    public void dropTableCharacter() throws SQLException {
        String dropTableCharacters = "DROP TABLE Characters;";
        Objects.requireNonNull(DatabaseConnector.getInstance("main")).dropTableCharacter(dropTableCharacters);
    }

    public void createTableCharacter() throws SQLException {
        String createTableCharacter = "CREATE TABLE Characters (Character_ID int  auto_increment not null, Character_name varchar(50) not null, Character_class varchar(100) not null, Character_level int not null, Character_xp int not null, Character_weapon varchar(100) not null, PRIMARY KEY(Character_ID) );";
        Objects.requireNonNull(DatabaseConnector.getInstance("main")).createTableCharacter(createTableCharacter);
    }

    public int readID(String name) throws SQLException {
        String readID = "SELECT Character_ID FROM Characters WHERE Character_name = ?;";
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).getID(readID, name);
    }

    public void updateFighter(int oldNameId, String newName, String newClass, String weapons) throws SQLException {
        String updateCharacter = "UPDATE characters " + "SET character_name = ?, character_class = ?, character_weapon = ? " + "WHERE character_id = ?;";
        Objects.requireNonNull(DatabaseConnector.getInstance("main")).updateFighter(updateCharacter, oldNameId, newName, newClass, weapons);
    }

    public String readCharacterName(int i) throws SQLException {
        String readNameById = "SELECT Character_name FROM Characters WHERE Character_ID = ?;";
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).getCharacterName(readNameById, i);
    }

    public Collection<CharacterModel> findAll(String mode) {
        ResultSet resultSet = DatabaseConnector.getInstance(mode).querySelect(readAllCharacters);
        try {
            return convertAllResultsToModel(resultSet, mode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<CharacterModel> convertAllResultsToModel(ResultSet resultSet, String mode) throws SQLException {
        ArrayList<CharacterModel> characterModels = new ArrayList<>();
        while (!resultSet.isLast()) {
            if (resultSet.next()) {
                characterModels.add(convertResultSetToModel(resultSet, mode));
            }
        }

        return characterModels;
    }

    private CharacterModel convertResultSetToModel(ResultSet resultSet, String mode) throws SQLException {
            try {
                int id = resultSet.getInt("Character_ID");
                String name = resultSet.getString("Character_name");
                String characterClass = resultSet.getString("Character_class");
                int level = resultSet.getInt("Character_level");
                int xp = resultSet.getInt("Character_xp");
                String weapon = resultSet.getString("Character_weapon");
                CharacterClassModel characterClassModel = CharacterClassRepository.getInstance().readCharacterByName(characterClass, mode);
                WeaponModel weaponModel = WeaponRepository.getInstance().readWeaponByName(weapon);
                PictureModel pictureModel = PictureRepository.getInstance().getPictureModel(characterClass, mode);
                return new CharacterModel(id, name, characterClassModel, CharacterLvlController.getInstance().getLevelModel(), level, xp, weaponModel, pictureModel);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getAnonymousLogger().severe(e.getMessage());
            }
        return null;

    }
}
