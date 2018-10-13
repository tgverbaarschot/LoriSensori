import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FunctioneelBeheerderTest {


    FunctioneelBeheerder testFunctioneelBeheerder;
    Bedrijf testBedrijf;
    Medewerker testMedewerker;
    RechtEnums testRechtEnum;

    @BeforeEach
    void setUp()
    {
        testFunctioneelBeheerder = new FunctioneelBeheerder();
        testBedrijf = new Bedrijf();
        testMedewerker = new Medewerker();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //UPDATEN BEDRIJF

    @Test
    void medewerker_updatenBedrijfMetStringWaarde_trueReturned()
    {
        testFunctioneelBeheerder.updatenBedrijf(testBedrijf);
    }

    @Test
    void medewerker_updatenBedrijfMetEnumWaarde_trueReturned()
    {
        testFunctioneelBeheerder.updatenBedrijf(testBedrijf);
    }

    @Test
    void medewerker_updatenBedrijfMetStringWaarde_falseReturned()
    {
        testFunctioneelBeheerder.updatenBedrijf(testBedrijf);
    }

    @Test
    void medewerker_updatenBedrijfMetEnumWaarde_falseReturned()
    {
        testFunctioneelBeheerder.updatenBedrijf(testBedrijf);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //TOEVOEGEN MEDEWERKER

    @Test
    void functioneelBeheerder_toevoegenMedewerker_trueReturned()
    {
    Assert.assertTrue(testFunctioneelBeheerder.toevoegenMedewerker(testMedewerker));
    }

    @Test
    void functioneelBeheerder_toevoegenMedewerkerDieAlBestaat_falseReturned()
    {
        testFunctioneelBeheerder.toevoegenMedewerker(testMedewerker); // na elke test de ingevoerde data in database verwijderen
        assertFalse(testFunctioneelBeheerder.toevoegenMedewerker(testMedewerker), "Medewerker bestaat al kan niet worden toegevoegd");
    }

    @Test
    void functioneelBeheerder_toevoegenMedewerkerDieNietCompleetIs_falseReturned()
    {
        testFunctioneelBeheerder.toevoegenMedewerker(testMedewerker); // na elke test de ingevoerde data in database verwijderen
        assertFalse(testFunctioneelBeheerder.toevoegenMedewerker(testMedewerker), "Medewerker variabelen niet compleet, medewerker niet toegevoegd");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //TOEKENNEN RECHTEN

    @Test
    void functioneelBheerder_toekennenRechten_trueReturned()
    {
        testFunctioneelBeheerder.toekennenRechten(testRechtEnum);
    }

    @Test
    void functioneelBheerder_toekennenRechtenZijnAlToegewezen_falseReturned()
    {
        testFunctioneelBeheerder.toekennenRechten(testRechtEnum);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //UPDATEN MEDEWERKER

    @Test
    void functioneelBeheerder_updatenMedewerkerMetVoornaam_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetAchternaam_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetGeboorteDatum_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetGebruikersNaam_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetWachtwoord_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetEmail_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetTelefoonNummer_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetRechten_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetStatus_trueReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetVoornaam_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetAchternaam_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetGeboorteDatum_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetGebruikersNaam_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetWachtwoord_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetEmail_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetTelefoonNummer_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetRechten_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

    @Test
    void functioneelBeheerder_updatenMedewerkerMetStatus_falseReturned(){testFunctioneelBeheerder.updatenMedewerker(testMedewerker);}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //AFMELDEN MEDEWERKER

    @Test
    void functioneelBeheerder_afmeldenMedewerker_trueReturned()
    {
        testFunctioneelBeheerder.afmeldenMedewerker(testMedewerker);
    }

    @Test
    void functioneelBeheerder_afmeldenMedewerker_falseReturned()
    {
        testFunctioneelBeheerder.afmeldenMedewerker(testMedewerker);
    }

    @Test
    void functioneelBeheerder_afmeldenMedewerkerDieNietBestaat_falseReturned()
    {
        testFunctioneelBeheerder.afmeldenMedewerker(testMedewerker);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ZOEKEN MEDEWERKER

    @Test
    void functioneelBeheerder_zoekenMedewerker_medewerkerReturned()
    {
        Medewerker zoekMedewerker = testFunctioneelBeheerder.zoekMedewerker("TestNaam");
        Assert.assertEquals("Return Medewerker moet hetzelfde zijn als Medewerker die is gezocht", testMedewerker, zoekMedewerker );
    }

    @Test
    void functioneelBeheerder_zoekenMedewerkerMedewerkerBestaatNiet_nullReturned()
    {
        Medewerker zoekMedewerker = testFunctioneelBeheerder.zoekMedewerker("");
        Assert.assertNull("Zoekopdracht moet niets opleveren", zoekMedewerker);
    }
}