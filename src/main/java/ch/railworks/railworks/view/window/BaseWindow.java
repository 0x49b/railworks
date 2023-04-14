package ch.railworks.railworks.view.window;

import javafx.scene.layout.GridPane;

public class BaseWindow extends GridPane {

    private final BaseWindowModel bwm;
    private final int GRID_SIZE = 25;

    public BaseWindow() {
        super();
        this.bwm = new BaseWindowModel();
    }

    public BaseWindow height(double height) {
        bwm.setWindowHeight(height);
        return this;
    }

    public BaseWindow width(double width) {
        bwm.setWindowWidth(width);
        return this;
    }

    public BaseWindow size(double width, double height) {
        bwm.setWindowWidth(width);
        bwm.setWindowHeight(height);
        return this;
    }

    public BaseWindow title(String title) {
        bwm.setWindowTitle(title);
        return this;
    }

}
