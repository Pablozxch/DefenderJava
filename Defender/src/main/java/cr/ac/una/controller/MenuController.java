/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.controller;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MenuController extends Controller  implements Initializable
{

    @FXML
    private JFXButton Btn_music;
    @FXML
    private ImageView img_sonido;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void clicks(ActionEvent event)
    {
    }
    
}
