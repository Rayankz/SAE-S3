package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Blast;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class ToursOffensives extends Tour {

    private IntegerProperty cadence; // La cadence est la capacité de Tirs par minute
    private ObservableList<Projectile> projectiles; // Liste de tous les projectiles actuellement tirés par la tour

    private int vitesseProjectile;
    public ToursOffensives(int x0, int y0, int pointsDeVie, int degats, int defense, int prix,Environnement terrain,int cadence,int vitesse,double portée) {
        super(x0, y0, pointsDeVie, degats, defense, prix, terrain, portée);

        this.cadence = new SimpleIntegerProperty(cadence);
        this.projectiles = FXCollections.observableArrayList();
        this.vitesseProjectile=vitesse;
    }


    // Accesseur pour les projectiles
    public ObservableList<Projectile> getProjectiles() {
        return this.projectiles;
    }


    public void agit(int n){
        tirer(n);
    }

    public int getCadence() {
        return cadence.getValue();
    }

    public IntegerProperty cadenceProperty() {
        return cadence;
    }

    public abstract void creationProjectile(Soldat s);
    public void tirer(int nTemps) {
        Soldat s = ennemiÀPorter();
        if (s != null) {
            if (s.estVivant()) {
                if(nTemps%getCadence()==0)
                creationProjectile(s);
               }
        }
    }

    public int getVitesseProjectile() {
        return vitesseProjectile;
    }
}
