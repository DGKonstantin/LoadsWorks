import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeleteSpases {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int startLine = 0;

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
        System.out.println(finishS);
    }

}
