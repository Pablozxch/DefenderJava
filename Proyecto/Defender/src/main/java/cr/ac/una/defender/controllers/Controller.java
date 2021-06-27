/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import cr.ac.una.defender.models.*;
import javafx.scene.media.*;
import javafx.stage.*;

/**
 *
 * @author jp015
 */
public abstract class Controller
{

    private Stage stage;
    private String accion;
    private static UserDto datos = new UserDto();
    public MediaPlayer musica;
    Boolean completado = false;
    private int valor;

    public Boolean getCompletado()
    {
        return completado;
    }

    public void setCompletado(Boolean completado)
    {
        this.completado = completado;
    }

    public String getAccion()
    {
        return accion;
    }

    public void setAccion(String accion)
    {
        this.accion = accion;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public Stage getStage()
    {

        return stage;
    }

    public UserDto getDatos()
    {
        return datos;
    }

    public void setDatos(UserDto datos)
    {
        this.datos = datos;
    }

    public void musica()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Menu.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(AudioClip.INDEFINITE);
        musica.setVolume(0.02);
        musica.play();

    }

    public void sonidobotones()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Boton.wav").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();
    }

    public void paramusica()
    {
        musica.stop();
    }

    public void comprado()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Cmonedas.wav").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();
    }

    public void disparar()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/flecha.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void sonidodebatalla()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/campoBatalla.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(AudioClip.INDEFINITE);
        musica.setVolume(0.06);
        musica.play();
    }

    public void playSound2()
    {

        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Zombie.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();

    }

    public void playRayo()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Rayo.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(1);
        musica.play();
    }

    public void playC14()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/C14.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(AudioClip.INDEFINITE);
        musica.setVolume(0.5);
        musica.play();
    }

    public void playFireball()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Fire.wav").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(1);
        musica.play();
    }

    public void playFreeze()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/freeze.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(1);
        musica.play();
    }

    public void playZ()
    {

        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/zombieauch.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();

    }

    public void playC()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Caba.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void plaA()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Alien.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void playR()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Robot.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void pasarlvl()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/ParaPasarLvl.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void playlevelcomplete()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/LvlComplete.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void playFinalGame()

    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/FinalGame.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void playPerdio()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Perdio.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.07);
        musica.play();
    }

    public void onAccion(int op)
    {
        switch(op)
        {
            case 1:
                this.valor = 1;//regresar a jugar
            case 2:
                this.valor = 2;//menu config
                break;
            case 3:
                this.valor = 3;//salir al menu principal
                break;
            case 4:
                this.valor = 4;//reiniciar
            case 5:
                this.valor = 5;
                break;
            case 6:
                this.valor = 6;
                break;
            default:
                break;
        }

    }

    public abstract void initialize();

    public int getValor()
    {
        return valor;
    }

    public void setValor(int valor)
    {
        this.valor = valor;
    }

}
