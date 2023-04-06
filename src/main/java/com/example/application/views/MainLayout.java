package com.example.application.views;


import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.example.application.repositories.CharacterRepository;
import com.example.application.repositories.TournamentRepository;
import com.example.application.views.CharacterView.FighterView;
import com.example.application.views.Help.HelpView;
import com.example.application.views.Custom.TournamentView;
import com.example.application.views.Create.CreateFighterView;
import com.example.application.views.OutPut.OutputView;
import com.example.application.views.Configuration.RenameFighterView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.sql.SQLException;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() throws SQLException {
        TournamentRepository.getInstance().dropTableTournamentToCharacter();
        TournamentRepository.getInstance().dropTableTournament();
        CharacterRepository.getInstance().dropTableCharacter();

        CharacterRepository.getInstance().createTableCharacter();
        TournamentRepository.getInstance().createTableTournament();
        TournamentRepository.getInstance().createTableTournamentToCharacter();

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Padding.SMALL);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Java Game");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.SMALL);
        Header header = new Header(appName);
        header.getStyle().set("margin-left", "20px");

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Create Character", CreateFighterView.class, "la la-heart"));
        nav.addItem(new AppNavItem("Configuration Character", RenameFighterView.class, "la la-sync"));
        nav.addItem(new AppNavItem("Character View", FighterView.class, "la la-globe"));
        nav.addItem(new AppNavItem("Tournament Output", OutputView.class, "la la-globe"));
        nav.addItem(new AppNavItem("Custom Tournament", TournamentView.class , "la la-history"));
        //nav.addItem(new AppNavItem("Tournament History", FightHistoryView.class, "la la-history"));
        nav.addItem(new AppNavItem("Help", HelpView.class, "la la-history"));
        nav.getStyle().set("text-align", "center");
        nav.getStyle().set("font-size", "18px");
        return nav;
    }

    private Footer createFooter() {
        return new Footer();
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
