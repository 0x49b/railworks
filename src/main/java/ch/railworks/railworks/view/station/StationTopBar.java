package ch.railworks.railworks.view.station;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class StationTopBar extends GridPane {

    private final int SIZE = 25;
    private final int INSETS = 5;
    private final int COLUM_CONSTRAINT = 20;


    public StationTopBar(String stationName, String stationCode, double width) {
        super();

        this.setBackground(new Background(new BackgroundFill(Color.web("#1C65C0FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        setMaxHeight(SIZE);
        setPrefHeight(SIZE);
        setPrefWidth(width);
        getColumnConstraints().add(new ColumnConstraints(COLUM_CONSTRAINT));
        setVgap(5);
        setHgap(5);
        setPadding(new Insets(INSETS));

        Image stationImage = new Image(Objects.requireNonNull(getClass().getResource("lupenbild-icon.png")).toExternalForm());

        ImageView stationImageView = new ImageView();
        stationImageView.setImage(stationImage);
        stationImageView.setFitHeight(COLUM_CONSTRAINT);
        stationImageView.setFitWidth(COLUM_CONSTRAINT);

        add(stationImageView, 0, 0);

        Label stationNameLabel = new Label(stationName + " (" + stationCode + ")");
        stationNameLabel.getStyleClass().add("railworks-station-label");
        add(stationNameLabel, 1, 0);

        Image closeImage = new Image(Objects.requireNonNull(getClass().getResource("close.png")).toExternalForm());
        ImageView closeImageView = new ImageView();
        closeImageView.setImage(closeImage);
        closeImageView.setFitHeight(COLUM_CONSTRAINT-10);
        closeImageView.setFitWidth(COLUM_CONSTRAINT-10);

        add(closeImageView, 140, 0);


    }


}
