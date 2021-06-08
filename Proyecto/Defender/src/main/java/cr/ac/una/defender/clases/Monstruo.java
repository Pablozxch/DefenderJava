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
public class Monstruo implements Accion
{

    private int vida;
    private String[] caminar;
    private String[] morir;
    private String[] atacar;
    private int x;
    private int y;
    private ImageView imagen;

    public Monstruo()
    {
    }

    public Monstruo(int vida , int x , int y)
    {
        this.vida = vida;
        this.x = x;
        this.y = y;
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public String[] getCaminar()
    {
        return caminar;
    }

    public void setCaminar(String[] caminar)
    {
        this.caminar = caminar;
    }

    public String[] getMorir()
    {
        return morir;
    }

    public void setMorir(String[] morir)
    {
        this.morir = morir;
    }

    public String[] getAtacar()
    {
        return atacar;
    }

    public void setAtacar(String[] atacar)
    {
        this.atacar = atacar;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public ImageView getImagen()
    {
        return imagen;
    }

    public void setImagen(ImageView imagen)
    {
        this.imagen = imagen;
    }

    @Override
    public void caminar()
    {
        for(String caminar1 : caminar)
        {
            ImageView ss= new ImageView(new Image(caminar1));
            ss.setX(500);
            ss.setY(200);
            ss.visibleProperty().set(true);
            System.out.println("asd"+caminar1);
        }
    }

    @Override
    public void atacar()
    {
        for(String atacar1 : atacar)
        {
            System.out.println(atacar1);
        }
    }

    @Override
    public void morir()
    {
        for(String morir1 : morir)
        {
            System.out.println(morir1);
        }
    }

}
