package savadrox.project.models;

import javax.persistence.*;

@Entity
public class PojazdSpalinowy extends Pojazd{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String driveTrainType;
    private String fuelType;
    @OneToOne
    private Engine engine;
    public String getEngine() {
        return this.engine.getType();
    }


    public String getDriveTrainType() {
        return driveTrainType;
    }

    public void setDriveTrainType(String driveTrainType) {
        this.driveTrainType = driveTrainType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public PojazdSpalinowy(String name, int wheelCount, int maxSpeed, String driveTrainType, String fuelType, Engine engine) {
        super(name, wheelCount, maxSpeed);
        this.driveTrainType = driveTrainType;
        this.fuelType = fuelType;
        this.engine = engine;
    }


    public PojazdSpalinowy(){}

    @Override
    public String toString() {
        return  super.toString()+" "+this.getDriveTrainType() +" "+ this.getFuelType() + " "+ engine.toString();
    }

}
