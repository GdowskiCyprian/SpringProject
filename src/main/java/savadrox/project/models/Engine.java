package savadrox.project.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private int volume;
    private int power;

    public int getId() {return id;}

    public void setId(int id) { this.id = id; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Engine() {
    }

    public Engine(String type, int volume, int power) {
        this.type = type;
        this.volume = volume;
        this.power = power;
    }
    @Override
    public String toString() {
        return this.getType() + " " + this.getVolume()+ " " + this.getPower();
    }
}
