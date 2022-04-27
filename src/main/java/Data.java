import java.util.Arrays;

/**
 * The class responsible for working with data and storing it
 */
public class Data {
    private final static int ARRAY_SIZE = 30000;
    private char[] arr;
    private int index;
    private String output;

    public Data() {
        arr = new char[ARRAY_SIZE];
        Arrays.fill(arr, (char) 0);
        this.index = 0;
        output = "";
    }

    public char[] getArr() {
        return arr;
    }

    public void setArr(char[] arr) {
        this.arr = arr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if (index < 0) index = ARRAY_SIZE + index;
        if (index >= ARRAY_SIZE) index %= ARRAY_SIZE;
        this.index = index;
    }

    public void addOutput(char c) {
        output += c;
    }

    public String getOutput() {
        return output;
    }
}