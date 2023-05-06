class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 0;
        int col = 0;
        int cntYellow = 0;
        int sum = brown + yellow;

        for (int i = 3; i <= sum / 2; i++) {
            if (sum % i == 0) {
                row = sum / i;
                col = i;
                cntYellow = (row - 2) * (col - 2);
                if (cntYellow == yellow) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{0, 0};
    }
}