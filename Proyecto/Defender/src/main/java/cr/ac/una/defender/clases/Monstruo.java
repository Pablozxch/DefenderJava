/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import java.util.logging.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.image.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Monstruo implements Acciones
{

    public int vida;
    public int posx;
    public int posy;
    public String[] movimiento;
    public String[] ataque;
    public String[] dead;
    int cont = 0;
    int a = 81;
    Boolean parar = false;

    public int getCont()
    {
        return cont;
    }

    public void setCont(int cont)
    {
        this.cont = cont;
    }

    public int getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public Monstruo()
    {
    }

    public Monstruo(int vida)
    {
        this.vida = vida;

    }

    public int getPosy()
    {
        return posy;
    }

    public void setPosy(int posy)
    {
        this.posy = posy;
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getPosx()
    {
        return posx;
    }

    public void setPosx(int posx)
    {
        this.posx = posx;
    }

    public String[] getMovimiento()
    {
        return movimiento;
    }

    public void setMovimiento(String[] movimiento)
    {
        this.movimiento = movimiento;
    }

    public String[] getAtaque()
    {
        return ataque;
    }

    public void setAtaque(String[] ataque)
    {
        this.ataque = ataque;
    }

    public String[] getDead()
    {
        return dead;
    }

    public void setDead(String[] dead)
    {
        this.dead = dead;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Monstruo{vida=").append(vida);
        sb.append(", posx=").append(posx);
        sb.append(", posy=").append(posy);
        sb.append(", movimiento=").append(movimiento);
        sb.append(", ataque=").append(ataque);
        sb.append(", dead=").append(dead);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void caminar(ImageView imagenview , int possx)
    {

        TranslateTransition translate = new TranslateTransition();
        imagenview.setImage(new Image(movimiento[0]));
        System.out.println("La posicion final es " + getPosx());
        setPosx(possx - 950);
        translate.setByX(getPosx());
        translate.setDuration(Duration.seconds(10));
        translate.setNode(imagenview);
        animacion(imagenview , movimiento);
        translate.play();
        translate.setOnFinished((t) ->
        {
            animacion(imagenview , dead);
        });

    }

    void animacion(ImageView imagenview , String[] nombre)
    {
        cont = 0;
        a = 81;
        if(nombre == dead)
        {
            a = nombre.length;
            //System.out.println("El valor es " + a);
            parar = true;

        }
        else
        {
            // System.out.println("El nombre es" + a);
        }

        Thread taskThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < a-1; i++)
                {
                    try
                    {
                        Thread.sleep(125);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable()
                    {
                        @Override

                        public void run()
                        {

                            System.out.println("Vamos por " + cont);
                            System.out.println("El valor de la imagen es " + nombre[cont]);
                            imagenview.setImage(new Image(nombre[cont]));
                            cont++;
                            if(parar == true)
                            {
                                System.out.println("a huevo");
                            }
                            else
                            {
                                if(cont < nombre.length)
                                {

                                }
                                else
                                {
                                    cont = 0;
                                }

                            }

                        }

                    });

                }
            }
        });

        taskThread.start();
        cont = 0;
    }

    void recibirdamage()
    {

    }
}
