import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RunnerTest {

    /**
     * Test "Hello World!" | all commands and nested loops
     */
    @Test
    void run1()
    {
        String inputProgram = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++";

        CommandDictionary dictionary = new CommandDictionary();
        Runner runner = new Runner(dictionary);

        try
        {
            assertEquals("Hello World!",runner.run(inputProgram));
        }catch (IllegalSyntaxException err)
        {
            System.err.println(err.getMessage());
        }
    }

    /**
     * Test null
     */
    @Test
    void run2()
    {
        String inputProgram = null;

        CommandDictionary dictionary = new CommandDictionary();
        Runner runner = new Runner(dictionary);

        try
        {
            assertEquals("",runner.run(inputProgram));
        }catch (IllegalSyntaxException err)
        {
            System.err.println(err.getMessage());
        }
    }

    /**
     * Test not correct input
     */
    @Test
    void run3()
    {
        String inputProgram = "null";

        CommandDictionary dictionary = new CommandDictionary();
        Runner runner = new Runner(dictionary);

        assertThrows(IllegalSyntaxException.class, () -> runner.run(inputProgram));

    }
}