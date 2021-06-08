/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import cr.ac.una.defender.clases.*;
import cr.ac.una.defender.models.*;
import java.io.*;
import java.util.*;
import javafx.beans.property.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.media.*;
import javafx.stage.*;
import javafx.util.*;

/**
 *
 * @author jp015
 */
public abstract class Controller
{

    private Stage stage;
    private String accion;
    private static UserDto datos = new UserDto();
    public AudioClip musica;

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

    public void sendTabEvent(KeyEvent event)
    {
        event.consume();
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED , null , null , KeyCode.TAB , false , false , false , false);
        ((Control) event.getSource()).fireEvent(keyEvent);
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
        musica = new AudioClip(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Menu.mp3").toString());
        musica.setCycleCount(AudioClip.INDEFINITE);
        musica.setVolume(0.05);
        musica.play();

    }

    public void sonidobotones()
    {
        musica = new AudioClip(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Boton.wav").toString());
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
        musica = new AudioClip(this.getClass().getResource("/cr/ac/una/defender/resources/sonidos/Cmonedas.wav").toString());
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();
    }
    public abstract void initialize();
}
