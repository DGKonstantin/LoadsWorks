

import java.util.ArrayList;
import java.util.Scanner;

public class Krok2 {

    public static void main(String[] args) {
        int d = 0;
        ArrayList<Integer> spases = new ArrayList<Integer>();
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            String s = sc.nextLine();

            if (s.equals("")){
                if (d > 2){
                    break;
                }
                d++;
            }
            strings.add(s);
            spases.add(0);
        } while (sc.hasNextLine());

        int[] level = new int[strings.size()];
        for (int k : level){
            k = 0;
        }

        for (int i = 0; i < strings.size(); i++) {
            char[] ch = strings.get(i).toCharArray();
            int t = 0;
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == ' ') {
                    t++;
                } else {
                    spases.add(i, t);
                    break;
                }
            }
        }

        for (int i = 0; i < strings.size(); i++){
            char[] ch = strings.get(i).toCharArray();
            for (int j = 0; j < ch.length; j ++){
                if (ch[j] == '{'){
                    for (int k = i + 1; k < level.length; k++){
                        level[k]++;
                    }
                }
                if (ch[j] == '}'){
                    for (int k = i + 1; k < level.length; k++){
                        if (level[k] != 0) {
                            level[k]--;
                        }
                        else level[k] = 0;
                    }
                }
            }
        }
        for (int j = 0; j < strings.size(); j++){
            int startLine = 0;
            String s = (String) strings.get(j);
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ' '){
                    startLine++;
                }
                else if (s.charAt(i) != ' '){
                    break;
                }
            }
            String finishS = "";
            for (int i = startLine; i < s.length(); i++){
                finishS += s.charAt(i);
            }
            strings.remove(j);
            strings.add(j, finishS);
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("");
            for (int k = 0; k < level[i]; k++){
                System.out.print("    ");
            }
            for (int j = spases.get(i); j < strings.get(i).length(); j++){
                System.out.print(strings.get(i).charAt(j));
            }
        }
    }
}
