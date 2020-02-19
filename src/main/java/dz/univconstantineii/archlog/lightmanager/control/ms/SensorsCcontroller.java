package dz.univconstantineii.archlog.lightmanager.control.ms;

import dz.univconstantineii.archlog.lightmanager.model.beans.Lampe;
import dz.univconstantineii.archlog.lightmanager.model.beans.Luminosity;
import dz.univconstantineii.archlog.lightmanager.system.managers.ArduinoManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class SensorsCcontroller {
    private final ArduinoManager arduinoManager;

    public SensorsCcontroller() {
        this.arduinoManager = ArduinoManager.getInstance();
    }

    @RequestMapping(value = "/mouvement", method = RequestMethod.GET)
    public boolean isMovement() {
        return arduinoManager.isMovement();
    }

    @RequestMapping(value = "/light", method = RequestMethod.GET)
    public Luminosity getLight() {
        return arduinoManager.getLuminosity();
    }
}
