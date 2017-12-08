
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindLetters {

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        s = reader.readLine();

        ArrayList<Integer> letterList = new ArrayList<>();

        letterList = getIntList(s);

        String[] list = getString1(letterList, s);
        System.out.print(list[0] + ":");
        for (int i = 1; i < list.length; i++){
            System.out.print("\\" + list[i]);
        }
    }

    private static ArrayList<Integer> getIntList(String s) {
        Character[] alphabet = new Character[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Character[] numbers = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Character[] forbbidensigns = new Character[]{'\'', '\"', '|', '<', '>', '?', ':', '*', '/'};
        Character[] sings = new Character[]{' ', '.', ',', ';', '}', '{', '[', ']', '=', '+', '-', '_', ')', '(', '&', '^', '%', '$', '#', '@', '!', '`', '~'};

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (s.charAt(i) == alphabet[j] || s.charAt(i) == Character.toUpperCase(alphabet[j]))
                    list.add(i);
            }
            for (int j = 0; j < numbers.length; j++) {
                if (s.charAt(i) == numbers[j])
                    list.add(i);
            }
            /*
            for (int j = 0; j < sings.length; j++) {
                if (s.charAt(i) == sings[j])
                    list.add(i);
            }
             */
            /*
            for (int j = 0; j < forbbidensigns.length; j++) {
                if (s.charAt(i) == forbbidensigns[j])
                    list.add(i);
            }
             */
        }
        return list;
    }

    private static String[] getString1(ArrayList<Integer> list, String s) {
        String result = "";
        try {
            System.out.print(s.charAt(list.get(0)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) + 1 != list.get(i)) {
                    result += "~" + Character.toString(s.charAt(list.get(i)));
                } else
                    result += s.charAt(list.get(i));
            }
            String[] listString = result.split("~");
        return listString;
    }
}
