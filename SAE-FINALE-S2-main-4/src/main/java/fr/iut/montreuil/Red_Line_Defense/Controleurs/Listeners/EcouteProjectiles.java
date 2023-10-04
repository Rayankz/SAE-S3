package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueProjectile;
import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

public class EcouteProjectiles {

    private ListProperty<Projectile> listProjectiles;
    private Environnement terrain;



    @FXML
    private Pane centerPane;

    public EcouteProjectiles(Environnement terrain,Pane centerPane){
        this.terrain = terrain;
        this.centerPane = centerPane;
        this.listProjectiles = this.terrain.getProjectilesProperty();
        ajouterEcouteurSurProjectile();
    }

    public void ajouterEcouteurSurProjectile(){
        this.listProjectiles.addListener((ListChangeListener<Projectile>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    List<? extends Projectile> addedProjectiles = change.getAddedSubList();
                    for (Projectile projectile : addedProjectiles) {
                        new VueProjectile(centerPane,projectile);
                    }
                }
                if (change.wasRemoved()) {
                    {
                        for (int i = change.getRemoved().size() - 1; i >= 0; i--) {
                            Projectile projectile= change.getRemoved().get(i);
                            Node n = centerPane.lookup("#" + projectile.getId());
                            centerPane.getChildren().remove(n);
                }
            }
                }
            }
        });
    }
}