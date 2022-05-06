import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Structure that stores commands and their identifiers
 */
public class CommandDictionary {
    Map<Character, Command> commandsMap;

    public CommandDictionary() {
        this.commandsMap = new HashMap<>();
        fillCommandsMap();
    }

    private void fillCommandsMap() {
        List<Command> commands = new LinkedList<>();
        commands.add(new CommandInc('+'));
        commands.add(new CommandDec('-'));
        commands.add(new CommandLeft('<'));
        commands.add(new CommandRight('>'));
        commands.add(new CommandOut('.'));
        commands.add(new CommandWhile('[', ']'));

        for (Command command : commands) {
            for (char id : command.getIdentifiers()) {
                commandsMap.put(id, command);
            }
        }
    }

    /**
     * Return command by identifier
     *
     * @param id command identifier
     * @return Command from Map
     */
    public Command getCommand(char id) {
        return commandsMap.get(id);
    }
}
