package Codewars;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class ReverseSntenses {
    public static void main(String[] args) {
        System.out.println(reverseWords("The greatest victory is that which requires no battle"));
    }

    public static String reverseWords(String str){
        String result = "";
        for (int i = str.split(" ").length - 1; i >= 0; i--){
            if (i != 0)
                result += str.split(" ")[i] + " ";
            else
                result += str.split(" ")[i];
        }
        return result;
    }

    /*
    public static String reverseWords1(String str){
        //write your code here...
        List Words = Arrays.asList(str.split(" "));
        Collections.reverse(Words);
        return String.join(" ", Words);
    }
     */
}
