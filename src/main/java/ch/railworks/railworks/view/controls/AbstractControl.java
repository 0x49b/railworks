package ch.railworks.railworks.view.controls;

import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.UUID;

public class AbstractControl extends Pane implements Serializable {

    UUID uid;
    ElementPosition position;

    final int SIZE = 25;


    public AbstractControl() {
        super();
        uid = UUID.randomUUID();
    }

    public UUID getUid() {
        return uid;
    }

    public ElementPosition getPosition() {
        return position;
    }

    public void setPosition(ElementPosition position) {
        this.position = position;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void draw(){}

}
