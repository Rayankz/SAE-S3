package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.Random;

public class StrategyVague2 extends StrategyVague {

    public StrategyVague2() {

        super(8, 6, 0);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        int soldat1 = 0; int soldat2 = 0;

        Random random = new Random();

        if (nbrTour % 15 == 0) {

            if ((soldat1 < this.getNbrSpawnsType1()) || (soldat2 < this.getNbrSpawnsType2())) {

                int soldierTypeToSpawn = random.nextInt(2) + 1; // Cela génère soit un soldat de type 1 ou 2.

                if ((soldierTypeToSpawn == 1) && (soldat1 < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 9, environnement);
                    soldat1++;
                }
                else if ((soldierTypeToSpawn == 2) && (soldat2 < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 9, environnement);
                    soldat2++;
                }
            }
        }
    }
}
