package ch.railworks.railworks.view.station;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class StationTopBar extends HBox {

    private final int SIZE = 20;
    private final int INSETS = 2;
    private final int COLUM_CONSTRAINT = SIZE-INSETS;


    public StationTopBar(String stationName, String stationCode, double width) {
        super();

        this.setBackground(new Background(new BackgroundFill(Color.web("#1C65C0FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        setMaxHeight(SIZE);
        setPrefHeight(SIZE);
        setPrefWidth(width);
        setPadding(new Insets(INSETS));

        Image stationImage = new Image(Objects.requireNonNull(getClass().getResource("lupenbild-icon.png")).toExternalForm());

        ImageView stationImageView = new ImageView();
        stationImageView.setImage(stationImage);
        stationImageView.setFitHeight(COLUM_CONSTRAINT);
        stationImageView.setFitWidth(COLUM_CONSTRAINT);

        Label stationNameLabel = new Label(stationName + " (" + stationCode + ")");
        stationNameLabel.getStyleClass().add("railworks-station-label");

        Image closeImage = new Image(Objects.requireNonNull(getClass().getResource("close.png")).toExternalForm());
        ImageView closeImageView = new ImageView();
        closeImageView.setImage(closeImage);
        closeImageView.setFitHeight(COLUM_CONSTRAINT-(5+INSETS));
        closeImageView.setFitWidth(COLUM_CONSTRAINT-(5+INSETS));

        Button closeButton = new Button();
        closeButton.setGraphic(closeImageView);
        closeButton.setPrefHeight(SIZE);
        closeButton.setPrefWidth(SIZE);
        closeButton.setMaxHeight(SIZE);
        closeButton.setMaxWidth(SIZE);
        closeButton.setBackground(new Background(new BackgroundFill(Color.web("#293C60FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Region spacerBig = new Region();
        setHgrow(spacerBig, Priority.ALWAYS);
        Region spacerSmall = new Region();
        spacerSmall.setPrefWidth(INSETS);

        setAlignment(Pos.CENTER_LEFT);
        getChildren().addAll(stationImageView, spacerSmall, stationNameLabel, spacerBig,closeButton);


        /**
         * Insets insets = pane.getInsets();
         * Dimension size = b1.getPreferredSize();
         * b1.setBounds(25 + insets.left, 5 + insets.top,
         *              size.width, size.height);
         * size = b2.getPreferredSize();
         * b2.setBounds(55 + insets.left, 40 + insets.top,
         *              size.width, size.height);
         * size = b3.getPreferredSize();
         * b3.setBounds(150 + insets.left, 15 + insets.top,
         *              size.width + 50, size.height + 20);
         */


    }


}
