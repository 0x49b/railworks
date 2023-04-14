package ch.railworks.railworks.view.menu;


import ch.railworks.railworks.model.PresentationModel;
import ch.railworks.railworks.view.Workarea;
import ch.railworks.railworks.view.station.Station;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;

import java.util.List;
import java.util.stream.Collectors;

public class TopMenu extends MenuBar {

    Menu     appName;
    Menu     system;
    Menu     znzl;
    Menu     zugdaten;
    Menu     gleismelder;
    Menu     ubersichtsbilder;
    Menu     lupenbilder;
    MenuItem dopp;
    MenuItem bg;
    Menu     konfiguration;
    Menu     help;


    PresentationModel pm;
    Workarea          wa;

    public TopMenu(Workarea workarea) {
        super();

        wa = workarea;
        pm = workarea.getModel();

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

        dopp = new MenuItem("DOPP");
        bg   = new MenuItem("BG");
        lupenbilder.getItems().addAll(dopp, bg);

        konfiguration = new Menu("Konfiguration");
        konfiguration.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-konfiguration");

        help = new Menu("?");
        help.getStyleClass().addAll("railworks-topmenu-item", "railworks-topmenu-help");

        getMenus().addAll(appName, system, znzl, zugdaten, gleismelder, ubersichtsbilder, lupenbilder, konfiguration, help);
        getStyleClass().add("railworks-topmenu");

        registerEventHandler();

    }

    private void registerEventHandler() {

        bg.setOnAction(event -> {
            System.out.println("Adding Station");
            Station station1 = new Station("Brugg_Elektra", "BG", 273, 909);
            System.out.println("Added station " + station1.getStationName());

            pm.addStation(station1);

            System.out.println("All Stations from PM");

            wa.update();

            List<Node> stationList = pm.getAllStations();
            for(Node s: stationList){
                System.out.println(s);
            }

        });

    }


}
