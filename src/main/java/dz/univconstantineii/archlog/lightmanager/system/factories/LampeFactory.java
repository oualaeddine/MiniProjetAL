package dz.univconstantineii.archlog.lightmanager.system.factories;

import dz.univconstantineii.archlog.lightmanager.model.beans.Lampe;
import dz.univconstantineii.archlog.lightmanager.model.beans.VariableLampe;
import org.sintef.jarduino.DigitalPin;

public class LampeFactory {
    static int lastLampId;

    public Lampe getLampe(String name, DigitalPin port) {
        lastLampId++;
        return new Lampe(lastLampId, name, port);
    }
    public Lampe getVariableLightLampe(String name, DigitalPin port) {
        lastLampId++;
        return new VariableLampe(lastLampId, name, port);
    }
}
