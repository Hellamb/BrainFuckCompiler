public class UnaryCommandOut extends UnaryCommand {

    public UnaryCommandOut(char id) {
        super(id);
    }

    //Unary command that puts a value on the output
    @Override
    public void execute(Data data) {
        data.addOutput(data.getArr()[data.getIndex()]);
    }

    @Override
    public Command create() {
        return new UnaryCommandOut(super.getId());
    }
}
