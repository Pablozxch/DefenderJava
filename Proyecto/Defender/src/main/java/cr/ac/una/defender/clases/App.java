package cr.ac.una.defender.clases;

import cr.ac.una.defender.utils.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.*;
import javafx.stage.*;

/**
 * JavaFX App
 */
public class App extends Application
{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException
    {
        FlowController.getInstance().InitializeFlow(stage , null);
        stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
        stage.setTitle("Defender");

        FlowController.getInstance().goVista("Login");
    }

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args)
    {
        launch();
    }

}
