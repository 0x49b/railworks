package ch.railworks.railworks.utils;

import ch.railworks.railworks.view.Workarea;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class MouseGestures {

    final DragContext dragContext = new DragContext();
    Workarea workarea;

    public MouseGestures(Workarea workarea) {
        this.workarea = workarea;
    }

    public void makeDraggable(final Node node) {
        node.setOnMousePressed(onMousePressedEventHandler);
        node.setOnMouseDragged(onMouseDraggedEventHandler);
        node.setOnMouseReleased(onMouseReleasedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        Node node = (Node) event.getSource();
        dragContext.x = node.getBoundsInParent().getMinX() - event.getScreenX();
        dragContext.y = node.getBoundsInParent().getMinY() - event.getScreenY();
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {
        Node node = (Node) event.getSource();
        double offsetX = event.getScreenX() + dragContext.x;
        double offsetY = event.getScreenY() + dragContext.y;
        node.relocate(offsetX, offsetY);
    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
    };


    static class DragContext {
        double x;
        double y;
    }
}
