/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.utils;

import cr.ac.una.defender.clases.App;
import cr.ac.una.defender.controllers.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FlowController
{

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
    private static ResourceBundle idioma;
    private static HashMap<String , FXMLLoader> loaders = new HashMap<>();

    private FlowController()
    {

    }

    private static void createInstance()
    {
        if(INSTANCE == null)
        {
            synchronized(FlowController.class)
            {
                if(INSTANCE == null)
                {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance()
    {
        if(INSTANCE == null)
        {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage , ResourceBundle idioma)
    {
        getInstance();
        this.mainStage = stage;
        this.idioma = idioma;
    }

    private FXMLLoader getLoader(String name)
    {
        FXMLLoader loader = loaders.get(name);
        if(loader == null)
        {
            synchronized(FlowController.class)
            {
                if(loader == null)
                {
                    try
                    {
                        loader = new FXMLLoader(App.class.getResource("/cr/ac/una/defender/views/" + name + ".fxml") , this.idioma);
                        loader.load();
                        loaders.put(name , loader);
                    }
                    catch(Exception ex)
                    {
                        loader = null;
                        java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE , "Creando loader [" + name + "]." , ex);
                    }
                }
            }
        }
        return loader;
    }

    public void goVista(String nombreVista)
    {
        try
        {

            this.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/cr/ac/una/defender/views/" + nombreVista + ".fxml") , this.idioma)));
            this.mainStage.setFullScreen(true);
            this.mainStage.show();
        }
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE , "Error inicializando la vista base." , ex);
        }
    }

    public void goVistaPuntuacion()
    {
        try
        {
            this.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/cr/ac/una/defender/views/Puntuacion.fxml") , this.idioma)));
            this.mainStage.centerOnScreen();
            this.mainStage.show();
        }
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE , "Error inicializando la vista base." , ex);
        }
    }

    public Controller getController(String viewName)
    {
        return getLoader(viewName).getController();
    }

    public void initialize()
    {
        this.loaders.clear();
    }

    public void salir()
    {
        this.mainStage.close();
    }
}
