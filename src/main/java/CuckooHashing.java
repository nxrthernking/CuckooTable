import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
public class CuckooHashing {
    private static final int CAPACITY = 10;

    private Node[] table1 = new Node[CAPACITY];
    /*private Node[] table2 = new Node[CAPACITY];*/

    public void add(int value) {
        int index1 = hash1(value);
        int index2 = hash2(value);
        Node node = new Node(value);
        if (table1[index1] == null) {
            table1[index1] = node;
        } else if (table1[index2] == null) {
            table1[index2] = node;
        } else {
            Node tmp = table1[index1];
            table1[index1] = node;
            int i = hash2(tmp.value);
            if (table1[i] == null) {
                table1[i] = tmp;
            } else {
                node = tmp;
                tmp = table1[i];
                table1[i] = node;
                int i2 = hash2(tmp.value);
                if (i2 == i) {
                    Node iterator = table1[i2];
                    while (iterator.next != null) {
                        iterator = iterator.next;
                    }
                    iterator.next = tmp;
                    tmp.prev = iterator;
                } else {
//                    table1[i2] = tmp;
                    add(tmp.value);
                }
            }
        }
    }

    public void remove(int value) {
        int index1 = hash1(value);
        int index2 = hash2(value);
        Node iterator = null;
        if (table1[index1].value == value) {
            if (table1[index1].next != null) {
                table1[index1] = table1[index1].next;
            } else {
                table1[index1] = null;
            }

        } else if (table1[index2].value == value) {
            if (table1[index2].next != null) {
                table1[index2] = table1[index2].next;
            } else {
                table1[index2] = null;
            }

        } else {
            iterator = table1[index2];
            while (iterator != null) {
                if (iterator.value == value) {
                    unlink(index2, iterator);
                }
                iterator = iterator.next;
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
        }else{
            iterator = table1[index2];
            while(iterator != null){
                if(iterator.value == value){
                    return true;
                }
                iterator = iterator.next;
            }
        }
        return false;
    }

    private void unlink(int index, Node iterator) {
        if (iterator.prev == null) {
            table1[index] = iterator.next;
        } else if (iterator.next == null) {
            iterator.prev.next = null;
        } else {
            iterator.prev.next = iterator.next;
            iterator.next.prev = iterator.prev;
        }
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
        private Node next;
        @ToString.Exclude
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

}
