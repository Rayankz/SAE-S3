package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.FabriquesDesSoldats.StrategyFabriqueChangeante;

public abstract class StrategyVague extends Strategy {

    private final int nbrSpawnsType1, nbrSpawnsType2, nbrSpawnsType3;
    private int soldat1, soldat2, soldat3;
    private StrategyFabriqueChangeante strategyFabriqueChangeante;

    public StrategyVague(int nbrSpawnsType1, int nbrSpawnsType2, int nbrSpawnsType3) {

        this.nbrSpawnsType1 = nbrSpawnsType1;
        this.nbrSpawnsType2 = nbrSpawnsType2;
        this.nbrSpawnsType3 = nbrSpawnsType3;
        this.soldat1 = 0; this.soldat2 = 0; this.soldat3 = 0;
        this.strategyFabriqueChangeante = new StrategyFabriqueChangeante();
    }
    public abstract void faireApparaitreEnnemi(int nbrTour, Environnement environnement);

    public int getNbrSpawnsType1() {

        return this.nbrSpawnsType1;
    }


    public int getNbrSpawnsType2() {

        return this.nbrSpawnsType2;
    }

    public int getNbrSpawnsType3() {

        return this.nbrSpawnsType3;
    }

    public int getTotalSoldats() {

        return getNbrSpawnsType1() + getNbrSpawnsType2() + getNbrSpawnsType3();
    }

    public int getSoldat1() {

        return this.soldat1;
    }

    public int getSoldat2() {

        return this.soldat2;
    }

    public int getSoldat3() {

        return this.soldat3;
    }

    public void incrSoldat1() {

        this.soldat1++;
    }

    public void incrSoldat2() {

        this.soldat2++;
    }

    public void incrSoldat3() {

        this.soldat3++;
    }

    public StrategyFabriqueChangeante getStrategyFabriqueChangeante() {

        return this.strategyFabriqueChangeante;
    }
}
