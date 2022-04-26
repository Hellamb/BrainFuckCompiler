import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] arguments){

        Map<Character, Command> commands = new HashMap<>();
        commands.put('>',node -> node.setIndex(node.getIndex()+1));
        commands.put('<',node -> node.setIndex(node.getIndex()-1));
        commands.put('+',node -> node.getArr()[node.getIndex()] +=1);
        commands.put('-',node -> node.getArr()[node.getIndex()] -=1);
        commands.put('.',node -> System.out.println(node.getArr()[node.getIndex()]));

        Analyzer analyzer = new SyntaxAnalyzer(commands);
        BrainFuckCompiler bfc = new BrainFuckCompiler(analyzer);

        bfc.compile(".+++.>.++.");

    }
}
