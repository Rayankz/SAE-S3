package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.FabriquesDesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class FabriqueSuperNovas implements FabriqueSoldats {

    public FabriqueSuperNovas() {

    }
    @Override
    public Soldat créerSoldat(double startX, double startY, Environnement environnement) {

        return new SuperNova((int) startX, (int) startY, 89, 49, environnement);
    }
}
