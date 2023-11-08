package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourSniper implements FabriqueDesToursPosables {

    public FabriqueDeLaTourSniper() {


    }

    @Override
    public Tour créerTour(int x, int y, Environnement environnement) {

        return new TourSniper(x, y, environnement);
    }
}
