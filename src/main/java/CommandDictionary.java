import java.util.HashMap;
import java.util.Map;

//A structure that stores commands and their identifiers
public class CommandDictionary {
    Map<Character, UnaryCommand> unaryCommands;
    Map<Character, BinaryCommand> binaryCommands;

    public CommandDictionary() {
        unaryCommands = new HashMap<>();
        unaryCommands.put('>', new UnaryCommandRight('>'));
        unaryCommands.put('<', new UnaryCommandLeft('<'));
        unaryCommands.put('+', new UnaryCommandInc('+'));
        unaryCommands.put('-', new UnaryCommandDec('-'));
        unaryCommands.put('.', new UnaryCommandOut('.'));

        binaryCommands = new HashMap<>();
        binaryCommands.put('[', new BinaryCommandWhile('[', ']'));
        binaryCommands.put(']', new BinaryCommandWhile('[', ']'));
    }

    //Returns true if such a unary command exists
    public boolean existUnary(char c) {
        return unaryCommands.containsKey(c);
    }

    //Returns true if such binary command exists
    public boolean existBinary(char c) {
        return binaryCommands.containsKey(c);
    }

    /**
     * Returns an array with the opening and closing identifiers of the binary command
     * @param c command-identifier
     * @return array[0] - opening identifier, array[1] - closing identifier
     */
    public char[] getBinaryIdentifiers(char c) {
        char[] identifiers = new char[2];

        if (binaryCommands.containsKey(c)) {
            BinaryCommand binaryCommand = binaryCommands.get(c);
            identifiers[0] = binaryCommand.getId_start();
            identifiers[1] = binaryCommand.getId_end();
            return identifiers;
        }

        return null;
    }

    /**
     * Gives Command object, with given command-identifier if exist
     * @param c command-identifier
     * @return new Command object, with given command-identifier
     */
    public Command get(char c) {
        if (existUnary(c)) {
            return unaryCommands.get(c).create();
        }

        if (existBinary(c)) {
            return binaryCommands.get(c).create();
        }

        return null;
    }
}
