class Solution {
    public int solution(int n, int k) {
        if(n >= 10) {
            int free = n / 10;
            return (n * 12000) + (k * 2000) - (free * 2000);
        } 
        return (n * 12000) + (k * 2000);
    }
}