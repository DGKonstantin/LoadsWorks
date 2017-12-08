package Codewars;

import java.util.*;

public class BackwardSimple {

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(backwardsPrime(70000, 70245));
        System.out.println("70001 70009 70061 70079 70121 70141 70163 70241");
        Date finish = new Date();
        System.out.println(finish.getTime() - start.getTime());
    }


    public static String backwardsPrime(long start, long end) {
        // your code
        ArrayList<String> list = new ArrayList<>();
        String result = "";
        for (long i = start; i < end; i++){
            int sim = 0;
            for (long j = 1; j <= i; j++){
                if (i % j == 0)
                    sim++;
            }
            if (sim == 2)
                list.add(Long.toString(i));
        }
        for (int i = 0; i < list.size(); i++){
            String backward = "";
            HashSet<Character> CharList = new HashSet<>();
            for (int j = list.get(i).length() - 1; j >= 0; j--) {
                backward += list.get(i).charAt(j);
                CharList.add(list.get(i).charAt(j));
            }
            int sim = 0;
            for (long j = 1; j <= Integer.parseInt(backward); j++){
                if (Integer.parseInt(backward) % j == 0)
                    sim++;
            }
            if (sim == 2 && Integer.parseInt(backward) != Integer.parseInt(list.get(i)))
                result += "" + list.get(i) + " ";

        }
        if (!result.isEmpty())
            result = result.substring(0, result.length() - 1);
        return result;
    }
}
