package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;
import com.example.application.model.PictureModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class PictureRepository {

    private static PictureRepository instance;

    public static PictureRepository getInstance() {
        if (instance == null) {
            instance = new PictureRepository();
        }
        return instance;
    }

    private String pictureSrc = "SELECT * FROM pictureSrc WHERE picture_class = ?;";

    public PictureModel getPictureModel(String fClass, String mode) throws SQLException {
       return convertAllResultsToModel(DatabaseConnector.getInstance(mode).getPictureSrc(pictureSrc, fClass), mode)
               .stream()
               .findFirst()
               .orElseThrow();
    }

    private Collection<PictureModel> convertAllResultsToModel(ResultSet resultSet, String mode) throws SQLException {
        ArrayList<PictureModel> pictureModels = new ArrayList<>();
        while (resultSet.next()) {
            pictureModels.add(convertResultSetToModel(resultSet, mode));
        }
        return pictureModels;
    }

    private PictureModel convertResultSetToModel(ResultSet resultSet, String mode) {
        try {

            int id = resultSet.getInt("picture_id");
            String pictureClass = resultSet.getString("picture_class");
            String pictureSrc = resultSet.getString("picture_src");
            return new PictureModel(id, pictureClass, pictureSrc);

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
        return null;

    }
}
