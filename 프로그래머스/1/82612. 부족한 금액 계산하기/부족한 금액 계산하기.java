class Solution {
    public long solution(int price, int money, int count) {
        long payment = (long) (count * (count + 1)) / 2 * price;
        long answer = money - payment;
        return (answer < 0)? answer * -1 : 0;
    }
}