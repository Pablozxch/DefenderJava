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

import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
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
    private ImageView Imv_sp1;
    @FXML
    private ImageView img_ballesta;
    @FXML
    private ProgressBar pgr_vida;
    @FXML
    private ProgressBar pgr_mana;
    @FXML
    private ProgressBar pgr_lvl;
    @FXML
    private ImageView img_arrow;

    private Monstruo Caba = new Caballero(500);
    private Monstruo Caba2 = new Alien(500);
    private Monstruo Caba3 = new Robott(500);
    private Monstruo Caba4 = new Star(500);
    private Monstruo Caba5 = new Zombie(500);
    ImageView m1 = new ImageView();
    ImageView m2 = new ImageView();
    ImageView m3 = new ImageView();
    ImageView m4 = new ImageView();
    ImageView m5 = new ImageView();
    int rotaa = 0;
    Arrow arrow = new Arrow();
    ImageView im = new ImageView();

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
//        m1.setFitHeight(200);
//        m1.setFitWidth(180);
//        grid.getChildren().add(m1);
//        GridPane.setConstraints(m1 , 9 , 0);
//        GridPane.setHalignment(m1 , HPos.CENTER);
//        GridPane.setValignment(m1 , VPos.BOTTOM);
//
//        m2.setFitHeight(200);
//        m2.setFitWidth(180);
//        grid.getChildren().add(m2);
//        GridPane.setConstraints(m2 , 9 , 1);
//        GridPane.setHalignment(m2 , HPos.CENTER);
//        GridPane.setValignment(m2 , VPos.BOTTOM);
//
//        m3.setFitHeight(200);
//        m3.setFitWidth(180);
//        grid.getChildren().add(m3);
//        GridPane.setConstraints(m3 , 9 , 2);
//        GridPane.setHalignment(m3 , HPos.CENTER);
//        GridPane.setValignment(m3 , VPos.BOTTOM);
//
//        m4.setFitHeight(200);
//        m4.setFitWidth(180);
//        grid.getChildren().add(m4);
//        GridPane.setConstraints(m4 , 9 , 3);
//        GridPane.setHalignment(m4 , HPos.CENTER);
//        GridPane.setValignment(m4 , VPos.BOTTOM);
//
//        m5.setFitHeight(150);
//        m5.setFitWidth(120);
//        grid.getChildren().add(m5);
//        GridPane.setConstraints(m5 , 9 , 4);
//        GridPane.setHalignment(m5 , HPos.CENTER);
//        GridPane.setValignment(m5 , VPos.BOTTOM);
//        Caba.caminar(m1 , 0);
//        Caba2.caminar(m2 , 0);
//        Caba3.caminar(m3 , 0);
//        Caba4.caminar(m4 , 0);
//        Caba5.caminar(m5 , 0);
      //  algo();

    }

    public void algo()
    {

        final Timeline timeline = new Timeline(
                  new KeyFrame(Duration.millis(0) , new KeyValue(pgr_lvl.progressProperty() , 0)) ,
                  new KeyFrame(Duration.seconds(10) , new KeyValue(pgr_lvl.progressProperty() , 1))
        );
        timeline.play();
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void disparar() //este metodo se encarga de hacer toda la animacion de disparar
    {
        root.addEventFilter(MouseEvent.MOUSE_CLICKED , (t) ->
        {
            if(t.getButton().PRIMARY == MouseButton.PRIMARY)
            {
                disparar();
            }
        });
    }

}
