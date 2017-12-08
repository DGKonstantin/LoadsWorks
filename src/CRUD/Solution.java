package CRUD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {

    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        String inPut = "-c Миронов  Андрей Анатольевич м 15/04/1990";
        //String inPut = "-u 1 Миронов Андрей Анатольевич м 15/04/1990";
        //String inPut = "-d 0";
        //String inPut = "-i 0";

        String[] s = inPut.split(" ");

        if (s[0].equals("-c")) {
            if (getSex(inPut).equals("м")) {
                Person person = Person.createMale(getName(inPut), getDate(inPut));
                allPeople.add(person);
            } else if (getSex(inPut).equals("ж")) {
                Person person = Person.createFemale(getName(inPut), getDate(inPut));
                allPeople.add(person);
            }
            System.out.println(allPeople.size() - 1);
        } else if (s[0].equals("-u")) {
            if (getSex(inPut).equals("м")) {
                Person person = Person.createMale(getName(inPut), getDate(inPut));
                allPeople.add(getId(inPut), person);
                allPeople.remove(getId(inPut) + 1);
            } else if (getSex(inPut).equals("ж")) {
                Person person = Person.createFemale(getName(inPut), getDate(inPut));
                allPeople.add(getId(inPut), person);
                allPeople.remove(getId(inPut) + 1);
                System.out.println(allPeople.size());
            }
        }
        else if (s[0].equals("-d")){
            Person person = Person.createFemale(null, null);
            allPeople.add(getId(inPut), person);
            allPeople.remove(getId(inPut) + 1);
        }
        else if (s[0].equals("-i")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person man = allPeople.get(getId(inPut));
            if (man.getSex() == Sex.MALE)
                System.out.println(man.getName() + " " + "м" + " " + dateFormat.format(man.getBirthDay()));
            else if (man.getSex() == Sex.FEMALE)
                System.out.println(man.getName() + " " + "ж" + " " + dateFormat.format(man.getBirthDay()));
        }
    }

    public static String getName(String inPut){
        String name = "";
        int sexPosition = 0;
        String[] s = inPut.split(" ");
        for (int i = 0; i < s.length; i++){
            if (s[i].equals("м") || s[i].equals("ж")){
                sexPosition = i;
                break;
            }
        }
        if ("1234567890".contains(Character.toString(s[1].charAt(0)))){
            for (int i = 2; i < sexPosition; i++){
                if (i != sexPosition - 1)
                    name += s[i] + " ";
                else
                    name += s[i];
            }
        }
        else
        {
            for (int i = 1; i < sexPosition; i++){
                if (i != sexPosition - 1)
                    name += s[i] + " ";
                else
                    name += s[i];
            }
        }
        return name;
    }

    public static Integer getId(String inPut){
        int id = 0;
        String[] s = inPut.split(" ");
        if ("1234567890".contains(Character.toString(s[1].charAt(0)))){
            id = Integer.parseInt(s[1]);
        }
        return id;
    }

    public static Date getDate(String inPut){
        String[] s = inPut.split(" ");
        String[] split = s[s.length - 1].split("/");
        String textDate = split[1] + "/" + split[0] + "/" + split[2];
        Date date = new Date(textDate);
        return date;
    }

    public static String getStringDate(String inPut){
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = outputFormat.format(getDate(inPut));
        return date;
    }

    public static String getSex(String inPut){
        String sex = "пол не определен";
        String[] s = inPut.split(" ");
        for (int i = 0; i < s.length; i++){
            if (s[i].equals("м")){
                sex = "м";
                break;
            }
            if (s[i].equals("ж")){
                sex = "ж";
                break;
            }
        }
        return sex;
    }
}
