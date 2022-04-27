import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    @Test
    //Test all unary commands
    void check1()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "+-><.";

        assertTrue(analyzer.check(input));
    }

    @Test
    //Test binary commands, with correct opens and closes
    void check2()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "[][[][]]";

        assertTrue(analyzer.check(input));
    }

    @Test
   //Test binary commands, with wrong opens and closes
    void check3()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "][";

        assertFalse(analyzer.check(input));
    }

    @Test
    //Test commands, with wrong identifiers
    void check4()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = ">&:^s*&#%.";

        assertFalse(analyzer.check(input));
    }

    @Test
    //Test "Hello world!"
    void check5()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.>>>++++++++[<++++>-]" +
                "<.>>>++++++++++[<+++++++++>-]<---.<<<<.+++.------.--------.>>+.";

        assertTrue(analyzer.check(input));
    }

    @Test
    //Test empty string
    void check6()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = "";

        assertTrue(analyzer.check(input));
    }

    @Test
    //Test null
    void check7()
    {
        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        String input = null;
        assertFalse(analyzer.check(input));
    }
}