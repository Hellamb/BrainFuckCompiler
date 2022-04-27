import java.util.HashMap;
import java.util.Map;

/**
 * The class responsible for analyzing input program
 */
public class Analyzer {
    CommandDictionary dictionary;

    public Analyzer(CommandDictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Check the correctness of the input program string
     *
     * @param program input program string
     * @return true if all OK, false if something wrong
     */
    public boolean check(String program) {
        if(program == null) return false;
        //Stores the number of non-closed binary commands
        Map<Character, Integer> binaryIdentifiersCounter = new HashMap<>();

        for (char c : program.toCharArray()) {
            boolean isUnary = dictionary.existUnary(c);
            boolean isBinary = dictionary.existBinary(c);

            if (!isUnary && !isBinary) {
                return false;
            }

            if (isBinary) {
                if (!checkBinary(c, binaryIdentifiersCounter)) {
                    return false;
                }
            }
        }
        //Checks the number of closed and open binary commands
        boolean[] isError = new boolean[1];
        binaryIdentifiersCounter.forEach((id, count) -> {
            if (count != 0) {
                isError[0] = true;
            }
        });
        return !isError[0];
    }


    //Checks if opener and closer parts of binary operators match
    private boolean checkBinary(char c, Map<Character, Integer> counter) {
        char[] identifiers = dictionary.getBinaryIdentifiers(c);
        char opener = identifiers[0];

        //If there is no identifier in the counter, then it adds
        boolean exist = counter.containsKey(opener);
        if (!exist) {
            counter.put(opener, 0);
        }

        //If the identifier is opening, then increase the counter, otherwise decrease
        if (c == opener) {
            counter.put(opener, counter.get(opener) + 1);
        } else {
            counter.put(opener, counter.get(opener) - 1);
        }

        //If the number of closed binary commands is greater than open ones
        if (counter.get(opener) < 0) {
            return false;
        }

        return true;
    }
}
