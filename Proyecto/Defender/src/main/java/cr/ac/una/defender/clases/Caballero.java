/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.animation.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Caballero extends Monstruo
{

    ImageView imagenview;
    String[] c;//caminar
    String[] a;//ataque
    String []d;//dead

    public Caballero()
    {
    }

    public Caballero(int vida)
    {
        super(vida);
        super.setPosx(0);
        c = new String[10];
        c[0] = "/cr/ac/una/defender/resources/Personajes/CabaW01.png";
        c[1] = "/cr/ac/una/defender/resources/Personajes/CabaW02.png";
        c[2] = "/cr/ac/una/defender/resources/Personajes/CabaW03.png";
        c[3] = "/cr/ac/una/defender/resources/Personajes/CabaW04.png";
        c[4] = "/cr/ac/una/defender/resources/Personajes/CabaW05.png";
        c[5] = "/cr/ac/una/defender/resources/Personajes/CabaW06.png";
        c[6] = "/cr/ac/una/defender/resources/Personajes/CabaW07.png";
        c[7] = "/cr/ac/una/defender/resources/Personajes/CabaW08.png";
        c[8] = "/cr/ac/una/defender/resources/Personajes/CabaW09.png";
        c[9] = "/cr/ac/una/defender/resources/Personajes/CabaW10.png";
        a = new String[10];
        a[0] = "/cr/ac/una/defender/resources/Personajes/CabaA01.png";
        a[1] = "/cr/ac/una/defender/resources/Personajes/CabaA02.png";
        a[2] = "/cr/ac/una/defender/resources/Personajes/CabaA03.png";
        a[3] = "/cr/ac/una/defender/resources/Personajes/CabaA04.png";
        a[4] = "/cr/ac/una/defender/resources/Personajes/CabaA05.png";
        a[5] = "/cr/ac/una/defender/resources/Personajes/CabaA06.png";
        a[6] = "/cr/ac/una/defender/resources/Personajes/CabaA07.png";
        a[7] = "/cr/ac/una/defender/resources/Personajes/CabaA08.png";
        a[8] = "/cr/ac/una/defender/resources/Personajes/CabaA09.png";
        a[9] = "/cr/ac/una/defender/resources/Personajes/CabaA10.png";
        d = new String[10];
        d[0] = "/cr/ac/una/defender/resources/Personajes/CabaD01.png";
        d[1] = "/cr/ac/una/defender/resources/Personajes/CabaD02.png";
        d[2] = "/cr/ac/una/defender/resources/Personajes/CabaD03.png";
        d[3] = "/cr/ac/una/defender/resources/Personajes/CabaD04.png";
        d[4] = "/cr/ac/una/defender/resources/Personajes/CabaD05.png";
        d[5] = "/cr/ac/una/defender/resources/Personajes/CabaD06.png";
        d[6] = "/cr/ac/una/defender/resources/Personajes/CabaD07.png";
        d[7] = "/cr/ac/una/defender/resources/Personajes/CabaD08.png";
        d[8] = "/cr/ac/una/defender/resources/Personajes/CabaD09.png";
        d[9] = "/cr/ac/una/defender/resources/Personajes/CabaD10.png";
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
