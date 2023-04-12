import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] array, int n) {
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        return Collections.frequency(arrayList, n);
    }
}