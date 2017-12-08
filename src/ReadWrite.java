import java.util.ArrayList;

public class ReadWrite {
        private ArrayList<Character> list;
        public void write(Character data)
        {
            list.add(data);
        }
        public Character read()
        {
            Character first = list.get(0);
            return first;
        }

        public int available()
        {
            return list.size();
        }
    }
