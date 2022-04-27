import java.util.List;

/**
 *
 */
public class Runner {

    /**
     * Executes the given list of commands on the data
     * @param commandList List of commands to be executed on the data
     * @param data object that stores data
     * @return result string
     */
    public String run(List<Command> commandList, Data data) {
        commandList.forEach(command -> command.execute(data));
        return data.getOutput();
    }

    /**
     * Executes the given list of commands on the empty data
     * @param commandList List of commands to be executed on the empty data
     * @return result string
     */
    public String run(List<Command> commandList) {
        Data data = new Data();
        return run(commandList, data);
    }
}
