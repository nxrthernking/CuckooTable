import lombok.Data;
import lombok.NoArgsConstructor;

public class CustomList {

    private Node head;
    private Node tail;

    public void add(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
        }else{
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }


    public void swap(){
        tail.next = head.next;
        tail.previous.next = head;
        head.next = null;
        head.previous = tail;
        Node tmp = head;
        head = tail;
        tail = tmp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node iterator = head;
        while(iterator != null){
            builder.append(iterator.value).append(" ");
            iterator = iterator.next;
        }
        return builder.toString();
    }

    @NoArgsConstructor
    @Data
    private static class Node{
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }
}
