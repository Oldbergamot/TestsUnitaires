package be.bxlformation.tu;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PremierTest {

    /**
     * Verification d'une addition de deux nombres entiers
     *------------------------------------------------------
     *
     *
     * - les deux nombres doivent être entier
     * - aucun des deux nombres ne doit être nul
     * - que le résultat de deux nombres correspondent au resultat souhaité
     * - vérifier que les deux nombres ne sont pas trop grands pour la taille du type
     *
     *
     *
     * Etapes d'implémentation
     * ----------------------
     *
     * Arrange - act - assert
     *
     * Arrange: initialiser tous les entrants nécessaires
     * Act : execution du test avec les entrants et sauvegarde des sortants
     * Assert : validation des sortants en fonction des entrants
     *
     *
     */

    @Test
    public void premierTest() {
        //test de réussite

        //Arrange
        int a = 3, b =4;
        Calculation premierTest = new Calculation();

        //Act
        int result = premierTest.addition(a,b);

        //Assert
        assertEquals(7,result);
        assertNotEquals(9, result);

    }

    @Test
    public void premierTestFailCarPasDesEntier() {
        //Arrange
        String inputUser_a = "toto", inputUser_b = "4";

        //Act
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputUser_a));

        int result ;
        NumberFormatException numberFormatException1 = null;
        try {
            result = Integer.parseInt(inputUser_b);
        }catch (NumberFormatException e) {
            numberFormatException1 = e;
        }

        //Assert
        assertNotNull(numberFormatException);
        assertNull(numberFormatException1);
    }

}
