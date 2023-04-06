package com.example.application.views.Help;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Starting tips")
@Route(value = "mainview", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelpView extends VerticalLayout {

    private HorizontalLayout startLayout, createDescriptionLayout, configureDescriptionLayout, fighterDescriptionLayout, outputDescriptionLayout;
    public HelpView() {

        Text startText = new Text("Welcome to my Fight simulator. Here you can create Fighters and fight them against the other until only one remains.");

        Text createDescriptionText = new Text("In the section 'Create Fighter' you can customise your fighter with a name and class");
        Text configurationDescriptionText = new Text("In the section 'Rename Fighter' you can rename or give a new class for the fighters you created.");
        Text fighterDescriptionText = new Text("In the section 'Fighter View' you can see a description of your fighters.");
        Text outputDescriptionText = new Text("In the section 'Output' there you can start and see the outcome of the battle.");

        startLayout = new HorizontalLayout(startText);
        startLayout.getStyle().set("font-size", "22px");

        createDescriptionLayout = new HorizontalLayout(createDescriptionText);
        createDescriptionLayout.getStyle().set("font-size", "18px");

        configureDescriptionLayout = new HorizontalLayout(configurationDescriptionText);
        configureDescriptionLayout.getStyle().set("font-size", "18px");

        fighterDescriptionLayout = new HorizontalLayout(fighterDescriptionText);
        fighterDescriptionLayout.getStyle().set("font-size", "18px");

        outputDescriptionLayout = new HorizontalLayout(outputDescriptionText);
        outputDescriptionLayout.getStyle().set("font-size", "18px");

        add(startLayout, createDescriptionLayout,  configureDescriptionLayout ,fighterDescriptionLayout, outputDescriptionLayout);

        this.getStyle().set("text-align", "center");
    }

}
