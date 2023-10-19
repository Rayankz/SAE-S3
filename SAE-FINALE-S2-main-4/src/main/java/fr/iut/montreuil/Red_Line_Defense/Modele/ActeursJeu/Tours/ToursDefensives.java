package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.ArrayList;
import java.util.Iterator;

public class ToursDefensives extends Tour{

    private ArrayList<Soldat> soldatsPiégés;
    public ToursDefensives(int x0, int y0, Environnement terrain) {

        super(x0, y0, 1500, 3, 600, 200, terrain, 100);
        this.soldatsPiégés = new ArrayList<>();
    }

    @Override
    public void agit(int n) {

        for (Soldat s: this.terrain.getSoldats()) {

            if (s != null) {

                s.estPiégés();
                this.soldatsPiégés.add(s);
            }
        }
        if (!this.soldatsPiégés.isEmpty()) {

            Iterator<Soldat> iterator = this.soldatsPiégés.iterator();
            while (iterator.hasNext()) {

                Soldat sP = iterator.next();
                if (!vérificationEstÀPorter(sP.getX0Value(), sP.getY0Value())) {

                    sP.libéré();
                    iterator.remove();
                }
            }
        }
    }

    public void suppSoldatPiégés(Soldat s){

        this.soldatsPiégés.remove(s);
    }
}