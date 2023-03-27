package ch.railworks.railworks.view.station;

import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Station extends GridPane {

    private UUID uid;
    private String stationName;
    private String stationCode;

    private StationTopBar topBar;

    private final int gridSize = 25;

    public Station(String stationName, String stationCode, double height, double width) {
        super();

        this.uid = UUID.randomUUID();
        this.stationName = stationName;
        this.stationCode = stationCode;

        setPrefSize(width, height);

        topBar = new StationTopBar(stationName, stationCode, width);

        for(int i = 0; i < Math.floor(height/gridSize); i++){
            getColumnConstraints().add(new ColumnConstraints(gridSize));
        }

        add(topBar, 0, 0, (int) Math.ceil(width/gridSize), 1);

        setBackground(new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
        getStyleClass().add("railworks-station");

    }

}
