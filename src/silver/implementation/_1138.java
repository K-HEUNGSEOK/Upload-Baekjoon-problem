package silver.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _1138 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person [] person = new Person[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;  i < n ; i ++){
            person[i] = new Person(i+1, sc.nextInt());
        }
        Arrays.sort(person);

        for (Person person1 : person) {
            list.add(person1.y,person1.x);
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }
    static class Person implements Comparable<Person>{
        int x,y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Person o){
            return o.x - this.x;
        }
    }
}
