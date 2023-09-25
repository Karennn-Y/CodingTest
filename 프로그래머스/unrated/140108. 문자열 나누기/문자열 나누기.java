import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        ArrayList<String> words = new ArrayList<>();
        String[] arr = s.split("");
        String x = arr[0];
        int idx = 0;
        int same = 1;

        for (int i = 1; i < arr.length; i++) {
            if (same == 0) {
                words.add(s.substring(idx, i));
                x = arr[i];
                idx = i;
                same = 1;
            }
            else if (x.equals(arr[i]))
                same++;
            else if (!x.equals(arr[i]))
                same--;
        }
        
        words.add(s.substring(idx, arr.length));
        return words.size();
    }
}