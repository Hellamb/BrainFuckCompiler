public class UnaryCommandDec extends UnaryCommand
{
    public UnaryCommandDec(char id)
    {
        super(id);
    }

    //Unary command that decrement current value
    @Override
    public void execute(Data data)
    {
        data.getArr()[data.getIndex()]-=(char)1;
    }

    @Override
    public Command create() {
        return new UnaryCommandDec(super.getId());
    }
}
