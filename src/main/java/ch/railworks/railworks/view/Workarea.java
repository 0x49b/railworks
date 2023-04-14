package ch.railworks.railworks.view;

import ch.railworks.railworks.model.PresentationModel;
import ch.railworks.railworks.utils.MouseGestures;
import ch.railworks.railworks.view.station.Station;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Workarea {

    private final PresentationModel pm;
    MouseGestures mouseGestures;
    Pane workareaLayer;
    private final ZoomableScrollPane scrollPane;

    public Workarea(PresentationModel pm) {
        super();
        this.pm = pm;
        mouseGestures = new MouseGestures(this);

        Group canvas = new Group();
        workareaLayer = new Pane();

        canvas.getChildren().add(workareaLayer);
        scrollPane = new ZoomableScrollPane(canvas);
        scrollPane.getStyleClass().add("railworks-scrollpane");

        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

    }

    public ScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public Pane getWorkareaLayer() {
        return this.workareaLayer;
    }

    public PresentationModel getModel() {
        return this.pm;
    }


    public void preUpdate() {
    }

    public void update() {

        getWorkareaLayer().getChildren().addAll(pm.getAddedStations());
        getWorkareaLayer().getChildren().removeAll(pm.getRemovedStations());

        for (Node s : pm.getAllStations()) {
           if( s instanceof Station){
               mouseGestures.makeDraggableHandle(((Station) s).getTopBar());
           }
        }

        pm.mergeStations();
    }

}
