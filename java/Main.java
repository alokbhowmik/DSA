import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        TreeSet1 set = new TreeSet1();
//        set.add(10, 20);
//        set.add(11, 21);
//        set.add(10, 40);
//
//        System.out.println(set);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        StringBuilder className = new StringBuilder();
        for (String s : name.split(" ")){
            className.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
        }
        System.out.println(className.toString());
    }
}
