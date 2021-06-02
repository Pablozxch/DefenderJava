/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.clases.*;
import cr.ac.una.defender.models.*;
import cr.ac.una.defender.services.*;
import cr.ac.una.defender.utils.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
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
    UserDto userDto = new UserDto();
    UserService service = new UserService();
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
        if(event.getSource() == Btn_register)
        {
            FlowController.getInstance().goVista("Register");
        }
        if(event.getSource() == Btn_login)
        {

            if(Txf_pass.getText().isEmpty() || Txf_user.getText().isEmpty())
            {
                new Mensaje().showModal(Alert.AlertType.WARNING , "Usuario " , getStage() , "Faltan Datos");
            }
            else
            {
                String username=Txf_user.getText();
                String pass=Txf_pass.getText();
                Respuesta respuesta = service.getUser(username , pass);
                if(respuesta.getEstado())
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Usuario " , getStage() , "Usuario encontrado");
                    setDatos(new Datos());
                    FlowController.getInstance().goVista("Menu");
                }
                else
                {
                    new Mensaje().showModal(Alert.AlertType.ERROR , "Usuario " , getStage() , "Datos incorrectos");
                    Txf_user.clear();
                    Txf_pass.clear();
                }

            }
        }
    }

    @FXML
    private void keypressed(KeyEvent event)
    {
        
    }

}
