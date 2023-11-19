package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueProjectile;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

public class EcouteProjectiles {

    private Environnement terrain;
    @FXML
    private Pane centerPane;

    public EcouteProjectiles(Environnement terrain, Pane centerPane) {

        this.terrain = terrain;
        this.centerPane = centerPane;
        ajouterEcouteurSurProjectile();
    }
    public void ajouterEcouteurSurProjectile() {

        this.terrain.getProjectilesProperty().addListener((ListChangeListener<Projectile>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    List<? extends Projectile> addedProjectiles = change.getAddedSubList();
                    for (Projectile projectile : addedProjectiles) {

                        new VueProjectile(this.centerPane, projectile);
                    }
                }
                if (change.wasRemoved()) {

                    for (int i = change.getRemoved().size() - 1; i >= 0; i--) {

                        Projectile projectile = change.getRemoved().get(i);
                        Node n = this.centerPane.lookup("#" + projectile.getId());
                        this.centerPane.getChildren().remove(n);
                    }
                }
            }
        });
    }
}