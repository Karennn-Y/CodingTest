import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public String solution(String s) {
        String answer = "";

        int[] splits = Stream.of(s.split(" "))
            .mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(splits);

        answer = String.valueOf(splits[0]) + " " + String.valueOf(splits[splits.length - 1]);
        return answer;
    }
}