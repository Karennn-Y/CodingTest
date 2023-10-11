import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> score = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        int idx = 0;
        for (String[] p : photo) {
            int sum = 0;
            for (String n : p) {
                 sum += score.getOrDefault(n, 0);
            }
            answer[idx++] = sum;
        }
        
        return answer;
    }
}