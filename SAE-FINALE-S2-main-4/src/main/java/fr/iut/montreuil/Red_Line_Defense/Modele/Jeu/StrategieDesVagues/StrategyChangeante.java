package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

import java.util.ArrayList;

public class StrategyChangeante extends Strategy {
    private ArrayList<StrategyVague> toutesLesVagues;
    private Environnement environnement;
    private int vagueCourante;

    public StrategyChangeante(Environnement environnement, ForgeSoldats forgeSoldats) {

        super(forgeSoldats);
        this.environnement = environnement;
        this.toutesLesVagues = new ArrayList<>();
        this.toutesLesVagues.add(new StrategyVague1(forgeSoldats));
        this.toutesLesVagues.add(new StrategyVague2(forgeSoldats));
        this.toutesLesVagues.add(new StrategyVague3(forgeSoldats));
        this.toutesLesVagues.add(new StrategyVague4(forgeSoldats));
        this.toutesLesVagues.add(new StrategyVague5(forgeSoldats));
        this.vagueCourante = 0;

    }
    public void choixDeLaVague() {

        if (this.environnement.getEnnemisTuesCetteVague() == this.toutesLesVagues.get(this.vagueCourante).getTotalSoldats()) {

            this.vagueCourante++;
            this.environnement.setEnnemisTuesCetteVague(0);
        }
        this.toutesLesVagues.get(this.vagueCourante).faireApparaitreEnnemi(this.environnement.getNbrTours(), this.environnement);
    }
    public ArrayList<StrategyVague> getToutesLesVagues() {

        return this.toutesLesVagues;
    }
}
