import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    /**
     * Test unary commands
     */
    @Test
    void run1() {
        Runner runner = new Runner();
        CommandDictionary dictionary = new CommandDictionary();
        List<Command> commandList = new LinkedList<>();

        for (int i = 0; i < 60; i++) {
            commandList.add(dictionary.get('+'));
        }
        commandList.add(dictionary.get('-'));
        commandList.add(dictionary.get('>'));
        commandList.add(dictionary.get('<'));
        commandList.add(dictionary.get('.'));

        assertEquals(";", runner.run(commandList));
    }

    /**
     * Test unary and binary commands with correct result
     */
    @Test
    void run2() {
        Runner runner = new Runner();
        CommandDictionary dictionary = new CommandDictionary();
        List<Command> commandList = new LinkedList<>();
        commandList.add(dictionary.get('>'));
        for (int i = 0; i < 9; i++) {
            commandList.add(dictionary.get('+'));
        }
        BinaryCommand binaryCommand = (BinaryCommand) dictionary.get('[');
        binaryCommand.addCommand(dictionary.get('<'));
        for (int i = 0; i < 8; i++) {
            binaryCommand.addCommand(dictionary.get('+'));
        }
        binaryCommand.addCommand(dictionary.get('>'));
        binaryCommand.addCommand(dictionary.get('-'));
        commandList.add(binaryCommand);
        commandList.add(dictionary.get('<'));
        commandList.add(dictionary.get('.'));

        assertEquals("H", runner.run(commandList));
    }

    /**
     * Test null in Commands list
     */
    @Test
    void run3() {
        Runner runner = new Runner();
        CommandDictionary dictionary = new CommandDictionary();
        List<Command> commandList = new LinkedList<>();
        commandList.add(null);

        assertThrows(NullPointerException.class, () -> runner.run(commandList));
    }

    /**
     * Test null in Data
     */
    @Test
    void run4() {
        Runner runner = new Runner();
        CommandDictionary dictionary = new CommandDictionary();
        List<Command> commandList = new LinkedList<>();
        commandList.add(dictionary.get('<'));

        assertThrows(NullPointerException.class, () -> runner.run(commandList, null));
    }
}