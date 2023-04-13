package ch.railworks.railworks.view.window;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class BaseTopBar extends HBox {

    private final int SIZE = 20;
    private final int INSETS = 2;
    private final int COLUM_CONSTRAINT = SIZE - INSETS;

    private Label windowTitleLabel;
    private Image windowImage;
    private final BaseWindowModel bwm;

    public BaseTopBar(BaseWindowModel bwm) {
        super();
        this.bwm = bwm;

        setMaxHeight(SIZE);
        setPrefHeight(SIZE);
        setPrefWidth(Double.MAX_VALUE);
        setPadding(new Insets(INSETS));

        initializeSelf();
        initializeControls();
        bindProperties();

    }

    public void initializeSelf() {
        getStyleClass().add("railworks-window");
    }


    public void initializeControls() {

        windowImage = new Image(java.util.Objects.requireNonNull(getClass().getResource("lupenbild-icon.png")).toExternalForm());
        ImageView windowImageView = new ImageView();
        windowImageView.setImage(windowImage);
        windowImageView.setFitHeight(COLUM_CONSTRAINT);
        windowImageView.setFitWidth(COLUM_CONSTRAINT);

        windowTitleLabel = new Label();
        windowTitleLabel.getStyleClass().add("railworks-window-label");

        Image closeImage = new Image(Objects.requireNonNull(getClass().getResource("close.png")).toExternalForm());
        ImageView closeImageView = new ImageView();
        closeImageView.setImage(closeImage);
        closeImageView.setFitHeight(COLUM_CONSTRAINT - (5 + INSETS));
        closeImageView.setFitWidth(COLUM_CONSTRAINT - (5 + INSETS));

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
        getChildren().addAll(windowImageView, spacerSmall, windowTitleLabel, spacerBig, closeButton);
    }

    public void bindProperties() {
        windowTitleLabel.textProperty().bind(bwm.windowTitleProperty());
    }

}
