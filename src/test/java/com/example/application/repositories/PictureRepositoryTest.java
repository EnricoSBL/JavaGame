package com.example.application.repositories;

import com.example.application.model.PictureModel;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PictureRepositoryTest {
    public static final String THE_OVERLORD = "The Overlord";
    // Keine Test ohne assert!
    public static final String EXPECTED_PICTURE_SRC = "images/The-Overlord.png";
    @Test
    void getPictureSrc() throws SQLException {
        PictureModel actualPictureSrc = PictureRepository.getInstance().getPictureModel(THE_OVERLORD, "test");
        assertEquals(EXPECTED_PICTURE_SRC, actualPictureSrc.getPictureSrc());
    }
}