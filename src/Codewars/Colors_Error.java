package Codewars;

public class Colors_Error {

    public static void main(String[] args) {
        System.out.println(printerError("bbqwertyuioplkjvcfyuiol"));
        System.out.println(printerError1("bbqwertyuioplkjvcfyuiol"));
    }


    public static String printerError(String s) {
        // your code 97/109
        int a = 0;
        for (int k : s.toCharArray()){
            if (k < 99 || k > 109)
                a++;
        }
        return a + "/" + s.length();
    }
    public static String printerError1(String s) {
        return s.replaceAll("[c-m]", "").length() + "/" + s.length();
    }
}
