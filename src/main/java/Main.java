public class Main {
    public static void main(String[] args) {

        String inputProgram = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        CommandDictionary dictionary = new CommandDictionary();
        Runner runner = new Runner(dictionary);

        try
        {
            System.out.println(runner.run(inputProgram));
        }catch (IllegalSyntaxException err)
        {
            System.err.println(err.getMessage());
        }

    }
}
