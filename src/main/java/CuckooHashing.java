import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
public class CuckooHashing {

    private static final int CAPACITY = 100;

    private Node[] table1 = new Node[CAPACITY];

    public void add(int value) {
        int index1 = hash1(value);
        int index2 = hash2(value);
        Node node = new Node(value);
        if (table1[index1] == null) {
            table1[index1] = node;
        } else if (table1[index2] == null) {
            table1[index2] = node;
        } else{
            for (; index2 < table1.length; index2++){
                if(table1[index2] == null){
                    table1[index2] = node;
                }
            }
        }
    }

    public void remove(int value) {
        int index1 = hash1(value);
        int index2 = hash2(value);
        Node iterator = null;
        if(table1[index1].value == value){
            table1[index1] = null;
        }else if(table1[index2].value == value){
            table1[index2] = null;
        }else{
            for (; index2 <table1.length; index2++){
                if(table1[index2].value == value){
                    table1[index2] = null;
                    break;
                }
            }
        }
    }

    public boolean contains(int value){
        int index1 = hash1(value);
        int index2 = hash2(value);
        Node iterator = null;
        if(table1[index1].value == value){
            return true;
        }else if(table1[index2].value == value){
            return true;
        }else {
            for (; index2 <table1.length; index2++){
                if(table1[index2].value == value){
                    return true;
                }
            }
        }
        return false;
    }


    private int hash1(int value) {
        value *= value;
        value >>= 2;
        return value % CAPACITY;
    }

    private int hash2(int value) {
        return value % CAPACITY;


    }

    @ToString
    @NoArgsConstructor
    public static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

}
