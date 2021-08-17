package be.bxlformation.tu;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoOrder {

    @Test
    @Order(2)
    public void nullValue(){

    }
    @Test
    @Order(1)
    public void emptyValue() {

    }

    @Test
    @Order(3)
    public void validValue(){

    }
}
