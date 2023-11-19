package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.StrategieDesVagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public interface Strategy {

    void faireApparaitreEnnemi(int nbrTour, Environnement environnement);
}
