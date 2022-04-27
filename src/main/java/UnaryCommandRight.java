public class UnaryCommandRight extends UnaryCommand {
    public UnaryCommandRight(char id) {
        super(id);
    }

    //Unary command that move index righter
    @Override
    public void execute(Data data) {
        data.setIndex(data.getIndex() + (char) 1);
    }

    @Override
    public Command create() {
        return new UnaryCommandRight(super.getId());
    }
}
