/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.controller;

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
    public MediaPlayer reproductor;

   final ArrayList<String> listacanciones = new ArrayList();
//    int a = 0;

    public void Agregarcanciones()
    {
        listacanciones.add("src\\main\\resources\\cr\\ac\\una\\musica/Aitepego.mp3");
        listacanciones.add("src\\main\\resources\\cr\\ac\\una\\musica/ontop.mp3");
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

    public void sendTabEvent(KeyEvent event)
    {
        event.consume();
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED , null , null , KeyCode.TAB , false , false , false , false);
        ((Control) event.getSource()).fireEvent(keyEvent);
    }

    public void Musica(int a)
    {
        int b = a;
        if(b >= listacanciones.size())
        {
            b = 0;
        }
        File archivo = new File((String) listacanciones.get(b));
        //System.out.println("El valro es " + b);

        Media audio = new Media(archivo.toURI().toString());
        reproductor = new MediaPlayer(audio);
        reproductor.play();
        int c = b;
        reproductor.setVolume(0.03);
        reproductor.setOnEndOfMedia(() ->
        {
            Musica(c + 1);
        });

    }

    public void pasarmuscia(KeyEvent event)
    {
        
        
    }

    public abstract void initialize();
}
