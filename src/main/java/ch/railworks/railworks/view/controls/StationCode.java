package ch.railworks.railworks.view.controls;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

@Getter
public class StationCode extends AbstractControl {

    private final String stationCode;
    private Rectangle outerBounds;
    private Label stationCodeLabel;
    private StackPane elementGroup;

    public StationCode(String stationCode) {
        super();
        this.stationCode = stationCode;

        outerBounds = new Rectangle();
        outerBounds.setHeight(SIZE);
        outerBounds.setWidth(SIZE * 2);
        outerBounds.setStroke(Color.WHITE);
        outerBounds.setStrokeWidth(1);
        outerBounds.setFill(Color.TRANSPARENT);

        stationCodeLabel = new Label(stationCode);
        stationCodeLabel.setTextFill(Color.FORESTGREEN);


        elementGroup = new StackPane();
        elementGroup.getChildren().addAll(outerBounds, stationCodeLabel);


        getChildren().addAll(elementGroup);

    }

    @Override
    public void draw() {}

}
