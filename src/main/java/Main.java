import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String inputProgram = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.>>>++++++++[<++++>-]" +
                "<.>>>++++++++++[<+++++++++>-]<---.<<<<.+++.------.--------.>>+.>++++++++++.";

        CommandDictionary dictionary = new CommandDictionary();
        Analyzer analyzer = new Analyzer(dictionary);
        Parser parser = new Parser(dictionary);
        Runner runner = new Runner();

        BrainFuckInterpreter bfi = new BrainFuckInterpreter(analyzer,parser,runner);
        try{
            System.out.println(bfi.interpret(inputProgram));
        } catch (Exception err)
        {
            System.err.println(err.getMessage());
        }
    }
}
