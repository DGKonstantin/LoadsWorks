package Codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {

    public static void main(String[] args) {
        /*
        String a[]  = new String[] { "1295", "code", "1346", "1028", "ar" };
	    String b[]  = new String[] { "12951295", "ode", "46", "10281066", "par" };
	    String r[]  = new String[] { "1028", "1295", "ar" };
         */
        String[] a1 = {"1295", "code", "1346", "1028", "ar"   };

        String[] a2 = {"12951295", "ode", "46", "10281066", "par" };
        for (String s : inArray(a1, a2))
        System.out.println(s + " ");
    }


    public static String[] inArray(String[] array1, String[] array2) {
        HashSet<String> set = new HashSet<>();
        for (String s1 : array1){
            for (String s2 : array2){
                if (s2.contains(s1))
                    set.add(s1);
            }
        }
        String[]result = new String[set.size()];
        result = set.toArray(result);
        Arrays.sort(result);
        return result;
    }

    public static String[] inArray1(String[] array1, String[] array2) {
        Set<String> result = new HashSet<>();

        for(String a1 : array1) {
            for(String a2 : array2) {
                if(a2.contains(a1)) {
                    result.add(a1);
                    break;
                }
            }
        }

        String[] resultArray = result.toArray(new String[result.size()]);

        Arrays.sort(resultArray);

        return resultArray;
    }
}
