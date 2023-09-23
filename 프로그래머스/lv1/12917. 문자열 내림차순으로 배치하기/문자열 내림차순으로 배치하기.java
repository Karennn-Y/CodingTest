import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arrays = s.split("");
        Arrays.sort(arrays, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : arrays)
            sb.append(str);
        return sb.toString();
    }
}