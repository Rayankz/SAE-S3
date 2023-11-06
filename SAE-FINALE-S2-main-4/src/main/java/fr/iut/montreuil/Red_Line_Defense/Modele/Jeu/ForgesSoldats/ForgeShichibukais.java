package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeShichibukais extends ForgeSoldats {

    public ForgeShichibukais(Environnement environnement) {

        super(environnement);
    }

    public void fabriquerShichibukais(double startX, double startY) {

        Soldat shichibukais = new Shichibukais((int) startX, (int) startY, 89, 49, this.getEnvironnement());
        this.getEnvironnement().ajouterSoldat(shichibukais);
    }
}
