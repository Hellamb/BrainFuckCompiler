public class UnaryCommandLeft extends  UnaryCommand
{
    public UnaryCommandLeft(char id)
    {
        super(id);
    }

    //Unary command that move index lefter
    @Override
    public void execute(Data data)
    {
        data.setIndex(data.getIndex()-(char)1);
    }

    @Override
    public Command create() {
        return new UnaryCommandLeft(super.getId());
    }
}
