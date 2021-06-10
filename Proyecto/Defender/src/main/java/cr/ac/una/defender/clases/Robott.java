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
public class Robott extends Monstruo
{
    ImageView imagenview;
    String[] c;//caminar
    String[] a;//ataque
    String []d;//dead

    public Robott()
    {
    }

    public Robott(int vida, int dinero)
    {
        super(vida,dinero);
        super.setPosx(0);
        c = new String[8];
        c[0] = "/cr/ac/una/defender/resources/Personajes/RobotW01.png";
        c[1] = "/cr/ac/una/defender/resources/Personajes/RobotW02.png";
        c[2] = "/cr/ac/una/defender/resources/Personajes/RobotW03.png";
        c[3] = "/cr/ac/una/defender/resources/Personajes/RobotW04.png";
        c[4] = "/cr/ac/una/defender/resources/Personajes/RobotW05.png";
        c[5] = "/cr/ac/una/defender/resources/Personajes/RobotW06.png";
        c[6] = "/cr/ac/una/defender/resources/Personajes/RobotW07.png";
        c[7] = "/cr/ac/una/defender/resources/Personajes/RobotW08.png";
        a = new String[8];
        a[0] = "/cr/ac/una/defender/resources/Personajes/RobotA01.png";
        a[1] = "/cr/ac/una/defender/resources/Personajes/RobotA02.png";
        a[2] = "/cr/ac/una/defender/resources/Personajes/RobotA03.png";
        a[3] = "/cr/ac/una/defender/resources/Personajes/RobotA04.png";
        a[4] = "/cr/ac/una/defender/resources/Personajes/RobotA05.png";
        a[5] = "/cr/ac/una/defender/resources/Personajes/RobotA06.png";
        a[6] = "/cr/ac/una/defender/resources/Personajes/RobotA07.png";
        a[7] = "/cr/ac/una/defender/resources/Personajes/RobotA08.png";
        d = new String[10];
        d[0] = "/cr/ac/una/defender/resources/Personajes/RobotD01.png";
        d[1] = "/cr/ac/una/defender/resources/Personajes/RobotD02.png";
        d[2] = "/cr/ac/una/defender/resources/Personajes/RobotD03.png";
        d[3] = "/cr/ac/una/defender/resources/Personajes/RobotD04.png";
        d[4] = "/cr/ac/una/defender/resources/Personajes/RobotD05.png";
        d[5] = "/cr/ac/una/defender/resources/Personajes/RobotD06.png";
        d[6] = "/cr/ac/una/defender/resources/Personajes/RobotD07.png";
        d[7] = "/cr/ac/una/defender/resources/Personajes/RobotD08.png";
        d[8] = "/cr/ac/una/defender/resources/Personajes/RobotD09.png";
        d[9] = "/cr/ac/una/defender/resources/Personajes/RobotD10.png";
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
