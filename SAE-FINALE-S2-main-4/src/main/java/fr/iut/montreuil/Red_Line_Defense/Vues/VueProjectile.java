package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class VueProjectile {
    @FXML
    private Pane centerPane;
    public VueProjectile(Pane centerPane, Projectile p) {

        this.centerPane = centerPane;
        CreationSprite(p);
    }
    public void CreationSprite(Projectile p) {

        ImageView projectile;
        String nomAffichage = p.getPath();
        projectile = new ImageView(loadImage(nomAffichage));
        orientationImage(p,projectile);
    }
    public void orientationImage(Projectile p, ImageView i) {

        double angle = p.calculerAngle(p.getX(), p.getY(), p.getxCible(), p.getyCible());
        i.setRotate(Math.toDegrees(angle));
        i.xProperty().bind(p.xProperty());
        i.yProperty().bind(p.yProperty());
        i.setId(p.getId());
        this.centerPane.getChildren().addAll(i);
    }
    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}
