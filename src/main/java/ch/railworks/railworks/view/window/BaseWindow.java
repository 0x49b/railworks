package ch.railworks.railworks.view.window;

import ch.railworks.railworks.model.PresentationModel;
import ch.railworks.railworks.utils.MouseGestures;
import ch.railworks.railworks.view.Workarea;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BaseWindow extends GridPane {

    private final BaseWindowModel bwm;
    private final int GRID_SIZE = 25;

    private final BaseTopBar windowTopBar;
    private final MouseGestures mouseGestures;


    //TODO remove workarea
    public BaseWindow(Workarea workarea) {
        super();
        bwm = new BaseWindowModel();
        mouseGestures = new MouseGestures(workarea);

        windowTopBar = new BaseTopBar(bwm);
    }

    public BaseWindow height(double height) {
        bwm.setWindowHeight(height);
        return this;
    }

    public BaseWindow width(double width) {
        bwm.setWindowWidth(width);
        return this;
    }

    public BaseWindow title(String title) {
        bwm.setWindowTitle(title);
        return this;
    }

    public BaseWindow enableWindowTopMenu() {
        bwm.setWindowTopMenuEnabled(true);
        return this;
    }

    public BaseWindow disableWindowTopMenu() {
        bwm.setWindowTopMenuEnabled(false);
        return this;
    }

    public BaseWindow init() {
        setPrefSize(bwm.getWindowWidth(), bwm.getWindowHeight());

        mouseGestures.makeDraggableHandle(windowTopBar);

        add(windowTopBar, 0, 0, (int) Math.ceil(bwm.getWindowWidth() / GRID_SIZE), 1);

        setBackground(new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
        getStyleClass().add("railworks-window");

        return this;
    }


    public BaseTopBar getWindowTopBar() {
        return windowTopBar;
    }

    public BaseWindowModel getBaseWindowModel() {
        return bwm;
    }

    public String toString() {
        return bwm.getWindowTitle();
    }

}
