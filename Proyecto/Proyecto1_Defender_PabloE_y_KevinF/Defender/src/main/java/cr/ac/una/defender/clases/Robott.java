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
public class Robott extends Mob
{


    public Robott()
    {
    }

    public Robott(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed , posxfinal);
        movimiento = new String[8];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/RobotW01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/RobotW02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/RobotW03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/RobotW04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/RobotW05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/RobotW06.png";
        movimiento[6] = "/cr/ac/una/defender/resources/Personajes/RobotW07.png";
        movimiento[7] = "/cr/ac/una/defender/resources/Personajes/RobotW08.png";
        ataque = new String[8];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/RobotA01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/RobotA02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/RobotA03.png";
        ataque[3] = "/cr/ac/una/defender/resources/Personajes/RobotA04.png";
        ataque[4] = "/cr/ac/una/defender/resources/Personajes/RobotA05.png";
        ataque[5] = "/cr/ac/una/defender/resources/Personajes/RobotA06.png";
        ataque[6] = "/cr/ac/una/defender/resources/Personajes/RobotA07.png";
        ataque[7] = "/cr/ac/una/defender/resources/Personajes/RobotA08.png";
        dead = new String[10];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/RobotD01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/RobotD02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/RobotD03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/RobotD04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/RobotD05.png";
        dead[5] = "/cr/ac/una/defender/resources/Personajes/RobotD06.png";
        dead[6] = "/cr/ac/una/defender/resources/Personajes/RobotD07.png";
        dead[7] = "/cr/ac/una/defender/resources/Personajes/RobotD08.png";
        dead[8] = "/cr/ac/una/defender/resources/Personajes/RobotD09.png";
        dead[9] = "/cr/ac/una/defender/resources/Personajes/RobotD10.png";
    }
}
