package com.example.sorter;

import com.example.sorter.controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SorterApplication extends Application {

    private final String APPLICATION_TITLE = "Student performance sorter";

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/application.fxml"));
        Parent root = loader.load();
        ApplicationController controller = loader.getController();
        controller.setParentStage(primaryStage);
        primaryStage.setTitle(APPLICATION_TITLE);
        final Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
