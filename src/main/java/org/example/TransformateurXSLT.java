package org.example;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TransformateurXSLT {

    public static void transformerXML(String fichierXML, String fichierXSL, String fichierResultat) {
        try {
            // Charger le fichier XSL
            Source xslt = new StreamSource(new File(fichierXSL));

            // Charger le fichier XML
            Source xml = new StreamSource(new File(fichierXML));

            // Créer le résultat de la transformation
            Result result = new StreamResult(new File(fichierResultat));

            // Créer une fabrique de transformateur
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Créer un transformateur pour la transformation
            Transformer transformer = transformerFactory.newTransformer(xslt);

            // Appliquer la transformation et enregistrer le résultat dans un fichier
            transformer.transform(xml, result);

            System.out.println("Transformation XSLT terminée avec succès.");

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

