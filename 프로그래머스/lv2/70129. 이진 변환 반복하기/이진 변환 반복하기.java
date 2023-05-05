class Solution {
    public int[] solution(String s) {
        
        int number = 0;
        int sum = 0;
        int count = 0;

        while (s.length() != 1) {
            number = s.replace("0", "").length();
            sum += (s.length() - number);
            s = Integer.toBinaryString(number);
            count++;
        }
        return new int[]{count, sum};
    }
}