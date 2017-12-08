package Codewars;

import java.util.Date;
import java.util.stream.IntStream;

public class Multiply35 {

    public static void main(String[] args) {
        Date s = new Date();
        solution(10000);
        Date f = new Date();
        System.out.println(f.getTime() - s.getTime());

        s = new Date();
        solution1(10000);
        f = new Date();
        System.out.println(f.getTime() - s.getTime());
    }


    public static int solution(int number) {
        //TODO: Code stuff here
        int result = 0;
        for (int i = 3; i < number; i++){
            if (i % 3 == 0 || i % 5 == 0)
                result += i;
        }
        return result;
    }

    public static int solution1(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }
}
