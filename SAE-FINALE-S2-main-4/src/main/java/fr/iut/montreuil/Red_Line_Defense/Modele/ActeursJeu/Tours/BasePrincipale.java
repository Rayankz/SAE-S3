package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.geometry.Point2D;

import java.util.HashSet;
import java.util.Set;

public class BasePrincipale extends Tour {


    // C'est la base principale, celle qu'il faudra defendre des soldats ennemis et qui sera en bout de course

    Set<Point2D> zone;

    public BasePrincipale(int x0, int y0, Environnement environnement) {

        super(x0, y0, 200, environnement); // 2 tiles de portée
        this.zone = new HashSet<>();
        this.setPortée(55);
        initializeZone();
    }

    public void agit(int n) {

        if (ennemiÀPorter() != null) {

            this.setPointsDeVieValue(this.getPointsDeVieValue() - this.ennemiÀPorter().getDegatValue());
            System.out.println("---pv base : " + this.getPointsDeVieValue());
            this.ennemiÀPorter().setPointsDeVieValue(-2);
        }
    }


    private void initializeZone() {

        for (int x = 88; x <= 90; x++) {

            for (int y = 47; y <= 49; y++) {

                this.zone.add(new Point2D(x, y));
            }
        }
    }

    public Set<Point2D> getZone() {

        return zone;
    }
}
