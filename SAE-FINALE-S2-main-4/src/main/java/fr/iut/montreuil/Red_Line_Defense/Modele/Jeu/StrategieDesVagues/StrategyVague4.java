package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueRookies;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueShichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueSuperNovas;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

import java.util.Random;

public class StrategyVague4 extends StrategyVague {

    public StrategyVague4() {

        super(9, 7, 3);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        Random random = new Random();
        ForgeSoldats f1 = new ForgeSoldats(environnement, new FabriqueRookies());
        ForgeSoldats f2 = new ForgeSoldats(environnement, new FabriqueSuperNovas());
        ForgeSoldats f3 = new ForgeSoldats(environnement, new FabriqueShichibukais());

        if (nbrTour % 10 == 0) {

            if ((getSoldat1() < this.getNbrSpawnsType1()) || (getSoldat2() < this.getNbrSpawnsType2()) || (getSoldat3() < this.getNbrSpawnsType3())) {

                int soldierTypeToSpawn = random.nextInt(3) + 1; // Cela génèrera soit 1, soit 2 ou 3 soldats.

                if ((soldierTypeToSpawn == 1) && (getSoldat1() < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    f1.spawnSoldat(16); //nouveauSpawnSoldat(1, 16, environnement);
                    incrSoldat1();
                }
                else if ((soldierTypeToSpawn == 2) && (getSoldat2() < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    f2.spawnSoldat(10); //nouveauSpawnSoldat(2, 10, environnement);
                    incrSoldat2();
                }
                else if ((soldierTypeToSpawn == 3) && (getSoldat3() < this.getNbrSpawnsType3())) {

                    System.out.println("Un nouveau Shichibukai apparait !");
                    f3.spawnSoldat(9); //nouveauSpawnSoldat(3, 9, environnement);
                    incrSoldat3();
                }
            }
        }
    }
}
