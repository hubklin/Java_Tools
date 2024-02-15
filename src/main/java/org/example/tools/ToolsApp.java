package org.example.tools;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ToolsApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        WebView view = new WebView();
        WebEngine engine = view.getEngine();


        engine.load("http://web.prz.edu.pl");

        BorderPane root = new BorderPane();
        root.setCenter(view);


        Menu toolsMenu = new Menu("Narzędzia");


        MenuItem jdkMenuItem = new MenuItem("Java Development Kit (JDK)");
        MenuItem javafxMenuItem = new MenuItem("JavaFX");
        MenuItem intellijMenuItem = new MenuItem("IntelliJ IDEA");


        jdkMenuItem.setOnAction(e -> engine.load("https://www.oracle.com/java/technologies/javase-downloads.html"));
        javafxMenuItem.setOnAction(e -> engine.load("https://openjfx.io/"));
        intellijMenuItem.setOnAction(e -> engine.load("https://www.jetbrains.com/idea/download/"));


        toolsMenu.getItems().addAll(jdkMenuItem, javafxMenuItem, intellijMenuItem);


        Menu javaApiMenu = new Menu("Java API");


        MenuItem seMenuItem = new MenuItem("Java SE API");
        MenuItem eeMenuItem = new MenuItem("Java EE API");
        MenuItem androidMenuItem = new MenuItem("Android API");


        seMenuItem.setOnAction(e -> engine.load("https://docs.oracle.com/en/java/javase/"));
        eeMenuItem.setOnAction(e -> engine.load("https://jakarta.ee/specifications/platform/10/apidocs/"));
        androidMenuItem.setOnAction(e -> engine.load("https://docs.oracle.com/en/java/javase/19/docs/api/index.html"));


        javaApiMenu.getItems().addAll(seMenuItem, eeMenuItem, androidMenuItem);


        Menu tutorialsMenu = new Menu("Tutoriale");


        MenuItem seTutorialItem = new MenuItem("Java SE Tutorial");
        MenuItem eeTutorialItem = new MenuItem("Java EE Tutorial");
        MenuItem androidTutorialItem = new MenuItem("Android Tutorial");


        seTutorialItem.setOnAction(e -> engine.load("https://docs.oracle.com/javase/tutorial/"));
        eeTutorialItem.setOnAction(e -> engine.load("https://eclipse-ee4j.github.io/jakartaee-tutorial/"));
        androidTutorialItem.setOnAction(e -> engine.load("https://developer.android.com/guide"));


        tutorialsMenu.getItems().addAll(seTutorialItem, eeTutorialItem, androidTutorialItem);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(toolsMenu, javaApiMenu, tutorialsMenu);


        root.setTop(menuBar);


        ToolBar toolBar = new ToolBar();
        Button refreshButton = new Button("Odśwież");
        Button backButton = new Button("Cofnij");

        refreshButton.setOnAction(e -> engine.reload());
        backButton.setOnAction(e -> {
            if (engine.getHistory().getCurrentIndex() > 0) {
                engine.getHistory().go(-1);
            }
        });

        toolBar.getItems().addAll(refreshButton, backButton);


        root.setBottom(toolBar);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Tools App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
