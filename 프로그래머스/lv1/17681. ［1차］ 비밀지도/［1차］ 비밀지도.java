class Solution {
    public String toBinary (int n, int num) {
        String binary = Integer.toBinaryString(num);
        if (binary.length() < n) {
            String zero = "0";
            return zero.repeat(n - binary.length()) + binary;
        }
        return binary;
    }

    public String[] solution (int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String binary1 = toBinary(n, arr1[i]);
            String binary2 = toBinary(n, arr2[i]);
            for (int j = 0; j < binary2.length(); j++) {
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1')
                    sb.append("#");
                else if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0')
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}