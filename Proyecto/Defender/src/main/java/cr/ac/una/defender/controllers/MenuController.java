/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.utils.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MenuController extends Controller implements Initializable
{

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imv_fondo;
    @FXML
    private Label Lbl_nombre;
    @FXML
    private JFXButton Btn_play;
    @FXML
    private JFXButton Btn_salir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }    

    @Override
    public void initialize()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource()==Btn_play)
        {
            FlowController.getInstance().goVista("PreGame");
        }
        if(event.getSource()==Btn_salir)
        {
            FlowController.getInstance().salir();
        }
    }
    
}
