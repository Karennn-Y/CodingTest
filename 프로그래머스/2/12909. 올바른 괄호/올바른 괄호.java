import java.util.Stack;

class Solution {
    boolean solution(String s) {
//         Stack<String> box = new Stack<>();
        
//         if (s.startsWith(")"))
//             return false;
        
//         for (String str : s.split("")) {
//            if (str.equals(")") && box.peek().equals("(") && !box.isEmpty())
//                 box.pop();
//             else
//                 box.push(str);
//         }
//         return box.isEmpty();
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')') answer = false;

        for (int i = 0; i < s.length(); i++){
            if (!stack.isEmpty() && s.charAt(i) == ')') stack.pop();
            else stack.push(s.charAt(i));
        }


        if (!stack.isEmpty()) return answer = false;
        else return answer;
    }
}