package Codewars;

import java.util.ArrayList;
import java.util.Stack;

public class CheckingGroups {


    public static void main(String[] args) {
        System.out.println(groupCheck("({})"));
        System.out.println(groupCheck("[[]()]"));
        System.out.println(groupCheck("[{()}]"));
        System.out.println(groupCheck("()"));
        System.out.println(groupCheck("([])"));
        System.out.println(groupCheck("{}([])"));
        System.out.println(groupCheck1("{[{}[]()[]{}{}{}{}{}{}()()()()()()()()]{{{[[[((()))]]]}}}}(())[[]]{{}}[][][][][][][]({[]})"));
       /*
        }
        @Test
        public void testBadlyMatchedGroups() {
            assertEquals("That group was matched incorrectly",Groups.groupCheck("{(})"), false);
            assertEquals("That group was matched incorrectly",Groups.groupCheck("[{}{}())"), false);
            assertEquals("That group was matched incorrectly",Groups.groupCheck("{)[}"), false);
            assertEquals("That group was matched incorrectly",Groups.groupCheck("[[[]])"), false);
            assertEquals("That group was matched incorrectly",Groups.groupCheck("()[]{]"), false);
            assertEquals("That group was matched incorrectly",Groups.groupCheck("{([]})"), false);
        }
        @Test
        public void testOpenOrPrematurelyClosedGroups() {
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("([]"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("[])"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("([]))"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("{{))"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("{}{"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("{"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("]"), false);
            assertEquals("That group was left open or prematurely closed",Groups.groupCheck("{{{{{{{{{{{((((((([])))))))}}}}}}}}}}"), false);
        }
        */
    }

    public static boolean groupCheck(String s){
        char[] CharS = s.toCharArray();
        ArrayList<Integer> posSqCl = new ArrayList<>();
        ArrayList <Integer> posSqOp = new ArrayList<>();
        ArrayList <Integer> posFigCl = new ArrayList<>();
        ArrayList <Integer> posFigOp = new ArrayList<>();
        ArrayList <Integer> posRCl = new ArrayList<>();
        ArrayList <Integer> posROp = new ArrayList<>();
        for (int i = 0; i < CharS.length; i++){
            if (CharS[i] == '(') posROp.add(i);
            if (CharS[i] == ')') posRCl.add(i);
            if (CharS[i] == '[') posSqOp.add(i);
            if (CharS[i] == ']') posSqCl.add(i);
            if (CharS[i] == '{') posFigOp.add(i);
            if (CharS[i] == '}') posFigCl.add(i);
        }
        boolean result = true;
        if (posFigCl.size() - posFigOp.size() == 0 && posSqCl.size() - posSqOp.size() == 0 && posRCl.size() - posROp.size() == 0) {
            for (int i = 0; i < posFigCl.size(); i++){
                if (posFigCl.get(i) < posFigOp.get(posFigCl.size() - i - 1)
                        || posFigCl.get(i) - posFigOp.get(posFigCl.size() - i - 1) == 2){
                    result = false;
                    break;
                }
            }
            for (int i = 0; i < posSqCl.size(); i++){
                if (posSqCl.get(i) < posSqOp.get(posSqCl.size() - i - 1)
                        || posSqCl.get(i) - posSqOp.get(posSqCl.size() - i - 1) == 2){
                    result = false;
                    break;
                }
            }
            for (int i = 0; i < posRCl.size(); i++){
                if (posRCl.get(i) < posROp.get(posRCl.size() - i - 1)
                        || posRCl.get(i) - posROp.get(posRCl.size() - i - 1) == 2){
                    result = false;
                    break;
                }
            }
        }
        else result = false;
        return result;
    }
    public static boolean groupCheck1(String s){
        if(s.length()%2 != 0) return false;

        Stack<Character> closeStack = new Stack<Character>();
        for(char c : s.toCharArray()){
            switch(c){
                case '[': closeStack.push(']'); break;
                case '(': closeStack.push(')'); break;
                case '{': closeStack.push('}'); break;
                case ']': //fall through
                case ')': //fall through
                case '}':
                    if(closeStack.pop() != c) return false;
                default: break;
            }
        }
        return (closeStack.empty()) ? true : false;
    }
}
