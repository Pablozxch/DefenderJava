/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.scene.image.*;

/**
 *
 * @author jp015
 */
public class Zombie extends Mob
{

    public Zombie()
    {
    }

    public Zombie(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed  , posxfinal);
        movimiento = new String[6];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1W01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1W02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1W03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1W04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1W05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1W06.png";
        ataque = new String[6];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1A01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1A02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1A03.png";
        ataque[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1A04.png";
        ataque[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1A05.png";
        ataque[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1A06.png";
        dead = new String[8];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/Zombie1D01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/Zombie1D02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/Zombie1D03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/Zombie1D04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/Zombie1D05.png";
        dead[5] = "/cr/ac/una/defender/resources/Personajes/Zombie1D06.png";
        dead[6] = "/cr/ac/una/defender/resources/Personajes/Zombie1D07.png";
        dead[7] = "/cr/ac/una/defender/resources/Personajes/Zombie1D08.png";
    }

}
