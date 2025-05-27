package fr.iutgon.ctp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(App.class.getResource("vue.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setTitle("Mon Pendu !");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
