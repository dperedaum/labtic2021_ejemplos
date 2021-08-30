package um.edu.uy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import um.edu.uy.ui.Principal;

@SpringBootApplication
public class Main extends Application  {

    private static ConfigurableApplicationContext context;

    private Parent root;

    @Override
    public void init() throws Exception {
        Main.context = SpringApplication.run(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(Main.getContext()::getBean);


        root = fxmlLoader.load(Principal.class.getResourceAsStream("Principal.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void stop() {
        Main.getContext().close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
