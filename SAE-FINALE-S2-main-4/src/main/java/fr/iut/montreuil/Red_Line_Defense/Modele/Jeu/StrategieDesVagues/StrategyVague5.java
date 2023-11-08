package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class StrategyVague5 extends StrategyVague {

    public StrategyVague5() {

        super(11, 9, 5);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        if (nbrTour % 9 == 0) {

            if ((getSoldat1() < this.getNbrSpawnsType1()) || (getSoldat2() < this.getNbrSpawnsType2()) || (getSoldat3() < this.getNbrSpawnsType3())) {

                this.getStrategyFabriqueChangeante().choixDeLaFabrique(this.getSoldat1(), this.getSoldat2(), this.getSoldat3(), this.getNbrSpawnsType1(), this.getNbrSpawnsType2(), this.getNbrSpawnsType3(), environnement, 16, 16, 9);
            }
        }
    }
}
