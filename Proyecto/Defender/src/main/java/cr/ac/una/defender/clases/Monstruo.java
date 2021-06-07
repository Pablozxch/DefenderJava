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
public class Monstruo
{

    private int vida;
    private String[] movimiento;
    private String damage;
    private String[] ataque;
    private Tipo tipo;

    public Monstruo()
    {

    }

    public Monstruo(int vida , Tipo tipo)
    {
        this.vida = vida;
        this.tipo = tipo;
        switch(tipo)
        {
            case TIPO1:
                movimiento = new String[6];
                movimiento[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                movimiento[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                movimiento[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                movimiento[3] = "/cr/ac/una/defender/resources/Personajes/EsqueW04.png";
                movimiento[4] = "/cr/ac/una/defender/resources/Personajes/EsqueW05.png";
                movimiento[5] = "/cr/ac/una/defender/resources/Personajes/EsqueW06.png";
                damage = "";
                ataque = new String[3];
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueA01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueA02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueA03.png";
                break;
            case TIPO2:
                // movimiento = "";
                damage = "";
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                break;
            case TIPO3:
                //  movimiento = "";
                damage = "";
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                break;
            case TIPO4:
                // movimiento = "";
                damage = "";
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                break;
            case TIPO5:
                //movimiento = "";
                damage = "";
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                break;
            case TIPO6:
                //movimiento = "";
                damage = "";
                ataque[0] = "/cr/ac/una/defender/resources/Personajes/EsqueW01.png";
                ataque[1] = "/cr/ac/una/defender/resources/Personajes/EsqueW02.png";
                ataque[2] = "/cr/ac/una/defender/resources/Personajes/EsqueW03.png";
                break;
        }
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public String[] getMovimiento()
    {
        return movimiento;
    }

    public void setMovimiento(String[] movimiento)
    {
        this.movimiento = movimiento;
    }

    public String getDamage()
    {
        return damage;
    }

    public void setDamage(String damage)
    {
        this.damage = damage;
    }



    public Tipo getTipo()
    {
        return tipo;
    }

    public void setTipo(Tipo tipo)
    {
        this.tipo = tipo;
    }

    public String[] getAtaque()
    {
        return ataque;
    }

    public void setAtaque(String[] ataque)
    {
        this.ataque = ataque;
    }

}
