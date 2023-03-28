package ch.railworks.railworks;

import ch.railworks.railworks.model.PresentationModel;
import ch.railworks.railworks.view.Workarea;
import ch.railworks.railworks.view.menu.TopMenu;
import ch.railworks.railworks.view.station.Station;
import fr.brouillard.oss.cssfx.CSSFX;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class RailWorks extends Application {

    BorderPane        root;
    PresentationModel pm;
    Timeline          timeline;
    Workarea          workarea;
    TopMenu           tm;


    @Override
    public void start(Stage primaryStage) {

        CSSFX.start();

        pm       = new PresentationModel();
        workarea = new Workarea(pm);
        tm       = new TopMenu(workarea);
        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> workarea.update()));

        timeline.setCycleCount(Animation.INDEFINITE);

        addStationElements();

        root = new BorderPane();
        root.getStyleClass().add("railworks");
        root.setTop(tm);

        Pane p = new Pane();
        pm.setWorkPane(p);
        p.getChildren().addAll(pm.getAllStations());

        pm.setWorkPane(p);
        root.setCenter(p);


        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());

        Image cursorImage = new Image(Objects.requireNonNull(getClass().getResource("default-pointer.png")).toExternalForm());
        scene.setCursor(new ImageCursor(cursorImage));

        primaryStage.setTitle(pm.getApplicationTitle() + " " + pm.getApplicationVersion());
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }


    private void addStationElements() {
        workarea.preUpdate();

        Station station = new Station("Doppleschwand-Rom._SiC", "DOPP", 273, 909);
        pm.addStation(station);

        workarea.update();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
