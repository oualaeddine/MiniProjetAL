package dz.univconstantineii.archlog.lightmanager.control.ms;

import dz.univconstantineii.archlog.lightmanager.system.managers.ArduinoManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {
    private final ArduinoManager arduinoManager;

    public SettingsController() {
        arduinoManager = ArduinoManager.getInstance();

    }

    @RequestMapping(value = "/auto/enable", method = RequestMethod.GET)
    public boolean enableAuto() {
        arduinoManager.setAuto(true);
        return true;
    }

    @RequestMapping(value = "/auto/disable", method = RequestMethod.GET)
    public boolean disableAuto() {
        arduinoManager.setAuto(false);
        return true;
    }
}
