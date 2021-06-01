import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        CuckooHashing table = new CuckooHashing();

        table.add(10);
        table.add(11);
        table.add(12);
        table.add(13);

        CuckooHashing.Node[] table1 = table.getTable1();
        Arrays.stream(table1).filter(Objects::nonNull).forEach(System.out::println);

        table.remove(10);
        System.out.println();
        Arrays.stream(table1).filter(Objects::nonNull).forEach(System.out::println);
        System.out.println(table.contains(13));
    }
}
