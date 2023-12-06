<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f4f4;
                    }

                    center {
                    margin-top: 20px;
                    }

                    h2 {
                    color: #333;
                    }

                    table {
                    width: 80%;
                    border-collapse: collapse;
                    margin-top: 20px;
                    }

                    th, td {
                    padding: 10px;
                    text-align: left;
                    }

                    th {
                    background-color: #333;
                    color: #fff;
                    }

                    tr:nth-child(even) {
                    background-color: #f9f9f9;
                    }

                    tr:hover {
                    background-color: #ddd;
                    cursor: pointer;
                    }
                </style>
                <script>
                    function redirectToProfile(numero, nom, prenom) {
                    // Encode the parameters to make sure special characters are handled properly
                    var encodedNom = encodeURIComponent(nom);
                    var encodedPrenom = encodeURIComponent(prenom);

                    window.location.href = "profile.html?selectedNumero=" + numero + "&amp;selectedNom=" + encodedNom + "&amp;selectedPrenom=" + encodedPrenom;
                    }
                </script>
            </head>
            <body>
                <center>
                    <h2>Liste des étudiants G Informatique 2 ENSAT</h2>
                    <table border="1">
                        <xsl:for-each select="personnes/personne">
                            <tr id="{numero}" onclick="redirectToProfile('{numero}', '{nom}', '{prenom}')">
                                <td>
                                    <xsl:if test="position() > 1">
                                        <xsl:value-of select="position() - 1"/>
                                    </xsl:if>
                                </td>
                                <td><xsl:value-of select="numero"/></td>
                                <td><xsl:value-of select="nom"/></td>
                                <td><xsl:value-of select="prenom"/></td>
                                <xsl:if test="position() > 1">
                                <td>
                                    Voir profil
                                </td>
                                </xsl:if>
                            </tr>
                        </xsl:for-each>
                    </table>
                </center>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
