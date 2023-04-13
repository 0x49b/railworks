package ch.railworks.railworks.view.window;

import javafx.scene.layout.GridPane;

public class BaseWindow extends GridPane {

    private double height;
    private double width;

    private String title;

    private final BaseWindowModel bwm;

    public BaseWindow() {
        super();
        this.bwm= new BaseWindowModel();
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
