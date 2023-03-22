package ch.railworks.railworks.view.menu;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class TopMenu extends MenuBar {


    Menu appName;
    Menu system;
    Menu znzl;
    Menu zugdaten;
    Menu gleismelder;
    Menu ubersichtsbilder;
    Menu lupenbilder;
    Menu konfiguration;
    Menu help;

    public TopMenu() {
        super();

        appName = new Menu("RailWorks");
        appName.setDisable(true);
        appName.getStyleClass().add("railworks-topmenu-appname");

        system = new Menu("System");
        system.getStyleClass().add("railworks-topmenu-system");

        znzl = new Menu("ZN/ZL");
        znzl.getStyleClass().add("railworks-topmenu-znzl");

        zugdaten = new Menu("Zugdaten");
        zugdaten.getStyleClass().add("railworks-topmenu-zugdaten");

        gleismelder = new Menu("Gleismelder");
        gleismelder.getStyleClass().add("railworks-topmenu-gleismelder");

        ubersichtsbilder = new Menu("Übersichtsbilder");
        ubersichtsbilder.getStyleClass().add("railworks-topmenu-ubersichtsbilder");

        lupenbilder = new Menu("Lupenbilder");
        lupenbilder.getStyleClass().add("railworks-topmenu-lupenbilder");

        konfiguration = new Menu("Konfiguration");
        konfiguration.getStyleClass().add("railworks-topmenu-konfiguration");

        help = new Menu("?");
        help.getStyleClass().add("railworks-topmenu-help");

        getMenus().addAll(appName, system, znzl, zugdaten, gleismelder, ubersichtsbilder, lupenbilder, konfiguration, help);
        getStyleClass().add("raileworks-topmenu");


    }


}
