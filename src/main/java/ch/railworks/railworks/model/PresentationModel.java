package ch.railworks.railworks.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class PresentationModel {
    private final StringProperty applicationTitle   = new SimpleStringProperty("RailWorks");
    private final StringProperty applicationVersion = new SimpleStringProperty("0.1");

    List<Node> allStations = new ArrayList<>();
    List<Node> addedStations = new ArrayList<>();
    List<Node> removedStations = new ArrayList<>();


    Pane workPane;

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public String getApplicationVersion() {
        return applicationVersion.get();
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion.set(applicationVersion);
    }

    public void addStation(Node station) {

        addedStations.add(station);
    }

    public void mergeStations() {
        allStations.addAll(addedStations);
        allStations.removeAll(removedStations);

        addedStations.clear();
        removedStations.clear();
    }


    public void setWorkPane(Pane p) {
        workPane = p;
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public StringProperty applicationVersionProperty() {
        return applicationVersion;
    }

    public List<Node> getAllStations() {
        return allStations;
    }

    public void setAllStations(List<Node> allStations) {
        this.allStations = allStations;
    }

    public List<Node> getAddedStations() {
        return addedStations;
    }

    public void setAddedStations(List<Node> addedStations) {
        this.addedStations = addedStations;
    }

    public List<Node> getRemovedStations() {
        return removedStations;
    }

    public void setRemovedStations(List<Node> removedStations) {
        this.removedStations = removedStations;
    }

    public Pane getWorkPane() {
        return workPane;
    }
}
