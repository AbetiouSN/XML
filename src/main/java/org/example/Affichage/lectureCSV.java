package org.example.Affichage;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class lectureCSV {

    public static void main(String[] args) {
        String fichierCSV = "C:\\Users\\PE\\Documents\\XML1\\src\\main\\resources\\affichageGlobals1.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fichierCSV))) {

            // Lecture de toutes les lignes du fichier CSV
            List<String[]> lignes = reader.readAll();

            for (String[] ligne : lignes) {
                if (ligne.length >= 3) {
                    System.out.println(" "+ligne[0] + " " + ligne[1] + " " + ligne[2]+" "+ligne[3]+" "+ligne[4]+" "+ligne[5]+" "+ligne[6]);
                } else {
                    System.out.println("Ligne invalide : " + Arrays.toString(ligne));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
