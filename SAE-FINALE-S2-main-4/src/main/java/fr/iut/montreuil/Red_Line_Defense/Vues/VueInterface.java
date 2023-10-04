package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.ControleurDefaite;
import fr.iut.montreuil.Red_Line_Defense.Main;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class VueInterface {


    private Scene scene;
    private StackPane vaguePane;
    Label solde;

    StackPane stackpane;


    ImageView berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b, wpp;


    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;
    VBox vboxRight;
    Label ennemisTues;
    Label vague;
    private ArrayList<ImageView> transitionVague;

    private Button lancerButton, test;
    private BorderPane borderPane;




    public VueInterface(Environnement terrain, Button lancerButton, Button test, Label solde, ImageView berry, Label ennemisTues,
                        HBox prix200b, HBox prix400b, HBox prix600b, HBox prix800b, ImageView berryBot200b, ImageView berryBot600b, ImageView berryBot400b, ImageView berryBot800b, VBox vboxRight,
                        ImageView wpp, StackPane stackpane, Scene scene, BorderPane borderpane, Label vague) {

        vague.textProperty().bind(terrain.getVague().asString());
        solde.setText(String.valueOf(terrain.getJoueur().getSoldeJoueurValue()));
        this.lancerButton = lancerButton;
        this.test = test;
        this.solde = solde;
        this.berry = berry;
        this.ennemisTues = ennemisTues;
        this.prix200b = prix200b;
        this.prix400b = prix400b;
        this.prix600b = prix600b;
        this.prix800b = prix800b;
        this.berryBot200b = berryBot200b;
        this.berryBot400b = berryBot400b;
        this.berryBot600b = berryBot600b;
        this.berryBot800b = berryBot800b;
        this.vboxRight = vboxRight;
        this.wpp = wpp;
        this.stackpane = stackpane;
        this.scene = scene;
        this.borderPane = borderpane;
        this.vague = vague;
        this.transitionVague = new ArrayList<ImageView>();
        ajouterLesImages();
        initializeRightPane();
        initializeImageBerry();
    }

    private void initializeImageBerry() {
        berry = new ImageView(getBerryImage());
        berryBot200b = new ImageView(getBerryPrixImage());
        prix200b.getChildren().add(berryBot200b);
        berryBot400b = new ImageView(getBerryPrixImage());
        prix400b.getChildren().add(berryBot400b);

        berryBot600b = new ImageView(getBerryPrixImage());
        prix600b.getChildren().add(berryBot600b);

        berryBot800b = new ImageView(getBerryPrixImage());
        prix800b.getChildren().add(berryBot800b);

    }

    public void initializeRightPane(){
        wpp = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/rightPane.gif"));
        stackpane.getChildren().add(0, wpp);

    }

    private Image getBerryImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/berry.png");
    }
    private Image getBerryPrixImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/berryPrix.png");
    }
    public void ajouterLesImages(){
        String VAGUE2 = "/fr/iut/montreuil/Red_Line_Defense/Images/Vagues/vague2.png";
        String VAGUE3 = "/fr/iut/montreuil/Red_Line_Defense/Images/Vagues/vague3.png";
        String VAGUE4 = "/fr/iut/montreuil/Red_Line_Defense/Images/Vagues/vague4.png";
        String VAGUE5 = "/fr/iut/montreuil/Red_Line_Defense/Images/Vagues/vague5.png";

        ImageView imageView2 = new ImageView(loadImage(VAGUE2));
        ImageView imageView3 = new ImageView(loadImage(VAGUE3));
        ImageView imageView4 = new ImageView(loadImage(VAGUE4));
        ImageView imageView5 = new ImageView(loadImage(VAGUE5));

        transitionVague.add(imageView2);
        transitionVague.add(imageView3);
        transitionVague.add(imageView4);
        transitionVague.add(imageView5);

    }





    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    // Getters and Setters for FXML elements
    public Button getLancerButton() {
        return lancerButton;
    }

    public void setLancerButton(Button lancerButton) {
        this.lancerButton = lancerButton;
    }

    public Button getTestButton() {
        return test;
    }

    public void setTestButton(Button test) {
        this.test = test;
    }

    public Label getSolde() {
        return solde;
    }
    public Label getVagueLabel() {return vague;}

    public Label getEnnemisTues(){
        return ennemisTues;
    }

    public void setEnnemisTues(Label ennemisTues) {
        this.ennemisTues = ennemisTues;
    }

    public void setSolde(Label solde) {
        this.solde = solde;
    }

    public ImageView getBerry() {
        return berry;
    }

    public void setBerry(ImageView berry) {
        this.berry = berry;
    }

    public HBox getHboxMoneyCount() {
        return hboxMoneyCount;
    }

    public void setHboxMoneyCount(HBox hboxMoneyCount) {
        this.hboxMoneyCount = hboxMoneyCount;
    }
    public void boucleImagesVagues(int n){
        ImageView imageView = transitionVague.get(n);

        // Création d'un layout avec un fond semi-transparent
        vaguePane = new StackPane(imageView);
        vaguePane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8);"); // Fond noir semi-transparent
        vaguePane.setVisible(false); // Initially invisible

        vaguePane.prefWidthProperty().bind(scene.widthProperty());
        vaguePane.prefHeightProperty().bind(scene.heightProperty());
        if (!borderPane.getChildren().contains(imageView)) {
            borderPane.getChildren().add(imageView);
        }

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(3.2),
                ae -> vaguePane.getChildren().remove(imageView)));
        timeline.play();
    }

    public void ajouterDefaite(Stage s){

        URL url = Main.class.getResource("Vues/VueDefaite.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ControleurDefaite controleur = loader.getController();

        Stage stage = s;

        if (stage != null) {
            Scene scene = new Scene(root, 940, 560);
            stage.setResizable(false);
            stage.setTitle("Red Line Defense");
            stage.setScene(scene);
            stage.show();
        }
    }

}
