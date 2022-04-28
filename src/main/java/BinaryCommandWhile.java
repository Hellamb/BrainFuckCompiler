public class BinaryCommandWhile extends BinaryCommand {
    public BinaryCommandWhile(char id_start, char id_end) {
        super(id_start, id_end);
    }

    @Override
    public void execute(Data data) {
//        Runner runner = new Runner();
        int index = data.getIndex();
        while (data.getArr()[index] != 0) {
//            runner.run(super.innerCommandList, data);
            super.innerCommandList.forEach(command -> command.execute(data));
        }
    }

    @Override
    public BinaryCommand create() {
        return new BinaryCommandWhile(super.getId_start(), super.getId_end());
    }
}
