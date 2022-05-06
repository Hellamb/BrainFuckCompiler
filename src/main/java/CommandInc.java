public class CommandInc extends Command {
    private char id;

    public CommandInc(char id) {
        super();
        this.id = id;
        super.addIdentifier(id);
    }

    /**
     * Increase current cell in data by 1
     *
     * @param data    data to process
     * @param program program string
     * @param pointer current point in program
     * @return new point in program
     */
    @Override
    public int execute(Data data, String program, int pointer) {
        int index = data.getIndex();
        data.getArr()[index] += (char) 1;

        return pointer + 1;
    }
}
