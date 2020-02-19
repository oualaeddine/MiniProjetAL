package dz.univconstantineii.archlog.lightmanager.control.ms;

import dz.univconstantineii.archlog.lightmanager.model.beans.Lampe;
import dz.univconstantineii.archlog.lightmanager.model.beans.VariableLampe;
import dz.univconstantineii.archlog.lightmanager.system.managers.ArduinoManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class LampesController {

    private final ArduinoManager arduinoManager;

    public LampesController() {
        arduinoManager = ArduinoManager.getInstance();
    }

    @RequestMapping(value = "/Lampes", method = RequestMethod.GET)
    public LinkedList<Lampe> getLamps() {
        return arduinoManager.getLamps();
    }

    @GetMapping(value = "/Lampes/{id}/on")
    public Lampe allumerLampe(@PathVariable int id) {
        arduinoManager.setAuto(false);
        return arduinoManager.allumer(id);
    }

    @GetMapping(value = "/Lampes/{id}/off")
    public Lampe eteindreLampe(@PathVariable int id) {
        arduinoManager.setAuto(false);
        return arduinoManager.eteindre(id);
    }

    @GetMapping(value = "/Lampes/{id}/luminosity/{luminosity}")
    public VariableLampe setLuminosity(@PathVariable int id, @PathVariable int luminosity) {
        return arduinoManager.setLuminosity(id, luminosity);
    }
}
