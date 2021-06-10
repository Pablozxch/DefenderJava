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
public class Zombie extends Monstruo
{
  ImageView imagenview;
    String[] c;//caminar
    String[] a;//ataque
    String []d;//dead

    public Zombie()
    {
    }

    public Zombie(int vida, int dinero)
    {
        super(vida,dinero);
        super.setPosx(0);
        c = new String[6];
        c[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1W01.png";
        c[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1W02.png";
        c[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1W03.png";
        c[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1W04.png";
        c[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1W05.png";
        c[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1W06.png";
        a = new String[6];
        a[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1A01.png";
        a[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1A02.png";
        a[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1A03.png";
        a[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1A04.png";
        a[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1A05.png";
        a[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1A06.png";
        d = new String[8];
        d[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1D01.png";
        d[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1D02.png";
        d[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1D03.png";
        d[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1D04.png";
        d[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1D05.png";
        d[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1D06.png";
        d[6] = "/cr/ac/una/defender/resources/Personajes/Zombie1D07.png";
        d[7] = "/cr/ac/una/defender/resources/Personajes/Zombie1D08.png";
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
