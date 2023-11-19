package fr.iut.montreuil.Red_Line_Defense.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners.*;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Audio;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables.FabriqueSimple;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.ForgeDesToursPosables.ForgeDesToursPosables;
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
    private Environnement environnement;
    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;
    private BasePrincipale basePrincipale;
    private EcouteVictoireEtDefaite ecouteVictoireEtDefaite;
    private VueBasePrincipale vueBasePrincipale;
    private double dernierClicX = 100;
    private double dernierClicY = 120;

    private ForgeDesToursPosables forgeDesToursPosables;

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

        this.environnement.setBasePrincipale(this.basePrincipale);

        this.centerPane.setOnMouseClicked(event -> {

            setDernierClicX(event.getX());
            setDernierClicY(event.getY());

            System.out.println("clic de souris: x = " + dernierClicX + " y = " + dernierClicY);
        });

        centerPane.setOnMouseClicked(event -> {
            System.out.println("Pane clicked");
            positionTour(event);
        });
    }

    public void setDernierClicX(double changement) {

        this.dernierClicX = changement;
    }

    public void setDernierClicY(double changement) {

        this.dernierClicY = changement;
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

        ecouteVictoireEtDefaite = new EcouteVictoireEtDefaite(environnement, vueInterface, this);
    }

    private void initializeJoueur() {

        this.joueur = new Joueur("Pepe");
    }

    private void initializeSons() {

        Media mediaJeu = new Media(getClass().getResource(OST_JEU_PATH).toString());
     //   Audio.chargerMedia(mediaJeu);
    }

    public void initializeInputs() {

        inputs = new Inputs(gameLoop, centerPane.getScene());
        inputs.pauseDuJeu();
    }

    private void initializeVueInterface() {

        this.vueInterface = new VueInterface(environnement, lancerButton, test, solde, berry, ennemisTues, prix200b, prix800b, prix600b, prix400b,
                berryBot200b, berryBot400b, berryBot600b, berryBot800b, vboxRight, wpp, stackpane, getScene(), getBorderPane(),
                vague);
        this.ecouteInterface = new EcouteInterface(this.environnement, this.vueInterface);
    }

    private void initializeEnvironnement() {

        this.environnement = Environnement.getInstance(this.joueur);
    }

    private void initializeBasePrincipale() {

        basePrincipale = new BasePrincipale(700, 335, environnement);
    }

    private void initializeVueBasePrincipale() {

        vueBasePrincipale = new VueBasePrincipale(centerPane, basePrincipale);
        this.ecouteBasePrincipale = new EcouteBasePrincipale(this.vueBasePrincipale, this.gameLoop);
    }

    private void initializeVueTours() {

        this.vueTours = new VueTours(this.centerPane);
        this.ecouteTours = new EcouteTours(this.environnement, this.vueTours);
        this.forgeDesToursPosables = new ForgeDesToursPosables(this.environnement, new FabriqueSimple(), this.vueTours);
    }

    private void initializeVueSoldats() {

        this.vueSoldats = new VueSoldats(this.centerPane);
        this.ecouteSoldats = new EcouteSoldats(this.environnement, this.vueSoldats);
    }

    private void initializeVueProjectile() {

        this.ecouteProjectiles = new EcouteProjectiles(this.environnement, this.centerPane);
    }

    private void initializeGameLoop() {

        this.gameLoop = new GameLoop(this.centerPane, this.vueSoldats, this.environnement);
    }
    public void positionTour(MouseEvent event) {

        double x = event.getX();
        double y = event.getY();

        if (this.forgeDesToursPosables.getFabriqueSimple().getType().equals("0")) {

            this.vueTours.showErrorMessage(x, y);
            this.forgeDesToursPosables.getFabriqueSimple().setType("0");
        }
        else if (this.environnement.getJoueur().getSoldeJoueurValue() < this.forgeDesToursPosables.rechercheDeTourPosable((int) x, (int) y).getPrixValue()) {

            this.vueTours.showErrorMoneyMessage(x, y);
            this.forgeDesToursPosables.getFabriqueSimple().setType("0");

        }
        else {
            if (this.forgeDesToursPosables.conditionsTourPosable(x, y)) {

                this.forgeDesToursPosables.fabriquerTourPosable((int) x, (int) y);
                //this.vueTours.setIdTourClicked("0");
                this.forgeDesToursPosables.getFabriqueSimple().setType("0");
            }
        }
    }
    public void selectionTour(MouseEvent event) {

        ImageView image = (ImageView) event.getSource();
        //this.vueTours.setIdTourClicked(image.getId());
        this.forgeDesToursPosables.getFabriqueSimple().setType(image.getId());
    }
    private Image loadImage(String path) {

        return new Image(getClass().getResourceAsStream(path));
    }
}
