package Codewars;

public class OldPhones {

    public static void main(String[] args) {
        /*
              assertEquals(9, Keypad.presses("LOL"));
      assertEquals(13, Keypad.presses("HOW R U"));
         */
        System.out.println(presses("QAaM*GDOl'I*@ymi"));
    }


    public static int presses(String phrase) {
        String[] strings = new String[]{"1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", " 0", "*", "#"};
        int count = 0;
        for (int i = 0; i < phrase.length(); i++){
            String ch = Character.toString(phrase.charAt(i)).toLowerCase();
            for (int k = 0; k < strings.length; k++){
                if(strings[k].contains(ch)){
                    for (int j = 0; j < strings[k].length(); j++){
                        count++;
                        if (strings[k].charAt(j) == ch.charAt(0))
                            break;
                    }
                    break;
                }
            }
        }
        return count;
    }
}
