package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueShichibukais implements FabriqueSoldats {

    public FabriqueShichibukais() {

    }
    public Soldat créerSoldat(double startX, double startY, Environnement environnement) {

        return new Shichibukais((int) startX, (int) startY, 89, 49, environnement);
    }
}
