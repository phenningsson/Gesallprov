package com.example.gesallprov;

public class AnswerQuestion {

    // Array met de vragen voor het quiz
    public static String[] question = {
            "Wat is het belangrijkste doel van de participatiewerkvorm die je wil inzetten?",
            "Voor welke doelgroep wil je participatie inzetten?",
            "Is de focus van de participatie vooral gericht op het individu of de groep?",
            "Hoe zou je jouw ervaring met het organiseren van participatieprocessen omschrijven?",
            "Hoeveel tijd heb je beschikbaar voor de organisatie van de participatiewerkvorm?",
            "Welke mate van invloed wil je dat de deelnemers hebben in het participatieproces?",
            "Welke mate van diepgang wil je bereiken gedurende het participatieproces?",
            "In welke fase van het onderzoek of project wil je participatie toepassen?",
            "Zal er tijdens het participatieproces vertrouwelijke informatie worden gedeeld of opgehaald?",
            "Is het belangrijk dat de deelnemers anoniem kunnen blijven?",
            "Wat is de gewenste groepsgrootte?",
            "Is het belangrijk dat de participatiewerkvorm laagdrempelig is voor de deelnemers?",
            "Wat is de gewenste tijdsduur van de participatiewerkvorm?",
            "Is het belangrijk dat de deelnemers tijdens de participatie nieuwe dingen kunnen leren of ondervinden?",
            "Is het belangrijk dat de participatiewerkvorm gericht is op het stimuleren van innovatie en vernieuwing?",
            "Wil je de participatiewerkvorm formeel of informeel vormgeven?",
            "Wil je de input van de deelnemers tijdens de participatiewerkvorm open of doelgericht laten verlopen?"
    };

    // Array met de mogelijke keuzes voor elke vraag
    public static String[][] choices = {
            {"Informeren", "Instrueren", "Adviseren", "Overtuigen", "Activeren", "Emotioneren", "Inspireren", "Informatie verzamelen", "Draagvlak creëren", "Besluitvorming"},
            {"Burgers", "Studenten", "Professionals", "Kinderen", "Jongeren", "30+", "65+"},
            {"Individu", "Groep"},
            {"Weinig", "Neutraal", "Veel"},
            {"Er is veel tijd beschikbaar", "Er is minder tijd beschikbaar"},
            {"Informeren", "Inspreken", "Consulteren", "Coproduceren / samenwerken", "Delegeren", "Zelfbestuur"},
            {"Veel diepgang", "Neutraal", "Weinig diepgang", "Geen diepgang"},
            {"Voorbereidende fase", "Analyserende fase", "Uitvoerende fase", "Monitorende fase"},
            {"Ja, er zal vertrouwelijke informatie worden gedeeld/opgehaald", "Nee, alleen openbare informatie zal worden gebruikt"},
            {"Ja, anonimiteit van de deelnemers is van belang", "Nee, anonimiteit is niet noodzakelijk"},
            {"Kleinschalig", "Klein groepsverband", "Middelgroot groepsverband", "Groot groepsverband", "Massaal", "Open"},
            {"Ja, laagdrempeligheid is belangrijk", "Nee, laagdrempeligheid is niet noodzakelijk"},
            {"Eenmalige sessie", "Meerdere sessies"},
            {"Ja, het is belangrijk dat deelnemers kunnen leren en nieuwe dingen ondervinden", "Nee, leren is niet van toepassing"},
            {"Ja, het is belangrijk dat de participatiewerkvorm innovatie en vernieuwing stimuleert", "Nee, innovatie en vernieuwing zijn niet van toepassing"},
            {"Formele setting", "Informele setting"},
            {"Open input", "Doelgerichte input"}
    };

    // aantal vraagalternatieven per vraag
    public static int[][] answerMappings = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, // Question 1
            {0, 1, 2, 3, 4, 5, 6}, // Question 2
            {0, 1}, // Question 3
            {0, 1, 2}, // Question 4
            {0, 1}, // Question 5
            {0, 1, 2, 3, 4, 5}, // Question 6
            {0, 1, 2, 3}, // Question 7
            {0, 1, 2, 3}, // Question 8
            {0, 1}, // Question 9
            {0, 1}, // Question 10
            {0, 1, 2, 3, 4, 5}, // Question 11
            {0, 1}, // Question 12
            {0, 1}, // Question 13
            {0, 1}, // Question 14
            {0, 1}, // Question 15
            {0, 1}, // Question 16
            {0, 1} // Question 17
    };
}
