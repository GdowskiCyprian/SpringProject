package savadrox.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PojazdElektryczny extends Pojazd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int enginePower;
    private int range;


    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public PojazdElektryczny(String name, int wheelCount, int maxSpeed, int enginePower, int range) {
        super(name, wheelCount, maxSpeed);
        this.enginePower = enginePower;
        this.range = range;
    }
    public PojazdElektryczny(){}

    @Override
    public String toString() {
        return  super.toString()+" "+this.getEnginePower()+" "+this.getRange();
    }
}
