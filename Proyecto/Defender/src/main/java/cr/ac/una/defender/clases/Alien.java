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
public class Alien extends Monstruo
{

    ImageView imagenview;
    String[] c;//caminar
    String[] a;//ataque
    String[] d;//dead

    public Alien()
    {
    }

    public Alien(int vida,int dinero)
    {
        super(vida,dinero);
        super.setPosx(0);
        c = new String[12];
        c[0] = "/cr/ac/una/defender/resources/Personajes/AlienW01.png";
        c[1] = "/cr/ac/una/defender/resources/Personajes/AlienW02.png";
        c[2] = "/cr/ac/una/defender/resources/Personajes/AlienW03.png";
        c[3] = "/cr/ac/una/defender/resources/Personajes/AlienW04.png";
        c[4] = "/cr/ac/una/defender/resources/Personajes/AlienW05.png";
        c[5] = "/cr/ac/una/defender/resources/Personajes/AlienW06.png";
        c[6] = "/cr/ac/una/defender/resources/Personajes/AlienW07.png";
        c[7] = "/cr/ac/una/defender/resources/Personajes/AlienW08.png";
        c[8] = "/cr/ac/una/defender/resources/Personajes/AlienW09.png";
        c[9] = "/cr/ac/una/defender/resources/Personajes/AlienW10.png";
        c[10] = "/cr/ac/una/defender/resources/Personajes/AlienW11.png";
        c[11] = "/cr/ac/una/defender/resources/Personajes/AlienW12.png";
        a = new String[12];
        a[0] = "/cr/ac/una/defender/resources/Personajes/AlienA01.png";
        a[1] = "/cr/ac/una/defender/resources/Personajes/AlienA02.png";
        a[2] = "/cr/ac/una/defender/resources/Personajes/AlienA03.png";
        a[3] = "/cr/ac/una/defender/resources/Personajes/AlienA04.png";
        a[4] = "/cr/ac/una/defender/resources/Personajes/AlienA05.png";
        a[5] = "/cr/ac/una/defender/resources/Personajes/AlienA06.png";
        a[6] = "/cr/ac/una/defender/resources/Personajes/AlienA07.png";
        a[7] = "/cr/ac/una/defender/resources/Personajes/AlienA08.png";
        a[8] = "/cr/ac/una/defender/resources/Personajes/AlienA09.png";
        a[9] = "/cr/ac/una/defender/resources/Personajes/AlienA10.png";
        a[10] = "/cr/ac/una/defender/resources/Personajes/AlienA11.png";
        a[11] = "/cr/ac/una/defender/resources/Personajes/AlienA12.png";
        d = new String[12];
        d[0] = "/cr/ac/una/defender/resources/Personajes/AlienD01.png";
        d[1] = "/cr/ac/una/defender/resources/Personajes/AlienD02.png";
        d[2] = "/cr/ac/una/defender/resources/Personajes/AlienD03.png";
        d[3] = "/cr/ac/una/defender/resources/Personajes/AlienD04.png";
        d[4] = "/cr/ac/una/defender/resources/Personajes/AlienD05.png";
        d[5] = "/cr/ac/una/defender/resources/Personajes/AlienD06.png";
        d[6] = "/cr/ac/una/defender/resources/Personajes/AlienD07.png";
        d[7] = "/cr/ac/una/defender/resources/Personajes/AlienD08.png";
        d[8] = "/cr/ac/una/defender/resources/Personajes/AlienD09.png";
        d[9] = "/cr/ac/una/defender/resources/Personajes/AlienD10.png";
        d[10] = "/cr/ac/una/defender/resources/Personajes/AlienD11.png";
        d[11] = "/cr/ac/una/defender/resources/Personajes/AlienD12.png";

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
