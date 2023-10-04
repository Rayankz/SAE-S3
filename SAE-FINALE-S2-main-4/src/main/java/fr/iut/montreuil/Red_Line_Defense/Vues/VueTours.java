package fr.iut.montreuil.Red_Line_Defense.Vues;


import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.*;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
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

public class VueTours {

    public static final String HERBE_VIERGE_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/herbeVierge.png";
    public static final String CHEMIN_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/chemin.png";
    public static final String BAD_CLICK_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/badClic.png";
    public static final String MAP_TOUR_SORCIER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sorcierPosable.png"; // Mitrallieuse
    public static final String MAP_TOUR_SNIPER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sniperPosable.png"; // Sniper
    public static final String MAP_TOUR_MORTIER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/mortierPosable.png"; // Teleguidée
    public static final String MAP_TOUR_ENFER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/enferPosable.png"; // Ralentis
    public static final String MENU_TOUR_SORCIER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/TourMenu/sorcierPosable.png"; // Mitrallieuse
    public static final String MENU_TOUR_SNIPER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/TourMenu/sniperPosable.png"; // Sniper
    public static final String MENU_TOUR_MORTIER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/TourMenu/mortierPosable.png"; // Teleguidée
    public static final String MENU_TOUR_ENFER_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/TourMenu/enferPosable.png"; // Ralentis
    public static final String CLIC_CHEMIN_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/errChemin.png";
    public static final String CLIC_NO_MONEY_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/ErrorMessages/noMoney.png";


    private Environnement terrain;

    @FXML
    private Pane centerPane;


    private String idTourClicked = "0";

    public VueTours(Environnement terrain, Pane centerPane) {
        this.terrain = terrain;
        this.centerPane = centerPane;
    }

    @FXML
    public void positionTour(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        DoubleProperty progression = new SimpleDoubleProperty(1.0);;
        ProgressBar hpb = creerBarreDeVie(progression, x, y);

        System.out.println("x " + (int)(x/8) + " y " +(int) (y/8));
        ImageView i = new ImageView();
        //StackPane stackPane = new StackPane();
        //stackPane.setPadding(new Insets(10));

        if (idTourClicked.equals("0")) {
            // Aucune tour sélectionnée, afficher ce message d'erreur
            showErrorMessage(x, y);
        } else if (terrain.getJoueur().getSoldeJoueurValue()<=0)  {
            // Message d'erreur en cas de clic sans avoir le solde necéssaire
            showErrorMoneyMessage(x, y);
        } else {
            if (tourPosable(x, y)) {
                switch (idTourClicked) {
                    case "tour200b":
                        i = createTourImageView(x, y, MAP_TOUR_ENFER_PATH);
                        ToursDeffensives td = new ToursDeffensives((int) x,(int) y, terrain);
                        terrain.ajouterTour(td);
                        i.setId(td.getId());
                        hpb.setId(td.getId()+"p");
                        progression.bind(Bindings.divide(td.getPointsDeVieProperty(), (double) td.getPointsDeVieValue()));
                        break;

                    case "tour400b":
                        i = createTourImageView(x, y, MAP_TOUR_SORCIER_PATH);
                        TourMitrailleuse tm = new TourMitrailleuse((int) x, (int) y,terrain);
                        terrain.ajouterTour(tm);
                        i.setId(tm.getId());
                        hpb.setId(tm.getId()+"p");
                        progression.bind(Bindings.divide(tm.getPointsDeVieProperty(), (double) tm.getPointsDeVieValue()));
                        break;

                    case "tour600b":
                        i = createTourImageView(x, y, MAP_TOUR_SNIPER_PATH);
                        TourSniper ts = new TourSniper((int) x, (int) y,terrain);
                        terrain.ajouterTour(ts);
                        i.setId(ts.getId());
                        hpb.setId((ts.getId()+"p"));
                        progression.bind(Bindings.divide(ts.getPointsDeVieProperty(), (double) ts.getPointsDeVieValue()));
                        break;
                    case "tour800b":
                        i = createTourImageView(x, y, MAP_TOUR_MORTIER_PATH);
                        TourLanceMissile tlm = new TourLanceMissile((int) x, (int) y,terrain);
                        terrain.ajouterTour(tlm);
                        i.setId(tlm.getId());
                        hpb.setId((tlm.getId()+"p"));
                        progression.bind(Bindings.divide(tlm.getPointsDeVieProperty(), (double) tlm.getPointsDeVieValue()));
                        break;
                }
                //afficherBarreDeVie(stackPane, i, hpb);
                centerPane.getChildren().addAll(i, hpb);

                idTourClicked = "0"; // Réinitialiser la sélection de la tour
            }
        }
    }

    public ProgressBar creerBarreDeVie(DoubleProperty d, double x, double y){
        ProgressBar hpBarre = new ProgressBar();
        hpBarre.progressProperty().bind(d);
        //hpBarre.setPadding(new Insets(2));
        hpBarre.setLayoutX(x-25); // moitié de l'image
        hpBarre.setLayoutY(y-10-22); //10 pixels au dessus + la moitié de l'image
        hpBarre.setPrefHeight(10);
        hpBarre.setPrefWidth(50);
        return hpBarre;
    }



    private ImageView createTourImageView(double x, double y, String path) {
        ImageView maTour = new ImageView(loadImage(path));
        maTour.setX(x - 15);
        maTour.setY(y - 22);
        return maTour;
    }


    private boolean tourPosable(double x, double y) {
        int mapX = (int) x / 8;
        int mapY = (int) y / 8;

        // La position de départ pour la vérification de l'entourage
        int startX = mapX - 3;
        int startY = mapY - 3;

        // Vérifier si la case est valide et si elle est libre
        if (terrain.valeurDeLaCase(mapY, mapX) == 1){
            showErrorCheminMessage(x, y);
        }
        else {
            if (mapX >= 0 && mapX < terrain.getXmax() && mapY >= 0 && mapY < terrain.getYmax()) {
                // Vérifier si aucune tour n'est déjà positionnée sur cette case ou sur les cases entourant celle-ci
                for (int i = startX; i <= startX + 6; i++) {
                    for (int j = startY; j <= startY + 6; j++) {
                        if (i >= 0 && i < terrain.getXmax() && j >= 0 && j < terrain.getYmax()) {
                            for (Tour tour : terrain.getTours()) {
                                if (((int) (tour.getX0Value() / 8) == i) && ((int) (tour.getY0Value() / 8) == j)) {
                                    System.out.println("Tour deja posée sur " + tour.getX0Value() + " (" + ((int) tour.getX0Value() / 8) + ") " + tour.getY0Value() + " (" + ((int) tour.getY0Value() / 8) + ") ");
                                    return false; // Une tour est déjà positionnée sur cette case ou sur une case entourante
                                }
                            }
                        }
                    }
                }
                return true; // La case et ses cases environnantes sont libres et aucune tour n'est positionnée dessus
            }
        }
        return false; // La case est invalide ou déjà occupée par une tour ou une case environnante est occupée par une tour
    }




    private void showErrorMessage(double x, double y) {
        ImageView errorImageView = createErrorImageView(x, y);
        centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }

    private ImageView createErrorImageView(double x, double y) {
        ImageView err = new ImageView(loadImage(BAD_CLICK_IMAGE_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }
    private void showErrorMoneyMessage(double x, double y) {
        ImageView errorImageView = createMoneyErrorImageView(x, y);
        centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }

    private ImageView createMoneyErrorImageView(double x, double y) {
        ImageView err = new ImageView(loadImage(CLIC_NO_MONEY_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }
    private void showErrorCheminMessage(double x, double y) {
        ImageView errorImageView = createCheminErrorMessage(x, y);
        centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }

    private ImageView createCheminErrorMessage(double x, double y) {
        ImageView err = new ImageView(loadImage(CLIC_CHEMIN_IMAGE_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }

    @FXML
    public void selectionTour(MouseEvent event) {
        ImageView image = (ImageView) event.getSource();
        this.idTourClicked = image.getId();
    }

    private Image loadImage(String path) {
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

}