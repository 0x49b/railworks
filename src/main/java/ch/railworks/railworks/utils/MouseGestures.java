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

    public void makeDraggableHandle(final Node node){

        node.setOnMousePressed(onMousePressedOuterEventHandler);
        node.setOnMouseDragged(onMouseDraggedOuterEventHandler);
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

        /*
         * Constrain to maximum of ParentNode
         */
        if(offsetX < 0.0) offsetX = 0.0;
        if(offsetY < 0.0) offsetY = 0.0;
        if((node.getBoundsInParent().getWidth() + offsetX) > workarea.getModel().getWorkPane().getWidth()) offsetX = (workarea.getModel().getWorkPane().getWidth()-node.getBoundsInParent().getWidth());
        if((node.getBoundsInParent().getHeight() + offsetY) > workarea.getModel().getWorkPane().getHeight()) offsetY = (workarea.getModel().getWorkPane().getHeight()-node.getBoundsInParent().getHeight());

        node.relocate(offsetX, offsetY);
    };

    EventHandler<MouseEvent> onMousePressedOuterEventHandler = event -> {
        Node baseNode = (Node) event.getSource();
        Node node = baseNode.getParent();
        dragContext.x = node.getBoundsInParent().getMinX() - event.getScreenX();
        dragContext.y = node.getBoundsInParent().getMinY() - event.getScreenY();
    };

    EventHandler<MouseEvent> onMouseDraggedOuterEventHandler = event -> {
        Node baseNode = (Node) event.getSource();
        Node node = baseNode.getParent();

        double offsetX = event.getScreenX() + dragContext.x;
        double offsetY = event.getScreenY() + dragContext.y;

        /*
         * Constrain to maximum of ParentNode
         */
        if(offsetX < 0.0) offsetX = 0.0;
        if(offsetY < 0.0) offsetY = 0.0;
        if((node.getBoundsInParent().getWidth() + offsetX) > workarea.getModel().getWorkPane().getWidth()) offsetX = (workarea.getModel().getWorkPane().getWidth()-node.getBoundsInParent().getWidth());
        if((node.getBoundsInParent().getHeight() + offsetY) > workarea.getModel().getWorkPane().getHeight()) offsetY = (workarea.getModel().getWorkPane().getHeight()-node.getBoundsInParent().getHeight());

        node.relocate(offsetX, offsetY);
    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
    };

}
