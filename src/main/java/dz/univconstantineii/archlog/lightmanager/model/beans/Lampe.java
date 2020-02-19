package dz.univconstantineii.archlog.lightmanager.model.beans;

import org.sintef.jarduino.DigitalPin;

import java.io.Serializable;

public class Lampe implements Serializable {
    DigitalPin port;
    String  name;
    int id;
    boolean isOn;

    public Lampe(int id, String name, DigitalPin port) {
        this.port = port;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DigitalPin getPort() {
        return port;
    }

    public void setPort(DigitalPin port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Lampe{" +
                "port='" + port + '\'' +
                ", name='" + name + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
