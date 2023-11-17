package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueTours;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

import java.util.List;

public class EcouteTours {

    private Environnement environnement;

    private VueTours vueTours;

    public EcouteTours(Environnement terrain, VueTours vueTours) {

        this.environnement = terrain;
        this.vueTours = vueTours;
        ajouterEcouteurSurTours();
    }

    public void ajouterEcouteurSurTours() {

        this.environnement.getToursProperty().addListener(new ListChangeListener<Tour>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Tour> t) {

                while (t.next()) {

                    if (t.wasAdded()) {

                        List<? extends Tour> addedTowers = t.getAddedSubList();
                        for (Tour tour : addedTowers) {

                            int x = (int) (tour.getX0Value()); int y = (int) (tour.getY0Value());
                            System.out.println("bonjour x: " + (int) (tour.getX0Value() / 8) + " y: " + (int) (tour.getY0Value() / 8));
                            ajouterVueTourelle(x, y, tour.getPath(), tour.getId(), tour.getPointsDeVieProperty(), tour.getPointsDeVieValue());
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

    public void ajouterVueTourelle(int x, int y, String path, String id, IntegerProperty pv, int pv2) {

        ImageView imageView = vueTours.createTourImageView(x, y, path);
        imageView.setId(id);

        DoubleProperty progression = new SimpleDoubleProperty(1.0);
        progression.bind(Bindings.divide(pv, (double) pv2));

        ProgressBar hpb = vueTours.créerBarreDeVie(progression, x, y);
        hpb.setId(id + "p");
        vueTours.getCenterPane().getChildren().addAll(imageView, hpb);
    }
}
