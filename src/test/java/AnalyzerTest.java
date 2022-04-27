import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    /**
     * Test all unary commands
     */
    @Test
    void check1() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "+-><.";

        assertTrue(analyzer.check(input));
    }

    /**
     * Test binary commands, with correct opens and closes
     */
    @Test
    void check2() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "[][[][]]";

        assertTrue(analyzer.check(input));
    }

    /**
     * Test binary commands, with wrong opens and closes
     */
    @Test
    void check3() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "][";

        assertFalse(analyzer.check(input));
    }

    /**
     * Test binary commands, with wrong opens and closes
     */
    @Test
    void check4() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = ">&:^s*&#%.";

        assertFalse(analyzer.check(input));
    }

    /**
     * Test "Hello world!"
     */
    @Test
    void check5() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.>>>++++++++[<++++>-]" +
                "<.>>>++++++++++[<+++++++++>-]<---.<<<<.+++.------.--------.>>+.";

        assertTrue(analyzer.check(input));
    }

    /**
     * Test empty string
     */
    @Test
    void check6() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "";

        assertTrue(analyzer.check(input));
    }

    /**
     * Test null
     */
    @Test
    void check7() {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = null;
        assertFalse(analyzer.check(input));
    }
}