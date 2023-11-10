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

    private Environnement terrain;

    private VueTours vueTours;

    public EcouteTours(Environnement terrain, VueTours vueTours) {

        this.terrain = terrain;
        this.vueTours = vueTours;
        ajouterEcouteurSurTours();
    }

    public void ajouterEcouteurSurTours() {

        this.terrain.getToursProperty().addListener(new ListChangeListener<Tour>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Tour> t) {

                while (t.next()) {

                    if (t.wasAdded()) {

                        List<? extends Tour> addedTowers = t.getAddedSubList();
                        for (Tour tour : addedTowers) {

                            vueTours.getCenterPane().setOnMouseClicked(mouseEvent -> {

                                ImageView imageView = createTourImageView(mouseEvent.getX(), mouseEvent.getY(), tour.getPath());
                                imageView.setId(tour.getId());

                                DoubleProperty progression = new SimpleDoubleProperty(1.0);
                                progression.bind(Bindings.divide(tour.getPointsDeVieProperty(), (double) tour.getPointsDeVieValue()));

                                ProgressBar hpb = vueTours.créerBarreDeVie(progression, mouseEvent.getX(), mouseEvent.getY());
                                hpb.setId(tour.getId() + "p");
                                vueTours.getCenterPane().getChildren().addAll(imageView, hpb);

                                vueTours.getCenterPane().setOnMouseClicked(null);
                            });

                            //ImageView imageView = createTourImageView(mouseEvent.getX(), mouseEvent.getY(), tour.getPath());
                            //imageView.setId(tour.getId());

                            //DoubleProperty progression = new SimpleDoubleProperty(1.0);
                            //progression.bind(Bindings.divide(tour.getPointsDeVieProperty(), (double) tour.getPointsDeVieValue()));

                            //ProgressBar hpb = vueTours.creerBarreDeVie(progression, mouseEvent.getX(), mouseEvent.getY());
                            //hpb.setId(tour.getId() + "p");
                            //vueTours.getCenterPane().getChildren().addAll(imageView, hpb);
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

    public ImageView createTourImageView(double x, double y, String path) {

        ImageView maTour = new ImageView(this.vueTours.loadImage(path));
        maTour.setX(x - 15);
        maTour.setY(y - 22);
        return maTour;
    }
}
