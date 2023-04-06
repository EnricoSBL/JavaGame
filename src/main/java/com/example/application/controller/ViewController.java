package com.example.application.controller;

import com.example.application.model.CharacterModel;
import com.example.application.repositories.CharacterClassRepository;
import com.example.application.repositories.CharacterRepository;
import com.example.application.model.WeaponModel;
import com.example.application.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Objects;
@Component
public class ViewController {
@Autowired
    //private JdbcTemplate jdbcTemplate;
    private static ViewController instance;
        public int counterOfFighters;

    public static ViewController getInstance(){
        if (instance == null){
            instance = new ViewController();
        }
        return instance;
    }
    private Tournament16Controller f = Tournament16Controller.getInstance();
    public void findCharacter() throws SQLException {
        int maxFighters = counterOfFighters;
        int i = 1;
        while (i <= maxFighters){
            CharacterModel fighter = CharacterController.getInstance().findCharacter(i);
            Tournament16Controller.getInstance().addFighters(fighter);
            i++;
        }
    }

    public void findCharacterByID(int id) throws SQLException {
        CharacterModel fighter = CharacterController.getInstance().findCharacter(id);
        Tournament16Controller.getInstance().addFighters(fighter);
    }

    public boolean insertFighterIntoDB(String name, String fClass, String mode) throws SQLException, ClassNotFoundException {

        if (Objects.equals(fClass, "Random Class")){
            fClass = CharacterClassRepository.getInstance().getRandomCharacterClass().getClassName();
        }
        WeaponModel weaponModel = WeaponRepository.getInstance().setWeapon(fClass);
        String weapon = weaponModel.getName();
        CharacterRepository.getInstance().insertFighterIntoDB(name, fClass,1,0,weapon, mode );
        return true;
    }

    public void higherCounnterForFighter(){
        counterOfFighters++;
    }
    public int getCounterOfFighters(){
        return counterOfFighters;
    }

    public void startBattle() throws SQLException, InterruptedException {
        f.fightGame();
    }
}
