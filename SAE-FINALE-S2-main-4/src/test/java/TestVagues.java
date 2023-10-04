import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourLanceMissile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVagues {

    private Vagues vagues;

    @BeforeEach
    public void setUp() {
        // Initialisation de l'environnement avant chaque test
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        Environnement environnement = new Environnement(joueur);
        vagues = new Vagues(environnement);
    }

    @Test
    public void testResetTours() {
        Tour tour1 = new TourLanceMissile(250, 200, vagues.getEnvironnement());
        tour1.setPointsDeVieValue(10);
        Tour tour2 = new TourSniper(150, 100, vagues.getEnvironnement());
        tour2.setPointsDeVieValue(5);
        vagues.getEnvironnement().ajouterTour(tour1);
        vagues.getEnvironnement().ajouterTour(tour2);

        // When
        vagues.resetTours();

        // Then
        int sumPointsDeVie = 0;
        for (Tour tour : vagues.getEnvironnement().getTours()) {
            sumPointsDeVie += tour.getPointsDeVieValue();
        }
        Assertions.assertEquals(0, sumPointsDeVie);
    }

    @Test
    public void testSelectionSoldat() {

        Soldat actualSoldat=vagues.selectionSoldat(2, 10, 20);


        assertEquals(actualSoldat.getClass(), SuperNova.class);
        Assertions.assertEquals(10, actualSoldat.getX0Value());
        Assertions.assertEquals(20, actualSoldat.getY0Value());
    }

    @Test
    public void testAfficherSoldat(){
        vagues.afficherSoldat(2, 10, 20);
        Assertions.assertEquals(1, vagues.getListeSoldats());
    }

    @Test
    public void testMajDefenseSoldats(){
        Soldat s = vagues.afficherSoldat(2, 10, 20);
        int solHP = s.getPointsDeVieValue();
        vagues.majDefenseSoldats();

        Assertions.assertEquals(s.getPointsDeVieValue(), solHP-5);
    }

}
