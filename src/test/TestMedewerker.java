package test;

import logic.Medewerker;
import logic.Tank;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TestMedewerker {

    private Medewerker testMedewerker;
    private Tank testTank;

    @BeforeEach
    void setUp()
    {
        testMedewerker = new Medewerker();
        testTank = new Tank();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //TOEVOEGEN TANK
    @Test
    void medewerker_toevoegenTank_trueReturned()
    {
        Assert.assertTrue(testMedewerker.toevoegenTank(testTank));
    }

    @Test
    void medewerker_toevoegenTankDieAlBestaat_falseReturned()
    {
        testMedewerker.toevoegenTank(testTank); // na elke test de ingevoerde data in database verwijderen
        assertFalse(testMedewerker.toevoegenTank(testTank), "Tank bestaat al kan niet worden toegevoegd");
    }

    @Test
    void medewerker_toevoegenTankDieNietCompleetIs_falseReturned()
    {
        testMedewerker.toevoegenTank(testTank); // na elke test de ingevoerde data in database verwijderen
        assertFalse(testMedewerker.toevoegenTank(testTank), "Tank variabelen niet compleet, tank niet toegevoegd");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //UPDATEN TANK
    @Test
    void medewerker_updatenTankMetTankNummer_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetTankNaam_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetTankType_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetInhoudInLiters_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetBouwjaar_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetDiameter_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetLengte_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetGewicht_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetStatus_trueReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetOpeningstijd_trueReturned(){ testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetSluitingstijd_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetGpsBreedtegraad_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetGpsLengtegraad_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetDieselNiveau_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetAccuNiveau_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetVermogenZonnepaneel_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetSlotStatus_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetMeldingTanken_trueReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetTankNummer_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetTankNaam_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetTankType_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetInhoudInLiters_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetBouwjaar_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetDiameter_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetLengte_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetGewicht_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetStatus_falseReturned()
    {
        testMedewerker.updatenTank(testTank);
    }

    @Test
    void medewerker_updatenTankMetOpeningstijd_falseReturned(){ testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetSluitingstijd_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetGpsBreedtegraad_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetGpsLengtegraad_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetDieselNiveau_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetAccuNiveau_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetVermogenZonnepaneel_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetSlotStatus_falseReturned() { testMedewerker.updatenTank(testTank);}

    @Test
    void medewerker_updatenTankMetMeldingTanken_falseReturned() { testMedewerker.updatenTank(testTank);}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //AFMELDEN TANK

    @Test
    void medewerker_afmeldenTank_treuReturned()
    {
        testMedewerker.afmeldenTank(testTank);
    }

    @Test
    void medewerker_afmeldenTank_falseReturned()
    {
        testMedewerker.afmeldenTank(testTank);
    }

    @Test
    void medewerker_afmeldenTankDieNietBestaat_falseReturned()
    {
        testMedewerker.afmeldenTank(testTank);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ZOEKEN TANK

    @Test
    void medewerker_zoekenTank_tankReturned()
    {
        Tank zoekTank = testMedewerker.zoekTank("TestTank");
        Assert.assertEquals("Return Tank moet hetzelfde zijn als Tank die is gezocht", testTank, zoekTank );
    }

    @Test
    void medewerker_zoekenTankTankBestaatNiet_nullReturned()
    {
        Tank zoekTank = testMedewerker.zoekTank("");
        Assert.assertNull("Zoekopdracht moet niets opleveren", zoekTank);
    }
}