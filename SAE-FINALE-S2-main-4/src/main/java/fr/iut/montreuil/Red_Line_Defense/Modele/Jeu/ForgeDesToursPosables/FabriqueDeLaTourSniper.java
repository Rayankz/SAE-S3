package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourSniper extends FabriqueDesToursPosables {

    public FabriqueDeLaTourSniper(Environnement environnement) {

        super(environnement);
    }
    @Override
    public Tour créerTourPosable(int x, int y) {

        return new TourSniper(x, y, this.getEnvironnement());
    }
}
