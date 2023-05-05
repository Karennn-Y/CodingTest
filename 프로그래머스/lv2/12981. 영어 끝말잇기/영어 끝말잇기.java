import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int count = 1;
        int number = 2;
        ArrayList<String> check = new ArrayList<>();
        check.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (number == n + 1) {
                count += 1;
                number = 1;
            }
            if(check.contains(words[i])) {
                return new int[]{number, count};
            }
            
            String before = words[i - 1];
            String start = Character.toString(words[i].charAt(0));
                                              
            if(!before.endsWith(start)) {
                return new int[]{number, count};
            }
            check.add(words[i]);
            number += 1;
        }
    
        return new int[]{0, 0};
    }
}