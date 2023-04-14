package ch.railworks.railworks.view.window;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class BaseWindowModel {

    private List<Node> elements = new ArrayList<>();

    private final StringProperty windowTitle = new SimpleStringProperty("");
    private final DoubleProperty windowHeight = new SimpleDoubleProperty(0d);
    private final DoubleProperty windowWidth = new SimpleDoubleProperty(0d);

    public BaseWindowModel() {}

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

    public void addElement(Node element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public List<Node> getElements() {
        return elements;
    }

}
