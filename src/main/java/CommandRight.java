public class CommandRight extends Command {
    private char id;

    public CommandRight(char id) {
        super();
        this.id = id;
        super.addIdentifier(id);
    }

    /**
     * Move index in data righter by 1
     *
     * @param data    data to process
     * @param program program string
     * @param pointer current point in program
     * @return new point in program
     */
    @Override
    public int execute(Data data, String program, int pointer) {
        int index = data.getIndex();
        data.setIndex(index + 1);

        return pointer + 1;
    }
}