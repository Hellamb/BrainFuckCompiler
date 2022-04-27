import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrainFuckInterpreterFunctionalTest {

    @Test
    //Test "Hello World!"| Unary and binary operators
    void interpret1()
    {
        String inputProgram = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.>>>++++++++[<++++>-]" +
                "<.>>>++++++++++[<+++++++++>-]<---.<<<<.+++.------.--------.>>+.";

        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        Parser parser = new Parser(dictionary);
        Runner runner = new Runner();

        BrainFuckInterpreter bfi = new BrainFuckInterpreter(analyzer,parser,runner);
        try{
            assertEquals("Hello World!", bfi.interpret(inputProgram));
        } catch (Exception err)
        {
            System.err.println(err.getMessage());
        }
    }

    @Test
    //Test empty string
    void interpret2()
    {
        String inputProgram = "";

        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        Parser parser = new Parser(dictionary);
        Runner runner = new Runner();

        BrainFuckInterpreter bfi = new BrainFuckInterpreter(analyzer,parser,runner);
        try{
            assertEquals("", bfi.interpret(inputProgram));
        } catch (Exception err)
        {
            System.err.println(err.getMessage());
        }
    }

    @Test
    //Test commands, with wrong identifiers
    void interpret3()
    {
        String inputProgram = ">++++<.%[]";

        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        Parser parser = new Parser(dictionary);
        Runner runner = new Runner();

        BrainFuckInterpreter bfi = new BrainFuckInterpreter(analyzer,parser,runner);
        try{
            assertThrows(IllegalSyntaxException.class,() -> bfi.interpret(inputProgram));
        } catch (Exception err)
        {
            System.err.println(err.getMessage());
        }
    }
}