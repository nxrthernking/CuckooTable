import java.util.Arrays;
import java.util.Objects;

public class HashTable {
    private static final int CAPACITY = 100;
    private int size = 0;
    private Node[] table = new Node[CAPACITY];

    public void add(int value) {
        Node node = new Node(value);
        int index = hash(value);
        if (table[index] != null) {
            for (; index < CAPACITY; index++) {
                if (table[index] == null) {
                    break;
                }
            }
        }
        table[index] = node;
    }

    public Node find(int value) {
        int index = hash(value);
        Node node = table[index];
        if (node.value != value) {
//            node = table[index];
            for (; index < CAPACITY; index++){
                if(table[index].value == value){
                    node = table[index];
                    break;
                }
            }
        }
        return node;
    }

    public void remove(int value){
        int index = hash(value);
        Node node = table[index];
        if (node.value != value) {
            for (; index < CAPACITY; index++){
                if(table[index].value == value){
                    table[index] = null;
                }
            }
        }else{
            table[index] = null;
        }
    }

    private int hash(int key) {
        key *= key;
        key >>= 2;
        return key % CAPACITY;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(table).filter(Objects::nonNull).forEach(s -> builder.append(s).append("\n"));
        return builder.toString();
    }

    private static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
