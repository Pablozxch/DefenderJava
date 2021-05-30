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
import javafx.scene.image.*;
import javafx.scene.layout.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class RegisterController implements Initializable
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
    private JFXPasswordField Txf_pass1;
    @FXML
    private JFXButton Btn_register;
    @FXML
    private JFXButton Btn_back;
    @FXML
    private AnchorPane root2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource()==Btn_back)
        {
            FlowController.getInstance().goVista("Login");
        }
        if(event.getSource()==Btn_register)
        {
            if(Txf_pass.getText()!=Txf_pass1.getText())
            {
                System.out.println("Digite correctamente las contraseñas");
            }
            else
            {
                FlowController.getInstance().goVista("Login");
            }
        }
    }
    
}
