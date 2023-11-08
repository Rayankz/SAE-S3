package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourMitrailleuse;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourMitrailleuse extends FabriqueDesToursPosables {

    public FabriqueDeLaTourMitrailleuse(Environnement environnement) {

        super(environnement);
    }
    @Override
    public Tour créerTourPosable(int x, int y) {

        return new TourMitrailleuse(x, y , this.getEnvironnement());
    }
}
