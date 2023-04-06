package com.example.application.views.Custom;

import com.example.application.controller.CharacterController;
import com.example.application.controller.TournamentController;
import com.example.application.controller.ViewController;
import com.example.application.views.MainLayout;
import com.example.application.views.dtos.CharacterDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

@PageTitle("Custom Battles")
@Route(value = "customBattle", layout = MainLayout.class)
public class TournamentView extends HorizontalLayout {
    ComboBox<CharacterDto> characterComboBox;
    Button addButton, battleButton, createButton;
    Grid<CharacterDto> gridForCharacters;
    List<CharacterDto> listOfCharacters = new ArrayList<>();
    Collection<CharacterDto> allCharacterDtos = new ArrayList<>();
    List<CharacterDto> listOfRemovedCharacters = new ArrayList<>();

    public TournamentView(){

        createButton = new Button("Create Tournament");
        createButton.addClickListener(e -> {
            try {
                TournamentController.getInstance().createTournament();
            } catch (SQLException ex) {
                Logger.getAnonymousLogger().severe((ex.getMessage()));
            }
        });

        characterComboBox = new ComboBox<>();
        reInitials();
        characterComboBox.setItems(allCharacterDtos);
        gridForCharacters = new Grid<>();

        addButton = new Button("+");
        addButton.addClickListener(e -> { clickEventAddButton(); });

        gridForCharacters.addColumn(CharacterDto::getId).setHeader("ID");
        gridForCharacters.addColumn(CharacterDto::getName).setHeader("Name");
        gridForCharacters.addColumn(CharacterDto::getCharacterClassDto).setHeader("Class");
        gridForCharacters.addColumn(new ComponentRenderer<>(Button::new, (button, CharacterDto) -> {
            button.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
            button.addClickListener(e -> {
                listOfCharacters.remove(CharacterDto);
                listOfRemovedCharacters.remove(CharacterDto);
                reInitials();
                gridForCharacters.setItems(listOfCharacters);
            });
            button.setIcon(new Icon(VaadinIcon.TRASH));
        })).setHeader("Manage");

        battleButton = new Button("Battle");
        battleButton.addClickListener(e -> { clickEventBattleButton(); });

        HorizontalLayout uppderLayout = new HorizontalLayout(characterComboBox, addButton);
        VerticalLayout wholeLayout = new VerticalLayout(uppderLayout, gridForCharacters, battleButton);
        add(wholeLayout);

        gridForCharacters.getStyle().set("font-size", "20px");

    }
    private void reInitials(){
        allCharacterDtos = CharacterController.getInstance().getAllCharacters("main");
        if (!listOfRemovedCharacters.isEmpty()) {
            for (CharacterDto characterDto : listOfRemovedCharacters) {
                allCharacterDtos.remove(characterDto);
            }
        }
        characterComboBox.setItems(allCharacterDtos);
    }

    private void clickEventAddButton(){
        if (characterComboBox.getValue() == null){ Notification.show("Please select a Character before clicking the button"); }
        else {
            listOfCharacters.add(characterComboBox.getValue());
            gridForCharacters.setItems(listOfCharacters);
            removeCharacters(characterComboBox.getValue());
            characterComboBox.clear();
            reInitials();
        }
    }

    private void clickEventGridDeletion(){

    }

    private void clickEventBattleButton(){
        for (CharacterDto characterDto : listOfRemovedCharacters) {
            try { ViewController.getInstance().findCharacterByID(characterDto.getId()); } catch (SQLException ex) { Logger.getAnonymousLogger().severe((Supplier<String>) ex); }
        }
        try {
            ViewController.getInstance().startBattle();
        } catch (SQLException | InterruptedException ex) {
            Logger.getAnonymousLogger().severe((Supplier<String>) ex);
        }
    }
    private void removeCharacters(CharacterDto characterDto){
        listOfRemovedCharacters.add(characterDto);
    }

    private void useHTMLCodes(){
        characterComboBox.getStyle().set("margin-left", "50px");
    }
}
