import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    /**
     * test unary commands: '>', '<', '+', '-', '.'
     */
    @Test
    void parse() {
        CommandDictionary dictionary = new CommandDictionary();
        Parser parser = new Parser(dictionary);

        String input = "><+-.";
        List<Command> commandList = parser.parse(input);
        assertSame(dictionary.get('>').getClass(), commandList.get(0).getClass());
        assertSame(dictionary.get('<').getClass(), commandList.get(1).getClass());
        assertSame(dictionary.get('+').getClass(), commandList.get(2).getClass());
        assertSame(dictionary.get('-').getClass(), commandList.get(3).getClass());
        assertSame(dictionary.get('.').getClass(), commandList.get(4).getClass());
    }

    //TODO
}