package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Shichibukais extends Soldat {

    public Shichibukais(int x0, int y0, int x1, int y1,Environnement e) {
        super(x0, y0, 2500, 300, 20, 250, x1, y1, e);
        this.couleur = "Violet";// Ennemi True car ce sera un Soldat exclusivement Ennemi
    }
}
