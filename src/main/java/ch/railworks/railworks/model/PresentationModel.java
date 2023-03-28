package ch.railworks.railworks.model;

import ch.railworks.railworks.view.station.Station;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public class PresentationModel {
    private final StringProperty applicationTitle   = new SimpleStringProperty("RailWorks");
    private final StringProperty applicationVersion = new SimpleStringProperty("0.1");


    List<Station> allStations = new ArrayList<>();


    List<Station> addedStations = new ArrayList<>();


    List<Station> removedStations = new ArrayList<>();


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

    public void addStation(Station station) {

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

    public List<Station> getAllStations() {
        return allStations;
    }

    public void setAllStations(List<Station> allStations) {
        this.allStations = allStations;
    }

    public List<Station> getAddedStations() {
        return addedStations;
    }

    public void setAddedStations(List<Station> addedStations) {
        this.addedStations = addedStations;
    }

    public List<Station> getRemovedStations() {
        return removedStations;
    }

    public void setRemovedStations(List<Station> removedStations) {
        this.removedStations = removedStations;
    }

    public Pane getWorkPane() {
        return workPane;
    }
}
