package org.example;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLtoHTML {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("C:\\Users\\PE\\Documents\\XML1\\src\\main\\resources\\AdminInterface.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source xml = new StreamSource(new File("C:\\Users\\PE\\Documents\\XML1\\src\\main\\resources\\AdminInterface.xml"));
        transformer.transform(xml, new StreamResult(new File("C:\\Users\\PE\\Documents\\XML1\\src\\main\\resources\\resultat1.html")));
    }
}

