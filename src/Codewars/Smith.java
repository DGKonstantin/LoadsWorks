package Codewars;


import java.util.ArrayList;

public class Smith {
    public static void main(String[] args) {
        String s = "jklcdn jmlvkf kln fkld alkn kmsdlkv njna sjn alksjn  jnjkn kj nsdk vjen kjneskjd fvkemn vkjjacjnvka fe ";
        System.out.println(toJadenCase(s));
    }

    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment
        char[] chars = phrase.toCharArray();
        phrase = "";
        for (int i = 0; i < chars.length; i++){
            if  (chars[i] == ' ' && i + 1!= chars.length)
                chars[i + 1] = Character.toUpperCase(chars[i + 1]);
            if  (i == 0)
                chars[i] = Character.toUpperCase(chars[i]);
            phrase += chars[i];
        }
        if(phrase.isEmpty())
            phrase = null;
        return phrase;
    }
}
