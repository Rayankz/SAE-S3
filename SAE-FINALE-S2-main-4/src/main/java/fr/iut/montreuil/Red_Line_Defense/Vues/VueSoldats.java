package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class VueSoldats {


    private Pane centerPane;

    private Map<Soldat, ImageView> hashMapSoldatsSkin = new HashMap<>();


    public VueSoldats(Pane centerPane) {
        this.centerPane = centerPane;
    }



    public void ajouterSkinSoldat(Soldat s) {
        ImageView skin  = creerImageSoldat(s.getCouleur());
        System.out.println("Skin créé pour le soldat : " + skin);

        hashMapSoldatsSkin.put(s, skin);

        s.setX0(s.getX0Value());
        s.setY0(s.getY0Value());

        skin.xProperty().bind(s.getX0Property());
        skin.yProperty().bind(s.getY0Property());

        centerPane.getChildren().add(skin);
        System.out.println("  Skin ajouté au pane. Total des cercles  ");
    }

    public void setImageViewProperties(ImageView skin, String color, String direction){
        String imagePath = String.format("/fr/iut/montreuil/Red_Line_Defense/Images/Personnage/%s/%s.gif", color, direction);
        skin.setImage(loadImage(imagePath));
        skin.setFitWidth(30);
        skin.setFitHeight(30);
        skin.setTranslateX(-15);
        skin.setTranslateY(-15);
    }

    public void mettreAJourSkin(int directionIndex, Soldat soldat) {
        String direction;
        switch (directionIndex) {
            case 0:
                direction = "haut";
                break;
            case 1:
                direction = "down";
                break;
            case 2:
                direction = "left";
                break;
            case 3:
                direction = "right";
                break;
            default:
                throw new IllegalArgumentException("Invalid direction index: " + directionIndex);
        }
        ImageView skin = hashMapSoldatsSkin.get(soldat);
        setImageViewProperties(skin, soldat.getCouleur(), direction);
    }


    public ImageView creerImageSoldat(String color) {
        String imagePath = String.format("/fr/iut/montreuil/Red_Line_Defense/Images/Personnage/%s/haut.gif", color);
        Image image = loadImage(imagePath);
        ImageView img = new ImageView(image);
        img.setFitWidth(30);
        img.setFitHeight(30);
        img.setTranslateX(-15);
        img.setTranslateY(-15);
        img.setPreserveRatio(true);
        return img;
    }


    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    public void supprSkinSoldats(Soldat s) {
        centerPane.getChildren().remove(getSkinForSoldat(s));
    }

    public Map<Soldat, ImageView> getHashMap(){
        return this.hashMapSoldatsSkin;
    }

    public ImageView getSkinForSoldat(Soldat soldat) {
        return this.hashMapSoldatsSkin.get(soldat);
    }
    public Soldat getSoldatForSkin(ImageView i) {
        for (Map.Entry<Soldat, ImageView> entry : this.hashMapSoldatsSkin.entrySet()) {
            if (Objects.equals(i, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
