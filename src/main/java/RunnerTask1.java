import java.util.Arrays;
import java.util.Comparator;

public class RunnerTask1 {
    public static void main(String[] args) {
        String reverse = "dwqeAAAAAAAA AAA aaa qwe";

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return countA(o1.toCharArray()) - countA(o2.toCharArray());
            }
        };

        Arrays.stream(reverse.split(" ")).sorted(comparator).forEach(System.out::println);
    }

    private static int countA(char[] c) {
        int count = 0;
        for (char ch : c) {
            if (ch == 'A') {
                count++;
            }
        }
        return count;
    }
}
