import java.util.LinkedList;
import java.util.List;

/**
 * The abstract class responsible for binary commands
 */
public abstract class BinaryCommand implements Command
{
    private char id_start;
    private char id_end;
    protected List<Command> innerCommandList;

    public BinaryCommand(char id_start, char id_end)
    {
        this.id_start = id_start;
        this.id_end = id_end;
        innerCommandList = new LinkedList<>();
    }

    public char getId_start()
    {
        return id_start;
    }

    public char getId_end()
    {
        return id_end;
    }

    public void addCommand(Command command)
    {
        innerCommandList.add(command);
    }
}
