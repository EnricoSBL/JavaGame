import com.example.application.controller.DatabaseConnector;
import com.example.application.model.CharacterModel;
import com.example.application.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterTest {
    private DatabaseConnector databaseConnector = DatabaseConnector.getInstance("Test");

    @Test
    public void TestCharacter() throws SQLException, ClassNotFoundException {
        databaseConnector.insertFighterIntoDB(CharacterRepository.getInstance().getInsertCharacters(), "Enrico","The Overlord", 1, 500, "Staff of Ainz Oawl Gown");
        CharacterModel testModel = CharacterRepository.getInstance().findCharacterById(1, "test");
        assertNotNull(testModel);
        Assertions.assertEquals("Enrico", testModel.getName());
        Assertions.assertEquals("The Overlord", testModel.getCharacterClassName());
        Assertions.assertEquals(1, testModel.getLevel());
        Assertions.assertEquals(500, testModel.getExperiencePoints());
        Assertions.assertEquals("Staff of Ainz Oawl Gown", testModel.getWeaponName());
    }
}
