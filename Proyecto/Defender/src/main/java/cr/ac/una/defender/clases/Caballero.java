/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.animation.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Caballero extends Monstruo
{

    String[] caminarAccion;
    String[] morirAccion;
    String[] atacarAccion;

    public Caballero()
    {
    }

    public Caballero(int vida , int x , int y)
    {
        super(vida , x , y);
        caminarAccion = new String[10];
        caminarAccion[0] = "/cr/ac/una/defender/resources/Personajes/CabaW01.png";
        caminarAccion[1] = "/cr/ac/una/defender/resources/Personajes/CabaW02.png";
        caminarAccion[2] = "/cr/ac/una/defender/resources/Personajes/CabaW03.png";
        caminarAccion[3] = "/cr/ac/una/defender/resources/Personajes/CabaW04.png";
        caminarAccion[4] = "/cr/ac/una/defender/resources/Personajes/CabaW05.png";
        caminarAccion[5] = "/cr/ac/una/defender/resources/Personajes/CabaW06.png";
        caminarAccion[6] = "/cr/ac/una/defender/resources/Personajes/CabaW07.png";
        caminarAccion[7] = "/cr/ac/una/defender/resources/Personajes/CabaW08.png";
        caminarAccion[8] = "/cr/ac/una/defender/resources/Personajes/CabaW09.png";
        caminarAccion[9] = "/cr/ac/una/defender/resources/Personajes/CabaW10.png";
        atacarAccion = new String[10];
        atacarAccion[0] = "/cr/ac/una/defender/resources/Personajes/CabaA01.png";
        atacarAccion[1] = "/cr/ac/una/defender/resources/Personajes/CabaA02.png";
        atacarAccion[2] = "/cr/ac/una/defender/resources/Personajes/CabaA03.png";
        atacarAccion[3] = "/cr/ac/una/defender/resources/Personajes/CabaA04.png";
        atacarAccion[4] = "/cr/ac/una/defender/resources/Personajes/CabaA05.png";
        atacarAccion[5] = "/cr/ac/una/defender/resources/Personajes/CabaA06.png";
        atacarAccion[6] = "/cr/ac/una/defender/resources/Personajes/CabaA07.png";
        atacarAccion[7] = "/cr/ac/una/defender/resources/Personajes/CabaA08.png";
        atacarAccion[8] = "/cr/ac/una/defender/resources/Personajes/CabaA08.png";
        atacarAccion[9] = "/cr/ac/una/defender/resources/Personajes/CabaA10.png";
        super.setCaminar(caminarAccion);
        super.setAtacar(atacarAccion);
    }

    public void caminar()
    {
       Timeline animation = new Timeline(new KeyFrame(Duration.millis(70) , e -> super.caminar()));
       animation.play();
    }

    public void atacar()
    {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70) , e -> super.atacar()));
    }

    public void morir()
    {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70) , e -> super.morir()));
    }

}
