package fr.iutgon.ctp.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class PotenceController {

    @FXML
    public Rectangle bras_droit;

    @FXML
    public Rectangle bras_gauche;

    @FXML
    public Rectangle corde;

    @FXML
    public Ellipse corps;

    @FXML
    public Rectangle jambe_droite;

    @FXML
    public Rectangle jambe_gauche;

    @FXML
    public Rectangle mat;

    @FXML
    public Rectangle potence;

    @FXML
    public Rectangle soutien;

    @FXML
    public Circle tete;

    public VueController controller;

    public void setController(VueController controller) {
        this.controller = controller;
    }

}


