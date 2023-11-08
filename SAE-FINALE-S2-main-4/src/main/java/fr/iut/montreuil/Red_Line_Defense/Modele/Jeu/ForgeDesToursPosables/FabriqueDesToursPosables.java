package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public abstract class FabriqueDesToursPosables {

    private Environnement environnement;

    public FabriqueDesToursPosables(Environnement environnement) {

        this.environnement = environnement;
    }

    public abstract Tour créerTourPosable(int x, int y);

    public void fabriquerTourPosable(int x, int y) {

        Tour tour = créerTourPosable(x, y);
        this.environnement.ajouterTourPosable(tour);
        this.environnement.getJoueur().debiterSolde(tour.getPrixValue());
    }
    public Environnement getEnvironnement() {

        return this.environnement;
    }
}
