package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.FabriquesDesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues.StrategyVague;

import java.util.ArrayList;
import java.util.Random;

public class StrategyFabriqueChangeante {

    private ArrayList<FabriqueSoldats> toutesLesFabriques;

    public StrategyFabriqueChangeante() {

        this.toutesLesFabriques = new ArrayList<>();
        this.toutesLesFabriques.add(new FabriqueRookies());
        this.toutesLesFabriques.add(new FabriqueSuperNovas());
        this.toutesLesFabriques.add(new FabriqueShichibukais());
    }

    public void choixDeLaFabrique(int soldat1, int soldat2, int soldat3, int soldat1ASpawn, int soldat2ASpawn, int soldat3ASpawn, Environnement environnement, int spawn1, int spawn2, int spawn3, StrategyVague s) {

        if (soldat1 < soldat1ASpawn) {

            System.out.println("Un nouveau Rookie apparait !");
            spawnSoldat(spawn1, this.toutesLesFabriques.get(0), environnement); //nouveauSpawnSoldat(1, 16, environnement);
            s.incrSoldat1();
        }
        else if (soldat2 < soldat2ASpawn) {

            System.out.println("Un nouveau Super Nova apparait !");
            spawnSoldat(spawn2, this.toutesLesFabriques.get(1), environnement); //nouveauSpawnSoldat(2, 16, environnement);
            s.incrSoldat2();
        }
        else if (soldat3 < soldat3ASpawn) {

            System.out.println("Un nouveau Shichibukai apparait !");
            spawnSoldat(spawn3, this.toutesLesFabriques.get(2), environnement); //nouveauSpawnSoldat(3, 9, environnement);
            s.incrSoldat3();
        }
    }

    public int[] randomSelection(int i) {

        int[] résultat = new int[4];

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

        résultat[0] = randomStartPosition[0];
        résultat[1] = randomStartPosition[1];
        résultat[2] = randomDestPosition[0];
        résultat[3] = randomDestPosition[1];

        return résultat;
    }

    public void fabriquerSoldat(double startX, double startY, FabriqueSoldats fabriqueSoldats, Environnement environnement) {

        Soldat soldat = fabriqueSoldats.créerSoldat(startX, startY, environnement);
        environnement.ajouterSoldat(soldat);
    }

    public void spawnSoldat(int spawn, FabriqueSoldats fabriqueSoldats, Environnement environnement) {

        int[] randomSelection = randomSelection(spawn);
        int startX = randomSelection[0] * 8;
        int startY = randomSelection[1] * 8;

        fabriquerSoldat(startX, startY, fabriqueSoldats, environnement);
    }
}

