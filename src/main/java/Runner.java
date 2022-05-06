/**
 * The class responsible for execute commands on data
 */
public class Runner {
    CommandDictionary dictionary;

    public Runner(CommandDictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Executes the given program on the empty data
     *
     * @param program program string
     * @return result string
     */
    public String run(String program) throws IllegalSyntaxException {
        if(program == null) return "";

        Data data = new Data();
        int pointer = 0;

        while (pointer != program.length()) {
            Command command = dictionary.getCommand(program.charAt(pointer));
            if(command == null) throw new IllegalSyntaxException("Command '"+program.charAt(pointer)+"' not found");
            pointer = command.execute(data, program, pointer);
        }

        return data.getOutput();
    }
}
