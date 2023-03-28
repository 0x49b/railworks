package ch.railworks.railworks.view.station;

import ch.railworks.railworks.view.controls.StationCode;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.UUID;


public class Station extends GridPane {

    private UUID uid;
    private String stationName;
    private String stationCode;

    private StationTopBar topBar;
    private StationMenuBar menuBar;

    private final int gridSize = 25;

    public Station(String stationName, String stationCode, double height, double width) {
        super();

        this.uid = UUID.randomUUID();
        this.stationName = stationName;
        this.stationCode = stationCode;

        setPrefSize(width, height);

        topBar = new StationTopBar(stationName, stationCode, width);
        menuBar = new StationMenuBar();

        for (int i = 0; i < Math.floor(height / gridSize); i++) {
            getColumnConstraints().add(new ColumnConstraints(gridSize));
        }

        add(topBar, 0, 0, (int) Math.ceil(width / gridSize), 1);
        add(menuBar, 0, 1, (int) Math.ceil(width / gridSize), 1);

        setBackground(new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
        getStyleClass().add("railworks-station");

        // Elements of Station from Row 2 on
        StationCode sCode = new StationCode(stationCode);

        add(sCode, 0, 3);

    }

}
