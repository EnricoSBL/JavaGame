package com.example.application.views.OutPut;

import com.example.application.controller.CharacterController;
import com.example.application.controller.ViewController;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;

@PageTitle("Output")
@Route(value = "outputview", layout = MainLayout.class)
public class OutputView extends HorizontalLayout {
    private TextArea outputTextArea;
    private Button battleButton, clearLosserButton, clearAllButton;
    private ConfirmDialog dialog;
    public OutputView() {

        outputTextArea = new TextArea();
        outputTextArea.setWidth("1000px");
        outputTextArea.setHeight("900px");
        outputTextArea.getStyle().set("margin-left", "350px");
        outputTextArea.getStyle().set("margin-up", "50px");
        outputTextArea.getStyle().set("webkit-user-select", "none");
        outputTextArea.getStyle().set("moz-user-select", "none");
        outputTextArea.getStyle().set("ms-user-select", "none");
        outputTextArea.getStyle().set("user-select", "none");
        CharacterController.getInstance().setOutputView(this);

        clearLosserButton = new Button();

        clearAllButton = new Button();

        outputTextArea.addClassNames("flex", "gap-xs", "h-m", "items-center","px-s","text-body");
        setMargin(true);

        battleButton = new Button("Start");
        battleButton.addClickListener(e -> {
            outputTextArea.setValue("");
            try { ViewController.getInstance().findCharacter(); }
            catch (SQLException ex) { throw new RuntimeException(ex); }

            try { ViewController.getInstance().startBattle(); }
            catch (SQLException | InterruptedException ex) { throw new RuntimeException(ex); }
        });
        add(outputTextArea, battleButton);
    }
    public void addTextToTextArea(String massege){ outputTextArea.setValue(outputTextArea.getValue() + "\n" + massege); }
}
