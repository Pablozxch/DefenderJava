/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.animation.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Bullet 
{

   private int posxfinal;
   private int posyfinal;
   private boolean hit=false;
   private int radio;

    public Bullet()
    {
    }

    public Bullet(int posxfinal , int posyfinal , int radio)
    {
        this.posxfinal = posxfinal;
        this.posyfinal = posyfinal;
        this.radio = radio;
    }

    public int getRadio()
    {
        return radio;
    }

    public void setRadio(int radio)
    {
        this.radio = radio;
    }

    public int getPosxfinal()
    {
        return posxfinal;
    }

    public void setPosxfinal(int posxfinal)
    {
        this.posxfinal = posxfinal;
    }

    public int getPosyfinal()
    {
        return posyfinal;
    }

    public void setPosyfinal(int posyfinal)
    {
        this.posyfinal = posyfinal;
    }

    public boolean isHit()
    {
        return hit;
    }

    public void setHit(boolean hit)
    {
        this.hit = hit;
    }
    

}
