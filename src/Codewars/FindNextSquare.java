package Codewars;

import static java.lang.Math.*;

public class FindNextSquare {

    public static void main(String[] args) {
        System.out.println(findNextSquare(121));
    }

    public static long findNextSquare(long sq) {
        long result = -1;
        for (long i = 0; i < 46342; i++){
            if (i * i == sq){
                result = (i + 1) * (i + 1);
                break;
            }
        }
        return result;
    }
    public static long findNextSquare1(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }
}
