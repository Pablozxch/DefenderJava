/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.utils.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class LoginController extends Controller implements Initializable
{

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imv_fondo;
    @FXML
    private JFXTextField Txf_user;
    @FXML
    private JFXPasswordField Txf_pass;
    @FXML
    private JFXButton Btn_login;
    @FXML
    private JFXButton Btn_register;
    @FXML
    private AnchorPane root2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        //imv_fondo.fitHeightProperty().bind(root.heightProperty());
        //imv_fondo.fitWidthProperty().bind(root.widthProperty());
        System.out.println("puto");

    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource()==Btn_register)
        {
            FlowController.getInstance().goVista("Register");
        }
        if(event.getSource()==Btn_login)
        {
            FlowController.getInstance().goVista("Menu");
            System.out.println("Pasó al menu del juego");
        }
    }

}
