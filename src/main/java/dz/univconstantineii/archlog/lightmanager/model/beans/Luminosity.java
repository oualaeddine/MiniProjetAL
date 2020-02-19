package dz.univconstantineii.archlog.lightmanager.model.beans;

public class Luminosity {
    int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Luminosity(int amount) {
        this.amount = amount;
    }

    public boolean isLight() {
        return amount > 2000;
    }
}
