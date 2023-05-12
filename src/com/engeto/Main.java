package com.engeto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.concurrent.Callable;


public class Main {
    public static void main(String[] args) throws PlantException {
        PlantList plants = new PlantList();
        try {
            plants.importFromFile(PlantSettings.getFilename(), PlantSettings.getDelimiter());
        } catch (PlantException e) {
            System.err.println("Chyba při čtení souboru " + PlantSettings.getFilename()
                    + ":\n" + e.getLocalizedMessage());
        }

        try {
            plants.importFromFile("kvetiny-spatne-datum.txt", PlantSettings.getDelimiter());
        } catch (PlantException e) {
            System.err.println("Chyba při čtení souboru " + "kvetiny-spatne-datum.txt"
                    + ":\n" + e.getLocalizedMessage());
        }

        try {
            plants.importFromFile("kvetiny-spatne-frekvence.txt", PlantSettings.getDelimiter());
        } catch (PlantException e) {
            System.err.println("Chyba při čtení souboru " + "kvetiny-spatne-frekvence.txt"
                    + ":\n" + e.getLocalizedMessage());
        }
        plants.addPlantList(new Plant("Amarila v obyvaku"));
        plants.addPlantList(new Plant("Bazalka v kuchyni", 3, LocalDate.now()));
//        plant.removePlantList(2);
//        PlantList listOfPlants = new PlantList();
        Collections.sort(plants.getPlantList(), new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Plant plant: plants.getPlantList()) {
            System.out.println(plant.getName()+" "+plant.getNotes()+plant.getPlanted()+" "+plant.getWatering()+plant.getWateringInfo()+" "+plant.getFrequencyOfWatering());
        }
        System.out.println("-------");

        Collections.sort(plants.getPlantList(), new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.getWatering().compareTo(o2.getWatering());
            }
        });

        for (Plant plant: plants.getPlantList()) {
            System.out.println(plant.getName()+" "+plant.getNotes()+plant.getPlanted()+" "+plant.getWatering()+plant.getWateringInfo()+" "+plant.getFrequencyOfWatering());
        }
        System.out.println("-------");


        for (Plant plant: plants.getPlantList()) {
            LocalDate today = LocalDate.now();;
            if (ChronoUnit.DAYS.between(plant.getWatering(),today) < 5)
            System.out.println(plant.getName()+" "+plant.getWatering()+" "+plant.getNotes());
        }


       plants.exportToFile(PlantSettings.outFilename(), PlantSettings.getDelimiter());

    }
}