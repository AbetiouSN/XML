<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <script>
                    function redirectToProfile(numero, nom, prenom) {
                    window.location.href = "profile.html?selectedNumero=" + numero + "&selectedNom=" + nom + "&selectedPrenom=" + prenom;
                    }
                </script>
            </head>
            <body>
                <center>
                    <h2>Liste des personnes</h2>
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
                                <td>
                                    Voir profil
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </center>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
