package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import be.bxlformation.tu.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DemoAssertions {

    private final Calculation calculation = new Calculation();

    @Test
    public void standardAssertions() {
        assertEquals(2, calculation.addition(1,1));
        assertNotEquals(2, calculation.addition(1,2),"1+2 ne fait pas 2!");
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
    public void timeoutNotExceeded() {
        String result = assertTimeout(Duration.ofMillis(150),
                () -> "nawak");
        assertEquals("nawak", result); //vérifie que la chaine de char nawak ne dépasse pas 150ml lors de son instanciation
    }

    /*
    nb : on peut remplacer la lambda simplement par une méthode du type :
    public String creerUneString(String s) {
        return s;
        }
     */

    /*exo : un objet personne est bien fonctionnel avec un prénom et un nom*/


    /**
     *  Vérifie si la classe Person a bien deux atributs nommé firstName et lastName
     */

    @Test
    public void testClassePersonne() {
        Person person = new Person();
        Class<?> personClass = person.getClass();
        NoSuchFieldException noSuchFieldException = null;
        try {
//            Field firstName = personClass.getField("firstName"); -> demande que les attributs soient public
//            Field lastName = personClass.getField("lastName");
            Field firstName = personClass.getDeclaredField("firstName");
            Field lastName = personClass.getDeclaredField("lastName");
        } catch (NoSuchFieldException e) {
           noSuchFieldException = e;
        }
        assertNull(noSuchFieldException);
    }

    /**
     * vérifie que first name et last name ont reçu une valeur.
     */
    @Test
    public void testPersonInstance() {
        Person person = new Person();

        assertNull(person.getFirstName(), "First name is null");
        assertNull(person.getLastName(), "Last name is null");

        /*
        null car constructeur sans paramètres
         */

        Person person1 = new Person("Arnaud", "Daune");

        assertNotNull(person1.getFirstName());
        assertNotNull(person1.getLastName());

        /*
        not null pcq constructeur avec paramètres
         */
    }

    @Test
    public void testPersonInstanceCorrection() {
        Person person1 = new Person("Arnaud", "Daune");
        assertAll("Personne",
                () -> assertEquals("Arnaud", person1.getLastName()),
                () -> assertEquals("Daune", person1.getFirstName()),
                () -> assertNotEquals("Plop", person1.getFirstName())
                );
    }

    @Test
    public void depenantAssertions() {
        Person person1 = new Person("Arnaud", "Daune");
        assertAll(
                "properties",
                () -> {
                    assertNotNull(person1.getLastName());                                   // vérifie que la personne a un last name et si oui
                    assertAll(                                                              // on test l'ensemble de ces asserts
                            () -> assertTrue(person1.getFirstName().startsWith("D")),       //si le getLastName avait été null, alors le test aurait directement échoué
                            () -> assertTrue(person1.getLastName().startsWith("A"))
                    );
                },
                () -> {
                    assertNotNull(person1.getFirstName());
                    assertAll(
                            () -> assertTrue(person1.getLastName().endsWith("d")),
                            () -> assertTrue(person1.getFirstName().endsWith("e"))
                    );
                }
        );
    }

    @Test
    @Disabled
    public void testANePasPrendreEnCompte () {
        /*
        on utilise l'anotation @Disable pour ne plus utiliser le test, il sera alors ignoré
         */
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void OSTests() {
        /*
        test qui ne se fera que sur windows
         */
    }

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @interface TestOnWindows {}

    @TestOnWindows
    public void OSTest2(){
        /*
        test qui ne se fera que sur windows avec anotation perso
         */
    };

    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_12) //entre le 8 et le 12
    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void onlyOnJava8() {
        /*
        test uniquement si la version de java est la 8
         */
    }

    @Test
    @EnabledIf("conditionPersonnalisee")
    public void enableByCondition() {
        /*
        uniquement si conditionPerso est true
         */
    }

    @Test
    @DisabledIf("conditionPersonnalisee")
    public void disableByCondition() {
        /*
        pas pris en compte si conditionPerso est true
         */
    }

    public boolean conditionPersonnalisee() {
        return true;
    }




}
