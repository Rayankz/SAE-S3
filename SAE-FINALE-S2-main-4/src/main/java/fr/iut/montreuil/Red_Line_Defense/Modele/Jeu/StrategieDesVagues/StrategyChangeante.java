package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class StrategyChangeante implements Strategy {
    private ArrayList<StrategyVague> toutesLesVagues;
    private Environnement environnement;
    private IntegerProperty vagueCourante;

    public StrategyChangeante(Environnement environnement) {

        this.environnement = environnement;
        this.toutesLesVagues = new ArrayList<>();
        this.toutesLesVagues.add(new StrategyVague1());
        this.toutesLesVagues.add(new StrategyVague2());
        this.toutesLesVagues.add(new StrategyVague3());
        this.toutesLesVagues.add(new StrategyVague4());
        this.toutesLesVagues.add(new StrategyVague5());
        this.vagueCourante = new SimpleIntegerProperty(4);
    }
    public IntegerProperty getVagueCourante() {

        return this.vagueCourante;
    }
    public IntegerBinding getVagueCourante2() {

        return this.vagueCourante.add(1);
    }

    public void setVagueCourante(int vagueCourante) {

        this.vagueCourante.set(vagueCourante);
    }

    @Override
    public void faireApparaitreEnnemi(int nbrTour, Environnement environnement) {
        if ( vagueCourante.get() < 4 && this.environnement.getEnnemisTuesCetteVague() == this.toutesLesVagues.get(this.vagueCourante.get()).getTotalSoldats()) {

            this.setVagueCourante(this.vagueCourante.get() + 1);
            this.environnement.setEnnemisTuesCetteVague(0);
        }
        if (vagueCourante.get() <5)
            this.toutesLesVagues.get(this.vagueCourante.get()).faireApparaitreEnnemi(this.environnement.getNbrTours(), this.environnement);

    }


}
