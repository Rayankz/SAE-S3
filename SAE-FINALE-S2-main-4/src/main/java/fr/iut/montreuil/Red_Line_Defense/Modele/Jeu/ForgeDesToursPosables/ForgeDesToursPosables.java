package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners.TourPlacementErrorListener;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ForgeDesToursPosables {
    private Environnement environnement;
    private FabriqueSimple fabriqueSimple;
    private TourPlacementErrorListener errorListener;

    public ForgeDesToursPosables(Environnement environnement, FabriqueSimple fabriqueSimple, TourPlacementErrorListener errorListener) {

        this.fabriqueSimple = fabriqueSimple;
        this.environnement = environnement;
        this.errorListener = errorListener;
    }
    public void fabriquerTourPosable(String type, int x, int y) {

        Tour tour = this.fabriqueSimple.créerTourPosable(type, x, y, this.environnement);
        if (tour != null) {

            this.environnement.ajouterTourPosable(tour);
            this.environnement.getJoueur().débiterSolde(tour.getPrixValue());
        }
        else {

            System.err.println("La tour n'a pas pu être créée pour le type : " + type);
        }
    }

    public Tour rechercheDeTourPosable(String type, int x, int y) {

        return this.fabriqueSimple.créerTourPosable(type, x, y, this.environnement);
    }

    public boolean conditionsTourPosable(double x, double y) {

        int mapX = (int) x / 8; int mapY = (int) y / 8;

        // La position de départ pour la vérification de l'entourage
        int startX = mapX - 3; int startY = mapY - 3;

        // Vérifier si la case est valide et si elle est libre
        if (this.environnement.getBFS().valeurDeLaCase(mapY, mapX) == 1) {

            this.errorListener.onCheminError(x, y);
        }
        else {
            if (mapX >= 0 && mapX < this.environnement.getBFS().getXmax() && mapY >= 0 && mapY < this.environnement.getBFS().getYmax()) {
                // Vérifier si aucune tour n'est déjà positionnée sur cette case ou sur les cases entourant celle-ci
                for (int i = startX; i <= startX + 6; i++) {

                    for (int j = startY; j <= startY + 6; j++) {

                        if (i >= 0 && i < this.environnement.getBFS().getXmax() && j >= 0 && j < this.environnement.getBFS().getYmax()) {

                            for (Tour tour : this.environnement.getTours()) {

                                if (((int) (tour.getX0Value() / 8) == i) && ((int) (tour.getY0Value() / 8) == j)) {

                                    System.out.println("Tour deja posée sur " + tour.getX0Value() + " (" + ((int) tour.getX0Value() / 8) + ") " + tour.getY0Value() + " (" + ((int) tour.getY0Value() / 8) + ") ");
                                    return false; // Une tour est déjà positionnée sur cette case ou sur une case entourée
                                }
                            }
                        }
                    }
                }
                return true; // La case et ses cases environnantes sont libres et aucune tour n'est positionnée dessus
            }
        }
        return false; // La case est invalide ou déjà occupée par une tour ou une case environnante est occupée par une tour
    }
}
