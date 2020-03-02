package savadrox.project.Controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savadrox.project.Repositories.RepositoryEngine;
import savadrox.project.Repositories.RepositoryPojazdElektryczny;
import savadrox.project.Repositories.RepositoryPojazdSpalinowy;
import savadrox.project.SaveToFile;
import savadrox.project.models.Engine;
import savadrox.project.models.PojazdElektryczny;
import savadrox.project.models.PojazdEngine;
import savadrox.project.models.PojazdSpalinowy;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    public RepositoryPojazdElektryczny repositoryPojazdElektryczny;
    public RepositoryPojazdSpalinowy repositoryPojazdSpalinowy;
    public RepositoryEngine repositoryEngine;

    public Controller(RepositoryPojazdElektryczny repositoryPojazdElektryczny, RepositoryPojazdSpalinowy repositoryPojazdSpalinowy, RepositoryEngine repositoryEngine) {
        this.repositoryPojazdElektryczny = repositoryPojazdElektryczny;
        this.repositoryPojazdSpalinowy = repositoryPojazdSpalinowy;
        this.repositoryEngine = repositoryEngine;
    }
    SaveToFile zapis = new SaveToFile();
    @RequestMapping("/pojazdy/spalinowe")
    public String getPojazdySpalinowe(Model pojazdSpalinowy,Model engine){
        pojazdSpalinowy.addAttribute("pojazdySpalinowe",repositoryPojazdSpalinowy.findAll());

        pojazdSpalinowy.addAttribute("engines",repositoryEngine.findAll());
        return "pojazdySpalinowe";
    }
    @RequestMapping("/pojazdy/elektryczne")
    public String getPojazdyElektryczne(Model pojazdElektryczny){
        pojazdElektryczny.addAttribute("pojazdyElektryczne",repositoryPojazdElektryczny.findAll());
        return "pojazdyElektryczne";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/pojazdy/elektryczne1")
    public void postPojazdElektryczny(@RequestBody PojazdElektryczny pojazdElektryczny){
        System.out.println("a");
        repositoryPojazdElektryczny.save(pojazdElektryczny);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pojazdy/spalinowe")
    public void postPojazdSpalinowy(@RequestBody PojazdEngine pojazdEngine){
        PojazdSpalinowy pojazdSpalinowy = new PojazdSpalinowy();
        Engine engine = new Engine();
        engine.setPower(pojazdEngine.enginePower);
        engine.setType(pojazdEngine.EngineType);
        engine.setVolume(pojazdEngine.engineVolume);
        repositoryEngine.save(engine);
        pojazdSpalinowy.setName(pojazdEngine.name);
        pojazdSpalinowy.setWheelCount(pojazdEngine.wheelCount);
        pojazdSpalinowy.setMaxSpeed(pojazdEngine.maxSpeed);
        pojazdSpalinowy.setFuelType(pojazdEngine.fuelType);
        pojazdSpalinowy.setDriveTrainType(pojazdEngine.driveTrainType);
        pojazdSpalinowy.setEngine(engine);
        repositoryPojazdSpalinowy.save(pojazdSpalinowy);

    }


    @RequestMapping("/zapis")
    public void zapis(@RequestParam(value="value", required=false, defaultValue="World") String value) throws IOException {
        zapis.saveTables(repositoryPojazdElektryczny.findAll(),repositoryPojazdSpalinowy.findAll());
    }
    @RequestMapping("/odczyt")
    public void odczyt(@RequestParam(value="value", required=false, defaultValue="World") String value) throws IOException {
        zapis.loadTables(repositoryPojazdElektryczny,repositoryPojazdSpalinowy,repositoryEngine);
    }


}
