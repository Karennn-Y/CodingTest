class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int nextCount = 0;
        while(count != nextCount) {
            n++;
            nextCount = Integer.bitCount(n);
        }
        return n;
    }
}