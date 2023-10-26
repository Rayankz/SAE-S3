package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.ArrayList;

public class StrategyChangeante extends Strategy {

    private ArrayList<StrategyVague> toutesLesVagues;
    private Environnement environnement;

    public StrategyChangeante(Environnement environnement) {

        this.environnement = environnement;
        this.toutesLesVagues = new ArrayList<>();
        this.toutesLesVagues.add(new StrategyVague1());
        this.toutesLesVagues.add(new StrategyVague2());
        this.toutesLesVagues.add(new StrategyVague3());
        this.toutesLesVagues.add(new StrategyVague4());
        this.toutesLesVagues.add(new StrategyVague5());

    }

    public void choixDeLaVague() {

        int i = 0;
        if (this.environnement.getEnnemisTuesCetteVague() == this.toutesLesVagues.get(i).getTotalSoldats()) {

            i++;
            this.environnement.setEnnemisTuesCetteVague(0);
        }
        this.toutesLesVagues.get(i).faireApparaitreEnnemi(this.environnement.getNbrTours(), this.environnement);
    }

    public ArrayList<StrategyVague> getToutesLesVagues() {

        return this.toutesLesVagues;
    }
}
