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
    @FXML
    private AnchorPane root2;
    @FXML
    private JFXButton Btn_defender;
    @FXML
    private JFXButton Btn_Castillo;
    @FXML
    private JFXButton Btn_mana;
    @FXML
    private JFXButton Btn_fuerza;
    @FXML
    private JFXButton Btn_agilidad;
    @FXML
    private JFXButton Btn_retroceso;
    @FXML
    private JFXButton Btn_ddamage;
    @FXML
    private JFXButton Btn_tirodoble;
    @FXML
    private JFXButton Btn_fireball;
    @FXML
    private JFXButton Btn_freeze;
    @FXML
    private JFXButton Btn_lightning;
    @FXML
    private JFXButton Btn_meteor;
    @FXML
    private JFXButton Btn_frostage;
    @FXML
    private JFXButton Btn_thunderstorm;
    @FXML
    private JFXButton Btn_armagedon;
    @FXML
    private JFXButton Btn_iceage;
    @FXML
    private JFXButton Btn_ragnarok;
    @FXML
    private JFXButton Btn_next;
    @FXML
    private JFXButton Btn_upgrade;
    @FXML
    private AnchorPane root;
    @FXML
    private Label Lbl_info;
    @FXML
    private ImageView imgv_ccomprar;
    @FXML
    private Label Lbl_ccompra;
    /**
     * Initializes the controller class.
     */
    int dinero = 0;
    int esmeraldas = 0;
    int fuerza = 0;
    int agilidad = 0;
    int retroceso = 0;
    int ddamage = 0;
    int lvl=1;
    int vida = 0;
    int mana = 0;

    int fireball = 0;
    int freeze = 0;
    int lightning = 0;

    int meteor = 0;
    int frostage = 0;
    int thunderstorm = 0;

    int armagedon = 0;
    int aceage = 0;
    int ragnarok = 0;
    @FXML
    private Label Lbl_stage;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
       //llenartodo();
        llenarspells();
        Lbl_money.setText(String.valueOf(dinero));
        Lbl_diamantes.setText(String.valueOf(esmeraldas));
        Lbl_stage.setText("Stage :" +String.valueOf(lvl));

    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void llenartodo()
    {
        dinero = Integer.parseInt(getDatos().getDinero());
        esmeraldas = Integer.parseInt(getDatos().getEsmeralda());
        fuerza = Integer.parseInt(getDatos().getLvlFuerza());
        agilidad = Integer.parseInt(getDatos().getLvlAgilidad());
        retroceso = Integer.parseInt(getDatos().getLvlRetroceso());
        ddamage = Integer.parseInt(getDatos().getLvlDDamage());
        lvl= Integer.parseInt(getDatos().getLvl());
        vida = Integer.parseInt(getDatos().getmVida());
        mana = Integer.parseInt(getDatos().getmMana());

        fireball = Integer.parseInt(getDatos().getLvlFireBall());
        freeze = Integer.parseInt(getDatos().getLvlFreeze());
        lightning = Integer.parseInt(getDatos().getLvlRayo());
    }

    public void llenarspells()
    {
        switch(fireball)
        {
            case 4:
                meteor = 1;
                break;
            case 5:
                meteor = 2;
                break;
            case 6:
                meteor = 3;
                break;
            case 7:
                armagedon = 1;
                break;
            case 8:
                armagedon = 2;
                break;
            case 9:
                armagedon = 3;
                break;
            default:
                break;
        }
        switch(freeze)
        {
            case 4:
                frostage = 1;
                break;
            case 5:
                frostage = 2;
                break;
            case 6:
                frostage = 3;
                break;

            case 7:
                aceage = 1;
                break;
            case 8:
                aceage = 2;
                break;
            case 9:
                aceage = 3;
                break;
            default:
                break;
        }
        switch(lightning)
        {
            case 4:
                thunderstorm = 1;
                break;
            case 5:
                thunderstorm = 2;
                break;
            case 6:
                thunderstorm = 3;
                break;
            case 7:
                ragnarok = 3;
                break;
            case 8:
                ragnarok = 3;
                break;
            case 9:
                ragnarok = 3;
                break;
            default:
                break;
        }

    }

    @FXML

    private void click(ActionEvent event)
    {
        if(event.getSource() == Btn_defender)
        {
            Lbl_info.setText("En esta parte se van a mostrar todo el tipo de \n informacion sobre las mejoras "
                      + "que puedes \nrealizar  en el juego");
        }
        if(event.getSource() == Btn_Castillo)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setText("Incrementa el daño de la ballesta \n"
                      + "Current: 10 \n"
                      + "Next: 15");
        }
        if(event.getSource() == Btn_mana)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_fuerza)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
        }
        if(event.getSource() == Btn_agilidad)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
        }
        if(event.getSource() == Btn_retroceso)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
        }
        if(event.getSource() == Btn_ddamage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
        }
        if(event.getSource() == Btn_tirodoble)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
        }
        if(event.getSource() == Btn_fireball)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_freeze)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_lightning)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_meteor)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_frostage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_thunderstorm)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_iceage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_armagedon)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_ragnarok)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
        if(event.getSource() == Btn_next)
        {
            FlowController.getInstance().goVista("Level020");
        }
        if(event.getSource() == Btn_upgrade)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
        }
    }

}
