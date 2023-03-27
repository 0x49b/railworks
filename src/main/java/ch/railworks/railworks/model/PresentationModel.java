package ch.railworks.railworks.model;

import ch.railworks.railworks.view.station.Station;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class PresentationModel {
    private final StringProperty applicationTitle = new SimpleStringProperty("RailWorks");
    private final StringProperty applicationVersion = new SimpleStringProperty("0.1");

    @Getter
    List<Station> allStations = new ArrayList<>();

    @Getter
    List<Station> addedStations = new ArrayList<>();

    @Getter
    List<Station> removedStations = new ArrayList<>();

    @Getter
    @Setter
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
        allStations.add(station);
    }

    public void mergeStations() {
        allStations.addAll(addedStations);
        allStations.removeAll(removedStations);

        addedStations.clear();
        removedStations.clear();
    }


}
