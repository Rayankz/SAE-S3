package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeSuperNovas extends ForgeSoldats {

    public ForgeSuperNovas(Environnement environnement) {

        super(environnement);
    }

    public void fabriquerSuperNovas(double startX, double startY) {

        Soldat superNova = new SuperNova((int) startX, (int) startY, 89, 49, this.getEnvironnement());
        this.getEnvironnement().ajouterSoldat(superNova);
    }
}
