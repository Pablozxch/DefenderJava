/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import java.util.logging.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.media.*;
import javafx.scene.shape.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public class Mob implements Accion
{

    public int vida;
    public int posx;
    public int posy;
    public int height;
    public int weight;
    public int speed;
    public String[] movimiento;
    public String[] ataque;
    public String[] dead;
    public ImageView imagenView;
    private int posxfinal;
    public AudioClip musica;
    private Boolean muerto = false;
    private int contataques = 0;
    public TranslateTransition translate;
    private boolean congelado = false;

    public Mob()
    {
        imagenView = new ImageView();
    }

    public Mob(int vida , int posx , int posy , int height , int weight , int speed , int posxfinal)
    {
        this();
        this.vida = vida;
        this.posx = posx;
        this.posy = posy;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.posxfinal = posxfinal;
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
        if(muerto == true)
        {

        }
        else
        {

            if(vida <= 0)
            {
                translate.stop();
                sprite(dead);

            }

        }

    }

    public int getPosx()
    {
        return posx;
    }

    public void setPosx(int posx)
    {
        this.posx = posx;
    }

    public int getPosy()
    {
        return posy;
    }

    public void setPosy(int posy)
    {
        this.posy = posy;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
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

    public ImageView getImagenView()
    {
        return imagenView;
    }

    public void setImagenView(ImageView imagenView)
    {
        this.imagenView = imagenView;
        imagenView.setFitHeight(150);
        imagenView.setFitWidth(120);
    }

    public int getPosxfinal()
    {
        return posxfinal;
    }

    public Bounds getBound()
    {
        return imagenView.getBoundsInParent();
    }

    public void setPosxfinal(int posxfinal)
    {
        this.posxfinal = posxfinal;
    }
    public int a = 81;
    public int cont = 0;
    public boolean parar;
    public Thread taskThread;
    public int i = 0;

    public void sprite(String[] nombre)
    {
        cont = 0;
        a = 81;

        if(nombre == movimiento)
        {
            if(nombre.length > 7)
            {
                a = 6 * getSpeed();
                a -= 20;
            }
            else
            {
                a = 6 * getSpeed();
                a += 30;
            }

        }

        else if(nombre == dead)
        {
            a = nombre.length;
            //System.out.println("El valor es " + a);
            parar = true;
            muerto = true;

        }

        taskThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(i = 0; i < a - 1; i++)
                {

                    try
                    {
                        Thread.sleep(135);
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
                            if(nombre == ataque && parar == false)
                            {
                                if(getMuerto() == true)
                                {
                                    i = a;
                                    taskThread.stop();
                                    cont = 0;
                                    sprite(dead);
                                }
                                a += 50;
                            }
                            // System.out.println("La accion fue " + nombre.toString());
                            imagenView.setImage(new Image(nombre[cont]));
                            cont++;
                            int x = nombre.length - 1;
                            if(cont > x)
                            {
                                cont = 0;
                                if(nombre == ataque && muerto == false)
                                {
                                    setContataques(getContataques() + 1);
                                    //System.out.println("El damage es " + getContataques());
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

    public Duration segacutal;

    @Override
    public void Start()
    {
        if(!muerto)
        {
            translate = new TranslateTransition();
            imagenView.setImage(new Image(movimiento[0]));
            setPosx(posxfinal);
            segacutal = translate.getCurrentTime();
            translate.setByX(posxfinal);
            translate.setDuration(Duration.seconds(getSpeed()));
            translate.setNode(imagenView);
            sprite(movimiento);
            translate.play();
            translate.setOnFinished((t) ->
            {
                sprite(ataque);
            });
        }

    }

    public void playSound()
    {

        musica = new AudioClip(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/zombieauch.mp3").toString());
        musica.setCycleCount(AudioClip.INDEFINITE);
        musica.setVolume(0.05);
        musica.play();

    }

    @Override
    public void dect(Circle bullet , int damage)
    {
        if(imagenView.getBoundsInParent().intersects(bullet.getBoundsInParent()))
        {
            // System.out.println("Le di");
            if(!muerto)
            {
                setVida(getVida() - damage);
            }
        }

    }

    @Override
    public void detectF(Circle bullet , int time)
    {
        if(imagenView.getBoundsInParent().intersects(bullet.getBoundsInParent()))
        {
            // System.out.println("Le di");
            congelado = true;
            if(!muerto && congelado == true)
            {
                try
                {
                    taskThread.sleep(time);
                    translate.wait(time);
                }
                catch(InterruptedException ex)
                {
                    Logger.getLogger(Mob.class.getName()).log(Level.SEVERE , null , ex);
                }
            }
        }
        else
        {
            congelado = false;
        }

    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Mob{vida=").append(vida);
        sb.append(", posx=").append(posx);
        sb.append(", posy=").append(posy);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", speed=").append(speed);
        sb.append(", movimiento=").append(movimiento);
        sb.append(", ataque=").append(ataque);
        sb.append(", dead=").append(dead);
        sb.append(", imagenView=").append(imagenView);
        sb.append(", posxfinal=").append(posxfinal);
        sb.append(", musica=").append(musica);
        sb.append(", muerto=").append(muerto);
        sb.append(", contataques=").append(contataques);
        sb.append(", a=").append(a);
        sb.append(", cont=").append(cont);
        sb.append(", parar=").append(parar);
        sb.append(", translate=").append(translate);
        sb.append('}');
        return sb.toString();
    }

    public Boolean getMuerto()
    {
        return muerto;
    }

    public int getContataques()
    {
        return contataques;
    }

    public void setContataques(int contataques)
    {
        this.contataques = contataques;
    }

    public void congelar(int time)
    {
        try
        {
            translate.wait(time);
            taskThread.wait(time);
        }
        catch(InterruptedException ex)
        {
            Logger.getLogger(Mob.class.getName()).log(Level.SEVERE , null , ex);
        }
    }

    @Override
    public void pausar()
    {
        System.out.println("Me paré");
        if(!muerto)
        {
            translate.pause();
            taskThread.stop();
        }

    }

    @Override
    public void iniciar()
    {
        System.out.println("Seguí");
        if(!muerto)
        {
            translate.play();
            taskThread.resume();

        }

    }

    public boolean isCongelado()
    {
        return congelado;
    }

    public void setCongelado(boolean congelado)
    {
        this.congelado = congelado;
    }

}
