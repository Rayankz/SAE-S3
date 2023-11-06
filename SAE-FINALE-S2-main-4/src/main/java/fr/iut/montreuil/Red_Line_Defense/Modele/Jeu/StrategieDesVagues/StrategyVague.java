package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.Random;

public abstract class StrategyVague extends Strategy {

    private int nbrSpawnsType1;
    private int nbrSpawnsType2;
    private int nbrSpawnsType3;

    public StrategyVague(int nbrSpawnsType1, int nbrSpawnsType2, int nbrSpawnsType3) {

        this.nbrSpawnsType1 = nbrSpawnsType1;
        this.nbrSpawnsType2 = nbrSpawnsType2;
        this.nbrSpawnsType3 = nbrSpawnsType3;
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

    public Soldat nouveauSpawnSoldat(int typeSoldat, int spawn, Environnement environnement) {

        int[] randomSelection = randomSelection(spawn);
        int startX = randomSelection[0] * 8;
        int startY = randomSelection[1] * 8;

        Soldat soldat = afficherSoldat(startX, startY,typeSoldat, environnement);
        return soldat;
    }

    public Soldat afficherSoldat(double startX, double startY, int typeSoldat, Environnement environnement) {

        Soldat s = selectionSoldat(typeSoldat, startX, startY, environnement);
        environnement.getSoldatsProperty().add(s);

        return s;
    }

    public Soldat selectionSoldat(int typeSoldat, double startX, double startY, Environnement environnement) {

        Soldat s;

        switch(typeSoldat) {
            case 1:
                s = new Rookie((int) startX, (int) startY, 89, 49, environnement);
                break;
            case 2:
                s = new SuperNova((int) startX, (int) startY, 89, 49, environnement);
                break;
            case 3:
                s = new Shichibukais((int) startX, (int) startY, 89, 49, environnement);
                break;
            default:
                s = new Rookie((int) startX, (int) startY, 89, 49, environnement);
        }

        return s;
    }

    public int[] randomSelection(int i) {

        int[] resultat = new int[4];

        // 0-9 10-16

        int[][] possibleStartPositions = {
                {14, 57},
                {15, 57},
                {16, 57},
                {0, 42},
                {0, 41},
                {0, 43},
                {0, 19},
                {0, 18},
                {9, 1},
                {8, 1},
                {44, 59},
                {45, 58},
                {44, 57},
                {82, 0},
                {83, 0},
                {81, 1},
                {82, 2}
        };

        int[][] possibleDestPositions = {
                {89, 49}
        };

        Random random = new Random();

        int[] randomStartPosition = possibleStartPositions[random.nextInt(i)];
        int[] randomDestPosition = possibleDestPositions[random.nextInt(possibleDestPositions.length)];

        resultat[0] = randomStartPosition[0];
        resultat[1] = randomStartPosition[1];
        resultat[2] = randomDestPosition[0];
        resultat[3] = randomDestPosition[1];

        return resultat;
    }
}
