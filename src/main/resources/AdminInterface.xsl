<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="page/navbar/title"/></title>
                <style>
                    body {
                    font-family: 'Arial', sans-serif;
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 0;
                    }

                    .container {
                    margin: 0 auto;
                    max-width: 1200px; /* ou une autre largeur selon vos besoins */
                    }

                    .container-fluid {
                    margin: 0;
                    padding: 0;
                    }

                    header {
                    background-color: #007BFF;
                    color: #fff;
                    padding: 20px;
                    text-align: center;
                    }

                    img.logo {
                    max-width: 100px;
                    height: auto;
                    margin-right: 5px;
                    border-radius: 15%;
                    }

                    h1 {
                    margin: 0;
                    display: inline-block;
                    margin-left: 700px;
                    color: #fff;
                    }

                    nav {
                    margin-top: 20px;
                    text-align: center;
                    }

                    ul {
                    list-style-type: none;
                    padding: 0;
                    }

                    li {
                    display: inline-block;
                    margin-right: 20px;
                    }

                    a {
                    text-decoration: none;
                    color: #333;
                    font-weight: bold;
                    }

                    p {
                    margin-top: 20px;
                    }

                    footer {
                    background-color: #343a40;
                    color: #fff;
                    padding-right: 30px;
                    text-align: center;
                    position: absolute;
                    bottom: 0;
                    width: 100%;
                    height: auto;
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    }

                    img.footer-img {
                    width: 300px; /* Taille de l'image */
                    height: auto;
                    }

                    .footer-text {
                    /*flex-grow: 1; *//* Permet au texte de remplir l'espace disponible à droite */
                    text-align: right;
                    margin-right: 20px;
                    }
                    .button-container {
                    display: flex;
                    justify-content: space-around; /* Ajustez selon vos besoins */
                    }

                    .card {
                    border: 1px solid #ccc;
                    padding: 10px;
                    margin: 10px;
                    border-radius: 5px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    cursor:pointer;
                    }

                    .card:hover {
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <header>
                        <img class="logo" src="ensat.png" alt="Logo"/>
                        <h1><xsl:value-of select="page/navbar/title"/></h1>
                    </header>
                    <div class="card">
                        <p>Cette page est réservée à l'administrateur de l'université.</p>
                    </div>
                    <nav class="button-container">

                        <div class="card">
                            <h2><xsl:value-of select="page/navbar/buttons/button[1]"/></h2>
                            <p>Description du premier bouton...</p>
                        </div>

                        <div class="card">
                            <h2><xsl:value-of select="page/navbar/buttons/button[2]"/></h2>
                            <p>Description du deuxième bouton...</p>
                        </div>

                        <div class="card">
                            <h2><xsl:value-of select="page/navbar/buttons/button[3]"/></h2>
                            <p>Description du troisième bouton...</p>
                        </div>
                    </nav>
                    <footer class="container">
                        <img class="footer-img" src="images (2).png" alt="Description de l'image du footer"/>
                        <div class="footer-text">
                            <p><xsl:value-of select="page/footer/university-name"/></p>
                            <p>Contactez-nous : <a href="mailto:{page/footer/contact-email}"><xsl:value-of select="page/footer/contact-email"/></a></p>
                            <p>Téléphone : <xsl:value-of select="page/footer/phone"/></p>
                            <address><xsl:value-of select="page/footer/address"/></address>
                            <p>Développeurs : <xsl:value-of select="page/footer/developers"/></p>
                        </div>
                    </footer>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
