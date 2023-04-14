package ch.railworks.railworks.view.window;

import javafx.beans.property.*;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class BaseWindowModel {

    private List<Node> elements = new ArrayList<>();

    private final StringProperty windowTitle = new SimpleStringProperty("");
    private final DoubleProperty windowHeight = new SimpleDoubleProperty(0d);
    private final DoubleProperty windowWidth = new SimpleDoubleProperty(0d);
    private final BooleanProperty windowTopMenuEnabled = new SimpleBooleanProperty(false);

    public BaseWindowModel() {
    }

    public String getWindowTitle() {
        return windowTitle.get();
    }

    public StringProperty windowTitleProperty() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle.set(windowTitle);
    }

    public double getWindowHeight() {
        return windowHeight.get();
    }

    public DoubleProperty windowHeightProperty() {
        return windowHeight;
    }

    public void setWindowHeight(double windowHeight) {
        this.windowHeight.set(windowHeight);
    }

    public double getWindowWidth() {
        return windowWidth.get();
    }

    public DoubleProperty windowWidthProperty() {
        return windowWidth;
    }

    public void setWindowWidth(double windowWidth) {
        this.windowWidth.set(windowWidth);
    }

    public boolean isWindowTopMenuEnabled() {
        return windowTopMenuEnabled.get();
    }

    public BooleanProperty windowTopMenuEnabledProperty() {
        return windowTopMenuEnabled;
    }

    public void setWindowTopMenuEnabled(boolean windowTopMenuEnabled) {
        this.windowTopMenuEnabled.set(windowTopMenuEnabled);
    }

    public void addElement(Node element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public List<Node> getElements() {
        return elements;
    }

}
