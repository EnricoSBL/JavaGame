package com.example.application.controller;

import com.example.application.views.dtos.CharacterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CharacterControllerTest {


    static final int ID_FOR_TEST_CHARACTER = 1;
    static final CharacterDto EXPECTED_CHARACHTER_DTO_FOR_TEST = new CharacterDto();

    @BeforeAll
    public static void beforeAll() {
        EXPECTED_CHARACHTER_DTO_FOR_TEST.setId(ID_FOR_TEST_CHARACTER);
        EXPECTED_CHARACHTER_DTO_FOR_TEST.setName("Enrico");
    }

    @Test
    void testGetCharacterDtoById() {
        CharacterDto characterDtoById = CharacterController.getInstance().getCharacterDtoById(EXPECTED_CHARACHTER_DTO_FOR_TEST.getId(), "test");
        assertEquals(EXPECTED_CHARACHTER_DTO_FOR_TEST, characterDtoById);
    }

    @Test
    void testGetAllCharacters() {
        Collection<CharacterDto> allCharacters = CharacterController.getInstance().getAllCharacters("test");
        assertFalse(allCharacters.isEmpty());
    }

}