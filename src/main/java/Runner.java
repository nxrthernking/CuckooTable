import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            int x = random.nextInt(200);
            System.out.println(x);
            hashTable.add(x);
        }
        hashTable.add(12);
        System.out.println(hashTable);
        System.out.println(hashTable.find(12));
        hashTable.remove(12);
        System.out.println();
        System.out.println(hashTable);
    }
}
