package be.bxlformation.tu.triangle;

import be.bxlformation.tu.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExoTriangle {

    private final Triangle rect = new Triangle(3,4,5);
    private final Triangle equi = new Triangle(3,3,3);
    private final Triangle iso = new Triangle(3,3,4);
    private final Triangle scal = new Triangle(4,2,3);

    /**
     * Réussite :
     *
     * 1 - test scalène
     * 2 - test rectangle
     * 3 - test équilaterale
     * 4 - test isocèle
     *
     * Echec
     *
     * 5 - test longueur possible : Triangle Inequality Theorem.
     * 6 - test validité des inputs (entier, double, etc)
     * 7 -
     */

    /**
     *
     */

    @Test
    public void testOnLength() {

        //valid input
        Triangle triangle1 = new Triangle(3,4,5);
        //invalid input
        Triangle triangle2 = new Triangle(6,7,125);

        assertNotEquals(triangle1.getTriangleType(), "ceci n'est pas un triangle");
        assertEquals(triangle2.getTriangleType(), "ceci n'est pas un triangle");

    }

    @Test
    public void testRect() {
        assertEquals(rect.getTriangleType(), "rectangle");
        assertNotEquals(equi.getTriangleType(), "rectangle");
    }

    @Test
    public void testEqui() {
        assertEquals(equi.getTriangleType(), "equilateral");
        assertNotEquals(rect.getTriangleType(), "equilateral");
    }

    @Test
    public void testIso() {

        assertEquals(iso.getTriangleType(), "isocele");
        assertNotEquals(equi.getTriangleType(), "isocele");
        assertNotEquals(rect.getTriangleType(), "isocele");

    }

    @Test
    public void testScalene() {
        assertEquals(scal.getTriangleType(), "scalene");
    }
}
