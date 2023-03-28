package ch.railworks.railworks.view.controls;

import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

public class AbstractControl extends Pane implements Serializable {

    @Getter
    UUID uid;

    @Getter
    @Setter
    ElementPosition position;

    final int SIZE = 25;


    public AbstractControl() {
        super();
        uid = UUID.randomUUID();
    }

    public void draw(){}

}