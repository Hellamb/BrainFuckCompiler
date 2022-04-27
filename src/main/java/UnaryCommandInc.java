public class UnaryCommandInc extends UnaryCommand {
    public UnaryCommandInc(char id) {
        super(id);
    }

    //Unary command that increment current value
    @Override
    public void execute(Data data) {
        data.getArr()[data.getIndex()] += (char) 1;
    }

    @Override
    public Command create() {
        return new UnaryCommandInc(super.getId());
    }
}
