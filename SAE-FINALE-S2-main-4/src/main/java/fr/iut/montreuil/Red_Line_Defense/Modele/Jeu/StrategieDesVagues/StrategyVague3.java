package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.Random;

public class StrategyVague3 extends StrategyVague {

    public StrategyVague3() {

        super(10, 8, 0);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        int soldats1 = 0; int soldats2 = 0;

        Random random = new Random();

        if (nbrTour % 12 == 0) {

            if ((soldats1 < this.getNbrSpawnsType1()) || (soldats2 < this.getNbrSpawnsType2())) {

                int soldierTypeToSpawn = random.nextInt(2) + 1; // Cela génère soit un soldat de type 1 ou 2.

                if ((soldierTypeToSpawn == 1) && (soldats1 < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 12, environnement);
                    soldats1++;
                }
                else if ((soldierTypeToSpawn == 2) && (soldats2 < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 12, environnement);
                    soldats2++;
                }
            }
        }
    }
}
