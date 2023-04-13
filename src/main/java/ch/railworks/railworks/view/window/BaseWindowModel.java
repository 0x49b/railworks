package ch.railworks.railworks.view.window;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BaseWindowModel {

    private final StringProperty windowTitle = new SimpleStringProperty("");

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
}
