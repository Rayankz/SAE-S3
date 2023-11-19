package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.*;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueSimple {

    private String type;

    public FabriqueSimple() {

        this.type = "0";
    }
    public Tour créerTourPosable(int x, int y, Environnement environnement) {

        switch(this.type) {
            case "tour800b":

                return new TourLanceMissile(x, y, environnement);
            case "tour400b":

                return new TourMitrailleuse(x, y, environnement);
            case "tour600b":

                return new TourSniper(x, y, environnement);
            case "tour200b":

                return new ToursDefensive(x, y, environnement);
            default:

                throw new IllegalArgumentException("Type de tour non reconnu : " + type);
        }
    }
    public String getType() {

        return this.type;
    }
    public void setType(String type) {

        this.type = type;
    }
}
