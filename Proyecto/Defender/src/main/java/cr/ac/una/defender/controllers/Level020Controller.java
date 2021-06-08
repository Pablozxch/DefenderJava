/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.clases.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.transform.*;
import javafx.util.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class Level020Controller extends Controller implements Initializable
{

    @FXML
    private AnchorPane root;
    @FXML
    private HBox Hbx_stats;
    @FXML
    private Label Lbl_money;
    @FXML
    private Label Lbl_diamantes;
    @FXML
    private GridPane grid;
    @FXML
    private JFXButton Btn_spell1;
    @FXML
    private JFXButton Btn_pause;
    @FXML
    private JFXButton Btn_spell2;
    @FXML
    private ImageView Imv_sp2;
    @FXML
    private JFXButton Btn_spell3;
    @FXML
    private ImageView Imv_sp3;
    @FXML
    private ImageView Imv_sp31;

    /**
     * Initializes the controller class.
     */
    private Monstruo caba = new Caballero(100,9 , 0);
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {

    }

    void ataque()
    {

    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void llenadomonstruos()
    {
        //  mostruo.ejecutarMovimiento("");

    }

}
