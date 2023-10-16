package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueSoldats;
import javafx.beans.property.ListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import java.util.List;

public class EcouteSoldats {

    private VueSoldats vueSoldat;

    private Environnement environnement;

    public EcouteSoldats(Environnement environnement, VueSoldats vueSoldat) {

        this.environnement = environnement;
        this.vueSoldat = vueSoldat;
        ajouterEcouteurSurSoldat();
    }

    public Environnement getEnvironnement() {

        return this.environnement;
    }

    public void ajouterEcouteurSurSoldat() {

        this.environnement.getSoldatsProperty().addListener(new ListChangeListener<Soldat>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Soldat> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        List<? extends Soldat> addedSoldiers = c.getAddedSubList();
                        for (Soldat soldat : addedSoldiers) {
                            vueSoldat.ajouterSkinSoldat(soldat);
                            ajouterEcouteurSurCoordonneesSoldat(soldat);
                        }

                    } else if (c.wasRemoved()) {
                        List<? extends Soldat> deletedSoldiers = c.getRemoved();
                        for (Soldat soldat : deletedSoldiers) {
                            vueSoldat.supprSkinSoldats(soldat);
                        }

                    }
                }
            }
        });
    }

    public void ajouterEcouteurSurCoordonneesSoldat(Soldat s) {

        s.getX0Property().addListener(new ChangeListener<Number>() {
               public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                   if (newValue.intValue() > oldValue.intValue()) {

                       vueSoldat.mettreAJourSkin(3, s);
                   } else {

                       vueSoldat.mettreAJourSkin(2, s);
                   }
               }
           });

           s.getY0Property().addListener(new ChangeListener<Number>() {
               public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                   if (newValue.intValue() > oldValue.intValue()) {

                       vueSoldat.mettreAJourSkin(1, s);
                   } else {

                       vueSoldat.mettreAJourSkin(0, s);
                   }
               }
           });

       }
}




