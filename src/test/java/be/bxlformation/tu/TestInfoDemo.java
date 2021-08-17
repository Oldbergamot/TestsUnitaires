package be.bxlformation.tu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfoDemo {

    @Test
    @DisplayName("TEST 1")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
    }

    @Test
    void test2() {

    }

}
