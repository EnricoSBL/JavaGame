package com.example.application.controller;


import com.example.application.repositories.EffectRepository;

import java.sql.SQLException;

public class EffectController {

    private static EffectController instance;

    public static EffectController getInstance(){
        if (instance == null){
            instance = new EffectController();
        }
        return instance;
    }

    public int readEffectNumber(String name) throws SQLException {
        return EffectRepository.getInstance().getReadEffectNumber(name);
    }
}
