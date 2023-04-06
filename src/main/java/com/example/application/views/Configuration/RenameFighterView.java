package com.example.application.views.Configuration;

import com.example.application.controller.CharacterController;
import com.example.application.views.MainLayout;
import com.example.application.views.dtos.CharacterDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

@PageTitle("Configuration Fighter")
@Route(value = "renameview", layout = MainLayout.class)
public class RenameFighterView extends VerticalLayout {

    private ComboBox<String> fClassComboBox;
    ComboBox<CharacterDto> characterDtoComboBox;
    private Button selectButton, changeButton, deleteButton;
    private String name, fClass, newName, newFClass;
    private TextField nameTextField;
    private TextArea fighterInformationTextArea;

    private ConfirmDialog dialog;
    private boolean toDelete;
    public RenameFighterView() throws SQLException {
        setSpacing(false);
        characterDtoComboBox = new ComboBox<>();
        reInitials();


        selectButton = new Button("Select");
        selectButton.addClickListener(e -> {
            int id = characterDtoComboBox.getValue().getId();
            CharacterDto characterDtoById = CharacterController.getInstance().getCharacterDtoById(id);
            this.updateView(characterDtoById);
        });
        changeButton = new Button("Change");
        changeButton.addClickListener(e -> { changeView(characterDtoComboBox.getValue().getId()); });

        nameTextField = new TextField("New Character name");

        fClassComboBox = new ComboBox<>("New Character class");
        fClassComboBox.setItems(CharacterController.getInstance().getCharacterClassNamesForComboBox());
        fClassComboBox.setClearButtonVisible(true);

        fighterInformationTextArea = new TextArea("Old Character information");

        deleteButton = new Button("Delete");
        deleteButton.addClickListener(e -> dialog.open());

        HorizontalLayout mainLayout = new HorizontalLayout(characterDtoComboBox, selectButton);

        add(mainLayout);
    }


    private void updateView(CharacterDto characterDto){
        nameTextField.setVisible(true);
        fClassComboBox.setVisible(true);
        fighterInformationTextArea.setVisible(true);
        changeButton.setVisible(true);
        deleteButton.setVisible(true);

        name = characterDto.getName();
        fClass = characterDto.getCharacterClassDto().getClassName();

        boolean toDelete;

        dialog = new ConfirmDialog();
        dialog.setHeader("Delete Character");
        dialog.setText("Are you sure you want to delete Character " + characterDto.getName() + "? This action cannot be undone.");

        dialog.setCancelable(true);
        dialog.addCancelListener(event -> dialog.close());

        dialog.setConfirmText("Yes");
        dialog.addConfirmListener(event -> {
            try {
                toDelete(characterDto);
            } catch (SQLException e) {
                Logger.getAnonymousLogger().severe(e.getMessage());
            }
        });


        HorizontalLayout renamingLayout = new HorizontalLayout(nameTextField, fClassComboBox, changeButton, deleteButton);
        changeButton.getStyle().set("margin-top", "35px");
        deleteButton.getStyle().set("margin-top", "35px");
        add(fighterInformationTextArea, renamingLayout);

        fighterInformationTextArea.setValue("Name: " + name + "     Class: " + fClass);
        fighterInformationTextArea.setEnabled(false);
        fighterInformationTextArea.getStyle().set("width", "800px");
        fighterInformationTextArea.getStyle().set("height", "90px");
        fighterInformationTextArea.getStyle().set("font-size", "30px");
    }

    private void changeView(int id){
        try {
            CharacterController.getInstance().updateFighter(id, nameTextField.getValue(), fClassComboBox.getValue());
        } catch (SQLException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        reInitials();
        basicStateAfterFunciton();
    }

    private void reInitials(){
        Collection<CharacterDto> allCharacterDtos = CharacterController.getInstance().getAllCharacters("main");
        characterDtoComboBox.setItems(allCharacterDtos);
    }


    private void toDelete(CharacterDto characterDto) throws SQLException {
        CharacterController.getInstance().deleteFighter(characterDto.getId());
        basicStateAfterFunciton();
        reInitials();
    }

    private void basicStateAfterFunciton() {
        characterDtoComboBox.clear();
        nameTextField.setValue("");
        fClassComboBox.setValue("");
        fighterInformationTextArea.setValue("");
        nameTextField.setVisible(false);
        fClassComboBox.setVisible(false);
        fighterInformationTextArea.setVisible(false);
        changeButton.setVisible(false);
        deleteButton.setVisible(false);
    }
}
