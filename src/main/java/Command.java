import java.util.HashSet;
import java.util.Set;

/**
 * The abstract class responsible for commands
 */
public abstract class Command {
    private Set<Character> identifiers;

    public Command() {
        this.identifiers = new HashSet<>();
    }

    /**
     * Process some data
     *
     * @param data    data to process
     * @param program program string
     * @param pointer current point in program
     * @return new point in program
     */
    public abstract int execute(Data data, String program, int pointer) throws IllegalSyntaxException;

    public Set<Character> getIdentifiers() {
        return new HashSet<>(identifiers);
    }

    protected void addIdentifier(char identifier) {
        identifiers.add(identifier);
    }
}
