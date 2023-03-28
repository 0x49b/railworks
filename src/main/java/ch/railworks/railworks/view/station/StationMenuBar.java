package ch.railworks.railworks.view.station;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class StationMenuBar extends MenuBar {

    Menu bild;
    Menu optionen;
    Menu texte;


    public StationMenuBar() {
        super();

        bild = new Menu("Bild");
        optionen = new Menu("Optionen");
        texte = new Menu("Texte");

        getMenus().addAll(bild, optionen, texte);

    }

}
