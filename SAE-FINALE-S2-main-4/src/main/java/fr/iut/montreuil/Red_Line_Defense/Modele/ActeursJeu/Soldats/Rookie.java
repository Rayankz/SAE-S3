package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class Rookie extends Soldat {

    public Rookie(int x0, int y0, int x1, int y1, Environnement e) {
        super(x0, y0, 1000, 300, 20, 100, x1, y1,e );
        this.couleur = "Bleu";// Ennemi True car ce sera un Soldat exclusivement Ennemi
    }
}
