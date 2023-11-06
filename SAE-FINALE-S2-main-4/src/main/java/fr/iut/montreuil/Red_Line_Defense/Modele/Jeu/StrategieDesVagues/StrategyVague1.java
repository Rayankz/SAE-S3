package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

public class StrategyVague1 extends StrategyVague {

    public StrategyVague1(ForgeSoldats forgeSoldats) {

        super(12, 0, 0, forgeSoldats);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        if ((nbrTour % 20 == 0) && (getSoldat1() < this.getNbrSpawnsType1())) {

            System.out.println("Un nouveau Soldat Apparait !");
            this.getForgeSoldats().spawnSoldat(9);
            incrSoldat1();
        }
    }
}
