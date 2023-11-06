package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public abstract class ForgeSoldats {

    private Environnement environnement;

    public ForgeSoldats(Environnement environnement) {

        this.environnement = environnement;
    }

    public Environnement getEnvironnement() {

        return this.environnement;
    }


}
