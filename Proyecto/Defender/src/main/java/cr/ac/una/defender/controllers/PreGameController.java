/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import cr.ac.una.defender.utils.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class PreGameController extends Controller implements Initializable
{

    @FXML
    private HBox Hbx_stats;
    @FXML
    private Label Lbl_money;
    @FXML
    private Label Lbl_diamantes;
    private ImageView Imv_next;

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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
