package Codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimesInNumbers {

    public static void main(String[] args) {
        factors(7775460);
    }


    public static String factors(int n) {

        int i = 2;
        ArrayList<Integer> list = new ArrayList<>(){};
        ArrayList<Integer> multies = new ArrayList<>();
        list.add(5);
        list.add(2);
        /*
        while (n != 1){
            if (n % i == 0){
                list.add(i);
                n = n / i;
                i = 2;
            }
            else
                i++;
        }
         */
        int r = 0;
        for (Integer s : list)
            System.out.println(s);

        return null;
    }
}
