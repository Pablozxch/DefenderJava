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

    public abstract void initialize();
}
