package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueTours;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

import java.util.List;

public class EcouteTours {

    private Environnement environnement;

    private VueTours vueTours;

    private double dernierClicX = 100;

    private double dernierClicY = 120;

    public EcouteTours(Environnement terrain, VueTours vueTours) {

        this.environnement = terrain;
        this.vueTours = vueTours;
        ajouterEcouteurSurTours();

        vueTours.getCenterPane().setOnMouseClicked(event -> {

            setDernierClicX(event.getX());
            setDernierClicY(event.getY());

            System.out.println("clic de souris: x = " + dernierClicX + " y = " + dernierClicY);
        });
    }

    public void ajouterEcouteurSurTours() {

        this.environnement.getToursProperty().addListener(new ListChangeListener<Tour>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Tour> t) {

                while (t.next()) {

                    if (t.wasAdded()) {

                        List<? extends Tour> addedTowers = t.getAddedSubList();
                        for (Tour tour : addedTowers) {

                            ImageView imageView = vueTours.createTourImageView(dernierClicX, dernierClicY, tour.getPath());
                            imageView.setId(tour.getId());

                            DoubleProperty progression = new SimpleDoubleProperty(1.0);
                            progression.bind(Bindings.divide(tour.getPointsDeVieProperty(), (double) tour.getPointsDeVieValue()));

                            ProgressBar hpb = vueTours.créerBarreDeVie(progression, dernierClicX, dernierClicY);
                            hpb.setId(tour.getId() + "p");
                            vueTours.getCenterPane().getChildren().addAll(imageView, hpb);
                        }
                    }
                    if (t.wasRemoved()) {
                        {
                            for (int i = t.getRemoved().size() - 1; i >= 0; i--) {

                                Tour tour = t.getRemoved().get(i);
                                Node n = vueTours.getCenterPane().lookup("#" + tour.getId());
                                Node m = vueTours.getCenterPane().lookup("#" + tour.getId() + "p");
                                vueTours.getCenterPane().getChildren().remove(n);
                                vueTours.getCenterPane().getChildren().remove(m);
                            }
                        }
                    }
                }
            }
        });
    }

    public void setDernierClicX(double changement) {

        this.dernierClicX = changement;
    }

    public void setDernierClicY(double changement) {

        this.dernierClicY = changement;
    }
}
