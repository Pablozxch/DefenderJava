/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;


/**
 *
 * @author jp015
 */
public class RedSkull extends Mob
{


  public RedSkull()
    {
    }

    public RedSkull(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        super(vida , posx , posy , height , weight , speed , posxfinal);
        movimiento = new String[6];
        movimiento[0] = "/cr/ac/una/defender/resources/Personajes/RedW01.png";
        movimiento[1] = "/cr/ac/una/defender/resources/Personajes/RedW02.png";
        movimiento[2] = "/cr/ac/una/defender/resources/Personajes/RedW03.png";
        movimiento[3] = "/cr/ac/una/defender/resources/Personajes/RedW04.png";
        movimiento[4] = "/cr/ac/una/defender/resources/Personajes/RedW05.png";
        movimiento[5] = "/cr/ac/una/defender/resources/Personajes/RedW06.png";
        ataque = new String[3];
        ataque[0] = "/cr/ac/una/defender/resources/Personajes/RedA01.png";
        ataque[1] = "/cr/ac/una/defender/resources/Personajes/RedA02.png";
        ataque[2] = "/cr/ac/una/defender/resources/Personajes/RedA03.png";
        dead = new String[5];
        dead[0] = "/cr/ac/una/defender/resources/Personajes/RedD01.png";
        dead[1] = "/cr/ac/una/defender/resources/Personajes/RedD02.png";
        dead[2] = "/cr/ac/una/defender/resources/Personajes/RedD03.png";
        dead[3] = "/cr/ac/una/defender/resources/Personajes/RedD04.png";
        dead[4] = "/cr/ac/una/defender/resources/Personajes/RedD05.png";

    }
    
}
