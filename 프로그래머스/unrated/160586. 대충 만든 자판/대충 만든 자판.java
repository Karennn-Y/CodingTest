import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answers = new int[targets.length];
        HashMap<String, Integer> keys = new HashMap<>();

        for (String k : keymap) {
            String[] arr = k.split("");
            for (int i = 0; i < arr.length; i++) {
                String str = arr[i];
                if (keys.containsKey(str)) keys.put(str, Math.min(keys.get(str), i + 1));
                else keys.put(str, i + 1);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (String s : targets[i].split("")) {
                if (keys.containsKey(s))
                    count += keys.get(s);
                else {
                    count = -1;
                    break;
                }
            }
            answers[i] = count;
        }
        return answers;
    }
}