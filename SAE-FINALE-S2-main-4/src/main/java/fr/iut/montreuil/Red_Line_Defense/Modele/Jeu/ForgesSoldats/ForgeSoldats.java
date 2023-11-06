package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.Random;

public class ForgeSoldats {
    private Environnement environnement;
    private FabriqueSoldats fabriqueSoldats;

    public ForgeSoldats(Environnement environnement, FabriqueSoldats fabriqueSoldats) {

        this.environnement = environnement;
        this.fabriqueSoldats = fabriqueSoldats;
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
    public void fabriquerSoldat(double startX, double startY) {

        Soldat soldat = this.fabriqueSoldats.créerSoldat(startX, startY, this.environnement);
        this.environnement.ajouterSoldat(soldat);
    }
    public void spawnSoldat(int spawn) {

        int[] randomSelection = randomSelection(spawn);
        int startX = randomSelection[0] * 8;
        int startY = randomSelection[1] * 8;

        fabriquerSoldat(startX, startY);
    }
}
