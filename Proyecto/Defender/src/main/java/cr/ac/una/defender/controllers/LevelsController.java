/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.clases.*;
import cr.ac.una.defender.utils.*;
import java.awt.*;
import java.io.*;

import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.logging.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;

import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.*;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.util.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class LevelsController extends Controller implements Initializable
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
    private JFXButton Btn_spell1;
    @FXML
    private JFXButton Btn_pause;
    @FXML
    private ImageView Imv_sp2;
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
    private ProgressBar pgr_lvl;
    private ImageView mig = new ImageView();

    List<Mob> monstruo = new ArrayList<Mob>();
    List<ImageView> imagenCrear = new ArrayList<ImageView>();
    private Timeline timeline;
    Circle circle = new Circle();
    Boolean pego = false;
    Boolean gameOver = false;
    @FXML
    private Label lbl_stage;
    public int contdamage;
    public int f = 20;
    public Thread taskThread;
    public int sizeM = 0;
    public int oleadas = 0;
    public int oleadaM = getDatos().getLvl().intValue();
    public int damageB = 0;
    @FXML
    private ImageView imv_fondo;
    private int randparamob;
    public int damageBS1;
    public int damageBS2;
    public int damageBS3;
    private Thread taskThread3;
    @FXML
    private ImageView imvUserL;
    private int radios1;//se encarga del radio de los spells
    private int radios2;
    private int radios3;
    @FXML
    private ImageView imgPausa;
    private double vidaP;
    private double manaP;
    private int veloBullets;
    double progreso;
    @FXML
    private Label labelOleadas;
    boolean poderdispara = true;
    boolean poderlanzarspell = true;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        sonidodebatalla();
        llenarVariablesJugador();//se encarga de llenar las variavles del jugador     
        fondo();

        Long esmeraldas = getDatos().getEsmeralda();
        switch(getDatos().getLvl().intValue())
        {
            case 10:
                getDatos().setEsmeralda(esmeraldas + 500);
                break;
            case 20:
                getDatos().setEsmeralda(esmeraldas + 500);
                break;
            case 30:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 40:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 50:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 60:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 70:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 80:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            case 90:
                getDatos().setEsmeralda(esmeraldas + 1000);
                break;
            default:
                break;
        }
        crearmostruos();//crea mostruos
        contarDaamge();//cuenta el daño de los monstruos

        grid.addEventFilter(MouseEvent.MOUSE_PRESSED , (MouseEvent mouse) ->
        {
            //este metodo se encarga de disparar desde la "ballesta" hacia los mobs
            if(mouse.getButton() == MouseButton.PRIMARY)
            {
                if(poderdispara == true)
                {
                    poderdispara = false;
                    TranslateTransition translate = new TranslateTransition();
                    circle = new Circle();
                    Image im = new Image("/cr/ac/una/defender/resources/bullet.png");
                    circle.setFill(new ImagePattern(im));
                    circle.setRadius(20);
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(mouse.getY() - 80);
                    translate.setByX(mouse.getX() - 32);
                    translate.setDuration(Duration.millis(veloBullets));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();
                    detectcoli(circle);
                    disparar();

                    translate.setOnFinished((t) ->
                    {
                        poderdispara = true;
                        detectcoli(circle);
                        circle.setOpacity(0);
                        circle.disableProperty().set(true);

                    });
                }
            }

        });
        if(damageBS1 != 0)
        {
            speelFireball();//Drag an drop de los spells
        }
        if(damageBS2 != 0)
        {
            spellRayo();//Drag an drop de los spells
        }
        if(damageBS3 != 0)
        {
            spellFreeze();//Drag an drop de los spells
        }
        llenarcosademana();//llenar el mana continuamente
    }

    void fondo()//setear el fondo, cambiar el arma, cambiar el usuario
    {
        if(oleadaM <= 2)
        {
            //imv_fondo.setImage(new Image("/cr/ac/una/defender/resources/Fondolvlprueba.png"));
        }
        else if(oleadaM > 2 && oleadaM <= 4)
        {
            imv_fondo.setImage(new Image("/cr/ac/una/defender/resources/Eastseadragonpalacelawn.jpg"));
        }
        else if(oleadaM > 4 && oleadaM <= 6)
        {
            imv_fondo.setImage(new Image("/cr/ac/una/defender/resources/Dark_Ages_Lawn.jpg"));
        }
        else if(oleadaM > 6 && oleadaM <= 8)
        {
            imv_fondo.setImage(new Image("/cr/ac/una/defender/resources/FrostbiteCaveslawn.jpg"));
        }
        else
        {
            imv_fondo.setImage(new Image("/cr/ac/una/defender/resources/Neon_Mixtape_Tour_Lawn.jpg"));
        }
        Imv_sp2.setImage(new Image("/cr/ac/una/defender/resources/rayo.png"));
        Imv_sp3.setImage(new Image("/cr/ac/una/defender/resources/freeze.png"));

        if(getDatos().getImgBallesta() == 1)
        {

            img_ballesta.setImage(new Image("/cr/ac/una/defender/resources/Gun1.png"));
        }
        else if(getDatos().getImgBallesta() == 2)
        {
            img_ballesta.setImage(new Image("/cr/ac/una/defender/resources/Gun2.png"));

        }
        else if(getDatos().getImgBallesta() == 3)
        {
            img_ballesta.setImage(new Image("/cr/ac/una/defender/resources/Gun3.png"));

        }
        switch(getDatos().getImgUser().intValue())
        {
            case 1:
                imvUserL.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU1.png"));
                break;
            case 2:
                imvUserL.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU2.png"));
                break;
            case 3:
                imvUserL.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU3.png"));
                break;
            case 4:
                imvUserL.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU4.png"));
                break;
            case 5:
                imvUserL.setImage(new Image("/cr/ac/una/defender/resources/usersi/imgU5.png"));
                break;
            default:
                break;

        }

    }
    public int vidamob = 200;

    public void crearmostruos()//Se encarga de hcaer graficamente lso mobs en el grid
    {
        oleadas++;
//        pgr_lvl.setProgress(pgr_lvl.getProgress() + 0.25);
        labelOleadas.setText("Oleada: " + oleadas);
        vidamob = 200 * oleadas;

        for(int i = 0; i < 5; i++)
        {
            if(oleadaM <= 20)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 0-20
            {
                randparamob = 1;
                monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 35) + 30 , -950));

            }
            else if(oleadaM > 20 && oleadaM <= 40)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 21-40
            {

                randparamob = (int) (Math.random() * 2) + 1;
                if(randparamob == 1)
                {
                    monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 30) + 26 , -950));

                }
                if(randparamob == 2)
                {
                    monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 30) + 26 , -950));

                }
            }
            else if(oleadaM > 40 && oleadaM <= 60)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 41-60
            {
                randparamob = (int) (Math.random() * 3) + 1;

                switch(randparamob)
                {
                    case 1:
                        monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 28) + 24 , -950));
                        break;
                    case 2:
                        monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 28) + 24 , -950));
                        break;
                    case 3:
                        monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 28) + 24 , -950));
                        break;
                    default:
                        break;
                }

            }
            else if(oleadaM > 60 && oleadaM <= 80)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 61-80
            {
                randparamob = (int) (Math.random() * 4) + 1;

                switch(randparamob)
                {
                    case 1:
                        monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 24) + 22 , -950));
                        break;
                    case 2:
                        monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 24) + 22 , -950));
                        break;
                    case 3:
                        monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 24) + 22 , -950));
                        break;
                    case 4:
                        monstruo.add(new Caballero(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 24) + 12 , -950));
                        break;
                    default:
                        break;
                }
            }
            else if(oleadaM > 80 && oleadaM <= 90)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 81-100
            {
                randparamob = (int) (Math.random() * 5) + 1;

                switch(randparamob)
                {
                    case 1:
                        monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 22) + 20 , -950));
                        break;
                    case 2:
                        monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 22) + 20 , -950));
                        break;
                    case 3:
                        monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 22) + 15 , -750));
                        break;
                    case 4:
                        monstruo.add(new Caballero(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 22) + 15 , -950));
                        break;
                    case 5:
                        monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 22) + 15 , -950));
                        break;
                    default:
                        break;
                }
            }
            else
            {
                randparamob = (int) (Math.random() * 6) + 1;

                switch(randparamob)
                {
                    case 1:
                        monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -950));
                        break;
                    case 2:
                        monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -950));
                        break;
                    case 3:
                        monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -750));
                        break;
                    case 4:
                        monstruo.add(new Caballero(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -950));
                        break;
                    case 5:
                        monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -950));
                        break;
                    default:
                        monstruo.add(new RedSkull(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 17) + 15 , -950));
                        break;
                }
            }

            imagenCrear.add(new ImageView());
            grid.getChildren().addAll(imagenCrear.get(i));
            monstruo.get(i).setImagenView(imagenCrear.get(i));
            GridPane.setConstraints(imagenCrear.get(i) , 9 , i);
            GridPane.setHalignment(imagenCrear.get(i) , HPos.CENTER);
            GridPane.setValignment(imagenCrear.get(i) , VPos.BOTTOM);
            monstruo.get(i).Start();
        }

    }

    public void setvpro(double valor)//este metodo se encarga de manejar la vida del usuario, si pierde gg
    {
        vidaP = vidaP - valor * 1000;
        if(vidaP <= 100)
        {
            pgr_vida.setProgress(pgr_vida.getProgress() - valor);
            if(pgr_vida.getProgress() <= 0)
            {
                if(gameOver == false)
                {
                    gameOver = true;
                    try
                    {

                        paramusica();
                        taskThread.stop();
                        taskThread3.stop();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/defender/views/Perdio.fxml"));
                        Parent root2 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setOpacity(1);
                        stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
                        stage.setTitle("Defender");
                        Scene scene = new Scene(root2 , 600 , 400);
                        stage.setScene(scene);
                        playPerdio();
                        stage.resizableProperty().set(false);
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner(Btn_pause.getScene().getWindow());
                        stage.centerOnScreen();
                        stage.showAndWait();
                        FlowController.getInstance().goVista("PreGame");
                    }
                    catch(IOException ex)
                    {
                        Logger.getLogger(LevelsController.class.getName()).log(Level.SEVERE , null , ex);
                    }
                }

            }
        }

    }

    public void detectcoli(Circle circle1)//este metodo se encarga de validar la coli de las balas
    {
        int damagefinal = calcularDobleDamage() + calcularTiroDoble();
        System.out.println("El valor del damage es " + damagefinal);
        for(Mob monstruo1 : monstruo)
        {
            monstruo1.dect(circle1 , damagefinal * 2);//para poder matar mejor

        }
        contarmuetos();
    }

    public void detectcolispells1(Circle circle2)//este metodo se encarga de validar la coli de las spells 1
    {

        for(Mob monstruo1 : monstruo)
        {
            monstruo1.dect(circle2 , damageBS1);

        }
        contarmuetos();
    }

    public void detectcolispells2(Circle circle3)//este metodo se encarga de validar la coli de las spells 2
    {

        for(Mob monstruo1 : monstruo)
        {
            monstruo1.dect(circle3 , damageBS2);

        }
        contarmuetos();
    }

    public void detectcolispells3(Circle circle3)//este metodo se encarga de validar la coli de las spells 3
    {

        for(Mob monstruo1 : monstruo)
        {
            monstruo1.detectF(circle3 , damageBS3);

        }
        contarmuetos();
    }

    void calcularoeladas()
    {
        if(oleadaM < 10)
        {
            oleadallegar = 1;
        }
        else if(oleadaM > 10 && oleadaM <= 20)
        {
            oleadallegar = 2;
        }
        else if(oleadaM > 20 && oleadaM <= 30)
        {
            oleadallegar = 3;
        }
        else if(oleadaM > 30 && oleadaM <= 40)
        {
            oleadallegar = 4;
        }
        else if(oleadaM > 40 && oleadaM <= 50)
        {
            oleadallegar = 5;
        }
        else if(oleadaM > 50 && oleadaM <= 60)
        {
            oleadallegar = 6;
        }
        else if(oleadaM > 60 && oleadaM <= 70)
        {
            oleadallegar = 7;
        }
        else if(oleadaM > 70 && oleadaM <= 80)
        {
            oleadallegar = 8;
        }
        else if(oleadaM > 80 && oleadaM <= 90)
        {
            oleadallegar = 9;
        }
        else
        {
            oleadallegar = 10;
        }
    }

    void contarmuetos()//cuanta la cantidad de muertos para poer pasar de ronda 
    {
        sizeM = monstruo.size();
        int cMuertes = 0;
        Lbl_money.setText(getDatos().getDinero().toString());
        int dinero2 = getDatos().getDinero().intValue();
        int dinero = 0;
        for(Mob monstruo1 : monstruo)
        {
            if(monstruo1.getMuerto() == true)
            {
                cMuertes++;
            }
        }
        if(cMuertes == sizeM)
        {
            System.out.println("Buenas");
            grid.getChildren().clear();
            dinero = sizeM * (25 * oleadaM);
            monstruo.clear();
            imagenCrear.clear();
            int cdinero = dinero + dinero2;
            System.out.println("El dinero fue " + cdinero);
            Lbl_money.setText(String.valueOf(cdinero));
            getDatos().setDinero((long) cdinero);

            System.out.println("Oleada llegar " + oleadallegar);
            if(oleadas == oleadallegar)
            {
                taskThread.stop();
                taskThread3.stop();
                paramusica();
                Long lvl = getDatos().getLvl() + 1;
                getDatos().setLvl(lvl);
                getDatos().setDinero(Long.valueOf(Lbl_money.getText()));

                try
                {

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/defender/views/Lvlcomplete.fxml"));
                    Parent root3 = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setOpacity(1);
                    Scene scene = new Scene(root3 , 600 , 400);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
                    stage.setTitle("Defender");
                    playlevelcomplete();
                    stage.resizableProperty().set(false);
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(Btn_pause.getScene().getWindow());
                    stage.centerOnScreen();
                    stage.show();
                    FlowController.getInstance().goVista("PreGame");
                }
                catch(IOException ex)
                {
                    Logger.getLogger(LevelsController.class.getName()).log(Level.SEVERE , null , ex);
                }

            }
            crearmostruos();
        }
    }
    public int oleadallegar;

    public void speelFireball()//drag and drop del spell de fireball
    {

        Imv_sp1.setOnDragDetected((MouseEvent event) ->
        {
            Dragboard db = Imv_sp1.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(Imv_sp1.getImage());
            db.setContent(content);
            event.consume();
        });

        Imv_sp1.setOnDragOver(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(event.getGestureSource() != Imv_sp1
                          && event.getDragboard().hasImage())
                {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();

            }
        });

        Imv_sp1.setOnDragDone(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(pgr_mana.getProgress() > 0.05)
                {
                    Dragboard db = event.getDragboard();
                    TranslateTransition translate = new TranslateTransition();
                    circle = new Circle();
                    Image im = new Image("/cr/ac/una/defender/resources/fire.png");
                    circle.setFill(new ImagePattern(im));
                    circle.setRadius(radios1);
                    circle.setEffect(new DropShadow(50 , Color.RED));
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        poderlanzarspell = true;
                        playFireball();
                        if(manaP <= 100)
                        {
                            pgr_mana.setProgress(pgr_mana.getProgress() - 0.02 * getDatos().getLvlFreeze());
                        }
                        else
                        {
                            manaP = 20 * getDatos().getLvlFreeze();
                        }

                        detectcolispells1(circle);
                        circle.setOpacity(0);
                        circle.disableProperty().set(true);

                    });

                }
                event.consume();

            }
        });

    }

    public void spellRayo()//drag and drop del spell de rayo
    {

        Imv_sp2.setOnDragDetected((MouseEvent event) ->
        {
            Dragboard db = Imv_sp2.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(Imv_sp2.getImage());
            db.setContent(content);
            event.consume();
        });

        Imv_sp2.setOnDragOver(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(event.getGestureSource() != Imv_sp2
                          && event.getDragboard().hasImage())
                {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();

            }
        });

        Imv_sp2.setOnDragDone(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(pgr_mana.getProgress() > 0.05)

                {
                    Dragboard db = event.getDragboard();
                    TranslateTransition translate = new TranslateTransition();
                    circle = new Circle();
                    Image im = new Image("/cr/ac/una/defender/resources/rayo.png");
                    circle.setFill(new ImagePattern(im));
                    circle.setRadius(radios2);
                    circle.setEffect(new DropShadow(50 , Color.WHITE));
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        poderlanzarspell = true;
                        playRayo();
                        if(manaP <= 100)
                        {
                            pgr_mana.setProgress(pgr_mana.getProgress() - 0.05 * getDatos().getLvlFreeze());
                        }
                        else
                        {
                            manaP = 40 * getDatos().getLvlFreeze();
                        }

                        detectcolispells2(circle);
                        circle.setOpacity(0);
                        circle.disableProperty().set(true);

                    });
                }

                event.consume();

            }
        });

    }

    public void spellFreeze()//drag and drop del spell de freeze
    {

        Imv_sp3.setOnDragDetected((MouseEvent event) ->
        {
            Dragboard db = Imv_sp3.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(Imv_sp3.getImage());
            db.setContent(content);
            event.consume();
        });

        Imv_sp3.setOnDragOver(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(event.getGestureSource() != Imv_sp3
                          && event.getDragboard().hasImage())
                {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();

            }
        });

        Imv_sp3.setOnDragDone(new EventHandler<DragEvent>()
        {
            public void handle(DragEvent event)
            {
                if(pgr_mana.getProgress() > 0.05)

                {
                    Dragboard db = event.getDragboard();
                    TranslateTransition translate = new TranslateTransition();
                    circle = new Circle();
                    Image im = new Image("/cr/ac/una/defender/resources/freeze.png");
                    circle.setFill(new ImagePattern(im));
                    circle.setRadius(radios3);
                    circle.setEffect(new DropShadow(50 , Color.BLUE));
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        poderlanzarspell = true;
                        playFreeze();
                        if(manaP <= 100)
                        {
                            pgr_mana.setProgress(pgr_mana.getProgress() - 0.010 * getDatos().getLvlFreeze());
                        }
                        else
                        {
                            manaP = 80 * getDatos().getLvlFreeze();
                        }

                        detectcolispells3(circle);
                        circle.setOpacity(0);
                        circle.disableProperty().set(true);

                    });
                }

                event.consume();

            }
        });

    }

    public void contarDaamge()// este metodo se encarga de evaluar siempre la lista de mobs para ver si ya atacaron
    {

        taskThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < f; i++)
                {
                    f += 50;
                    try
                    {
                        Thread.sleep(135);
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
                            //System.out.println("Ejecutando");
                            for(Mob monstruo1 : monstruo)
                            {
                                contdamage = monstruo1.getContataques();
                                monstruo1.setContataques(0);
                                if(contdamage != 0)
                                {
                                    setvpro(0.005 * oleadas);

                                }

                            }
                        }

                    });

                }

            }
        });

        taskThread.start();

    }

    void llenarVida()//quita la vida
    {
        if(vidaP == 0)
        {
            vidaP = 100;
        }
        else if(vidaP == 1)
        {
            vidaP = 100;
        }
        else if(vidaP == 2)
        {
            vidaP = 200;
        }
        else if(vidaP == 3)
        {
            vidaP = 300;
        }
        else if(vidaP == 4)
        {
            vidaP = 400;
        }
    }

    void llenarMana()// llena la mana
    {
        if(manaP == 0)
        {
            manaP = 100;
        }
        else if(manaP == 1)
        {
            manaP = 100;
        }
        else if(manaP == 2)
        {
            manaP = 200;
        }
        else if(manaP == 3)
        {
            manaP = 300;
        }
        else if(manaP == 4)
        {
            manaP = 400;
        }
    }

    int calcularDobleDamage()// se encarga de calcular el damage doble
    {
        int f = damageB;
        switch(getDatos().getLvlDDamage().intValue())
        {
            case 0:
                int x = (int) (Math.random() * 4) + 1;
                if(x == 1)
                {
                    f *= 2;
                }

                break;
            case 1:
                x = (int) (Math.random() * 4) + 1;
                if(x == 1 || x == 2)
                {
                    f *= 2;
                }
                break;
            case 2:
                x = (int) (Math.random() * 4) + 1;
                if(x == 1 || x == 2 || x == 3)
                {
                    f *= 2;
                }
                break;
            default:
                f *= 2;
                break;
        }

        return f;

    }

    int calcularTiroDoble()// se encarga de calcular el tiro doble
    {
        int f = damageB;
        switch(getDatos().getLvlTiroDoble().intValue())
        {
            case 0:
                int x = (int) (Math.random() * 4) + 1;
                if(x == 1)
                {
                    f *= 2;
                }

                break;
            case 1:
                x = (int) (Math.random() * 4) + 1;
                if(x == 1 || x == 2)
                {
                    f *= 2;
                }
                break;
            case 2:
                x = (int) (Math.random() * 4) + 1;
                if(x == 1 || x == 2 || x == 3)
                {
                    f *= 2;
                }
                break;
            default:
                f *= 2;
                break;
        }

        return f;
    }

    void llenarDamageB()//se encarga de llenar el damage base
    {
        switch(damageB)
        {
            case 0:
                damageB = 25;
                break;
            case 1:
                damageB = 50;
                break;
            case 2:
                damageB = 75;
                break;
            default:
                damageB = 100;
                break;
        }
    }

    void llenarDamageBS1()//se encarga de llenar el damage del primer spell mas el radio
    {
        switch(damageBS1)//parte del hechizo de fireball
        {
            case 0:
                damageBS1 = 0;
                radios1 = 0;
                break;
            case 1:
                damageBS1 = 150;
                radios1 = 25;
                break;
            case 2:
                damageBS1 = 200;
                radios1 = 50;
                break;
            case 3:
                damageBS1 = 250;
                radios1 = 75;
                break;
            case 4:
                damageBS1 = 300;
                radios1 = 100;
                break;
            case 5:
                damageBS1 = 350;
                radios1 = 125;
                break;
            case 6:
                damageBS1 = 400;
                radios1 = 150;
                break;

            case 7:
                damageBS1 = 450;
                radios1 = 175;
                break;
            case 8:
                damageBS1 = 500;
                radios1 = 200;
                break;
            case 9:
                damageBS1 = 550;
                radios1 = 225;
                break;
        }
    }

    void llenarDamageBS2()//se encarga de llenar el damage del segundo sepll mas el radio
    {
        switch(damageBS2)//parte del hechizo de rayo
        {
            case 0:
                damageBS2 = 0;
                radios2 = 0;
                break;
            case 1:
                damageBS2 = 150;
                radios2 = 25;
                break;
            case 2:
                damageBS2 = 200;
                radios2 = 50;
                break;
            case 3:
                damageBS2 = 250;
                radios2 = 75;
                break;
            case 4:
                damageBS2 = 300;
                radios2 = 100;
                break;
            case 5:
                damageBS2 = 350;
                radios2 = 125;
                break;
            case 6:
                damageBS2 = 400;
                radios2 = 150;
                break;

            case 7:
                damageBS2 = 450;
                radios2 = 175;
                break;
            case 8:
                damageBS2 = 500;
                radios2 = 200;
                break;
            case 9:
                damageBS2 = 550;
                radios2 = 225;
                break;
            default:
                damageBS2 = 800;
                break;

        }
    }

    void llenarDamageBS3()//se encarga de llenar la velocidad de los spells + el radio
    {
        switch(damageBS3)//parte del hechizo de hielo;
        {
            case 0:
                damageBS3 = 0;
                radios3 = 0;
                break;
            case 1:
                damageBS3 = 1000;
                radios3 = 25;
                break;
            case 2:
                damageBS3 = 1200;
                radios3 = 50;
                break;
            case 3:
                damageBS3 = 1400;
                radios3 = 75;
                break;
            case 4:
                damageBS3 = 1600;
                radios3 = 100;
                break;
            case 5:
                damageBS3 = 1800;
                radios3 = 125;
                break;
            case 6:
                damageBS3 = 2000;
                radios3 = 150;
                break;

            case 7:
                damageBS3 = 2200;
                radios3 = 175;
                break;
            case 8:
                damageBS3 = 2400;
                radios3 = 200;
                break;
            case 9:
                damageBS3 = 2600;
                radios3 = 225;
                break;

        }
    }

    void llenarVeloBullets()//se encarga de llenar la velocidad de las balas
    {
        switch(veloBullets)
        {
            case 0:
                veloBullets = 2000;
                break;
            case 1:
                veloBullets = 1500;
                break;
            case 2:
                veloBullets = 1000;
                break;
            case 3:
                veloBullets = 500;
                break;

        }
    }

    public void llenarVariablesJugador()//este metodo se encarga de usar la variable de damage de la base de datos
    {
        damageB = getDatos().getLvlFuerza().intValue();// damage base
        damageBS1 = getDatos().getLvlFireBall().intValue();//damage speel 1
        damageBS2 = getDatos().getLvlRayo().intValue();//damage speel 2
        damageBS3 = getDatos().getLvlFreeze().intValue();//damage speel 3
        vidaP = getDatos().getmVida().doubleValue();//cantidad de vida
        manaP = getDatos().getmMana().doubleValue();//cantidad de mana
        veloBullets = getDatos().getLvlAgilidad().intValue();
        llenarVeloBullets();
        llenarDamageB();
        llenarDamageBS1();
        llenarDamageBS2();
        llenarDamageBS3();
        llenarMana();
        llenarVida();
        calcularoeladas();
        System.out.println("El valor del radio del spells 1 es " + radios1);
        System.out.println("El valor del radio del spells 2 es " + radios2);
        System.out.println("El valor del radio del spells 3 es " + radios3);
        Lbl_money.setText(getDatos().getDinero().toString());
        Lbl_diamantes.setText(getDatos().getEsmeralda().toString());
        lbl_stage.setText("Stage : " + getDatos().getLvl().toString());
    }

    @Override
    public void initialize()
    {
        llenarVariablesJugador();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void llenarcosademana()//se encarga de llenar la barra de mana permanentemente 
    {
        taskThread3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < f; i++)
                {
                    f += 50;
                    try
                    {
                        Thread.sleep(135);
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
                            pgr_mana.setProgress(pgr_mana.getProgress() + 0.0009);
                            if(pgr_mana.getProgress() == 1)
                            {
                                llenarMana();
                            }
                        }

                    });

                }

            }
        });

        taskThread3.start();
    }
    public Boolean parar = false;

    @FXML
    private void click(ActionEvent event) throws IOException//detecta los clicks para pausar el juego
    {

        if(event.getSource() == Btn_pause && parar == false)
        {
            paramusica();
            grid.disableProperty().set(true);
            Imv_sp1.disableProperty().set(true);
            Imv_sp2.disableProperty().set(true);
            Imv_sp3.disableProperty().set(true);
            parar = true;
            imgPausa.setImage(new Image("/cr/ac/una/defender/resources/resume.png"));
            imgPausa.setEffect(new Glow(1));
            for(Mob monstruo1 : monstruo)
            {
                monstruo1.pausar();//colocar el otro metodo de pausar 
            }

        }
        else if(event.getSource() == Btn_pause && parar == true)
        {
            sonidodebatalla();
            grid.disableProperty().set(false);
            Imv_sp1.disableProperty().set(false);
            Imv_sp2.disableProperty().set(false);
            Imv_sp3.disableProperty().set(false);
            parar = true;
            for(Mob monstruo1 : monstruo)
            {
                monstruo1.iniciar();
            }
            imgPausa.setEffect(new Glow(0));
            imgPausa.setImage(new Image("/cr/ac/una/defender/resources/pause.png"));
            parar = false;

        }
    }

}
