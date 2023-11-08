package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues.StrategyChangeante;

public class Vagues {

    private Environnement environnement;
    private StrategyChangeante strategyChangeante;

    public Vagues(Environnement environnement) {

        this.environnement = environnement;
        this.strategyChangeante = new StrategyChangeante(this.environnement);
    }

    public void unTour() {

        this.strategyChangeante.choixDeLaVague();
    }
    public void majDefenseSoldats() {

        for (Soldat s : this.environnement.getSoldats()) {

            if (s.getPointsDeVieValue() > 5) {

                s.setPointsDeVieValue(s.getPointsDeVieValue() - 5);
            }
        }
    }
    public void resetTours() {

        for (Tour t : this.environnement.getTours()){

            t.setPointsDeVieValue(0);
        }
    }
    public Environnement getEnvironnement() {

        return this.environnement;
    }
}