import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();
        StringBuilder sb = new StringBuilder();
        int current = 0;
        int[] scores = new int[3];
        int idx = 0;
        for (int i = 0 ; i < darts.length; i++) {
            switch (darts[i]) {
                case 'S' -> {
                    current = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
                case 'D' -> {
                    double num = Double.parseDouble(sb.toString());
                    current = (int) Math.pow(num, 2);
                    sb.setLength(0);
                }
                case 'T' -> {
                    double num = Double.parseDouble(sb.toString());
                    current = (int) Math.pow(num, 3);
                    sb.setLength(0);
                }
                case '*' -> {
                    if (i == darts.length - 1) {
                        scores[1] *= 2;
                        scores[2] = current * 2;
                        current = 0;
                    } else if (idx == 0) {
                        scores[0] = current * 2;
                        current = 0;
                        idx++;
                    } else {
                        scores[0] *= 2;
                        scores[1] = current * 2;
                        current = 0;
                        idx++;
                    }
                }
                case '#' -> {
                    scores[idx++] = (current * -1);
                    current = 0;
                }
                default -> {
                    if (current != 0) {
                        scores[idx++] = current;
                        current = 0;
                    }
                    sb.append(darts[i]);
                }
            }
        }
        if (current != 0)
            scores[2] = current;
        return Arrays.stream(scores).sum();
    }
}