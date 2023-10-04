package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

public class EcouteTours {

    private ListProperty<Tour> listeTours;

    private Joueur joueur;
    private Environnement terrain;

    private Pane centerPane;

    public EcouteTours(Environnement terrain, Pane centerPane) {
        this.terrain = terrain;
        this.centerPane = centerPane;
        this.joueur = terrain.getJoueur();
        this.listeTours = this.terrain.getToursProperty();
        ajouterEcouteurSurTours();
    }

    public void ajouterEcouteurSurTours() {

        this.listeTours.addListener(new ListChangeListener<Tour>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Tour> t) {
                while (t.next()) {
                    if (t.wasAdded()) {
                        List<? extends Tour> addedTowers = t.getAddedSubList();
                        for (Tour tour : addedTowers) {
                            joueur.debiterSolde(tour.getPrixValue());
                        }
                        if (joueur.getSoldeJoueurValue() < 0) {

                        }
                    }
                    if (t.wasRemoved()) {
                        {
                            for (int i = t.getRemoved().size() - 1; i >= 0; i--) {
                                Tour tour = t.getRemoved().get(i);
                                Node n = centerPane.lookup("#" + tour.getId());
                                Node m = centerPane.lookup("#" + tour.getId()+"p");
                                centerPane.getChildren().remove(n);
                                centerPane.getChildren().remove(m);
                            }
                        }
                    }
                }
            }
        });
    }
}
