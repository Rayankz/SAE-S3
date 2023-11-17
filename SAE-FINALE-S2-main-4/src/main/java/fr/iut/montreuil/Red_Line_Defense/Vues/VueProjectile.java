package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class VueProjectile {

    @FXML
    private Pane centerPane;

    public final static String BOULE_DE_FEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bouleDeFeu.png";
    public final static String BOMBE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bombe.png";


    public VueProjectile(Pane centerPane,Projectile p){

        this.centerPane = centerPane;
        CreationSprite(p);
    }

    //TODO
    //Le truc en bas est moche (redondance) il faut le refactorer
    public void CreationSprite(Projectile p) {
        ImageView projectile;
        String nomAffichage;
        if (p instanceof Missile) {
            nomAffichage = BOMBE_PATH;
        }
        else {
            nomAffichage = BOULE_DE_FEU_PATH;
        }
        projectile = new ImageView(loadImage(nomAffichage));
        orientationImage(p,projectile);

        /*if (p instanceof Missile) {
            double angle = p.calculerAngle(p.getX(), p.getY(), p.getxCible(), p.getyCible());
            projectile.setRotate(Math.toDegrees(angle));}
            */
    }
    public void orientationImage(Projectile p, ImageView i) {
        double angle = p.calculerAngle(p.getX(), p.getY(), p.getxCible(), p.getyCible());
        i.setRotate(Math.toDegrees(angle));
        i.xProperty().bind(p.xProperty());
        i.yProperty().bind(p.yProperty());
        i.setId(p.getId());
        centerPane.getChildren().addAll(i);
    }

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}
