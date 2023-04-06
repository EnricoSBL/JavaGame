package com.example.application.views.CharacterView;

import com.example.application.controller.CharacterController;
import com.example.application.views.MainLayout;
import com.example.application.views.dtos.CharacterClassDto;
import com.example.application.views.dtos.CharacterDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.sql.SQLException;
import java.util.Collection;

@PageTitle("Fighter View")
@Route(value = "fighterview", layout = MainLayout.class)
@RouteAlias(value = "fighterview", layout = MainLayout.class)
public class FighterView extends VerticalLayout {

    ComboBox<String> fighterComboBox;
    ComboBox<CharacterDto> characterDtoComboBox;
    Image image;
    Label fighterName;
    TextArea attributesTextArea, skillTextArea;
    ProgressBar progressBar;
    Button selectButton, selectAllButton;

    Grid<CharacterDto> grid;


    VerticalLayout attributeLayouts;
    HorizontalLayout attributeLayout, progressLayout, skillLayout;
    int j;
    public FighterView() throws SQLException {

        fighterComboBox = new ComboBox<>();
        characterDtoComboBox = new ComboBox<>();
        fighterName = new Label();
        image = new Image();
        attributesTextArea = new TextArea();
        setHTMLCodes();

        Collection<CharacterDto> allCharacterDtos = CharacterController.getInstance().getAllCharacters("main");
        characterDtoComboBox.setItems(allCharacterDtos);

        selectButton = new Button("Select");
        selectButton.addClickListener(e -> {
            int id = characterDtoComboBox.getValue().getId();
            CharacterDto characterDtoById = CharacterController.getInstance().getCharacterDtoById(id);
            this.updateView(characterDtoById);
        });

        selectAllButton = new Button("Select all");
        selectAllButton.addClickListener(e ->{
            showAllCharacters(allCharacterDtos);
        });


        HorizontalLayout selectionLayout = new HorizontalLayout(characterDtoComboBox, selectButton, selectAllButton);

        add(selectionLayout);
        this.setSpacing(false);
    }

    private void updateView(CharacterDto characterDtoById) {
        CharacterClassDto characterClassDto = characterDtoById.getCharacterClassDto();
        int hp = characterClassDto.getHp();
        int ap = characterClassDto.getAp();//CharacterClassRepository.getInstance().readApFromDb(fClass);
        int level = characterDtoById.getLevel(); //CharacterClassRepository.getInstance().readLvlFromDb(fClass);
        int xp = characterDtoById.getExperiencePoints(); //CharacterClassRepository.getInstance().readXpFromDb(fClass);
        int lvlReq = characterDtoById.getLevelRequirement();//CharacterClassRepository.getInstance().readLvlReqFromDb(fClass);
        String imageSrc = characterDtoById.getPictureDto().getPictureSrc();
        //imageSrc = PictureRepository.getInstance().getPictureSrc(fClass);
        image.setSrc(imageSrc);
        //    image.
        String name = characterDtoById.getName();
        fighterName.setText(characterDtoById.getName());
        attributesTextArea.setValue("Class: " + characterClassDto + "\n" +
                "Hp: " + hp + "        " +
                "Ap: " + ap + "\n" +
                "Level: " + level + "        " +
                "Xp: " + xp + "\n" +
                "Level Req: " + lvlReq + "\n"
        );
        progressBar.setMax(lvlReq);
        progressBar.setValue(xp);


        attributeLayouts = new VerticalLayout(fighterName, attributesTextArea);
        attributeLayouts.setSpacing(false);
        attributeLayouts.setMargin(false);
        attributeLayouts.setPadding(false);

        attributeLayout = new HorizontalLayout(image, attributeLayouts);
        attributeLayout.setSpacing(false);
        attributeLayout.setMargin(false);
        attributeLayout.setPadding(false);

        progressLayout = new HorizontalLayout(progressBar);
        progressLayout.setSpacing(false);
        progressLayout.setMargin(false);
        progressLayout.setPadding(false);

        skillLayout = new HorizontalLayout(skillTextArea);
        skillLayout.setSpacing(false);
        skillLayout.setMargin(false);
        skillLayout.setPadding(false);

        add(attributeLayout, progressLayout, skillLayout);

        setVisibleLayouts();
    }

    private void showAllCharacters(Collection characterDtosById){
        grid = new Grid<>(CharacterDto.class, false);
        grid.addColumn(CharacterDto::getName).setHeader("Name");
        grid.addColumn(CharacterDto::getCharacterClassDto).setHeader("Class");
        grid.addColumn(CharacterDto::getHealthPoints).setHeader("Hp");
        grid.addColumn(CharacterDto::getAttackPoints).setHeader("Ap");
        grid.addColumn(CharacterDto::getLevel).setHeader("Lvl");
        grid.addColumn(CharacterDto::getExperiencePoints).setHeader("Xp");
        grid.addColumn(CharacterDto::getLevelRequirement).setHeader("Level Requirement");
        grid.addColumn(CharacterDto::getWeaponDto).setHeader("Weapon");

        grid.setItems(characterDtosById);
        grid.getStyle().set("margin-top","50px");

        add(grid);

        setVisibleGrid();
    }

    private void setHTMLCodes(){
        attributesTextArea.setWidth("450px");
        attributesTextArea.setHeight("250px");
        attributesTextArea.setEnabled(false);
        attributesTextArea.getStyle().set("margin-left", "40px");
        attributesTextArea.getStyle().set("margin-top", "40px");
        attributesTextArea.getStyle().set("font-size", "32px");

        progressBar = new ProgressBar();
        progressBar.setWidth("400px");
        progressBar.getStyle().set("margin-left", "520px");
        progressBar.getStyle().set("margin-up", "40px");
        progressBar.getStyle().set("height", "10px");

        skillTextArea = new TextArea();
        skillTextArea.setValue("");
        skillTextArea.setHeight("400px");
        skillTextArea.setWidth("890px");
        skillTextArea.setEnabled(false);
        skillTextArea.getStyle().set("margin-top", "10px");
        skillTextArea.getStyle().set("margin-left", "520px");

        image.setMaxWidth("400px");
        image.setMaxHeight("400px");
        image.getStyle().set("margin-left", "520px");
        image.getStyle().set("margin-bottom", "20px");

        fighterName.getStyle().set("font-size", "50px");
        fighterName.getStyle().set("margin-left", "40px");

    }

    private void setVisibleGrid(){
        grid.setVisible(true);
        attributeLayout.setVisible(false);
        progressLayout.setVisible(false);
        skillLayout.setVisible(false);
    }
    private void setVisibleLayouts(){
        grid.setVisible(false);
        attributeLayout.setVisible(true);
        progressLayout.setVisible(true);
        skillLayout.setVisible(true);
    }
        /*
        if (Objects.equals(fClass, "Fighter")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Forest Helper")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Magic Caster")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Street Fighter")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Sword Fighter")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Gladiator")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Guardian of the Forest")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Golem")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Forest Ranger")){  }
        if (Objects.equals(fClass, "Scholar of the Academia")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Exiled Magic User")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Master of the Ring")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Sword Master")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Champion of the Arena")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "The highest Protector of the Forest")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Golem of Life Essence")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "The Hero of the Forest")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Sage of the Academia")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "The Ruler of the Forest")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "The Saviour of the Forest")){ return "images/empty-plant.png"; }
        if (Objects.equals(fClass, "Elder Lic")){ return "images/empty-plant.png"; }
        */
}
