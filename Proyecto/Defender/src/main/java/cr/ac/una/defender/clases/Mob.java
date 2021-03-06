/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import java.util.*;
import javafx.animation.*;
import javafx.application.*;
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

    public void setVida(int vida)//Cuando se setea la vida de recibir damage este para el translate y ejecuta el spripte morir
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
    public Hilos hilo;
    public String[] current;

    public void sprite(String[] nombre)//rcibe como valor el nombre del spirte a realizar mas su respectivo array de imagenes
    {
        hilo = new Hilos();
        current = nombre;
        cont = 0;
        a = 81;

        if(current == movimiento)
        {
            if(current.length > 7)
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

        else if(current == dead)
        {
            a = current.length;
            //System.out.println("El valor es " + a);
            parar = true;
            muerto = true;

        }

        hilo.start();
        cont = 0;
    }

    //public Duration segacutal;
    @Override
    public void Start()//se encarga de dar inicio a todo, empezado en una posicion x del grid hasta terminar en  otra, haciendo un traslate
    {
        if(!muerto)
        {
            translate = new TranslateTransition();
            imagenView.setImage(new Image(movimiento[0]));
            setPosx(posxfinal);
            //segacutal = translate.getCurrentTime();
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

    @Override
    public void dect(Circle bullet , int damage)//se encarga de detectar la colicion de las balas 
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
    public void detectF(Circle spell , int time)//se encarga de detectar la colicion con los spells
    {
        if(imagenView.getBoundsInParent().intersects(spell.getBoundsInParent()))
        {
            if(!muerto)
            {
                hilo.pause();
                translate.pause();

                Timer myTimer = new Timer();
                myTimer.schedule(new TimerTask()
                {

                    @Override
                    public void run()
                    {
                        hilo.continuee();
                        translate.play();
                    }
                } , time);

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

    @Override
    public void pausar()//se encarga de hacer la pausa
    {
        System.out.println("Me par??");
        if(!muerto)
        {
            hilo.pause();
            translate.pause();
        }

    }

    @Override
    public void iniciar()//se encarga de reanudar la pausa
    {
        System.out.println("Segu??");
        if(!muerto)
        {
            if(current != ataque)
            {
                translate.play();

            }

            hilo.continuee();

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

    private class Hilos extends Thread
    {

        public Object lock = this;
        public boolean pause = false;

        public void pause()
        {
            pause = true;
        }

        public void continuee()
        {
            pause = false;
            synchronized(lock)
            {
                lock.notifyAll();
            }
        }

        private void pauseThread() throws InterruptedException
        {
            synchronized(lock)
            {
                if(pause)
                {
                    lock.wait(); // Note that this can cause an InterruptedException
                }
            }
        }

        @Override
        public void run()//metodo
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
                        if(current == ataque && parar == false)
                        {
                            if(getMuerto() == true)
                            {
                                i = a;
                                hilo.stop();
                                cont = 0;
                                sprite(dead);
                            }
                            a += 50;
                        }
                        // System.out.println("La accion fue " + nombre.toString());
                        if(hilo.pause != true)
                        {
                            imagenView.setImage(new Image(current[cont]));
                            cont++;
                        }
                        if(hilo.pause != true && muerto == true)
                        {
                            imagenView.setImage(new Image(current[cont]));
                            cont++;
                        }
                        int x = current.length - 1;
                        if(cont > x)
                        {
                            cont = 0;
                            if(current == ataque && muerto == false)
                            {
                                setContataques(getContataques() + 1);
                                //System.out.println("El damage es " + getContataques());
                            }
                        }

                    }

                });

            }
        }

    }
}
