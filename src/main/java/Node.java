public class Node {
    private final static int ARRAY_SIZE = 30000;
    private int[] arr;
    private int index;

    public Node(){
        arr = new int[ARRAY_SIZE];
        this.index = 0;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if(index<0) index = ARRAY_SIZE+index;
        if(index>=ARRAY_SIZE) index %=ARRAY_SIZE;
        this.index = index;
    }
}
