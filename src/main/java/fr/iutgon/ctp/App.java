package fr.iutgon.ctp;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Mon Pendu !");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
