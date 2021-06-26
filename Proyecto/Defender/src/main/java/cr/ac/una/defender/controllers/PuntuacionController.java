/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.defender.models.*;
import cr.ac.una.defender.services.*;
import cr.ac.una.defender.utils.*;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class PuntuacionController implements Initializable
{

    @FXML
    private TableView tblPuntajes;
    private JFXButton btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        llenartodo();
    }

    public void llenartodo()// se encarga de crear una tabla donde se muestran todos los jugadores de la base de datos 
    {
        try
        {
            TableColumn<UserDto , String> tbcUsername = new TableColumn<>("Nombre");
            tbcUsername.setPrefWidth(150);
            tbcUsername.setCellValueFactory(cd -> cd.getValue().username);

            TableColumn<UserDto , Long> tbcNivel = new TableColumn<>("Nivel");
            tbcNivel.setPrefWidth(150);
            tbcNivel.setCellValueFactory(cd -> cd.getValue().lvl.asObject());

            TableColumn<UserDto , Long> tbcDinero = new TableColumn<>("Dinero");
            tbcDinero.setPrefWidth(150);
            tbcDinero.setCellValueFactory(cd -> cd.getValue().dinero.asObject());

            TableColumn<UserDto , Long> tbcGemas = new TableColumn<>("Esmeraldas");
            tbcGemas.setPrefWidth(150);
            tbcGemas.setCellValueFactory(cd -> cd.getValue().esmeralda.asObject());

            tblPuntajes.getColumns().add(tbcUsername);
            tblPuntajes.getColumns().add(tbcNivel);
            tblPuntajes.getColumns().add(tbcDinero);
            tblPuntajes.getColumns().add(tbcGemas);
            tblPuntajes.refresh();

            UserService service = new UserService();

            Respuesta respuesta = service.obtenerTodo();

            if(respuesta.getEstado())
            {
                List<UserDto> lista = (List<UserDto>) respuesta.getResultado("Users");        
                ObservableList<UserDto> empleados = FXCollections.observableList(lista);
                tblPuntajes.setItems(empleados);
                tblPuntajes.refresh();
            }
            else
            {
                new Mensaje().showModal(Alert.AlertType.ERROR , "Consultar usuarios" , btnBack.getScene().getWindow() , respuesta.getMensaje());
            }

        }
        catch(Exception ex)
        {
            Logger.getLogger(PuntuacionController.class.getName()).log(Level.SEVERE , "Error consultando los empleados." , ex);
            // new Mensaje().showModal(Alert.AlertType.ERROR , "Consultar empleados" , getStage() , "Ocurrio un error consultado los empleados.");
        }
    }

}
