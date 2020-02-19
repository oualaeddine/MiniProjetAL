package dz.univconstantineii.archlog.lightmanager.model.beans;

import org.sintef.jarduino.DigitalPin;

public class VariableLampe extends Lampe {
    int power;

    public VariableLampe(int id, String name, DigitalPin port) {
        super(id, name, port);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
