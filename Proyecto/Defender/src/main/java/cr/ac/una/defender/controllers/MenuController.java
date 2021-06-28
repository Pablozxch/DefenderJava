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
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

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
    @FXML
    private JFXButton btnTabla;
    @FXML
    private JFXButton btnAcercaDe;
    @FXML
    private JFXButton btnAyuda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {

        musica();
    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event) throws IOException
    {
        if(event.getSource() == Btn_play)
        {
            paramusica();
            musica.stop();
            sonidobotones();
            FlowController.getInstance().goVista("PreGame");
        }
        else if(event.getSource() == Btn_salir)
        {
            sonidobotones();
            paramusica();
            FlowController.getInstance().salir();
        }
        else if(event.getSource() == btnTabla)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/defender/views/Puntuacion.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setOpacity(1);
            Scene scene = new Scene(root , 647 , 474);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
            stage.setTitle("Defender");
            stage.resizableProperty().set(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Btn_play.getScene().getWindow());
            stage.centerOnScreen();
            stage.showAndWait();

        }
        else if(event.getSource() == btnAcercaDe)
        {
            sonidobotones();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/defender/views/AcercaDe.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setOpacity(1);
            Scene scene = new Scene(root , 600 , 400);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
            stage.setTitle("Defender");
            stage.resizableProperty().set(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Btn_play.getScene().getWindow());
            stage.centerOnScreen();
            stage.showAndWait();

        }
        else if(event.getSource() == btnAyuda)
        {
            sonidobotones();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/defender/views/ComoJugar.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setOpacity(1);
            Scene scene = new Scene(root , 600 , 400);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
            stage.setTitle("Defender");
            stage.resizableProperty().set(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Btn_play.getScene().getWindow());
            stage.centerOnScreen();
            stage.showAndWait();

        }
    }

}
