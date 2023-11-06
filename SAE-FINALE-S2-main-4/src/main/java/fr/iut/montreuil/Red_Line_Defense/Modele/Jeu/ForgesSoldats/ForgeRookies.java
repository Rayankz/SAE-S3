package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeRookies extends ForgeSoldats{

    public ForgeRookies(Environnement environnement) {

        super(environnement);
    }

    public void fabriquerRookies(double startX, double startY) {

        Soldat rookie = new Rookie((int) startX, (int) startY, 89, 49, this.getEnvironnement());
        this.getEnvironnement().ajouterSoldat(rookie);
    }
}
