package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class StrategyVague1 extends StrategyVague {

    public StrategyVague1() {

        super(12, 0, 0);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        if ((nbrTour % 20 == 0) && (getSoldat1() < this.getNbrSpawnsType1())) {

            System.out.println("Un nouveau Soldat Apparait !");
            nouveauSpawnSoldat(1,9, environnement);
            incrSoldat1();
        }
    }
}
