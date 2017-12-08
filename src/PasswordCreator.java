import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PasswordCreator {

    public static void main(String[] args)
    {
        String address = "odjlkelkmckj.ru";

        HashMap<Character, String> map = getMap();
        HashMap<Character, String> mapStable = map;

        System.out.println(getPassword(mapStable, address));

        System.out.println(address.toUpperCase());

    }

    public static HashMap<Character, String> getMap(){
        Random random = new Random(System.currentTimeMillis());
        int minA = 65, maxA = 90, mina = 97, maxa = 122, minSighn = 48, maxSighn = 63;
        HashMap<Character, String> map = new HashMap<>();


        for (char c='a'; c<='z'; c++) {
            map.put(c, "" + (char)(mina + random.nextInt(maxa - mina + 1)) + (int)(0 + random.nextInt(99 - 0 + 1)) + (char)(minA + random.nextInt(maxA - minA + 1)) + (char)(minSighn + random.nextInt(maxSighn - minSighn + 1)));
        }
            map.put('.', "" + (char)(mina + random.nextInt(maxa - mina + 1)) + (int)(0 + random.nextInt(99 - 0 + 1)) + (char)(minA + random.nextInt(maxA - minA + 1)) + (char)(minSighn + random.nextInt(maxSighn - minSighn + 1)));

        return map;
    }

    public static String getPassword(HashMap<Character, String> map, String s){
        int length = 15;
        String password = "", t = "";

        for (Character ch : s.toCharArray()){
            password += map.get(ch);
        }

        while (password.length() > length){
            ArrayList<Character> pass = new ArrayList<>();
            for (int i = 0; i < password.length(); i++){
                if (i % 3 != 0)
                    pass.add(password.charAt(i));
            }
            password = "";
            for (Character ch : pass){
                password += ch;
            }
        }
        return password;
    }
}
