package be.bxlformation.tu.triangle;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class DemoRepetition {

    private Logger logger = Logger.getLogger(DemoRepetition.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
            logger.info(String.format("Répétition %d / %d pour %s",
            repetitionInfo.getCurrentRepetition(),
            repetitionInfo.getTotalRepetitions(),
            testInfo.getTestMethod().get().getName())
            );
    }

    @RepeatedTest(7)
    public void repeatedTest() {

    }

    @RepeatedTest(3)
    public void repeatedTestWithRepetitionInfp(RepetitionInfo repetitionInfo) {
        assertEquals(3,repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest( value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Action(s) répétées")
    void customDisplay(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        assertEquals("Action(s) répétées " +repetitionInfo.getCurrentRepetition()+ "/3", testInfo.getDisplayName() );
    }
}
