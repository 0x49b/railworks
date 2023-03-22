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

    private GridPane topBar;

    private final int gridSize = 25;

    public Station(String stationName, String stationCode, double height, double width) {
        super();

        this.uid = UUID.randomUUID();
        this.stationName = stationName;
        this.stationCode = stationCode;

        setPrefSize(width, height);

        topBar = new GridPane();
        topBar.setBackground(new Background(new BackgroundFill(Color.web("#1C65C0FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        topBar.setMaxHeight(25);
        topBar.setPrefHeight(25);
        topBar.setPrefWidth(width);
        topBar.getColumnConstraints().add(new ColumnConstraints(20));
        topBar.setVgap(5);
        topBar.setHgap(5);
        topBar.setPadding(new Insets(5));

        Image stationImage = new Image(Objects.requireNonNull(getClass().getResource("lupenbild-icon.png")).toExternalForm());

        ImageView stationImageView = new ImageView();
        stationImageView.setImage(stationImage);
        stationImageView.setFitHeight(20);
        stationImageView.setFitWidth(20);

        topBar.add(stationImageView, 0,0);

        Label stationNameLabel = new Label(stationName + " ("+stationCode+")");
        stationNameLabel.getStyleClass().add("railworks-station-label");
        topBar.add(stationNameLabel, 1, 0);

        for(int i = 0; i < Math.floor(height/gridSize); i++){
            getColumnConstraints().add(new ColumnConstraints(gridSize));
        }

        add(topBar, 0, 0, (int) Math.ceil(width/gridSize), 1);

        setBackground(new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
        getStyleClass().add("railworks-station");

    }

}
