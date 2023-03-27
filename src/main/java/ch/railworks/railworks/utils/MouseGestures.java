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


        // System.out.println(node.getBoundsInParent().getWidth() +"|"+node.getBoundsInParent().getHeight());
        // System.out.println(dragContext.x +"."+ dragContext.y);

        // System.out.println(workarea.getWorkareaLayer().getBoundsInParent().getWidth());
        System.out.println(workarea.getModel().getWorkPane().getBoundsInParent().getWidth());
        System.out.println();



        /*
         * Bind to maximum of ScrollPane
         */
        if(offsetX < 0.0) offsetX = 0.0;
        if(offsetY < 0.0) offsetY = 0.0;
        if((node.getBoundsInParent().getWidth() + offsetX) > workarea.getModel().getWorkPane().getWidth()) offsetX = (workarea.getModel().getWorkPane().getWidth()-node.getBoundsInParent().getWidth());
        if((node.getBoundsInParent().getHeight() + offsetY) > workarea.getModel().getWorkPane().getHeight()) offsetY = (workarea.getModel().getWorkPane().getHeight()-node.getBoundsInParent().getHeight());

        node.relocate(offsetX, offsetY);


        //System.out.println( offsetX +"/"+offsetY);


    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
    };


    class DragContext {
        double x;
        double y;
    }
}
