package dz.univconstantineii.archlog.lightmanager.system.managers;

import dz.univconstantineii.archlog.lightmanager.model.beans.Lampe;
import dz.univconstantineii.archlog.lightmanager.model.beans.Luminosity;
import dz.univconstantineii.archlog.lightmanager.model.beans.VariableLampe;
import dz.univconstantineii.archlog.lightmanager.model.enums.EventType;
import dz.univconstantineii.archlog.lightmanager.model.enums.LampeEventType;
import dz.univconstantineii.archlog.lightmanager.system.events.LampeEvent;
import dz.univconstantineii.archlog.lightmanager.system.factories.LampeFactory;
import org.sintef.jarduino.*;

import java.util.Date;
import java.util.LinkedList;

import static org.sintef.jarduino.DigitalPin.*;

public class ArduinoManager extends JArduino {
    private static final String COM_PORT = "COM4";
    private static final DigitalPin MOUVEMENT_SENSOR_PIN = DigitalPin.PIN_13;
    private static final AnalogPin LIGHT_SENSOR_PIN = AnalogPin.A_3;

    private static ArduinoManager instance;
    private LinkedList<Lampe> lampes;
    private boolean isAuto;

    public ArduinoManager() {
        super(COM_PORT);
        instance = this;
        initiate();

    }

    @Override
    protected void setup() throws InvalidPinTypeException {
        for (Lampe l : lampes) {
            pinMode(l.getPort(), PinMode.OUTPUT);
        }
        System.out.println("setup");

        pinMode(MOUVEMENT_SENSOR_PIN, PinMode.INPUT);
    }

    @Override
    protected void loop() throws InvalidPinTypeException {
        //getLuminosity();
        if (isAuto) {
            allumer(1);
            eteindre(2);
            if (isMovement() && !getLuminosity().isLight()) {
                allumer(4);
                eteindre(3);

                delay(15 * 1000);//attendre 15 secondes pour reverifier
            } else {
                eteindre(4);
                allumer(3);
            }
        } else {
            eteindre(1);
            allumer(2);
        }
    }

    public void initiate() {
        LampeFactory lfactory = new LampeFactory();
        lampes = new LinkedList<>();
        lampes.add(lfactory.getLampe("AUTO_ON", PIN_2));
        lampes.add(lfactory.getLampe("AUTO_OFF", PIN_4));
        lampes.add(lfactory.getLampe("BLUE", PIN_9));
        lampes.add(lfactory.getVariableLightLampe("WHITE", PIN_6));

        setAuto(true);
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public LinkedList<Lampe> getLamps() {
        return lampes;
    }

    public Lampe allumer(int id) {
        Lampe lampe = getLamp(id);
        if (lampe != null && !lampe.isOn()) {
            // set the LED on
            digitalWrite(lampe.getPort(), HIGH);
            System.out.println("rani ncha3l fi : " + lampe);

            lampe.setOn(true);
            LogsManager.logEvent(new LampeEvent(LampeEventType.ON, isAuto ? EventType.AUTO : EventType.MANUEL, new Date()));
        }
        return lampe;
    }

    public Lampe eteindre(int id) {
        Lampe lampe = getLamp(id);
        if (lampe != null && lampe.isOn()) {
            // set the LED off
            digitalWrite(lampe.getPort(), LOW);
            System.out.println("rani ntafi fi : " + lampe);
            lampe.setOn(false);
            LogsManager.logEvent(new LampeEvent(LampeEventType.OFF, isAuto ? EventType.AUTO : EventType.MANUEL, new Date()));
        }
        return lampe;
    }

    public VariableLampe setLuminosity(int id, int luminosity) {//todo
        VariableLampe lampe = (VariableLampe) getLamp(id);
        if (lampe != null) {
            // set the LED on
            digitalWrite(lampe.getPort(), HIGH);
            lampe.setOn(true);
        }
        return lampe;
    }

    public boolean isMovement() {
        return digitalRead(MOUVEMENT_SENSOR_PIN) == HIGH;
    }

    public Luminosity getLuminosity() {
   //     System.out.println("reading : " + analogRead(LIGHT_SENSOR_PIN));
        return new Luminosity(analogRead(LIGHT_SENSOR_PIN));
    }

    public static ArduinoManager getInstance() {
        return instance != null ? instance : new ArduinoManager();
    }

    private Lampe getLamp(int id) {
        for (Lampe l : lampes) {
            if (l.getId() == id) return l;
        }
        return null;
    }
}
