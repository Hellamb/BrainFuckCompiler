public class BrainFuckInterpreter
{
    private Analyzer analyzer;
    private Parser parser;
    private Runner runner;

    public BrainFuckInterpreter(Analyzer analyzer, Parser parser, Runner runner)
    {
        this.analyzer = analyzer;
        this.parser = parser;
        this.runner = runner;
    }

    /**
     * Interprets the input program string
     * @param program input program string
     * @return output result string
     * @throws IllegalSyntaxException if input program is wrong
     */
    public String interpret(String program) throws IllegalSyntaxException
    {
        if(analyzer.check(program))
        {
            return runner.run(parser.parse(program));
        }else
        {
            throw new IllegalSyntaxException();
        }
    }
}
