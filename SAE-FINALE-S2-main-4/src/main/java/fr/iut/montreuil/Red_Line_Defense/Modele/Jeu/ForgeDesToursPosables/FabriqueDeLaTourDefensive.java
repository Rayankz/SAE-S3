package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.ToursDefensive;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueDeLaTourDefensive extends FabriqueDesToursPosables {

    public FabriqueDeLaTourDefensive(Environnement environnement) {

        super(environnement);
    }

    @Override
    public Tour créerTourPosable(int x, int y) {

        return new ToursDefensive(x, y, this.getEnvironnement());
    }
}
