package silver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyEx1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
    }
}
