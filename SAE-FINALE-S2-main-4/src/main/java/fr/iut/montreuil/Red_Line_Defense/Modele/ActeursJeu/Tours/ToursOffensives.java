package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ToursOffensives extends Tour {

    private final IntegerProperty cadence; // La cadence est la capacité de Tirs par minute
    private final ObservableList<Projectile> projectiles; // Liste de tous les projectiles actuellement tirés par la tour
    private final int vitesseProjectile;

    public ToursOffensives(int x0, int y0, int pointsDeVie, int dégâts, int defense, int prix, Environnement terrain, int cadence, int vitesse, double portée, String path) {
        super(x0, y0, pointsDeVie, dégâts, defense, prix, terrain, portée, path);

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

    public abstract Projectile creationProjectile(Soldat s);

    public void tirer(int nTemps) {
        Soldat s = ennemiÀPorter(getPortée());
        if (s != null) {
            if (s.estVivant()) {
                if (nTemps % getCadence() == 0) {
                    Projectile p = creationProjectile(s);
                    getTerrain().ajouterProjectile(p);
                    p.animationProjectile();
                }
            }
        }
    }

    public int getVitesseProjectile() {
        return vitesseProjectile;
    }
}
