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

import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;

import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.*;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
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
    @FXML
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

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        fondo();
        int esmeraldas = getDatos().getEsmeralda().intValue();
        if(getDatos().getLvl().intValue() == 2)
        {

            getDatos().setEsmeralda(String.valueOf(esmeraldas + 1000));
        }
        else if(getDatos().getLvl().intValue() == 4)
        {
            getDatos().setEsmeralda(String.valueOf(esmeraldas + 1000));
        }
        else if(getDatos().getLvl().intValue() == 6)
        {
            getDatos().setEsmeralda(String.valueOf(esmeraldas + 1000));
        }
        sonidodebatalla();// se encarga de añadir sonido de campo de batalla
        llenarVariablesJugador();//se encarga de llenar las variavles del jugador 
        crearmostruos();//crea mostruos
        contarDaamge();//cuenta el daño de los monstruos
        grid.addEventFilter(MouseEvent.MOUSE_PRESSED , (MouseEvent mouse) ->
        {
            //este metodo se encarga de disparar desde la "ballesta" hacia los mobs
            TranslateTransition translate = new TranslateTransition();
            circle = new Circle();
            Image im = new Image("/cr/ac/una/defender/resources/bullet.png");
            circle.setFill(new ImagePattern(im));
            circle.setRadius(20);
            grid.getChildren().add(circle);
            translate.setNode(circle);
            translate.setByY(mouse.getY() - 80);
            translate.setByX(mouse.getX() - 32);
            translate.setDuration(Duration.millis(500));
            translate.interpolatorProperty().set(Interpolator.EASE_OUT);
            translate.play();
            detectcoli(circle);
            disparar();

            translate.setOnFinished((t) ->
            {
                detectcoli(circle);
                circle.setOpacity(0);
                circle.disableProperty().set(true);

            });
        });

        speelFireball();//Drag an drop de los spells
        spellRayo();//Drag an drop de los spells
        spellFreeze();//Drag an drop de los spells
        llenarcosademana();//llenar el mana continuamente
    }
    public int vidamob = 25;

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

    public void crearmostruos()//Se encarga de hcaer graficamente lso mobs en el grid
    {
        oleadas++;
        vidamob *= 1.5;

        for(int i = 0; i < 5; i++)
        {
            if(oleadaM <= 2)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 0-20
            {
                randparamob = 1;
                monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
            }
            else if(oleadaM > 2 && oleadaM <= 4)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 21-40
            {

                randparamob = (int) (Math.random() * 2) + 1;
                if(randparamob == 1)
                {
                    monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -750));
                }
                if(randparamob == 2)
                {
                    monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
            }
            else if(oleadaM > 4 && oleadaM <= 6)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 41-60
            {
                randparamob = (int) (Math.random() * 3) + 1;

                if(randparamob == 1)
                {
                    monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 2)
                {
                    monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 3)
                {
                    monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -750));
                }

            }
            else if(oleadaM > 6 && oleadaM <= 8)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 61-80
            {
                randparamob = (int) (Math.random() * 4) + 1;

                if(randparamob == 1)
                {
                    monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 2)
                {
                    monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 3)
                {
                    monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -750));
                }
                else if(randparamob == 4)
                {
                    monstruo.add(new Caballero(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -950));
                }
            }
            else if(oleadaM > 8)// se ecarga de crear estos tipos de mobs con base en las oleadas representando nivel 81-100
            {
                randparamob = (int) (Math.random() * 5) + 1;

                if(randparamob == 1)
                {
                    monstruo.add(new Zombie(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 2)
                {
                    monstruo.add(new Robott(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 25) + 20 , -950));
                }
                else if(randparamob == 3)
                {
                    monstruo.add(new Alien(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -750));
                }
                else if(randparamob == 4)
                {
                    monstruo.add(new Caballero(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -950));
                }
                else if(randparamob == 5)
                {
                    monstruo.add(new Star(vidamob , 0 , 0 , 0 , 0 , (int) (Math.random() * 20) + 15 , -950));
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
        pgr_vida.setProgress(pgr_vida.getProgress() - valor);
        if(pgr_vida.getProgress() <= 0)
        {

            taskThread.stop();
            musica.stop();
            FlowController.getInstance().goVista("PreGame");
        }
    }

    public void detectcoli(Circle circle1)//este metodo se encarga de validar la coli de las balas
    {

        for(Mob monstruo1 : monstruo)
        {
            monstruo1.dect(circle1 , damageB);

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

            grid.getChildren().clear();
            dinero = sizeM * 25;
            monstruo.clear();
            imagenCrear.clear();
            int cdinero = dinero + dinero2;
            System.out.println("El dinero fue " + dinero);
            System.out.println("El dinero fue " + cdinero);
            Lbl_money.setText(String.valueOf(cdinero));
            getDatos().setDinero(String.valueOf(cdinero));
            if(oleadas >= oleadaM)
            {
                taskThread.stop();
                musica.stop();
                String lvl = String.valueOf(getDatos().getLvl().intValue() + 1);
                getDatos().setLvl(lvl);
                getDatos().setDinero(Lbl_money.getText());
                System.out.println("Complete el nivel");
                
                FlowController.getInstance().goVista("PreGame");
            }
            crearmostruos();
        }
    }

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
                    circle.setRadius(50);
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        playFireball();
                        pgr_mana.setProgress(pgr_mana.getProgress() - 0.05);
                        detectcolispells1(circle);
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
                    circle.setRadius(50);
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        playFreeze();
                        pgr_mana.setProgress(pgr_mana.getProgress() - 0.07);
                        detectcolispells3(circle);
                        pgr_vida.setProgress(pgr_vida.getProgress() + 0.05);
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
                    circle.setRadius(50);
                    grid.getChildren().add(circle);
                    translate.setNode(circle);
                    translate.setByY(MouseInfo.getPointerInfo().getLocation().getY() - 250);
                    translate.setByX(MouseInfo.getPointerInfo().getLocation().getX() - 350);
                    translate.setDuration(Duration.millis(1000));
                    translate.interpolatorProperty().set(Interpolator.EASE_OUT);
                    translate.play();

                    translate.setOnFinished((w) ->
                    {
                        playRayo();
                        pgr_mana.setProgress(pgr_mana.getProgress() - 0.05);
                        detectcolispells2(circle);
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

                                    playZ();//reproduce sonido de zombie
                                    plaA();//reproduce sonido de alien
                                    playR();//reproduce sonido de robot
                                    playC();//reproduce sonido de caballero
                                    setvpro(0.01);

                                }

                            }
                        }

                    });

                }

            }
        });

        taskThread.start();

    }

    public void llenarVariablesJugador()//este metodo se encarga de usar la variable de damage de la base de datos
    {
        damageB = getDatos().getLvlFuerza().intValue();
        damageBS1 = getDatos().getLvlFireBall().intValue();
        damageBS2 = getDatos().getLvlRayo().intValue();
        damageBS3 = getDatos().getLvlFreeze().intValue();

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
        switch(damageBS1)
        {
            case 0:
                damageBS1 = 0;
                break;
            case 1:
                damageBS1 = 150;
                break;
            case 2:
                damageBS1 = 200;
                break;
            case 3:
                damageBS1 = 250;
                break;
            case 4:
                damageBS1 = 300;
                break;
            case 5:
                damageBS1 = 350;
                break;
            case 6:
                damageBS1 = 400;
                break;

            case 7:
                damageBS1 = 450;
                break;
            case 8:
                damageBS1 = 500;
                break;
            case 9:
                damageBS1 = 550;
                break;
            default:
                damageBS1 = 800;
                break;

        }

        switch(damageBS2)
        {
            case 0:
                damageBS2 = 0;
                break;
            case 1:
                damageBS2 = 150;
                break;
            case 2:
                damageBS2 = 200;
                break;
            case 3:
                damageBS2 = 250;
                break;
            case 4:
                damageBS2 = 300;
                break;
            case 5:
                damageBS2 = 350;
                break;
            case 6:
                damageBS2 = 400;
                break;

            case 7:
                damageBS2 = 450;
                break;
            case 8:
                damageBS2 = 500;
                break;
            case 9:
                damageBS2 = 550;
                break;
            default:
                damageBS2 = 800;
                break;

        }
        switch(damageBS3)
        {
            case 0:
                damageBS3 = 0;
                break;
            case 1:
                damageBS3 = 100;
                break;
            case 2:
                damageBS3 = 120;
                break;
            case 3:
                damageBS3 = 140;
                break;
            case 4:
                damageBS3 = 160;
                break;
            case 5:
                damageBS3 = 180;
                break;
            case 6:
                damageBS3 = 200;
                break;

            case 7:
                damageBS3 = 220;
                break;
            case 8:
                damageBS3 = 240;
                break;
            case 9:
                damageBS3 = 260;
                break;
            default:
                damageBS3 = 280;
                break;

        }
        System.out.println("El valor es " + damageBS1);
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
                            pgr_mana.setProgress(pgr_mana.getProgress() + 0.0005);
                        }

                    });

                }

            }
        });

        taskThread3.start();
    }
    public Boolean parar = false;

    @FXML
    private void click(ActionEvent event)//detecta los clicks para pausar el juego
    {
        if(event.getSource() == Btn_pause && parar == false)
        {
            System.out.println("Le di parar");
            new Mensaje().showModal(Alert.AlertType.CONFIRMATION , "Pausar" , Btn_pause.getScene().getWindow() , "El juego se ha pausado");
            for(Mob monstruo1 : monstruo)
            {
                monstruo1.pausar();
            }
            parar = true;

        }
        else if(event.getSource() == Btn_pause && parar == true)
        {
            System.out.println("Le di seguir");
            new Mensaje().showModal(Alert.AlertType.CONFIRMATION , "Reanudar" , Btn_pause.getScene().getWindow() , "El juego se ha rehanudado");
            for(Mob monstruo1 : monstruo)
            {
                monstruo1.iniciar();
            }
            parar = false;
        }
    }

}
