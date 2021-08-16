package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoAssertions {

    private final Calculation calculation = new Calculation();

    @Test
    public void standardAssertions() {
        assertEquals(2, calculation.addition(1,1));
        assertEquals(2, calculation.addition(1,2),"1+2 ne fait pas 2!");
        assertTrue(1<2, "1 est bien plus petit que 2");
    }

    @Test
    public void exceptionTesting() {
        Calculation calculation1 = null;
        NullPointerException nullPointerException = assertThrows(
                NullPointerException.class,
                ()-> calculation1.addition(1,1));
    }

    /*
    logique pour vérifier que la division par 0 dans une div entière

     */

    @Test
    public void divisionParZero() {

        int a = 5, b = 0;
        Calculation calculation1 = new Calculation();

        ArithmeticException arithmeticException = assertThrows
                (ArithmeticException.class,
                () -> calculation1.divisionEntiere(a,b));  //vérifie que ça lance bien l'arithmétique exception

        assertEquals(arithmeticException.getMessage(), "/ by zero"); //vérifie qu'il s'agit bien d'une div par zéro

        // ou

        ArithmeticException arithmeticException1 = null;
        try {
            //int result = a/b;
            calculation1.divisionEntiere(a,b);
        } catch (ArithmeticException e) {
            arithmeticException1 = e;
        }
        assertNotNull(arithmeticException1); //vérifie que ça lance bien l'arithmétique exception
        assertEquals(arithmeticException1.getMessage(), "/ by zero"); //vérifie qu'il s'agit bien d'une div par zéro
    }

    @Test
    public void divisionParZeroCorrection() {
        Calculation calculation1 = new Calculation();
    }

}
