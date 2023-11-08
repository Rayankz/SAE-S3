package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourLanceMissile;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourLanceMissile extends FabriqueDesToursPosables {

    public FabriqueDeLaTourLanceMissile(Environnement environnement) {

        super(environnement);
    }
    @Override
    public Tour créerTourPosable(int x, int y) {

        return new TourLanceMissile(x, y, this.getEnvironnement());
    }
}
