package com.example.application.views.History;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;

@PageTitle("Fight History")
@Route(value = "historyview", layout = MainLayout.class)
public class FightHistoryView extends HorizontalLayout {

    public FightHistoryView() throws SQLException {



    }
}
