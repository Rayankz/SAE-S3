package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class StrategyVague2 extends StrategyVague {

    public StrategyVague2() {

        super(8, 6, 0);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        if (nbrTour % 15 == 0) {

            this.getStrategyFabriqueChangeante().choixDeLaFabrique(this.getSoldat1(), this.getSoldat2(), this.getSoldat3(), this.getNbrSpawnsType1(), this.getNbrSpawnsType2(), this.getNbrSpawnsType3(), environnement, 9, 9, 0, this);
        }
    }
}
