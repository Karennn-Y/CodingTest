import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int idx = numbers.length;
        return numbers[idx - 1] * numbers[idx - 2];
    }
}