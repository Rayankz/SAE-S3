public class TestVagues {

    /*private Vagues vagues;

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
    }*/

}
