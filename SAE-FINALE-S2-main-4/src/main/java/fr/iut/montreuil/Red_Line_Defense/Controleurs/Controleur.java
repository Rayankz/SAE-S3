package fr.iut.montreuil.Red_Line_Defense.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners.*;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Audio;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.FabriqueSoldats;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgesSoldats.ForgeSoldats;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Inputs;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.Vues.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private static final int TAILLE_IMAGE = 8;
    public static final String OST_JEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/ostJeu.mp3";
    public static final String DEFAITE = "/fr/iut/montreuil/Red_Line_Defense/Sons/gameOver.mp3";

    @FXML
    private Pane centerPane;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label ennemisTues, pointVieBase;

    @FXML
    Label solde, vague;

    @FXML
    ImageView wpp, berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b;

    @FXML
    StackPane stackpane;

    @FXML
    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;
    @FXML
    VBox vboxRight;

    @FXML
    private Button lancerButton, test;

    private Joueur joueur;
    private VueInterface vueInterface;

    private EcouteSoldats ecouteSoldats;
    private EcouteTours ecouteTours;

    private EcouteBasePrincipale ecouteBasePrincipale;

    private EcouteInterface ecouteInterface;

    private Inputs inputs;

    private EcouteProjectiles ecouteProjectiles;

    private Environnement terrain;
    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;

    private BasePrincipale basePrincipale;

    private EcouteVictoireEtDefaite ecouteVictoireEtDefaite;

    private VueBasePrincipale vueBasePrincipale;
    private ForgeSoldats forgeSoldats;
    private FabriqueSoldats fabriqueSoldats;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // coucou madame pour lancer le jeu appuyez sur P :)
        this.centerPane.getChildren().add(new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/map.png")));
        initializeJoueur();
        initializeEnvironnement();
        initializeVueTours();
        initializeVueSoldats();
        initializeGameLoop();
        initializeVueInterface();
        initializeVueProjectile();
        initializeEcouteVictoireEtDefaite();
        initializeSons();
        initializeBasePrincipale();
        initializeVueBasePrincipale();


        this.terrain.setBasePrincipale(this.basePrincipale);
    }

    public Stage getStage() {

        Stage stage = (Stage) solde.getScene().getWindow();
        return stage;
    }

    public Scene getScene() {

        Scene scene = solde.getScene();
        return scene;
    }

    public BorderPane getBorderPane() {

        BorderPane borderPane = new BorderPane();
        return borderPane;
    }

    private void initializeEcouteVictoireEtDefaite() {

        ecouteVictoireEtDefaite = new EcouteVictoireEtDefaite(terrain, vueInterface, this);
    }

    private void initializeJoueur() {

        this.joueur = new Joueur("Arsan");
    }

    private void initializeSons() {

        Media mediaJeu = new Media(getClass().getResource(OST_JEU_PATH).toString());
        Audio.chargerMedia(mediaJeu);
    }

    public void initializeInputs() {

        inputs = new Inputs(gameLoop, centerPane.getScene());
        inputs.pauseDuJeu();
    }

    private void initializeVueInterface() {

        this.vueInterface = new VueInterface(terrain, lancerButton, test, solde, berry, ennemisTues, prix200b, prix800b, prix600b, prix400b,
                berryBot200b, berryBot400b, berryBot600b, berryBot800b, vboxRight, wpp, stackpane, getScene(), getBorderPane(),
                vague);
        this.ecouteInterface = new EcouteInterface(this.terrain, this.vueInterface);
    }

    private void initializeEnvironnement() {

        this.forgeSoldats = forgeSoldats; this.fabriqueSoldats = fabriqueSoldats;
        this.terrain = new Environnement(this.joueur, this.forgeSoldats, this.fabriqueSoldats);
    }

    private void initializeBasePrincipale() {

        basePrincipale = new BasePrincipale(700, 335,terrain);
    }

    private void initializeVueBasePrincipale() {

        vueBasePrincipale = new VueBasePrincipale(centerPane, basePrincipale);
        this.ecouteBasePrincipale = new EcouteBasePrincipale(this.vueBasePrincipale, this.gameLoop);
    }

    private void initializeVueTours() {

        this.vueTours = new VueTours(this.terrain, this.centerPane);
        this.ecouteTours = new EcouteTours(this.terrain, this.centerPane);
    }

    private void initializeVueSoldats() {

        this.vueSoldats = new VueSoldats(this.centerPane);
        this.ecouteSoldats = new EcouteSoldats(this.terrain, this.vueSoldats);
    }

    private void initializeVueProjectile() {

        this.ecouteProjectiles = new EcouteProjectiles(this.terrain, this.centerPane);
    }

    private void initializeGameLoop() {

        this.gameLoop = new GameLoop(this.centerPane, this.vueSoldats, this.terrain);
    }

    public GameLoop getGameLoop() {

        return this.gameLoop;
    }

    public void positionTour(MouseEvent event) {

        this.vueTours.positionTour(event);
    }

    public void selectionTour(MouseEvent event) {

        this.vueTours.selectionTour(event);
    }

    private Image loadImage(String path) {

        return new Image(getClass().getResourceAsStream(path));
    }
}
