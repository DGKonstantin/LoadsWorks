package Codewars;

import java.awt.*;

public class EncryptDecrypt {

    public static void main(String[] args) {
        String stert = "This is test!";
        int n = 9;
        System.out.println(encrypt(stert, n));
        String s = encrypt(stert, n);
        System.out.println(decrypt(s, n));
    }
    public static String encrypt(final String text, final int n) {
        // Your code here
        String result = "";
        if (n <= 0)
            result = text;
        else {
            for (int j = 0; j < n; j++) {
                String s1 = "", s2 = "";
                if (result == "")
                    result = text;
                for (int i = 0; i < result.length(); i++) {
                    if (i % 2 != 0)
                        s1 += result.charAt(i);
                    else
                        s2 += result.charAt(i);
                }
                result = s1 + s2;
            }
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        String result = "";
        if (n <= 0)
            result = encryptedText;
        else
        {
            for (int i = 0; i < n; i++){
                if (result == "")
                    result = encryptedText;
                String s1, s2;
                if (result.length() % 2 == 0){
                    s1 = result.substring(result.length() / 2, result.length());
                    s2 = result.substring(0, result.length() / 2);
                }
                else{
                    s1 = result.substring(result.length() / 2, result.length());
                    s2 = result.substring(0, result.length() / 2);
                }
                result = "";
                int k = 0;
                while (k < s1.length()){
                    result += s1.charAt(k);
                    try{
                        result += s2.charAt(k);
                    }catch (Exception e){}

                    k++;
                }
            }
        }
        return result;
    }

    public static String encrypt1(final String text, int n) {
        if (n <= 0 || text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char aChar = text.charAt(i);
            if (i % 2 == 1) {
                firstPart.append(aChar);
            } else {
                secondPart.append(aChar);
            }
        }

        return encrypt(firstPart.append(secondPart).toString(), --n);
    }

    public static String decrypt1(final String encryptedText, int n) {
        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        StringBuilder text = new StringBuilder();
        final int half = encryptedText.length() / 2;
        for (int i = 0; i < half; i++) {
            text.append(encryptedText.charAt(half + i)).append(encryptedText.charAt(i));
        }
        if (encryptedText.length() % 2 == 1) {
            text.append(encryptedText.charAt(encryptedText.length() - 1));
        }

        return decrypt(text.toString(), --n);
    }
}
