/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.animation.*;
import javafx.scene.image.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Arrow
{

    private ImageView im;
    private int tamx;
    private int tamy;

    public Arrow()
    {
    }

    public Arrow(ImageView im , int tamx , int tamy)
    {
        this.im = im;
        this.tamx = tamx;
        this.tamy = tamy;
    }

    public ImageView getIm()
    {
        return im;
    }

    public void setIm(ImageView im)
    {
        this.im = im;
    }

    public int getTamx()
    {
        return tamx;
    }

    public void setTamx(int tamx)
    {
        this.tamx = tamx;
    }

    public int getTamy()
    {
        return tamy;
    }

    public void setTamy(int tamy)
    {
        this.tamy = tamy;
    }

    public void mover(ImageView imagen , double nx , double ny)
    {
        System.out.println("Buenos dias");
        imagen.setImage(new Image("/cr/ac/una/defender/resources/arrow.png"));
        TranslateTransition im = new TranslateTransition();
        im.setByX(nx);
        im.setByY(ny);
        im.setDuration(Duration.millis(2000));
        im.setNode(imagen);
        im.play();
//        im.setOnFinished((t) ->
//        {
//            imagen.visibleProperty().set(false);
//        });

    }
}
