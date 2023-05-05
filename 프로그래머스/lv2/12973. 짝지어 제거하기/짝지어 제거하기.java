import java.util.Stack;

class Solution {
    public int solution(String s) {
        char[] words = s.toCharArray();
        Stack<Character> check = new Stack<>();
        
        for (int i = 0; i < words.length; i++) {
            if (check.isEmpty()) {
                check.push(words[i]);
            } else {
                if (check.peek() == words[i]) {
                    check.pop();
                } else {
                    check.push(words[i]);
                }
            }
        }
        return (check.isEmpty()) ? 1 : 0;
    }
}