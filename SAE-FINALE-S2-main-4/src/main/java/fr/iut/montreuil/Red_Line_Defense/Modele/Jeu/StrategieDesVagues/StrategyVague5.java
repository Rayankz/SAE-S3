package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

import java.util.Random;

public class StrategyVague5 extends StrategyVague {

    public StrategyVague5(ForgeSoldats forgeSoldats) {

        super(11, 9, 5, forgeSoldats);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {

        Random random = new Random();

        if (nbrTour % 9 == 0) {

            if ((getSoldat1() < this.getNbrSpawnsType1()) || (getSoldat2() < this.getNbrSpawnsType2()) || (getSoldat3() < this.getNbrSpawnsType3())) {

                int soldierTypeToSpawn = random.nextInt(3) + 1; // Cela générera soit 1, soit 2 ou 3

                if ((soldierTypeToSpawn == 1) && (getSoldat1() < this.getNbrSpawnsType1())) {

                    System.out.println("Un nouveau Rookie apparait !");
                    this.getForgeSoldats().spawnSoldat(16);
                    incrSoldat1();
                }
                else if ((soldierTypeToSpawn == 2) && (getSoldat2() < this.getNbrSpawnsType2())) {

                    System.out.println("Un nouveau Super Nova apparait !");
                    this.getForgeSoldats().spawnSoldat(16);
                    incrSoldat2();
                }
                else if ((soldierTypeToSpawn == 3) && (getSoldat3() < this.getNbrSpawnsType3())) {

                    System.out.println("Un nouveau Shichibukai apparait !");
                    this.getForgeSoldats().spawnSoldat(9);
                    incrSoldat3();
                }
            }
        }
    }
}
