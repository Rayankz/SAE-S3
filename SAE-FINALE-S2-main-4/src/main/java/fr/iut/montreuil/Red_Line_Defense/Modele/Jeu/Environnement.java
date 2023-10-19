package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Environnement {

    private IntegerProperty vague, ennemisTues;
    private int ennemisTuesCetteVague;
    private ListProperty<Projectile> listeProjectiles;
    private ListProperty<Tour> listeTours;
    private ListProperty<Soldat> listeSoldats;
    private int nbrTours = 0;
    private Joueur joueur ;
    public int[][] distances;
    private BasePrincipale basePrincipale;

    private Vagues vaguesDeJeu;

    public BFS BFS;

    public Environnement(Joueur joueur) {

        this.BFS=new BFS(this);

        this.joueur = joueur;

        this.vague = new SimpleIntegerProperty(1);
        this.ennemisTues = new SimpleIntegerProperty(0);

        this.ennemisTuesCetteVague = 0;

        ObservableList<Tour> observableListTour = FXCollections.observableArrayList();
        listeTours = new SimpleListProperty<>(observableListTour);

        ObservableList<Soldat> observableListSoldat = FXCollections.observableArrayList();
        listeSoldats = new SimpleListProperty<>(observableListSoldat);

        ObservableList<Projectile> projectileObservableList = FXCollections.observableArrayList();
        listeProjectiles = new SimpleListProperty<>(projectileObservableList);

        this.vaguesDeJeu  = new Vagues(this);

        this.distances = new int[getBFS().getYmax()][getBFS().getXmax()];  // Initialisation du tableau de distances
        BFS.calculerChemin(89, 47);
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- TOUR DE JEU ---------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void unTour() {

        verificationMorts(); //validé
        this.vaguesDeJeu.unTour(); //validé
        actionDesSoldats(this.nbrTours); //validé
        actionTours(this.nbrTours); //validé
        suppressionTour();
        this.basePrincipale.agit(1);
        checkNouvelleVagues();
        verificationDefaite();

        this.nbrTours++;
    }

    public void checkNouvelleVagues() {

        if (this.ennemisTuesCetteVague == this.vaguesDeJeu.getTotalSoldats()) {

            this.vague.setValue(this.vague.getValue() + 1);
            // Reset
            this.ennemisTuesCetteVague = 0;
        }
    }

    public void actionDesSoldats(int n) {

        if (!this.listeSoldats.isEmpty()) {

            for (Soldat soldat : this.listeSoldats) {

                soldat.déplacementSoldat(n);
            }
        }
    }

    public void verificationDefaite() {

        if (this.basePrincipale.getPointsDeVieValue() < 1) {

            this.vague.setValue(-1);

        }

    }

    public void actionTours(int n) {

        if(!this.listeTours.isEmpty()) {

            for (Tour t : this.listeTours) {

                t.agit(n);

                t.infligerDegats(2);

            }

        }

    }

   public void suppressionTour() {

        if (!listeTours.isEmpty()) {

            listeTours.removeIf(tour -> tour.getPointsDeVieValue() <= 0);
        }

    }

    public void verificationMorts() {

        Iterator<Soldat> iterator = this.listeSoldats.iterator();
        while (iterator.hasNext()) {

            Soldat soldat = iterator.next();
            if (soldat.getPointsDeVieValue() <= 0) {

                iterator.remove(); // Supprimer l'élément de la liste en utilisant l'itérateur
                this.joueur.crediterSolde(soldat.getValeurGagnee());
                this.ennemisTues.setValue(this.ennemisTues.getValue() + 1);
                this.ennemisTuesCetteVague++;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- INTERFACE ------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public IntegerProperty getVagueProperty() { return this.vague; }

    public int getVagueValue() { return this.vague.getValue(); }

    public IntegerProperty getEnnemisTuesProperty() { return this.ennemisTues;}

    public int getNbrTours() {

        return this.nbrTours;
    }

    public BFS getBFS() {

        return this.BFS;
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE PROJECTILES ------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void ajouterProjectile(Projectile projectile) {

        this.listeProjectiles.add(projectile);
    }

    public void supprimerProjectile(Projectile projectile) {

        this.listeProjectiles.remove(projectile);
    }

    public ListProperty<Projectile> getProjectilesProperty() {

        return this.listeProjectiles;
    }

    public ObservableList<Projectile> getProjectiles() {

        return this.listeProjectiles.get();
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- MAP DE JEU -------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE TOURS ------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void ajouterTour(Tour tour) {

        this.listeTours.add(tour);
    }

    public ListProperty<Tour> getToursProperty() {

        return this.listeTours;
    }

    public ObservableList<Tour> getTours() {

        return this.listeTours.get();
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE SOLDATS ----------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public ListProperty<Soldat> getSoldatsProperty() {

        return this.listeSoldats;
    }

    public ObservableList<Soldat> getSoldats() {

        return this.listeSoldats.get();
    }


    public Joueur getJoueur() {

        return this.joueur;
    }

    public void setBasePrincipale(BasePrincipale basePrincipale) {

        this.basePrincipale = basePrincipale;
    }

    public BasePrincipale getBasePrincipale() {

        return this.basePrincipale;
    }

    public Vagues getVagues() {

        return this.vaguesDeJeu;
    }

    public IntegerProperty getVague() {

        return this.vague;
    }
}
