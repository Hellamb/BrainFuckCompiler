public interface Command {
    void execute(Data data);

    Command create();
}
