import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * The class responsible for parsing program string into commands list
 */
public class Parser {
    CommandDictionary dictionary;

    public Parser(CommandDictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Parses program text into command list
     *
     * @param program input program string
     * @return List of commands
     */
    public List<Command> parse(String program) {
        List<Command> commandList = new LinkedList<>();
        Deque<BinaryCommand> binaryCommandDeque = new ArrayDeque<>();
        Command command;

        for (char c : program.toCharArray()) {
            command = dictionary.get(c);

            if (command instanceof UnaryCommand) {
                processUnary(command, binaryCommandDeque, commandList);
            }

            if (command instanceof BinaryCommand) {
                processBinary(command, c, binaryCommandDeque, commandList);
            }
        }

        return commandList;
    }

    //Processes unary commands by placing them in the desired execution list
    private void processUnary(Command command, Deque<BinaryCommand> binaryCommandDeque, List<Command> commandList) {
        if (binaryCommandDeque.isEmpty()) {
            commandList.add(command);
        } else {
            binaryCommandDeque.getLast().addCommand(command);
        }
    }

    //Processes binary commands by placing them in the desired execution list or creating new execution list
    private void processBinary(Command command, char c, Deque<BinaryCommand> binaryCommandDeque, List<Command> commandList) {
        BinaryCommand binaryCommand = (BinaryCommand) command;
        if (binaryCommand.getId_start() == c) {
            binaryCommandDeque.add(binaryCommand);
        } else {
            binaryCommand = binaryCommandDeque.removeLast();
            if (binaryCommandDeque.isEmpty()) {
                commandList.add(binaryCommand);
            } else {
                binaryCommandDeque.getLast().addCommand(binaryCommand);
            }
        }
    }
}
