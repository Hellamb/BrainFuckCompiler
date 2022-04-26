import java.util.List;

public interface Analyzer {
    List<Command> parse(String str);
}
