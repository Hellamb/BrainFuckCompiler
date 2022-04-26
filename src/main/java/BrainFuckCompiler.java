import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BrainFuckCompiler {

    Analyzer analyzer;

    public BrainFuckCompiler(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void compile(String code){
        List<Command> commandList = analyzer.parse(code);
        Node node = new Node();
        //for(Command command : commandList) command.execute(node);
        commandList.forEach(command -> command.execute(node));
    }
}
