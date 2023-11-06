package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.Random;

public class StrategyVague4 extends StrategyVague {

    public StrategyVague4() {

        super(9, 7, 3);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        int soldats1 = 0; int soldats2 = 0; int soldats3 = 0;

        Random random = new Random();

        if (nbrTour % 10 == 0) {

            if ((soldats1 < this.getNbrSpawnsType1()) || (soldats2 < this.getNbrSpawnsType2()) || (soldats3 < this.getNbrSpawnsType3())) {

                int soldierTypeToSpawn = random.nextInt(3) + 1; // Cela génèrera soit 1, soit 2 ou 3 soldats.

                if ((soldierTypeToSpawn == 1) && (soldats1 < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 16, environnement);
                    soldats1++;
                }
                else if ((soldierTypeToSpawn == 2) && (soldats2 < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 10, environnement);
                    soldats2++;
                }
                else if ((soldierTypeToSpawn == 3) && (soldats3 < this.getNbrSpawnsType3())) {

                    System.out.println("Un nouveau Shichibukai apparait !");
                    nouveauSpawnSoldat(3, 9, environnement);
                    soldats3++;
                }
            }
        }
    }
}
