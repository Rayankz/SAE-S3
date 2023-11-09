package fr.iut.montreuil.Red_Line_Defense.Vues;


import fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners.TourPlacementErrorListener;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.*;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables.FabriqueSimple;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables.ForgeDesToursPosables;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.InputStream;

public class VueTours implements TourPlacementErrorListener {
    public static final String BAD_CLICK_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/badClic.png";
    public static final String CLIC_CHEMIN_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/errChemin.png";
    public static final String CLIC_NO_MONEY_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/noMoney.png";
    private Environnement environnement;
    @FXML
    private Pane centerPane;
    private String idTourClicked = "0";
    private ForgeDesToursPosables forgeDesToursPosables;
    public VueTours(Environnement environnement, Pane centerPane) {

        this.environnement = environnement;
        this.centerPane = centerPane;
        this.forgeDesToursPosables = new ForgeDesToursPosables(this.environnement, new FabriqueSimple(), this);
    }
    public ProgressBar creerBarreDeVie(DoubleProperty d, double x, double y) {

        ProgressBar hpBarre = new ProgressBar();
        hpBarre.progressProperty().bind(d);
        //hpBarre.setPadding(new Insets(2));
        hpBarre.setLayoutX(x-25); // moitié de l'image
        hpBarre.setLayoutY(y-10-22); //10 pixels au-dessus + la moitié de l'image
        hpBarre.setPrefHeight(10);
        hpBarre.setPrefWidth(50);
        return hpBarre;
    }
    public ImageView createTourImageView(double x, double y, String path) {

        ImageView maTour = new ImageView(loadImage(path));
        maTour.setX(x - 15);
        maTour.setY(y - 22);
        return maTour;
    }
    public void showErrorMessage(double x, double y) {

        ImageView errorImageView = createErrorImageView(x, y);
        this.centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> this.centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }
    public ImageView createErrorImageView(double x, double y) {

        ImageView err = new ImageView(loadImage(BAD_CLICK_IMAGE_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }
    public void showErrorMoneyMessage(double x, double y) {

        ImageView errorImageView = createMoneyErrorImageView(x, y);
        this.centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> this.centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }
    public ImageView createMoneyErrorImageView(double x, double y) {

        ImageView err = new ImageView(loadImage(CLIC_NO_MONEY_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }
    public void showErrorCheminMessage(double x, double y) {

        ImageView errorImageView = createCheminErrorMessage(x, y);
        this.centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> this.centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }
    public ImageView createCheminErrorMessage(double x, double y) {

        ImageView err = new ImageView(loadImage(CLIC_CHEMIN_IMAGE_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }
    public void setIdTourClicked(String a) {

        this.idTourClicked = a;
    }
    public Image loadImage(String path) {

        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            if (inputStream != null) {

                return new Image(inputStream);
            } else {

                System.err.println("Impossible de charger l'image " + path);
                return null;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
    @FXML
    public void positionTour(MouseEvent event) {

        double x = event.getX();
        double y = event.getY();
        DoubleProperty progression = new SimpleDoubleProperty(1.0);;
        ProgressBar hpb = creerBarreDeVie(progression, x, y);

        System.out.println("x " + (int) (x / 8) + " y " + (int) (y / 8));
        ImageView i = new ImageView();

        if (this.idTourClicked.equals("0")) {
            // Aucune tour sélectionnée, afficher ce message d'erreur
            showErrorMessage(x, y);
        }//🇩🇿
        else if (this.environnement.getJoueur().getSoldeJoueurValue() <= this.forgeDesToursPosables.rechercheDeTourPosable(this.idTourClicked, (int) x, (int) y).getPrixValue())  {
            // Message d'erreur en cas de clic sans avoir le solde nécessaire
            showErrorMoneyMessage(x, y);
        }
        else {
            if (this.forgeDesToursPosables.conditionsTourPosable(x, y)) {

                this.forgeDesToursPosables.fabriquerTourPosable(this.idTourClicked, (int) x, (int) y);
                Tour tour = this.forgeDesToursPosables.rechercheDeTourPosable(this.idTourClicked, (int) x, (int) y);
                i = createTourImageView(x, y, tour.getPath());
                i.setId(tour.getId());
                hpb.setId(tour.getId() + "p");
                progression.bind(Bindings.divide(tour.getPointsDeVieProperty(), (double) tour.getPointsDeVieValue()));
                this.centerPane.getChildren().addAll(i, hpb);

                this.idTourClicked = "0"; // Réinitialiser la sélection de la tour
            }
        }
    }
    @Override
    public void onCheminError(double x, double y) {

        showErrorCheminMessage(x, y);
    }
}