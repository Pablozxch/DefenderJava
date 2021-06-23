/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import com.sun.glass.events.*;
import cr.ac.una.defender.utils.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class PausaController extends Controller implements Initializable
{

    @FXML
    private JFXButton btnSeguir;
    @FXML
    private JFXButton btn_Ajustes;
    @FXML
    private JFXButton Btn_Reinicar;
    @FXML
    private JFXButton btn_PreGame;
    @FXML
    private JFXButton BtnSeguir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        onAccion(1);
    }

    @FXML
    private void btnAccionSeguir(ActionEvent event)
    {
        sonidobotones();
        onAccion(1);
        Stage stage = (Stage) btnSeguir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnAccionConfig(ActionEvent event)
    {

    }

    @FXML
    private void btnReiniciar(ActionEvent event)
    {
        sonidobotones();
        onAccion(3);
        Stage stage = (Stage) btnSeguir.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void btnAccionRegresarMenu(ActionEvent event)
    {
        sonidobotones();
        Stage stage = (Stage) btnSeguir.getScene().getWindow();
        stage.close();
        FlowController.getInstance().goVista("Pregame");
    }

    @Override
    public void initialize()
    {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
