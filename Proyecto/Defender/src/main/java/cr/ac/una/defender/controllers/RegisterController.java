/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.models.*;
import cr.ac.una.defender.services.*;
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
public class RegisterController extends Controller implements Initializable
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
    UserDto userDto = new UserDto();
    UserService service = new UserService();

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == Btn_back)
        {
            FlowController.getInstance().goVista("Login");
        }
        if(event.getSource() == Btn_register)
        {
            if(Txf_user.getText().isEmpty())
            {
                new Mensaje().showModal(Alert.AlertType.WARNING , "Usuario " , getStage() , "Por favor digite el usuario");

            }
            else if((Txf_pass.getText().isEmpty() || Txf_pass1.getText().isEmpty()))
            {
                new Mensaje().showModal(Alert.AlertType.INFORMATION , "Contraseñas " , getStage() , "No digito alguna de las contraseñas");

            }
            else if(!Txf_pass.getText().equals(Txf_pass1.getText()))
            {

                new Mensaje().showModal(Alert.AlertType.WARNING , "Contraseñas " , getStage() , "Por favor digite correctamente las contraseñas");
                Txf_pass.clear();
                Txf_pass1.clear();
            }
            else
            {
                String username = Txf_user.getText();
                String pass = Txf_pass.getText();
                userDto.setUsername(username);
                userDto.setPass(pass);
                service.guardarUser(userDto);
                new Mensaje().showModal(Alert.AlertType.INFORMATION , "Usuario " , getStage() , "Usuario Registrado con exito");
                FlowController.getInstance().goVista("Login");
            }
        }
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
