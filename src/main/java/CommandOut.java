public class CommandOut extends Command {
    private char id;

    public CommandOut(char id) {
        super();
        this.id = id;
        super.addIdentifier(id);
    }

    /**
     * Add current cell value to output
     *
     * @param data    data to process
     * @param program program string
     * @param pointer current point in program
     * @return new point in program
     */
    @Override
    public int execute(Data data, String program, int pointer) {
        int index = data.getIndex();
        char c = data.getArr()[index];
        data.addOutput(c);

        return pointer + 1;
    }
}