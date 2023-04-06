package com.example.application.repositories;

import com.example.application.controller.DatabaseConnector;

import java.sql.SQLException;
import java.util.Objects;

public class EffectRepository {

    private static EffectRepository instance;

    public static EffectRepository getInstance(){
        if (instance == null){
            instance = new EffectRepository();
        }
        return instance;
    }

    public String readEffectId = "SELECT effect_id FROM effects WHERE effect_name = ?;";
    public String readEffectName = "SELECT effect_name FROM effects WHERE effect_id = ?;";
    public String readEffectTier = "SELECT effect_tier FROM effects WHERE effect_name = ?;";
    public String readEffectNumber = "SELECT effect_number FROM effects WHERE effect_name = ?;";

    public String getReadEffectName(int id) throws SQLException {
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).readEffectName(readEffectName, id);
    }
    public int getReadEffectTier(String name) throws SQLException {
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).readEffectTier(readEffectTier, name);
    }
    public int getReadEffectNumber(String name) throws SQLException {
        return Objects.requireNonNull(DatabaseConnector.getInstance("main")).readEffectNumber(readEffectNumber, name);
    }
}
