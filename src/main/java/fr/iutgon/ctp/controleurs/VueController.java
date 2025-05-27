package fr.iutgon.ctp.controleurs;

import fr.iutgon.ctp.modele.Pendu;
import fr.iutgon.ctp.modele.Scores;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class VueController implements Initializable {

    @FXML
    public MenuItem ctp_aide_ap;

    @FXML
    public MenuItem ctp_aide_scores;

    @FXML
    public BorderPane ctp_bp;

    @FXML
    public HBox ctp_footer_hbox;

    @FXML
    public FlowPane ctp_fp;

    @FXML
    public MenuBar ctp_menu_bar;

    @FXML
    public MenuItem ctp_partie_nouvelle;

    @FXML
    public MenuItem ctp_partie_quitter;

    public @FXML PotenceController potenceController;

    public Pendu pendu;

    private Scores scores = new Scores();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pendu = new Pendu();
        potenceController.setController(this);
        createTextField();
        createAvailableLetters();

        ctp_partie_quitter.addEventHandler(ActionEvent.ACTION, event -> {
            Platform.exit();
        });

        ctp_aide_ap.addEventHandler(ActionEvent.ACTION, event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Baptiste Gosselin");
            alert.setHeaderText("Baptiste Gosselin");
            alert.show();
        });

        ctp_aide_scores.addEventHandler(ActionEvent.ACTION, event -> {
            scores.show();
        });

        ctp_partie_nouvelle.addEventHandler(ActionEvent.ACTION, event -> {
            createTextField();
            createAvailableLetters();
        });

        pendu.perduProperty().addListener((observable, oldValue, newValue) -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pendu Perdu");
            alert.setHeaderText("Pendu Perdu");
            alert.show();
            disableAllButtons();
            scores.add(pendu.getPartie());
        });
    }

    private void createTextField(){
        pendu.tireNouveauMot();
        ctp_footer_hbox.getChildren().clear();
        for(int i = 0; i < pendu.getLettres().size(); i++){
            TextField textField = new TextField();
            textField.textProperty().bind(pendu.getLettres().get(i));
            textField.setEditable(false);
            textField.setPrefWidth(64);
            textField.setStyle("-fx-font-size: 24pt;");
            ctp_footer_hbox.getChildren().add(textField);
        }
    }

    private void createAvailableLetters(){
        ctp_fp.getChildren().clear();
        for(int i = 0; i < pendu.getDisponibles().size(); i++){
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setText(pendu.getDisponibles().get(i).toString());
            toggleButton.setPrefWidth(30);
            ctp_fp.getChildren().add(toggleButton);

            toggleButton.addEventHandler(ActionEvent.ACTION, event -> {
                pendu.propose(toggleButton.getText().charAt(0));
                toggleButton.setDisable(true);
                if (pendu.isGagne()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Pendu Gagne");
                    alert.setHeaderText("Pendu Gagne");
                    alert.show();
                    disableAllButtons();
                    scores.add(pendu.getPartie());
                }
            });
        }
    }

    private void disableAllButtons(){
        for (Node button : ctp_fp.getChildren()){
            ToggleButton toggleButton = (ToggleButton) button;
            toggleButton.setDisable(true);
        }
    }
}

