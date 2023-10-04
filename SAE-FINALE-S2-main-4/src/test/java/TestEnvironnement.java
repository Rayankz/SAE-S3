import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnvironnement {

    private Environnement environnement;

    @BeforeEach
    public void setUp() {
        // Initialisation de l'environnement avant chaque test
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        environnement = new Environnement(joueur);
    }

    @Test
    public void testVagueIncrement() {
        // Teste si la vague s'incrémente correctement
        assertEquals(1, environnement.getVagueValue());
        environnement.checkNouvelleVagues();
        assertEquals(2, environnement.getVagueValue());
    }

    @Test
    public void testEnnemisTues() {
        // Teste le nombre d'ennemis tués
        assertEquals(0, environnement.getEnnemisTuesValue());
        environnement.verificationMorts();
        assertEquals(0, environnement.getEnnemisTuesValue());

        Soldat rookie = new Rookie(15, 15, 15, 15);
        environnement.ajouterSoldat(rookie);
        rookie.setPointsDeVieValue(-1);
        environnement.verificationMorts();
        assertEquals(1, environnement.getEnnemisTuesValue());
    }

    @Test
    public void testUnTour() {
        // Teste l'incrémentation du nombre de tours
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        Environnement environnement = new Environnement(joueur);
        BasePrincipale basePrincipale = new BasePrincipale(15, 15);
        environnement.setBasePrincipale(basePrincipale);
        environnement.unTour();
        assertEquals(1, environnement.getNbrTours());
        environnement.unTour();
        assertEquals(2, environnement.getNbrTours());
    }

    @Test
    public void testAjouterSoldat() {
        // Teste l'ajout d'un soldat à l'environnement
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        Environnement environnement = new Environnement(joueur);

        Soldat rookie = new Rookie(15, 15, 15, 15);
        environnement.ajouterSoldat(rookie);

        assertTrue(environnement.getSoldats().contains(rookie));
        assertEquals(1, environnement.getSoldats().size());
    }

    @Test
    public void testSupprimerTour() {
        // Teste la suppression d'une tour de l'environnement
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        Environnement environnement = new Environnement(joueur);

        Tour tour = new TourSniper(15, 15, environnement);
        environnement.ajouterTour(tour);

        assertTrue(environnement.getTours().contains(tour));

        environnement.supprimerTour(tour);

        assertFalse(environnement.getTours().contains(tour));
    }

    @Test
    public void testAjouterProjectile() {
        // Teste l'ajout d'un projectile à l'environnement
        Joueur joueur = new Joueur("Mr. Jean Bonne-Note");
        Environnement environnement = new Environnement(joueur);

        Projectile projectile = new Boulet(15, 15, 15, 15, 1, 100, environnement);
        environnement.ajouterProjectile(projectile);

        assertTrue(environnement.getProjectiles().contains(projectile));
    }
}
