package org.demo.parcialCamachoTomas.servicios;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdnServiceTest {

    @Test
    public void testFilas() {
        String[] adn = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testColumnas() {
        String[] adn = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testDiagonalesPrincipal() {
        String[] adn = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testDiagonalesSecundariaIzq() {
        String[] adn = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testDiagonalesSecundariaDer() {
        String[] adn = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testDiagonalesTerciariaIzq() {
        String[] adn = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testDiagonalesTerciariaDer() {
        String[] adn = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testNoMutante() {
        String[] adn = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA"
        };
        assertFalse(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testMutant1() {
        String[] adn = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testNonMutant1() {
        String[] adn = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testMutant2() {
        String[] adn = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testMutant3() {
        String[] adn = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testNonMutant2() {
        String[] adn = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertFalse(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testMutant4() {
        String[] adn = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }

    @Test
    public void testMutant5() {
        String[] adn = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        assertTrue(AdnService.comprobarMutante(adn));
    }
}

