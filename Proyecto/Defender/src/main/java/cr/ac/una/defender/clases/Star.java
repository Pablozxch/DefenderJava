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
public class Star extends Mob
{

    ImageView imagenview;

    public Star()
    {
    }

    public Star(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed , posxfinal);
        movimiento = new String[6];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/StartW01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/StartW02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/StartW03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/StartW04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/StartW05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/StartW06.png";
        ataque = new String[3];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/StartA01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/StartA02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/StartA03.png";
        dead = new String[6];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/StartD01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/StartD02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/StartD03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/StartD04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/StartD05.png";
        dead[5] = "/cr/ac/una/defender/resources/Personajes/StartD06.png";

    }

}
