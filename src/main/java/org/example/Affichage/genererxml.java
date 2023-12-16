package org.example.Affichage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class genererxml {
    public static void genererXML(List<String[]> donnees, String cheminFichierXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element racine = document.createElement("etudiants");
            document.appendChild(racine);

            for (String[] ligne : donnees) {
                Element etudiant = document.createElement("etudiant");
                racine.appendChild(etudiant);

                // Check if the array has enough elements before accessing them
                if (ligne.length >= 10) {
                    String[] balises = {"numero", "nom", "prenom", "ginf21", "ginf22", "ginf23", "ginf24", "ginf25", "ginf26", "moyenne"};
                    for (int i = 0; i < 10; i++) {
                        Element element = document.createElement(balises[i]);
                        element.appendChild(document.createTextNode(ligne[i]));
                        etudiant.appendChild(element);
                    }
                } else {
                    // Handle the case where the array doesn't have enough elements
                    System.out.println("Invalid data in line: " + String.join(", ", ligne));
                    // You may choose to skip this line or take other appropriate action
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult resultat = new StreamResult(cheminFichierXML);

            transformer.transform(source, resultat);

            System.out.println("Fichier XML généré avec succès.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
