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
public class Alien extends Mob
{
    public Alien()
    {
    }

    public Alien(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed , posxfinal);
        movimiento = new String[12];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/AlienW01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/AlienW02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/AlienW03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/AlienW04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/AlienW05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/AlienW06.png";
        movimiento[6] = "/cr/ac/una/defender/resources/Personajes/AlienW07.png";
        movimiento[7] = "/cr/ac/una/defender/resources/Personajes/AlienW08.png";
        movimiento[8] = "/cr/ac/una/defender/resources/Personajes/AlienW09.png";
        movimiento[9] = "/cr/ac/una/defender/resources/Personajes/AlienW10.png";
        movimiento[10] = "/cr/ac/una/defender/resources/Personajes/AlienW11.png";
        movimiento[11] = "/cr/ac/una/defender/resources/Personajes/AlienW12.png";
        ataque = new String[12];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/AlienA01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/AlienA02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/AlienA03.png";
        ataque[3] = "/cr/ac/una/defender/resources/Personajes/AlienA04.png";
        ataque[4] = "/cr/ac/una/defender/resources/Personajes/AlienA05.png";
        ataque[5] = "/cr/ac/una/defender/resources/Personajes/AlienA06.png";
        ataque[6] = "/cr/ac/una/defender/resources/Personajes/AlienA07.png";
        ataque[7] = "/cr/ac/una/defender/resources/Personajes/AlienA08.png";
        ataque[8] = "/cr/ac/una/defender/resources/Personajes/AlienA09.png";
        ataque[9] = "/cr/ac/una/defender/resources/Personajes/AlienA10.png";
        ataque[10] = "/cr/ac/una/defender/resources/Personajes/AlienA11.png";
        ataque[11] = "/cr/ac/una/defender/resources/Personajes/AlienA12.png";
        dead = new String[12];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/AlienD01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/AlienD02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/AlienD03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/AlienD04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/AlienD05.png";
        dead[5] = "/cr/ac/una/defender/resources/Personajes/AlienD06.png";
        dead[6] = "/cr/ac/una/defender/resources/Personajes/AlienD07.png";
        dead[7] = "/cr/ac/una/defender/resources/Personajes/AlienD08.png";
        dead[8] = "/cr/ac/una/defender/resources/Personajes/AlienD09.png";
        dead[9] = "/cr/ac/una/defender/resources/Personajes/AlienD10.png";
        dead[10] = "/cr/ac/una/defender/resources/Personajes/AlienD11.png";
        dead[11] = "/cr/ac/una/defender/resources/Personajes/AlienD12.png";

    }
}
