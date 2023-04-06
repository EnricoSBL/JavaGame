package com.example.application.views.Create;

import com.example.application.controller.CharacterController;
import com.example.application.controller.ViewController;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@PageTitle("Create Fighter")
@Route(value = "createview", layout = MainLayout.class)
@RouteAlias(value = "createview", layout = MainLayout.class)
public class CreateFighterView extends VerticalLayout {

       private TextField nameTextField;
       private ComboBox classComboBox;
       private Button createButton;
       private ArrayList<String> ItemsForComboBox = CharacterController.getInstance().getCharacterClassNamesForComboBox();

       Notification note = new Notification();


    public CreateFighterView() throws SQLException {

        nameTextField = new TextField("Character name");
        nameTextField.addClassNames(LumoUtility.Margin.SMALL);
        nameTextField.setClearButtonVisible(true);
        //nameTextField.getStyle().set("color","white");


        classComboBox = new ComboBox<>("Character class");
        classComboBox.setItems(ItemsForComboBox);
        classComboBox.setValue("Random Class");
        //classComboBox.getStyle().set("color","white");

        createButton = new Button("Create");
        createButton.addClickListener(e -> {
            if (Objects.equals(nameTextField.getValue(), "")){
                Notification.show("Please fill our all boxes, before pressing create.");
            }
            if (classComboBox == null || Objects.equals(classComboBox.getValue(), "")) {
                Notification.show("Please fill all boxes, before pressing create.");

            }
            else {
                boolean isCreated = false;
                try {
                    isCreated = ViewController.getInstance().insertFighterIntoDB(nameTextField.getValue(), classComboBox.getValue().toString(), "main");
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (isCreated) {
                    Notification.show("Character " + nameTextField.getValue() + " is created.");
                    nameTextField.setValue("");
                    classComboBox.setValue("Random Class");
                    ViewController.getInstance().higherCounnterForFighter();
                } else {
                    Notification.show("Oops, something went wrong.");
                }
            }});
        //createButton.getStyle().set("color","white");

        HorizontalLayout horizontalLayoutAbove = new HorizontalLayout(nameTextField, classComboBox);
        HorizontalLayout horizontalLayoutBelow = new HorizontalLayout(createButton);

        add(horizontalLayoutAbove);
        add(horizontalLayoutBelow);


        this.setHeight("1300px");
        this.setWidth("2304px");

    }

}
