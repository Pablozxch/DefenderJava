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
public class Star extends Monstruo
{
        ImageView imagenview;
    String[] c;//caminar
    String[] a;//ataque
    String[] d;//dead

    public Star()
    {
    }

    public Star(int vida)
    {
        super(vida);
        super.setPosx(0);
        c = new String[6];
        c[0] = "/cr/ac/una/defender/resources/Personajes/StartW01.png";
        c[1] = "/cr/ac/una/defender/resources/Personajes/StartW02.png";
        c[2] = "/cr/ac/una/defender/resources/Personajes/StartW03.png";
        c[3] = "/cr/ac/una/defender/resources/Personajes/StartW04.png";
        c[4] = "/cr/ac/una/defender/resources/Personajes/StartW05.png";
        c[5] = "/cr/ac/una/defender/resources/Personajes/StartW06.png";
        a = new String[3];
        a[0] = "/cr/ac/una/defender/resources/Personajes/StartA01.png";
        a[1] = "/cr/ac/una/defender/resources/Personajes/StartA02.png";
        a[2] = "/cr/ac/una/defender/resources/Personajes/StartA03.png";
        d = new String[6];
        d[0] = "/cr/ac/una/defender/resources/Personajes/StartD01.png";
        d[1] = "/cr/ac/una/defender/resources/Personajes/StartD02.png";
        d[2] = "/cr/ac/una/defender/resources/Personajes/StartD03.png";
        d[3] = "/cr/ac/una/defender/resources/Personajes/StartD04.png";
        d[4] = "/cr/ac/una/defender/resources/Personajes/StartD05.png";
        d[5] = "/cr/ac/una/defender/resources/Personajes/StartD06.png";

        super.setDead(d);
        super.setMovimiento(c);
        super.setAtaque(a);

    }

    @Override
    public void caminar(ImageView imagenview , int possx)
    {

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(75) , e -> super.caminar(imagenview , possx)));
        //System.out.println("posx" + getPosx());
        animation.play();

    }
}
