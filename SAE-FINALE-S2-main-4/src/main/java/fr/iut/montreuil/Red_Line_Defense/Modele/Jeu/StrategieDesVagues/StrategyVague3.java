package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueRookies;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueSuperNovas;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

import java.util.Random;

public class StrategyVague3 extends StrategyVague {

    public StrategyVague3() {

        super(10, 8, 0);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        Random random = new Random();
        ForgeSoldats f1 = new ForgeSoldats(environnement, new FabriqueRookies());
        ForgeSoldats f2 = new ForgeSoldats(environnement, new FabriqueSuperNovas());

        if (nbrTour % 12 == 0) {

            if ((getSoldat1() < this.getNbrSpawnsType1()) || (getSoldat2() < this.getNbrSpawnsType2())) {

                int soldierTypeToSpawn = random.nextInt(2) + 1; // Cela génère soit un soldat de type 1 ou 2.

                if ((soldierTypeToSpawn == 1) && (getSoldat2() < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    f1.spawnSoldat(12); //nouveauSpawnSoldat(1, 12, environnement);
                    incrSoldat1();
                }
                else if ((soldierTypeToSpawn == 2) && (getSoldat2() < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    f2.spawnSoldat(12); //nouveauSpawnSoldat(2, 12, environnement);
                    incrSoldat2();
                }
            }
        }
    }
}
