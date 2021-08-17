package be.bxlformation.tu.triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTestParametre {

    enum JourSemaine {
        LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE
    }

    @ParameterizedTest
    @ValueSource(strings = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"})
    void estPresentDansEnum(String jour) {
        assertNotNull(JourSemaine.valueOf(jour.toUpperCase(Locale.ROOT)));
    }

    @ParameterizedTest
    @EnumSource(JourSemaine.class)
    void estPresentDansEnum(JourSemaine jourSemaine) {
        assertNotNull(jourSemaine);
    }

    @ParameterizedTest
    @EnumSource(names = {"LUNDI" , "JEUDI"})
    public void estIncluDansEnum(JourSemaine jourSemaine) {
        assertTrue(EnumSet.of(JourSemaine.LUNDI, JourSemaine.JEUDI).contains(jourSemaine));
    }

}
