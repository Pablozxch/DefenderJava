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
    int esmeraldas = 0;
    int fuerza = 0;
    int agilidad = 0;
    int retroceso = 0;
    int ddamage = 0;
    int tirodobble = 0;
    int lvl = 1;
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
        llenartodo();
        llenarspells();
        setinfo();

    }

    public void llenartodo()
    {
        esmeraldas = getDatos().getDinero().intValue();
        esmeraldas = getDatos().getEsmeralda().intValue();
        fuerza = getDatos().getLvlFuerza().intValue();
        agilidad = getDatos().getLvlAgilidad().intValue();
        retroceso = getDatos().getLvlRetroceso().intValue();
        ddamage = getDatos().getLvlDDamage().intValue();
        lvl = getDatos().getLvl().intValue();
        vida = getDatos().getmVida().intValue();
        mana = getDatos().getmMana().intValue();

        fireball = getDatos().getLvlFireBall().intValue();
        freeze = getDatos().getLvlFreeze().intValue();
        lightning = getDatos().getLvlRayo().intValue();
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
                ragnarok = 1;

                break;
            case 8:
                ragnarok = 2;

                break;
            case 9:
                ragnarok = 3;

                break;
            default:

                break;
        }

    }

    public void setinfo()
    {
        Lbl_money.setText(String.valueOf(esmeraldas));
        Lbl_diamantes.setText(String.valueOf(esmeraldas));
        Lbl_stage.setText("Stage :" + String.valueOf(lvl));
    }

    public void acutalizarpantalla()
    {
        Lbl_money.setText(String.valueOf(esmeraldas));
        Lbl_diamantes.setText(String.valueOf(esmeraldas));
        Lbl_stage.setText("Stage :" + String.valueOf(lvl));
        sonidobotones();
        comprado();
        mostrarinfo();
    }

    public void mostrarinfo()
    {
        Lbl_info.setText("En esta parte se van a mostrar todo el tipo de informacion sobre las mejoras "
                  + "que\n puedes realizar  en el juego");
    }

    @FXML
    private void click(ActionEvent event)
    {

        if(event.getSource() == Btn_defender)
        {
            mostrarinfo();
        }
        else if(event.getSource() == Btn_Castillo)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("1");
            switch(vida)
            {
                case 0:
                    Lbl_info.setText("Incrementa el daño de la ballesta "
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("200");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el daño de la ballesta "
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("400");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño de la ballesta "
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "1".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(vida == 0 & esmeraldas >= 200)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 200;
                    vida = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(vida == 1 & esmeraldas >= 400)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 400;
                    vida = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(vida == 2 & esmeraldas >= 600)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage(), "Comprado con exito");
                    esmeraldas -= 600;
                    vida = 3;
                    acutalizarpantalla();

                }

            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_mana)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("2");
            switch(mana)
            {
                case 0:
                    Lbl_info.setText("Incrementa la cantidad de mana"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("250");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de mana"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("450");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de mana"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("650");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "2".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(mana == 0 & esmeraldas >= 250)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    mana = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(mana == 1 & esmeraldas >= 450)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    mana = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(mana == 2 & esmeraldas >= 650)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    mana = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_fuerza)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("3");
            switch(fuerza)
            {
                case 0:
                    Lbl_info.setText("Incrementa la cantidad de fuerza"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de fuerza"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de fuerza"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");
                    sonidobotones();

                    break;
                default:
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "3".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(fuerza == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    fuerza = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fuerza == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    fuerza = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fuerza == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    fuerza = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_agilidad)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("4");
            switch(agilidad)
            {
                case 0:
                    Lbl_info.setText("Incrementa la cantidad de agilidad"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de agilidad"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de agilidad"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }

        else if(event.getSource() == Btn_upgrade & "4".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(agilidad == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    agilidad = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(agilidad == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    agilidad = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(agilidad == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    agilidad = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_retroceso)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("5");
            switch(retroceso)
            {
                case 0:
                    Lbl_info.setText("Incrementa la cantidad de retroceso"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de retroceso"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de retroceso"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "5".equals(Lbl_info.getId()) & fuerza >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(retroceso == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    retroceso = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(retroceso == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    retroceso = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(retroceso == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    retroceso = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_ddamage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("6");
            switch(ddamage)
            {
                case 0:
                    Lbl_info.setText("Incrementa el porcentaje del daño doble"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el porcentaje del daño doble"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el porcentaje del daño doble"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "6".equals(Lbl_info.getId()) & agilidad >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(ddamage == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    ddamage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ddamage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    ddamage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ddamage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    ddamage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_tirodoble)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/money.png"));
            Lbl_info.setId("7");
            switch(tirodobble)
            {
                case 0:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "7".equals(Lbl_info.getId()) & agilidad >= 3 & fuerza >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(tirodobble == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    tirodobble = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(tirodobble == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    tirodobble = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(tirodobble == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    tirodobble = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_fireball)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("8");
            switch(fireball)
            {
                case 0:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }

        else if(event.getSource() == Btn_upgrade & "8".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(fireball == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    fireball = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fireball == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    fireball = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fireball == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    fireball = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_freeze)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("9");
            switch(freeze)
            {
                case 0:
                    Lbl_info.setText("Incrementa el tiempo de hielo"
                              + "Current: " + 2 + " \n"
                              + "Next: " + 4);
                    Lbl_ccompra.setText("300");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de hielo"
                              + "Current: " + 6 + " \n"
                              + "Next: " + 8);
                    Lbl_ccompra.setText("600");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de hielo"
                              + "Current: " + 8 + " \n"
                              + "Next: " + 10);
                    Lbl_ccompra.setText("800");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }

        else if(event.getSource() == Btn_upgrade & "9".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(freeze == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    freeze = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(freeze == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    freeze = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(freeze == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    freeze = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_lightning)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("10");
            switch(lightning)
            {
                case 0:
                    Lbl_info.setText("Incrementa el daño del rayo"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 15);
                    Lbl_ccompra.setText("300");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el daño del rayo"
                              + "Current: " + 15 + " \n"
                              + "Next: " + 20);
                    Lbl_ccompra.setText("600");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño del rayo"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 25);
                    Lbl_ccompra.setText("800");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "10".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(lightning == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    lightning = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(freeze == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    lightning = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(lightning == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    lightning = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_meteor)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("11");
            switch(meteor)
            {
                case 0:
                    Lbl_info.setText("Incrementa el daño del fireball lvl2"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el daño del fireball lvl2"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño del fireball lvl2"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "11".equals(Lbl_info.getId()) & fireball >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(meteor == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    meteor = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(meteor == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    meteor = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(meteor == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    meteor = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_frostage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("12");
            switch(frostage)
            {
                case 0:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "12".equals(Lbl_info.getId()) & freeze >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(frostage == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    frostage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(frostage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    frostage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(frostage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    frostage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_thunderstorm)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("13");
            switch(thunderstorm)
            {
                case 0:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "13".equals(Lbl_info.getId()) & lightning >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(thunderstorm == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    thunderstorm = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(thunderstorm == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    thunderstorm = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(thunderstorm == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    thunderstorm = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_iceage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("14");
            switch(aceage)
            {
                case 0:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "15".equals(Lbl_info.getId()) & frostage >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(aceage == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    aceage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    aceage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    aceage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_armagedon)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("15");
            switch(armagedon)
            {
                case 0:
                    Lbl_info.setText("Incrementa el el daño de armagedon"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el el daño de armagedon"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño de armagedon"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "15".equals(Lbl_info.getId()) & frostage >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(aceage == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    aceage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    aceage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    aceage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_ragnarok)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("16");
            switch(ragnarok)
            {
                case 0:
                    Lbl_info.setText("Incrementa el el daño de armagedon"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el el daño de armagedon"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño de armagedon"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "16".equals(Lbl_info.getId()) & thunderstorm >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(ragnarok == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 250;
                    ragnarok = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ragnarok == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 450;
                    ragnarok = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ragnarok == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , getStage() , "Comprado con exito");
                    esmeraldas -= 650;
                    ragnarok = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , getStage() , "No hay Dinero");
            }
        }
        else if(event.getSource()
                  == Btn_next)
        {
            FlowController.getInstance().goVista("Level020");
        }
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
