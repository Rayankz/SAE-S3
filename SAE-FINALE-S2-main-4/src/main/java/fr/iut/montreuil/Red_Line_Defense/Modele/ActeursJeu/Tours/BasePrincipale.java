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

    public BasePrincipale(int x0, int y0, Environnement e) {
        super(x0, y0, 10000,e); // 2 tiles de portéé
         zone = new HashSet<>();
         initializeZone();
    }

    public void agit(int n) {

        if (porteeBP() != null) {

            this.setPointsDeVieValue(this.getPointsDeVieValue() - this.porteeBP().getDegatValue());
            System.out.println("---pv base : " + this.getPointsDeVieValue());
            for (Soldat s: this.getTerrain().getSoldatsProperty().getValue()) {

                Point2D positionSoldat = new Point2D(s.getX0Value()/8, s.getY0Value()/8);

                if (getZone().contains(positionSoldat)) {

                    infligerDegats(300);
                    s.setPointsDeVieValue(-1);
                }
            }
        }
    }


    private void initializeZone() {

        for (int x = 88; x <= 90; x++) {

            for (int y = 47; y <= 49; y++) {

                this.zone.add(new Point2D(x, y));
            }
        }
    }

    public Set<Point2D> getZone(){

        return zone;
    }

    public Soldat porteeBP() {
            System.out.println("entrer fonction");
            for (Soldat s : this.getTerrain().getSoldats()) {
                System.out.println("entrer boucle");
                if (s.estVivant()) {
                    System.out.println("vivant");
                    double distanceY = Math.abs(s.getY0Value() - getY0Value());
                    System.out.println(distanceY);
                    if (distanceY <= this.getPortée()) {
                        System.out.println("bonne portée");
                        return s;
                    }
                }
            }
            return null;
    }


}
