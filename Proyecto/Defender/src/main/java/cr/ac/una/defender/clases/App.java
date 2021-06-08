package cr.ac.una.defender.clases;

import cr.ac.una.defender.utils.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.*;

/**
 * JavaFX App
 */
public class App extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        stage.setFullScreen(true);
        FlowController.getInstance().InitializeFlow(stage , null);
        stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
        stage.setTitle("Defender");
        FlowController.getInstance().goVista("Login");
    }

    public static void main(String[] args)
    {
        launch();
    }
}
