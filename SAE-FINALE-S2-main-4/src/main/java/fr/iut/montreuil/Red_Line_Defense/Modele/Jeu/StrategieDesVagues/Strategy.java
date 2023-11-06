package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;

public abstract class Strategy {
    private ForgeSoldats forgeSoldats;

    public Strategy(ForgeSoldats forgeSoldats) {

        this.forgeSoldats = forgeSoldats;
    }
    public ForgeSoldats getForgeSoldats() {

        return this.forgeSoldats;
    }
}
