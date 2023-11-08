package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourMitrailleuse;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourMitrailleuse implements FabriqueDesToursPosables {

    public FabriqueDeLaTourMitrailleuse() {


    }

    @Override
    public Tour créerTour(int x, int y, Environnement environnement) {

        return new TourMitrailleuse(x, y , environnement);
    }
}
