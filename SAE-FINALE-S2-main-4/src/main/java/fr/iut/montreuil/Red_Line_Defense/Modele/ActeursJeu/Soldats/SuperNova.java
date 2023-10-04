package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class SuperNova extends Soldat {

    public SuperNova(int x0, int y0, int x1, int y1, Environnement e) {
        super(x0, y0, 5000, 300, 20,  250, x1, y1,e);
        this.couleur = "Vert";
    }
}
