import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            // 아스키 코드 값에 해당하는 거 넣기
            alphabet.add((char) ('a' + i));
        }
        
        for (Character c : skip.toCharArray())
            alphabet.remove(c);
        
        StringBuilder sb = new StringBuilder();
        
        for (Character c : s.toCharArray()) {
            int idx = alphabet.indexOf(c);
            idx = (idx + index) % alphabet.size(); // 인덱스 값이 넘어갈 수 있으니깐..
            sb.append(alphabet.get(idx));
        }
        return sb.toString();
    }
}