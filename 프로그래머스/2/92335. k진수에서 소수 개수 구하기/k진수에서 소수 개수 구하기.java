class Solution {
    public int solution(int n, int k) {
        String[] numbers = getNumber(n, k).split("0");
        int answer = 0;

        for (String number : numbers) {
            if(number.equals(""))
                continue;
            answer += isPrime(Long.parseLong(number));
        }
        return answer;
    }
    
    public String getNumber (int n, int k) {
        if (k == 10)
            return Integer.toString(n);

        return Integer.toString(n, k);
    }

    public int isPrime(long num) {
        if (num < 2)
            return 0;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}