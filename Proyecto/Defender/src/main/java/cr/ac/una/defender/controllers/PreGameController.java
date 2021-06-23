/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.services.*;
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
    UserService service = new UserService();
    int esmeraldas = 0;
    int dinero = 0;
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
    int imgBallesta = 0;
    int imgUser = 0;
    @FXML
    private Label Lbl_stage;
    @FXML
    private ImageView imvPistolaEscoger;
    @FXML
    private JFXButton bntT1;
    @FXML
    private JFXButton bntT2;
    @FXML
    private JFXButton bntT3;
    @FXML
    private ImageView img_user;
    @FXML
    private JFXButton btnS;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        llenartodo();//este metodo se encarga de llenar todo lo del usuariuo
        setinfo();//este metodo se encarga de setear la info en pantalla

    }

    public void llenartodo()//llenado de variables del jugador
    {

        imgBallesta = getDatos().getImgBallesta().intValue();
        if(imgBallesta == 0)
        {
            imgBallesta = 1;
        }
        switch(imgBallesta)
        {
            case 1:
                imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun1.png"));
                break;
            case 2:
                imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun2.png"));
                break;
            case 3:
                imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun3.png"));
                break;
            default:
                break;
        }
        imgUser = getDatos().getImgUser().intValue();
        if(imgUser == 0)
        {
            imgUser = 1;
        }
        switch(imgUser)
        {
            case 1:
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU1.png"));
                break;
            case 2:
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU2.png"));
                break;
            case 3:
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU3.png"));
                break;
            case 4:
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU4.png"));
                break;
            case 5:
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU5.png"));
                break;
            default:
                break;
        }

        dinero = getDatos().getDinero().intValue();
        esmeraldas = getDatos().getEsmeralda().intValue();
        fuerza = getDatos().getLvlFuerza().intValue();
        agilidad = getDatos().getLvlAgilidad().intValue();
        retroceso = getDatos().getLvlRetroceso().intValue();
        ddamage = getDatos().getLvlDDamage().intValue();
        tirodobble = getDatos().getLvlTiroDoble().intValue();
        lvl = getDatos().getLvl().intValue();
        vida = getDatos().getmVida().intValue();
        mana = getDatos().getmMana().intValue();

        fireball = getDatos().getLvlFireBall().intValue();
        freeze = getDatos().getLvlFreeze().intValue();
        lightning = getDatos().getLvlRayo().intValue();
        llenarspells();
    }

    public void llenarspells()//llenado de spells
    {

        switch(fireball)
        {
            case 4:
                fireball = 3;
                meteor = 1;
                break;
            case 5:
                fireball = 3;
                meteor = 2;

                break;
            case 6:
                fireball = 3;
                meteor = 3;

                break;
            case 7:
                fireball = 3;
                armagedon = 1;
                meteor = 3;
                break;
            case 8:
                fireball = 3;
                armagedon = 2;
                meteor = 3;
                break;
            case 9:
                fireball = 3;
                armagedon = 3;
                meteor = 3;
                break;
            default:

                break;
        }
        switch(freeze)
        {
            case 4:
                freeze = 3;
                frostage = 1;

                break;
            case 5:
                freeze = 3;
                frostage = 2;

                break;
            case 6:
                freeze = 3;
                frostage = 3;

                break;

            case 7:
                freeze = 3;
                aceage = 1;
                frostage = 3;
                break;
            case 8:
                freeze = 3;
                aceage = 2;
                frostage = 3;
                break;
            case 9:
                freeze = 3;
                aceage = 3;
                frostage = 3;
                break;
            default:

                break;
        }
        switch(lightning)
        {
            case 4:
                lightning = 3;
                thunderstorm = 1;

                break;
            case 5:
                lightning = 3;
                thunderstorm = 2;

                break;
            case 6:
                lightning = 3;
                thunderstorm = 3;

                break;
            case 7:
                lightning = 3;
                ragnarok = 1;
                thunderstorm = 3;
                break;
            case 8:
                lightning = 3;
                ragnarok = 2;
                thunderstorm = 3;
                break;
            case 9:
                lightning = 3;
                ragnarok = 3;
                thunderstorm = 3;
                break;
            default:

                break;
        }
    }

    public void setinfo()//seteo de la info en pantalla
    {
        Lbl_money.setText(String.valueOf(dinero));
        Lbl_diamantes.setText(String.valueOf(esmeraldas));
        Lbl_stage.setText("Stage :" + String.valueOf(lvl));
    }

    public void acutalizarpantalla()//se encarga de acutalizar la info en la pantalla luego de comprar mas sonido
    {

        Lbl_money.setText(String.valueOf(dinero));
        Lbl_diamantes.setText(String.valueOf(esmeraldas));
        Lbl_stage.setText("Stage :" + String.valueOf(lvl));
        sonidobotones();
        comprado();
        mostrarinfo();

    }

    public void mostrarinfo()//muestar la primer info
    {
        Lbl_info.setText("En esta parte se van a mostrar todo el tipo de informacion sobre las mejoras "
                  + "que\n puedes realizar  en el juego");
    }

    public void aumentarspells()//se encarga de guardar el lvl del fireball para la base de datos
    {
        fireball = fireball + meteor + armagedon;
        freeze = freeze + aceage + frostage;
        lightning = lightning + thunderstorm + ragnarok;
    }

    public void actuDB()// se encarga de acutalizar todas las variables para guardar la base de datos
    {
        aumentarspells();
        System.out.println("El valro es " + imgBallesta);
        getDatos().setImgUser(String.valueOf(imgUser));
        getDatos().setImgBallesta(String.valueOf(imgBallesta));
        getDatos().setDinero((long) dinero);
        getDatos().setEsmeralda((long) esmeraldas);
        getDatos().setLvlFuerza(String.valueOf(fuerza));
        getDatos().setLvlAgilidad(String.valueOf(agilidad));
        getDatos().setLvlRetroceso(String.valueOf(retroceso));
        getDatos().setLvlDDamage(String.valueOf(ddamage));
        getDatos().setLvlTiroDoble(String.valueOf(tirodobble));
        getDatos().setLvl((long) lvl);
        getDatos().setmVida(String.valueOf(vida));
        getDatos().setmMana(String.valueOf(mana));

        getDatos().setLvlFireBall(String.valueOf(fireball));

        getDatos().setLvlFreeze(String.valueOf(freeze));
        getDatos().setLvlRayo(String.valueOf(lightning));

    }

    @FXML
    private void click(ActionEvent event)//se encarga de detectar los clicks para comprar
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
                    Lbl_info.setText("Incrementa la vida del castillo "
                              + "Current: " + 100 + " \n"
                              + "Next: " + 200);
                    Lbl_ccompra.setText("200");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la vida del castillo "
                              + "Current: " + 200 + " \n"
                              + "Next: " + 300);
                    Lbl_ccompra.setText("400");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa ela vida del castillo "
                              + "Current: " + 300 + " \n"
                              + "Next: " + 400);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "1".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(vida == 0 & dinero >= 200)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 200;
                    vida = 1;
                    b = true;

                    acutalizarpantalla();
                }
                else if(vida == 1 & dinero >= 400)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 400;
                    vida = 2;
                    b = true;

                    acutalizarpantalla();
                }
                else if(vida == 2 & dinero >= 600)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    vida = 3;

                    acutalizarpantalla();

                }

            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 100 + " \n"
                              + "Next: " + 200);
                    Lbl_ccompra.setText("200");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de mana"
                              + "Current: " + 200 + " \n"
                              + "Next: " + 300);
                    Lbl_ccompra.setText("400");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de mana"
                              + "Current: " + 300 + " \n"
                              + "Next: " + 400);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 200;
                    mana = 1;
                    b = true;

                    acutalizarpantalla();
                }
                else if(mana == 1 & esmeraldas >= 450)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 400;
                    mana = 2;
                    b = true;

                    acutalizarpantalla();
                }
                else if(mana == 2 & esmeraldas >= 650)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    mana = 3;

                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa la cantidad de fuerza"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa la cantidad de fuerza"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("800");

                    sonidobotones();

                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "3".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(fuerza == 0 & dinero >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 300;
                    fuerza = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fuerza == 1 & dinero >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    fuerza = 2;
                    b = true;

                    acutalizarpantalla();
                }
                else if(fuerza == 2 & dinero >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 800;
                    fuerza = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_agilidad)//Mejora el tiempo de disparo
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
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }
        }

        else if(event.getSource() == Btn_upgrade & "4".equals(Lbl_info.getId()))
        {
            Boolean b = false;
            if(b == false)
            {
                if(agilidad == 0 & dinero >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 300;
                    agilidad = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(agilidad == 1 & dinero >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    agilidad = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(agilidad == 2 & dinero >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 800;
                    agilidad = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }

        }
        else if(event.getSource() == Btn_upgrade & "5".equals(Lbl_info.getId()) & fuerza >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(retroceso == 0 & dinero >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 300;
                    retroceso = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(retroceso == 1 & dinero >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    retroceso = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(retroceso == 2 & dinero >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 800;
                    retroceso = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Next: " + 20);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el porcentaje del daño doble"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 30);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el porcentaje del daño doble"
                              + "Current: " + 30 + " \n"
                              + "Next: " + 40);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "6".equals(Lbl_info.getId()) & agilidad >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(ddamage == 0 & dinero >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 300;
                    ddamage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ddamage == 1 & dinero >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    ddamage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ddamage == 2 & dinero >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 800;
                    ddamage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Next: " + 20);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 30);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el porcentajede tiro doble"
                              + "Current: " + 30 + " \n"
                              + "Next: " + 40);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "7".equals(Lbl_info.getId()) & agilidad >= 3 & fuerza >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(tirodobble == 0 & dinero >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 300;
                    tirodobble = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(tirodobble == 1 & dinero >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 600;
                    tirodobble = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(tirodobble == 2 & dinero >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    dinero -= 800;
                    tirodobble = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_fireball)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("8");
            switch(fireball)
            {
                case 0:
                    Lbl_info.setText("Incrementa el damage de fireball"
                              + "Current: " + 150 + " \n"
                              + "Next: " + 200);
                    Lbl_ccompra.setText("300");

                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el damage de fireball"
                              + "Current: " + 200 + " \n"
                              + "Next: " + 250);
                    Lbl_ccompra.setText("600");

                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el damage de fireball"
                              + "Current: " + 250 + " \n"
                              + "Next: " + 300);
                    Lbl_ccompra.setText("800");

                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 300;
                    fireball = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fireball == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 600;
                    fireball = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(fireball == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 800;
                    fireball = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 300 + " \n"
                              + "Next: " + 350);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el daño del fireball lvl2"
                              + "Current: " + 350 + " \n"
                              + "Next: " + 400);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño del fireball lvl2"
                              + "Current: " + 400 + " \n"
                              + "Next: " + 450);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1000;
                    meteor = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(meteor == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1200;
                    meteor = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(meteor == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1400;
                    meteor = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 450 + " \n"
                              + "Next: " + 500);
                    Lbl_ccompra.setText("1800");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el el daño de armagedon"
                              + "Current: " + 500 + " \n"
                              + "Next: " + 550);
                    Lbl_ccompra.setText("2000");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño de armagedon"
                              + "Current: " + 550 + " \n"
                              + "Next: " + 600);
                    Lbl_ccompra.setText("2400");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "15".equals(Lbl_info.getId()) & meteor >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(armagedon == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1800;
                    armagedon = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(armagedon == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2000;
                    armagedon = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(armagedon == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2400;
                    armagedon = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 2 + " seg" + " \n"
                              + "Next: " + 4 + " seg");
                    Lbl_ccompra.setText("300");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de hielo"
                              + "Current: " + 6 + " seg" + " \n"
                              + "Next: " + 8 + " seg");
                    Lbl_ccompra.setText("600");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de hielo"
                              + "Current: " + 8 + " seg" + " \n"
                              + "Next: " + 10 + " seg");
                    Lbl_ccompra.setText("800");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 300;
                    freeze = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(freeze == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 600;
                    freeze = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(freeze == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 800;
                    freeze = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_frostage)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("12");
            switch(frostage)
            {
                case 0:
                    Lbl_info.setText("Incrementa el tiempo de frostage"
                              + "Current: " + 10 + " \n"
                              + "Next: " + 12);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de frostage"
                              + "Current: " + 12 + " \n"
                              + "Next: " + 14);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de frostage"
                              + "Current: " + 14 + " \n"
                              + "Next: " + 16);
                    Lbl_ccompra.setText("1400");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1000;
                    frostage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(frostage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1200;
                    frostage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(frostage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1400;
                    frostage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 16 + " \n"
                              + "Next: " + 18);
                    Lbl_ccompra.setText("1800");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 20 + " \n"
                              + "Next: " + 22);
                    Lbl_ccompra.setText("2000");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el tiempo de congelacion"
                              + "Current: " + 22 + " \n"
                              + "Next: " + 24);
                    Lbl_ccompra.setText("2200");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
                    sonidobotones();
                    break;
            }
        }
        else if(event.getSource() == Btn_upgrade & "14".equals(Lbl_info.getId()) & frostage >= 3)
        {
            Boolean b = false;
            if(b == false)
            {
                if(aceage == 0 & esmeraldas >= 300)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1800;
                    aceage = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2000;
                    aceage = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(aceage == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2200;
                    aceage = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
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
                              + "Current: " + 150 + " \n"
                              + "Next: " + 200);
                    Lbl_ccompra.setText("300");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el daño del rayo"
                              + "Current: " + 200 + " \n"
                              + "Next: " + 250);
                    Lbl_ccompra.setText("600");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño del rayo"
                              + "Current: " + 250 + " \n"
                              + "Next: " + 300);
                    Lbl_ccompra.setText("800");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 300;
                    lightning = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(lightning == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 600;
                    lightning = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(lightning == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 800;
                    lightning = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }
        else if(event.getSource() == Btn_thunderstorm)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("13");
            switch(thunderstorm)
            {
                case 0:
                    Lbl_info.setText("Incrementa el damage del thunderstorm"
                              + "Current: " + 300 + " \n"
                              + "Next: " + 350);
                    Lbl_ccompra.setText("1000");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el damage del thunderstorm"
                              + "Current: " + 350 + " \n"
                              + "Next: " + 400);
                    Lbl_ccompra.setText("1200");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el damage del thunderstorm"
                              + "Current: " + 400 + " \n"
                              + "Next: " + 450);
                    Lbl_ccompra.setText("1600");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1000;
                    thunderstorm = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(thunderstorm == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1200;
                    thunderstorm = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(thunderstorm == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1600;
                    thunderstorm = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_ragnarok)
        {
            imgv_ccomprar.setImage(new Image("/cr/ac/una/defender/resources/esmerlad.png"));
            Lbl_info.setId("16");
            switch(ragnarok)
            {
                case 0:
                    Lbl_info.setText("Incrementa el el daño de ragnarok"
                              + "Current: " + 25 + " \n"
                              + "Next: " + 50);
                    Lbl_ccompra.setText("1800");
                    sonidobotones();
                    break;
                case 1:
                    Lbl_info.setText("Incrementa el el daño de ragnarok"
                              + "Current: " + 50 + " \n"
                              + "Next: " + 75);
                    Lbl_ccompra.setText("2000");
                    sonidobotones();
                    break;
                case 2:
                    Lbl_info.setText("Incrementa el daño de ragnarok"
                              + "Current: " + 75 + " \n"
                              + "Next: " + 100);
                    Lbl_ccompra.setText("2200");
                    sonidobotones();
                    break;
                default:
                    Lbl_info.setText("Comprada todas las mejoras");
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
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 1800;
                    ragnarok = 1;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ragnarok == 1 & esmeraldas >= 600)
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2000;
                    ragnarok = 2;
                    b = true;
                    acutalizarpantalla();
                }
                else if(ragnarok == 2 & esmeraldas >= 800)
                {
                    b = true;
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Compra " , Btn_mana.getScene().getWindow() , "Comprado con exito");
                    esmeraldas -= 2200;
                    ragnarok = 3;
                    acutalizarpantalla();

                }
            }

            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Compra " , Btn_mana.getScene().getWindow() , "No hay Dinero");
            }
        }

        else if(event.getSource() == Btn_next)
        {
            actuDB();
            Respuesta respuesta = service.guardarUser(getDatos());
            if(lvl <= 100)
            {
                FlowController.getInstance().goVista("Levels");
            }
            else
            {
                new Mensaje().showModal(Alert.AlertType.INFORMATION , "Completaste el juego" , Btn_mana.getScene().getWindow() , "Felicidades ganaste todos los niveles");
                FlowController.getInstance().goVista("Menu");
            }
        }
    }

    @Override
    public void initialize()
    {
//        llenartodo();
//        setinfo();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void swapGun(ActionEvent event)// se encarga de cambiar las armas
    {
        if(event.getSource() == bntT1)
        {
            imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun1.png"));
            imgBallesta = 1;
        }
        else if(event.getSource() == bntT2)
        {
            imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun2.png"));
            imgBallesta = 2;

        }
        else if(event.getSource() == bntT3)
        {
            imvPistolaEscoger.setImage(new Image("/cr/ac/una/defender/resources/Gun3.png"));
            imgBallesta = 3;
        }

    }

    @FXML
    private void swapIm(ActionEvent event)//se encarga de acambiar la imagen de usuario
    {
        if(event.getSource() == btnS)
        {
            imgUser++;
            if(imgUser <= 5)
            {
                switch(imgUser)
                {
                    case 1:
                        img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU1.png"));
                        break;
                    case 2:
                        img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU2.png"));
                        break;
                    case 3:
                        img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU3.png"));
                        break;
                    case 4:
                        img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU4.png"));
                        break;
                    case 5:
                        img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU5.png"));
                }
            }
            else
            {
                imgUser = 1;
                img_user.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU1.png"));
            }

        }
    }
}
