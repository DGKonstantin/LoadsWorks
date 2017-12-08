

import java.io.*;
import java.util.ArrayList;

public class CopyFile {





    public static void main(String[] args) throws Exception
    {
        Character[] alphabet = new Character[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outStream;
        InputStream inStream;

        String inAdress;
        String outAdress;

        inAdress = reader.readLine();
        //outAdress = reader.readLine();

        ArrayList<String> inadress = getWords(inAdress, alphabet);

        for (String string : inadress){
            System.out.println(string);
        }


        try{
            File inFile = new File("D:/Books/5_слов.doc");
            File outFile = new File("D:/my-object-data.txt");

            inStream = new FileInputStream(inFile);
            outStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];

            int length;

            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static ArrayList <String> getWords(String s, Character[] alp){
        boolean letter;
        String word = "";
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < alp.length; j++){
                letter = false;
                if (s.charAt(i) == alp[j]) {
                    letter = true;
                    break;
                }
                if (letter = true) {
                    word += Character.toString(alp[j]);
                }
                else {
                    list.add(word);
                }
            }
        }
        return list;
    }
}
