package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Blast;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Missile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class VueProjectile {

    @FXML
    private Pane centerPane;

    public final static String BOULE_DE_FEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bouleDeFeu.png";
    public final static String BOMBE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bombe.png";
    public final static String BLAST_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/blast.gif";


    public VueProjectile(Pane centerPane,Projectile p){
        this.centerPane=centerPane;
        CreationSprite(p);
    }
    public void CreationSprite(Projectile p){
        ImageView projectile;
        if(p instanceof Boulet) {
            ImageView bouleDeFeu = new ImageView(loadImage(BOULE_DE_FEU_PATH));
            orientationImage(p,bouleDeFeu);
            projectile=bouleDeFeu;
        }
        else if(p instanceof Blast){
            ImageView blastLaser = new ImageView(loadImage(BLAST_PATH));
            orientationImage(p,blastLaser);
            projectile=blastLaser;
        }
        else {
        ImageView bombe = new ImageView(loadImage(BOMBE_PATH));
        orientationImage(p,bombe);
        projectile=bombe;
        }

        if(p instanceof Missile) {
            double angle = p.calculerAngle(p.getX(), p.getY(), p.getxCible(), p.getyCible());
            projectile.setRotate(Math.toDegrees(angle));}
    }

    public Pane getCenterPane() {
        return centerPane;
    }
    public void orientationImage(Projectile p, ImageView i){
        double angle = p.calculerAngle(p.getX(), p.getY(), p.getxCible(), p.getyCible());
        i.setRotate(Math.toDegrees(angle));
        i.xProperty().bind(p.xProperty());
        i.yProperty().bind(p.yProperty());
        i.setId(p.getId());
        centerPane.getChildren().addAll(i);
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }
}
