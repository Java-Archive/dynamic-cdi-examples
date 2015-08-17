package org.rapidpm.ddi.examples.example003.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.examples.example003.ui.main.MainPane;


public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    MainPane root = new MainPane();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  public static void main(String[] args) {
    DI.activatePackages("org.rapidpm"); // speed up startup
    launch(args);
  }
}
