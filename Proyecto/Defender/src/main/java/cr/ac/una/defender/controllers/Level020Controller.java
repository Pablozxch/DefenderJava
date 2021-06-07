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
    private ImageView Imv_sp1;
    @FXML
    private JFXButton Btn_spell2;
    @FXML
    private ImageView Imv_sp2;
    @FXML
    private JFXButton Btn_spell3;
    @FXML
    private ImageView Imv_sp3;
    private Timeline timeline;
    private Duration TiemS = Duration.ZERO;

    private Duration TiemM = Duration.ZERO;

    /**
     * Initializes the controller class.
     */
    private Monstruo mostruo = new Monstruo(200 , Tipo.TIPO1);
    ImageView mm = new ImageView(mostruo.getMovimiento()[0]);
    ImageView mmm = new ImageView(mostruo.getAtaque()[0]);
    public Timer tiempo = new Timer();
    int col = 10;
    int col2 = 10;
    int cont = 0;
    int cont2 = 0;
    Random randd = new Random();
    int rr;

    @Override

    public void initialize(URL url , ResourceBundle rb)
    {

        mm.setFitHeight(70);
        mm.setFitWidth(60);
        mmm.setFitHeight(70);
        mmm.setFitWidth(60);
        grid.getChildren().addAll(mm);
        grid.getChildren().addAll(mmm);
        GridPane.setConstraints(mm , 9 , 0);
        GridPane.setConstraints(mmm , 0 , 3);
        primerS();

        //para varias cosas necesito crear la cantidad necesario para esto
//        primerS();
    }

    void primerS()//este metodo se encarga de hacer el movimiento por si solo, tengo que ver como lo hago de manera global o bueno ya veremos xD
    {
        Thread taskThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < 10; i++)
                {

                    try
                    {
                        Thread.sleep(350);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    Platform.runLater(new Runnable()
                    {
                        @Override

                        public void run()
                        {
                            col--;

                            GridPane.setConstraints(mm , col , rr);
                            mm.setImage(new Image(mostruo.getMovimiento()[cont]));
                            cont++;
                            if(cont == 6)
                            {
                                cont = 0;
                            }

                            GridPane.setConstraints(mmm , 0 , 3);
                            mmm.setImage(new Image(mostruo.getAtaque()[cont2]));
                            cont2++;
                            if(cont2 == 3)
                            {
                                cont2 = 0;
                            }

                        }

                    });
                }
            }
        });

        taskThread.start();
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
