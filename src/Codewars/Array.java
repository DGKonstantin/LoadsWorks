package Codewars;

import java.util.Random;

public class Array {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++){
            System.out.print(random.nextInt(1000) + ", ");
        }
    }
}
