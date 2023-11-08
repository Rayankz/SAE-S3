package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.FabriquesDeSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueRookies implements FabriqueSoldats {

    public FabriqueRookies() {

    }
    @Override
    public Soldat créerSoldat(double startX, double startY, Environnement environnement) {

        return new Rookie((int) startX, (int) startY, 89, 49, environnement);
    }
}
