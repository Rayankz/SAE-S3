package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;


import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Environnement terrain) {

        super(x0, y0, 500, 500, 5, 600, terrain, 5,1000,200, "/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sniperPosable.png"); // 50 tirs par minutes
    }

}
