import java.util.ArrayList;
import java.util.List;

public class remove {

    public static List<String> allPeople = new ArrayList<String>();

    static {
        allPeople.add("ppp");
        allPeople.add("III");
    }

    public static void main(String[] args) {
        String s = "0";
        System.out.println(allPeople.size());
        int t = getId(s);
        allPeople.remove(t);
        System.out.println(allPeople.size());
    }
    public static Integer getId(String s){
        return Integer.parseInt(s);
    }

}
