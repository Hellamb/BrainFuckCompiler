/**
 * The abstract class responsible for unary commands
 */
public abstract class UnaryCommand implements Command {
    private char id;

    public UnaryCommand(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }
}
