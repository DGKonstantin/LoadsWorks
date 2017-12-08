package Yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BeautyNotes {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string = reader.readLine();

        // создаем и инициализируем массив предложений
        ArrayList<String> sentenses = new ArrayList<String>(Arrays.asList(string.split("\\.")));

        // начинием перебирать предложения
        for (int i = 0; i < sentenses.size(); i++){

            // создаем и инициализируем массив слов в предожении
            ArrayList<String> words = new ArrayList<String>(Arrays.asList(sentenses.get(i).split(" ")));

            // начинием перебирать слова в предложении
            for (int j = 0; j < words.size(); j++){

                // исключаем пустые слова
                if (words.get(j).equals(""))
                    words.remove(j);

                // исключаем пробелы
                words.get(j).replaceAll(" ", "");

                // создаем и инициализируем буквы в слове
                ArrayList<String> letters = new ArrayList<String>(Arrays.asList(words.get(j).split("")));
                String local = "";

                // перебираем буквы
                for (int k = 0; k < letters.size(); k++){
                    // делаем соответсвующий регистр
                    if (!"qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM.".contains(letters.get(k))){
                        local += " " + letters.get(k) + " ";
                    }
                    if (j == 0 && k == 0) {
                        String capital = letters.get(k).toUpperCase();
                        letters.remove(k);
                        letters.add(k, capital);
                    }
                    else {
                        String noncapital = letters.get(k).toLowerCase();
                        letters.remove(k);
                        letters.add(k, noncapital);
                    }
                    local += letters.get(k);
                }
                words.remove(j);
                words.add(j, local);
                String result = "";

                // печатаем результат

                if (j == 0){
                    if (words.size() == 1)
                        result += words.get(j) + ". ";
                    else if (i == 0)
                        result += words.get(j);
                    else
                        result +=  " " + words.get(j) + " ";
                }
                else if (j == words.size() - 1){
                    result += words.get(j) + ".";
                }
                else{
                        result += words.get(j) + " ";
                }

                System.out.print(result);
            }
        }
    }
}
