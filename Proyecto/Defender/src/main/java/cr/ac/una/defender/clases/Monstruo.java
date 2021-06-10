/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import cr.ac.una.defender.controllers.*;
import java.util.logging.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
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
    double cont2 = 1;
    private int dinero;
    int m;

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

    public Monstruo(int vida , int dinero)
    {
        this.vida = vida;
        this.dinero = dinero;

    }

    public int getDinero()
    {
        return dinero;
    }

    public void setDinero(int dinero)
    {
        this.dinero = dinero;
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
        setPosx(possx - 950);
        System.out.println("La posicion final es " + getPosx());
        translate.setByX(getPosx());
        translate.setDuration(Duration.seconds(10));
        translate.setNode(imagenview);
        animacion(imagenview , movimiento);
        imagenview.addEventFilter(MouseEvent.MOUSE_CLICKED , (t) ->
        {
            if(t.getButton().PRIMARY == MouseButton.PRIMARY)
            {
                System.out.println("Le dio click al mob");
                setVida(getVida() - 100);
                System.out.println("La vida actual es " + getVida());
                if(vida == 0)
                {
                    imagenview.setDisable(true);
                    animacion(imagenview , dead);
                    translate.stop();

                }
            }
        });
        translate.play();
        translate.setOnFinished((t) ->
        {
            setVida(0);
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
                for(int i = 0; i < a - 1; i++)
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

                            //System.out.println("Vamos por " + cont);
                            //System.out.println("El valor de la imagen es " + nombre[cont]);
                            imagenview.setImage(new Image(nombre[cont]));
                            cont++;

                            if(parar == true && cont == a - 1)
                            {
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
        parar = false;
    }

    void recibirdamage()
    {

    }
}
