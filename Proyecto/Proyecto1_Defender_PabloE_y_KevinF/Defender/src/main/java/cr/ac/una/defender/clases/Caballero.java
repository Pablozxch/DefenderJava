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
public class Caballero extends Mob
{

    public Caballero()
    {
    }

    public Caballero(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed , posxfinal);
        movimiento = new String[10];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/CabaW01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/CabaW02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/CabaW03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/CabaW04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/CabaW05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/CabaW06.png";
        movimiento[6] = "/cr/ac/una/defender/resources/Personajes/CabaW07.png";
        movimiento[7] = "/cr/ac/una/defender/resources/Personajes/CabaW08.png";
        movimiento[8] = "/cr/ac/una/defender/resources/Personajes/CabaW09.png";
        movimiento[9] = "/cr/ac/una/defender/resources/Personajes/CabaW10.png";
        ataque = new String[10];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/CabaA01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/CabaA02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/CabaA03.png";
        ataque[3] = "/cr/ac/una/defender/resources/Personajes/CabaA04.png";
        ataque[4] = "/cr/ac/una/defender/resources/Personajes/CabaA05.png";
        ataque[5] = "/cr/ac/una/defender/resources/Personajes/CabaA06.png";
        ataque[6] = "/cr/ac/una/defender/resources/Personajes/CabaA07.png";
       ataque[7] = "/cr/ac/una/defender/resources/Personajes/CabaA08.png";
        ataque[8] = "/cr/ac/una/defender/resources/Personajes/CabaA09.png";
        ataque[9] = "/cr/ac/una/defender/resources/Personajes/CabaA10.png";
        dead = new String[10];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/CabaD01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/CabaD02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/CabaD03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/CabaD04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/CabaD05.png";
        dead[5] = "/cr/ac/una/defender/resources/Personajes/CabaD06.png";
        dead[6] = "/cr/ac/una/defender/resources/Personajes/CabaD07.png";
        dead[7] = "/cr/ac/una/defender/resources/Personajes/CabaD08.png";
        dead[8] = "/cr/ac/una/defender/resources/Personajes/CabaD09.png";
        dead[9] = "/cr/ac/una/defender/resources/Personajes/CabaD10.png";

    }


}
