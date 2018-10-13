import logic.Bedrijf;
import logic.TechnischBeheerder;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TechnischBeheerderTest {

    TechnischBeheerder testTechnischBeheerder;
    Bedrijf testBedrijf;

    @BeforeEach
    void setUp()
    {
        testTechnischBeheerder  = new TechnischBeheerder();
        testBedrijf = new Bedrijf();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //AANMAKEN BEDRIJF
    @Test
    void technischBeheerder_aanmakenBedrijf_trueReturned()
    {
        testTechnischBeheerder.aanmakenBedrijf(testBedrijf);
    }

    @Test
    void technischBeheerder_aanmakenBedrijfDatAlBestaat_falseReturned()
    {
        testTechnischBeheerder.aanmakenBedrijf(testBedrijf);
    }

    @Test
    void technischBeheerder_aanmakenBedrijfDatNietCompleetIs_falseReturned()
    {
        testTechnischBeheerder.aanmakenBedrijf(testBedrijf);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //AFMELDEN BEDRIJF

    @Test
    void technischBeheerder_afmeldenBedrijf_trueReturned()
    {
        testTechnischBeheerder.afmeldenBedrijf(testBedrijf);
    }

    @Test
    void technischBeheerder_afmeldenBedrijf_falseReturned()
    {
        testTechnischBeheerder.afmeldenBedrijf(testBedrijf);
    }

    @Test
    void technischBeheerder_afmeldenBedrijfDatNietBestaat_trueReturned()
    {
        testTechnischBeheerder.afmeldenBedrijf(testBedrijf);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ZOEKEN BEDRIJF

    @Test
    void technischBeheerder_zoekenBedrijf_trueReturned()
    {
        Bedrijf zoekBedrijf = testTechnischBeheerder.zoekBedrijf("TestBedrijf");
        Assert.assertEquals("Return Bedrijf moet hetzelfde zijn als Bedrijf dat is gezocht", testBedrijf, zoekBedrijf );
    }

    @Test
    void technischBeheerder_zoekenBedrijfBedrijfBestaatNiet_nullReturned()
    {
        Bedrijf zoekBedrijf = testTechnischBeheerder.zoekBedrijf("");
        Assert.assertNull("Zoekopdracht moet niets opleveren", zoekBedrijf);
    }
}