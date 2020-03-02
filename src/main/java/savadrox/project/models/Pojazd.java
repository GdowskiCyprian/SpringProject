package savadrox.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Pojazd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int wheelCount;
    private int maxSpeed;

    public int getId() {return id;}

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Pojazd(String name, int wheelCount, int maxSpeed) {
        this.name = name;
        this.wheelCount = wheelCount;
        this.maxSpeed = maxSpeed;
    }

    public Pojazd() {
    }

    @Override
    public String toString() {
        return this.getName()+" "+this.getWheelCount()+" "+this.getMaxSpeed();
    }
}
