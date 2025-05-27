package fr.iutgon.ctp.modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class Scores {

    ObservableList<Partie> parties = FXCollections.observableArrayList();

    public Scores() {
    }

    public void add(Partie partie){
        parties.add(partie);
    }

    public void show(){
        TableView<Partie> tableView = new TableView<>();
        TableColumn<Partie, String> word = new TableColumn("Mot");
        TableColumn<Partie, Number> score = new TableColumn("Erreurs");
        tableView.getColumns().add(word);
        tableView.getColumns().add(score);

        Callback<TableColumn.CellDataFeatures<Partie, String>, ObservableValue<String>> wordCallback = new Callback<TableColumn.CellDataFeatures<Partie, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Partie, String> partieStringCellDataFeatures) {
                return new SimpleStringProperty(partieStringCellDataFeatures.getValue().getMot());
            }
        };

        Callback<TableColumn.CellDataFeatures<Partie, Number>, ObservableValue<Number>> scoreCallback = new Callback<TableColumn.CellDataFeatures<Partie, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Partie, Number> partieStringCellDataFeatures) {
                return new SimpleIntegerProperty(partieStringCellDataFeatures.getValue().getErreurs());
            }
        };

        word.setCellValueFactory(wordCallback);
        score.setCellValueFactory(scoreCallback);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Scores");
        alert.getDialogPane().setContent(tableView);
        alert.show();
    }
}
