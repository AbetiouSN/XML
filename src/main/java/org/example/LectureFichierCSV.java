package org.example;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LectureFichierCSV {

    public static void main(String[] args) {
        String fichierCSV = "C:\\Users\\PE\\Documents\\xml\\src\\main\\resources\\listeEtudiantsGINFO_ENSAT.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fichierCSV))) {

            // Lecture de toutes les lignes du fichier CSV
            List<String[]> lignes = reader.readAll();

            for (String[] ligne : lignes) {
                if (ligne.length >= 3) {
                    System.out.println(" "+ligne[0] + " " + ligne[1] + " " + ligne[2]);
                } else {
                    System.out.println("Ligne invalide : " + Arrays.toString(ligne));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}


