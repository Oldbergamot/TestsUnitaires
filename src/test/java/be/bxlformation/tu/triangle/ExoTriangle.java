package be.bxlformation.tu.triangle;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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
     * 5 - test longueurs possibles : Triangle Inequality Theorem.
     * 6 - test validité des inputs (entier, double, etc)
     */

    @Test
    public void testOnLength() {

        //valid input
        Triangle triangle1 = new Triangle(3,4,5);
        //invalid input
        Triangle triangle2 = new Triangle(6,7,125);
        Triangle triangle3 = new Triangle(-1,2,3);
        Triangle triangle4 = new Triangle(0,2,8);

        assertNotEquals(triangle1.getTriangleType(), "ceci n'est pas un triangle");

//        NotATriangleException exception = assertThrows(
//                        NotATriangleException.class,
//                        triangle2::getTriangleType);
//        assertEquals(exception.getMessage(), "not a triangle");
//
//        NotATriangleException exception1 = assertThrows(
//                NotATriangleException.class,
//                triangle3::getTriangleType);
//        assertEquals(exception1.getMessage(), "not a triangle");
//
//        NotATriangleException exception2 = assertThrows(
//                NotATriangleException.class,
//                triangle4::getTriangleType);
//        assertEquals(exception2.getMessage(), "not a triangle");

//        assertEquals(triangle2.getTriangleType(), "ceci n'est pas un triangle");
//        assertEquals(triangle3.getTriangleType(), "ceci n'est pas un triangle");
//        assertEquals(triangle4.getTriangleType(),"ceci n'est pas un triangle");

        assertEquals(triangle2.getTriangleType(), "not a triangle");
        assertEquals(triangle3.getTriangleType(), "not a triangle");
        assertEquals(triangle4.getTriangleType(),"not a triangle");
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
        assertNotEquals(equi.getTriangleType(), "scalene");
    }

    @Test
    public void triangleDoitContenir3int() {
        Field [] fields = Triangle.class.getDeclaredFields();

        assertEquals(3, fields.length);

        assertAll("proprieteTypeInt",
                () -> assertEquals(int.class ,fields[0].getType()),
                () -> assertEquals(int.class ,fields[1].getType()),
                () -> assertEquals(int.class ,fields[2].getType())
        );
    }
}
