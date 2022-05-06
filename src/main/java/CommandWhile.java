public class CommandWhile extends Command {
    private char open;
    private char close;

    public CommandWhile(char open, char close) {
        super();
        this.open = open;
        this.close = close;
        super.addIdentifier(open);
        super.addIdentifier(close);
    }

    /**
     * While loop
     *
     * @param data    data to process
     * @param program program string
     * @param pointer current point in program
     * @return new point in program
     */
    @Override
    public int execute(Data data, String program, int pointer) throws IllegalSyntaxException
    {

        char symbolInData = data.getArr()[data.getIndex()];

        if (program.charAt(pointer) == open && symbolInData == 0) {
            return findCloser(program, pointer);
        }

        if ((program.charAt(pointer) == close) && (symbolInData != 0)) {
            return findOpener(program, pointer);
        }

        return pointer + 1;
    }

    private int findCloser(String program, int pointer) throws IllegalSyntaxException
    {
        int pairCounter = 0;
        pointer++;
        boolean isClose = program.charAt(pointer) == close;
        boolean isNested = false;

        while (!isClose || isNested) {
            if (program.charAt(pointer) == open) {
                pairCounter++;
            }
            if (program.charAt(pointer) == close) {
                pairCounter--;
            }

            pointer++;

            if(pointer >= program.length()) throw new IllegalSyntaxException("Syntax Exception : loop closer not found");

            isClose = program.charAt(pointer) == close;
            isNested = pairCounter != 0;
        }
        return pointer;
    }

    private int findOpener(String program, int pointer) throws IllegalSyntaxException {
        int pairCounter = 0;
        pointer--;
        boolean isOpen = program.charAt(pointer) == open;
        boolean isNested = false;

        while (!isOpen || isNested) {
            if (program.charAt(pointer) == open) {
                pairCounter--;
            }
            if (program.charAt(pointer) == close) {
                pairCounter++;
            }

            pointer--;

            if(pointer >= program.length()) throw new IllegalSyntaxException("Syntax Exception : loop opener not found");

            isOpen = program.charAt(pointer) == open;
            isNested = pairCounter != 0;
        }
        return pointer;
    }
}
