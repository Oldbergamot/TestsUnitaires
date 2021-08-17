package be.bxlformation.tu.triangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        assertNotNull(jourSemaine);    }

}
