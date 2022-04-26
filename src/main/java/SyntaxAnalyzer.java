import java.util.*;

public class SyntaxAnalyzer implements Analyzer {
    Map<Character,Command> commands;

    public SyntaxAnalyzer(Map<Character,Command> commandIdentifiers) {
        this.commands = commandIdentifiers;
    }

    public List<Command> parse(String str)
    {
        List<Command> commandsList = new LinkedList<>();
        for(char command : str.toCharArray())
        {
            if(commands.containsKey(command))
            {
                commandsList.add(commands.get(command));
            }
            else throw new IllegalArgumentException("Illegal command");
        }
        return commandsList;
    }
}
