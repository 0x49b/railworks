package ch.railworks.railworks;

import ch.railworks.railworks.model.PresentationModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class RailWorks extends Application {


    @Override
    public void start(Stage primaryStage) {

        PresentationModel pm = new PresentationModel();

        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());

        primaryStage.setTitle(pm.getApplicationTitle());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
