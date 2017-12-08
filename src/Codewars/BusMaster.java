package Codewars;

public class BusMaster {

    public static void main(String[] args) {
        System.out.println(arbitrate("001000101", 9));
    }

    public static String arbitrate(String input, int n) {
        String result = "";
        boolean one = false;
        for (int i = 0; i < n; i++) {
            if (one == false) {
                if (input.charAt(i) == '0')
                    result += '0';
                if (input.charAt(i) == '1') {
                    result += '1';
                    one = true;
                }
            } else {
                result += '0';
            }
        }
        return result;
    }
}
