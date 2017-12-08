

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Kollatc {

    public static void main(String[] args) throws Exception {

        HashMap<Integer, Integer> odd = new HashMap<>();
        HashMap<Integer, Integer> num = new HashMap<>();

        long x;
        int countNumber;
        for (int i = 2; i < 3; i++){
            x = i;
            countNumber = 0;
            while (x != 1){
                if(x % 2 == 0){
                    x = x / 2;
                }
                else
                {
                    x = 3 * x + 1;
                }
                countNumber++;
            }
            if (i % 2 == 0)
                odd.put(i, countNumber);
            else
                num.put(i, countNumber);
        }

        for (Integer integer : odd.keySet()){

            String key = integer.toString();
            String value = odd.get(integer).toString();
            System.out.println(String.format("%s : %s", key, value));
        }
        for (Integer integer : num.keySet()){

            String key = integer.toString();
            String value = num.get(integer).toString();
            System.out.println(String.format("%s : %s", key, value));
        }

    }

}
