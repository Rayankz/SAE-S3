package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourMitrailleuse extends ToursOffensives {
    public TourMitrailleuse(int x0, int y0, Environnement environnement) {
        super(x0, y0, 800, 100, 5, 400, environnement, 1,800, 75, "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sorcierPosable.png",new ForgeProjectilesSimple(environnement));
    }
}
