package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.ArrayList;
import java.util.Iterator;

public class ToursDefensive extends Tour {
    private final ArrayList<Soldat> soldatsPiégés;

    public ToursDefensive(int x0, int y0, Environnement terrain) {
        super(x0, y0, 1500, 3, 600,200, terrain, 100);
        soldatsPiégés = new ArrayList<>();
    }

    @Override
    public void agit(int n) {
        for (Soldat s: terrain.getSoldats()) {
            if (s != null) {
                s.estPiégés();
                soldatsPiégés.add(s);
            }
        }
        if (!soldatsPiégés.isEmpty()) {
            Iterator<Soldat> iterator = soldatsPiégés.iterator();
            while (iterator.hasNext()) {
                Soldat sP = iterator.next();
                if (!vérificationEstÀPorter(getX0Value(),getY0Value(),sP.getX0Value(), sP.getY0Value(),getPortee())) {
                    sP.libéré();
                    iterator.remove();
                }
            }
        }
    }

}
