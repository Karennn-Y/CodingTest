import java.util.Stack;

class Solution {
    public int check (String str) {
        char[] letters = str.toCharArray();
        Stack<Character> box = new Stack<>();
        
        for (char letter : letters) {
            if (box.isEmpty()) box.push(letter);
            else if (box.peek() == '(' && letter == ')') box.pop();
            else if (box.peek() == '{' && letter == '}') box.pop();
            else if (box.peek() == '[' && letter == ']') box.pop();
            else box.push(letter);
        }
        if (box.isEmpty()) return 1;
        return 0;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i) + s.substring(0, i);
            answer += check(str);
        }
        return answer;
    }
}