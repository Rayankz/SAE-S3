package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourLanceMissile;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourLanceMissile implements FabriqueDesToursPosables {

    public FabriqueDeLaTourLanceMissile() {


    }

    @Override
    public Tour créerTour(int x, int y, Environnement environnement) {

        return new TourLanceMissile(x, y, environnement);
    }
}
