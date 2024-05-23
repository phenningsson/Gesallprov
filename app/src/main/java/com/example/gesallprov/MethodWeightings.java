package com.example.gesallprov;

public class MethodWeightings {
    public static int[][] livingLabsWeights = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, // DOEL
            {2, 2, 2, 2, 2, 2, 2}, // DOELGROEP
            {2, 2}, // FOCUS OP
            {2, 0, 0}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {1, 1, 1, 2, 1, 1}, // INVLOED
            {2, 0, 0, 0}, // DIEPGANG
            {1, 1, 2, 0}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {2, 2, 2, 2, 2, 2}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {0, 2}, // TIJDSDUUR
            {2, 0}, // LEREN
            {2, 0}, // INNOVATIE
            {2, 2}, // FORMALITEIT
            {2, 2} // INPUT
    };

    public static int[][] worldCafeWeights = {
            {2, 2, 0, 0, 2, 0, 2, 2, 2, 0}, // DOEL
            {1, 2, 1, 2, 1, 1, 1}, // DOELGROEP
            {0, 1}, // FOCUS OP
            {2, 2, 2}, // ERVARING
            {0, 2}, // ARBEIDSINTENSIVITEIT
            {1, 0, 1, 1, 0, 0}, // INVLOED
            {0, 2, 2, 2}, // DIEPGANG
            {1, 0, 1, 1}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 1, 2, 2, 1, 1}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {2, 0}, // LEREN
            {2, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {2, 2} // INPUT
    };

    public static int[][] enqueterenWeights = {
            {0, 0, 0, 0, 0, 0, 0, 2, 0, 2}, // DOEL
            {2, 2, 2, 2, 2, 2, 2, 2}, // DOELGROEP
            {2, 0}, // FOCUS OP
            {1, 1, 1}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 2, 0, 0, 0, 0}, // INVLOED
            {0, 2, 2, 2}, // DIEPGANG
            {1, 1, 2, 1}, // FASEMODEL
            {2, 2}, // Vertrouwelijk
            {2, 2}, // ANONIEM
            {0, 0, 0, 0, 2, 0}, // GROEPSGROOTTE
            {2, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {0, 2}, // LEREN
            {0, 2}, // INNOVATIE
            {2, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] burgerjuryWeights = {
            {0, 0, 2, 0, 0, 0, 0, 2, 2, 2}, // DOEL
            {2, 0, 2, 0, 0, 2, 2, 2}, // DOELGROEP
            {2, 0}, // FOCUS OP
            {0, 0, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 0, 0, 2, 0, 0}, // INVLOED
            {2, 0, 0, 0}, // DIEPGANG
            {1, 2, 2, 0}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 0, 2, 0, 0, 0}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {0, 2}, // TIJDSDUUR
            {2, 0}, // LEREN
            {0, 2}, // INNOVATIE
            {2, 0}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] klankbordgroepWeights = {
            {2, 0, 2, 0, 0, 0, 0, 0, 2, 2}, // DOEL
            {2, 0, 2, 0, 0, 2, 2, 2}, // DOELGROEP
            {0, 2}, // FOCUS OP
            {0, 0, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 0, 0, 1, 0, 0}, // INVLOED
            {2, 0, 0, 0}, // DIEPGANG
            {1, 2, 2, 2}, // FASEMODEL
            {1, 1}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 2, 0, 0, 0, 0}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {0, 2}, // TIJDSDUUR
            {2, 0}, // LEREN
            {2, 0}, // INNOVATIE
            {2, 0}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] inspraakbijeenkomstWeights = {
            {2, 0, 2, 0, 0, 0, 0, 2, 2, 0}, // DOEL
            {2, 0, 2, 0, 2, 2, 2, 2}, // DOELGROEP
            {0, 2}, // FOCUS OP
            {2, 2, 0}, // ERVARING
            {0, 2}, // ARBEIDSINTENSIVITEIT
            {1, 1, 1, 1, 0, 1}, // INVLOED
            {0, 2, 2, 0}, // DIEPGANG
            {2, 2, 1, 1}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 0, 0, 0, 2, 0}, // GROEPSGROOTTE
            {2, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {1, 1}, // LEREN
            {0, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] straatinterviewsWeights = {
            {2, 0, 2, 0, 0, 0, 0, 2, 2, 0}, // DOEL
            {2, 0, 2, 0, 0, 2, 2, 2}, // DOELGROEP
            {2, 0}, // FOCUS OP
            {2, 0, 0}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {1, 1, 1, 0, 0, 0}, // INVLOED
            {0, 2, 2, 2}, // DIEPGANG
            {2, 1, 2, 2}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 0, 1, 1, 1, 1}, // GROEPSGROOTTE
            {2, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {0, 2}, // LEREN
            {0, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] scenariobouwWeights = {
            {0, 0, 2, 0, 0, 0, 0, 2, 0, 2}, // DOEL
            {0, 0, 0, 2, 0, 0, 0, 0}, // DOELGROEP
            {0, 2}, // FOCUS OP
            {0, 0, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 0, 2, 1, 0, 0}, // INVLOED
            {2, 0, 0, 0}, // DIEPGANG
            {1, 1, 1, 0}, // FASEMODEL
            {2, 0}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 2, 2, 2, 0, 0}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {0, 2}, // TIJDSDUUR
            {2, 0}, // LEREN
            {2, 0}, // INNOVATIE
            {2, 0}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] interactieveInternetomgevingWeights = {
            {2, 2, 0, 0, 0, 0, 0, 2, 0, 0}, // DOEL
            {2, 2, 2, 2, 0, 2, 2, 2}, // DOELGROEP
            {0, 2}, // FOCUS OP
            {0, 0, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 1, 1, 2, 0, 0}, // INVLOED
            {2, 2, 0, 0}, // DIEPGANG
            {2, 2, 1, 1}, // FASEMODEL
            {2, 0}, // Vertrouwelijk
            {2, 0}, // ANONIEM
            {0, 0, 0, 0, 2, 0}, // GROEPSGROOTTE
            {2, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {2, 0}, // LEREN
            {2, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] keukentafelgesprekkenWeights = {
            {0, 0, 2, 0, 0, 0, 0, 2, 2, 0}, // DOEL
            {2, 0, 2, 2, 0, 0, 2, 2}, // DOELGROEP
            {2, 0}, // FOCUS OP
            {0, 2, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {1, 2, 1, 1, 0, 0}, // INVLOED
            {2, 0, 0, 0}, // DIEPGANG
            {1, 2, 0, 0}, // FASEMODEL
            {2, 0}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {2, 0, 0, 0, 0, 0}, // GROEPSGROOTTE
            {0, 2}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {0, 2}, // LEREN
            {0, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int[][] photovoiceWeights = {
            {0, 0, 2, 0, 0, 2, 2, 2, 0, 0}, // DOEL
            {2, 2, 2, 2, 2, 2, 2, 2}, // DOELGROEP
            {2, 0}, // FOCUS OP
            {2, 2, 2}, // ERVARING
            {2, 2}, // ARBEIDSINTENSIVITEIT
            {0, 0, 2, 2, 0, 0}, // INVLOED
            {2, 2, 2, 0}, // DIEPGANG
            {1, 1, 0, 0}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {0, 2}, // ANONIEM
            {0, 1, 0, 1, 0, 0}, // GROEPSGROOTTE
            {1, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {1, 1}, // LEREN
            {0, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {2, 0} // INPUT
    };

    public static int[][] swipocratieWeights = {
            {0, 0, 0, 0, 2, 0, 2, 2, 0, 0}, // DOEL
            {2, 2, 2, 2, 0, 2, 0, 0}, // DOELGROEP
            {0, 2}, // FOCUS OP
            {2, 2, 2}, // ERVARING
            {2, 0}, // ARBEIDSINTENSIVITEIT
            {0, 2, 2, 0, 0, 0}, // INVLOED
            {0, 0, 2, 2}, // DIEPGANG
            {2, 2, 2, 2}, // FASEMODEL
            {0, 2}, // Vertrouwelijk
            {2, 0}, // ANONIEM
            {0, 0, 0, 0, 2, 0}, // GROEPSGROOTTE
            {2, 0}, // LAAGDREMPELIG
            {2, 0}, // TIJDSDUUR
            {0, 2}, // LEREN
            {0, 2}, // INNOVATIE
            {0, 2}, // FORMALITEIT
            {0, 2} // INPUT
    };

    public static int maxPointsLivingLabs = 34;
    public static int maxPointsWorldCafe = 31;

    public static int maxPointsEnqueteren = 33;

    public static int maxPointsBurgerjury = 34;

    public static int maxPointsKlankbordgroep = 32;

    public static int maxPointsInspraakbijeenkomst = 32;

    public static int maxPointsStraatinterviews = 32;

    public static int maxPointsScenariobouw = 33;

    public static int maxPointsInteractieveInternetomgeving = 34;

    public static int maxPointsKeukentafelgesprekken = 34;

    public static int maxPointsPhotovoice = 32;

    public static int maxPointsSwipocratie = 34;



















}
