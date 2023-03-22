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
        appName.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-appname");

        system = new Menu("System");
        system.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-system");

        znzl = new Menu("ZN/ZL");
        znzl.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-znzl");

        zugdaten = new Menu("Zugdaten");
        zugdaten.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-zugdaten");

        gleismelder = new Menu("Gleismelder");
        gleismelder.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-gleismelder");

        ubersichtsbilder = new Menu("Übersichtsbilder");
        ubersichtsbilder.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-ubersichtsbilder");

        lupenbilder = new Menu("Lupenbilder");
        lupenbilder.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-lupenbilder");

        konfiguration = new Menu("Konfiguration");
        konfiguration.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-konfiguration");

        help = new Menu("?");
        help.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-help");

        getMenus().addAll(appName, system, znzl, zugdaten, gleismelder, ubersichtsbilder, lupenbilder, konfiguration, help);
        getStyleClass().add("railworks-topmenu");

    }


}
