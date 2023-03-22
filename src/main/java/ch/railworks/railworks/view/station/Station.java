package ch.railworks.railworks.view.station;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Station extends Pane {

    private UUID uid;
    private String stationName;
    private String stationCode;

    public Station(String stationName, String stationCode, double height, double width) {
        super();

        this.uid = UUID.randomUUID();
        this.stationName = stationName;
        this.stationCode = stationCode;

        this.setHeight(height);
        this.setWidth(width);

        setBackground(new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
