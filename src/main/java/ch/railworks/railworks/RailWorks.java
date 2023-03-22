package ch.railworks.railworks;

import ch.railworks.railworks.model.PresentationModel;
import ch.railworks.railworks.view.menu.TopMenu;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class RailWorks extends Application {

    BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        PresentationModel pm = new PresentationModel();

        Image cursorImage = new Image(Objects.requireNonNull(getClass().getResource("default-pointer.png")).toExternalForm());

        root = new BorderPane();
        root.getStyleClass().add("root");
        initializeAreas();

        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        scene.setCursor(new ImageCursor(cursorImage));

        primaryStage.setTitle(pm.getApplicationTitle());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public void initializeAreas() {

        TopMenu tm = new TopMenu();
        root.setTop(tm);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
