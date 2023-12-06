package org.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class GenererFichierXML {

    public static void genererXML(List<String[]> donnees, String cheminFichierXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element racine = document.createElement("personnes");
            document.appendChild(racine);

            for (String[] ligne : donnees) {
                Element personne = document.createElement("personne");
                racine.appendChild(personne);

                Element numero = document.createElement("numero");
                numero.appendChild(document.createTextNode(ligne[0]));
                personne.appendChild(numero);

                Element nom = document.createElement("nom");
                nom.appendChild(document.createTextNode(ligne[1]));
                personne.appendChild(nom);

                Element prenom = document.createElement("prenom");
                prenom.appendChild(document.createTextNode(ligne[2]));
                personne.appendChild(prenom);
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
