package savadrox.project;

import org.springframework.stereotype.Component;
import savadrox.project.Repositories.RepositoryEngine;
import savadrox.project.Repositories.RepositoryPojazdElektryczny;
import savadrox.project.Repositories.RepositoryPojazdSpalinowy;
import savadrox.project.models.Engine;
import savadrox.project.models.PojazdElektryczny;
import savadrox.project.models.PojazdSpalinowy;

import java.io.*;
@Component
public class SaveToFile {

    File pliczek = new File("C:\\Users\\Savadrox\\OneDrive\\project\\src\\main\\java\\savadrox\\project\\pliczek.txt");

    public void saveTables(Iterable<PojazdElektryczny> tablicaPojazdowE, Iterable<PojazdSpalinowy> tablicaPojazdowS) throws IOException {
        if (!pliczek.exists()) {
            pliczek.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(pliczek);
        fileWriter.write(String.valueOf(tablicaPojazdowE));
        fileWriter.write("\n");
        fileWriter.write(String.valueOf(tablicaPojazdowS));
        fileWriter.close();
    }

    public void loadTables(RepositoryPojazdElektryczny repositoryPojazdElektryczny, RepositoryPojazdSpalinowy repositoryPojazdSpalinowy, RepositoryEngine repositoryEngine) throws IOException {
        if (pliczek.exists()) {
            FileReader fileReader = new FileReader(pliczek);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String pojazdyE = bufferedReader.readLine();
            pojazdyE = pojazdyE.substring(1, pojazdyE.length() - 1);
            int iloscElementowTablicy = 1;
            for (int i = 0; i < pojazdyE.length(); i++) {
                if (pojazdyE.charAt(i) == ',') {
                    iloscElementowTablicy++;
                }
            }
            String[] tablicaStringow = new String[iloscElementowTablicy];
            pojazdyE += ",";
            int a = 0;
            int b = 0;
            for (int i = 0; i < pojazdyE.length(); i++) {
                if (pojazdyE.charAt(i) == ',') {
                    tablicaStringow[b] = pojazdyE.substring(a, i) + " ";
                    a = i + 2;
                    b += 1;
                }
            }
            String[] tablica = new String[5];
            for (int k = 0; k < iloscElementowTablicy; k++) {
                int c = 0;
                int d = 0;
                PojazdElektryczny pojazdElektryczny = new PojazdElektryczny();
                for (int l = 0; l < tablicaStringow[k].length(); l++) {
                    if (tablicaStringow[k].charAt(l) == ' ') {
                        tablica[d] = tablicaStringow[k].substring(c, l);
                        //System.out.println(tablica[d]);
                        c = l + 1;
                        d += 1;
                    }
                }
                pojazdElektryczny.setName(tablica[0]);
                pojazdElektryczny.setWheelCount(Integer.parseInt(tablica[1]));
                pojazdElektryczny.setMaxSpeed(Integer.parseInt(tablica[2]));
                pojazdElektryczny.setEnginePower(Integer.parseInt(tablica[3]));
                pojazdElektryczny.setRange(Integer.parseInt(tablica[4]));
                repositoryPojazdElektryczny.save(pojazdElektryczny);
            }


            String pojazdyS = bufferedReader.readLine();
            pojazdyS = pojazdyS.substring(1, pojazdyS.length() - 1);
            int iloscElementowTablicyS = 1;
            for (int i = 0; i < pojazdyS.length(); i++) {
                if (pojazdyS.charAt(i) == ',') {
                    iloscElementowTablicyS++;
                }
            }
            String[] tablicaStringowS = new String[iloscElementowTablicyS];
            pojazdyS += ",";
            int e = 0;
            int f = 0;
            for (int i = 0; i < pojazdyS.length(); i++) {
                if (pojazdyS.charAt(i) == ',') {
                    tablicaStringowS[f] = pojazdyS.substring(e, i) + " ";
                    e = i + 2;
                    f += 1;
                }
            }
            String[] tablicaS = new String[8];
            for(int k=0;k<iloscElementowTablicyS;k++){
                int g=0;
                int h=0;
                PojazdSpalinowy pojazdSpalinowy = new PojazdSpalinowy();
                Engine engine = new Engine();
                for (int l = 0; l < tablicaStringowS[k].length(); l++) {
                    if (tablicaStringowS[k].charAt(l) == ' ') {
                        tablicaS[h] = tablicaStringowS[k].substring(g, l);
                        g = l + 1;
                        h += 1;
                    }
                }
                pojazdSpalinowy.setName(tablicaS[0]);
                pojazdSpalinowy.setWheelCount(Integer.parseInt(tablicaS[1]));
                pojazdSpalinowy.setMaxSpeed(Integer.parseInt(tablicaS[2]));
                pojazdSpalinowy.setDriveTrainType(tablicaS[3]);
                pojazdSpalinowy.setFuelType(tablicaS[4]);
                engine.setType(tablicaS[5]);
                engine.setVolume(Integer.parseInt(tablicaS[6]));
                engine.setPower(Integer.parseInt(tablicaS[7]));
                pojazdSpalinowy.setEngine(engine);
                repositoryEngine.save(engine);
                repositoryPojazdSpalinowy.save(pojazdSpalinowy);
            }






        }
    }
}

