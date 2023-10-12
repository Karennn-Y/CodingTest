public static int[] solution (int[] score, int k) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> fame = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {
            fame.add(score[i]);
            if (fame.size() > k)
                fame.poll();
            answer[i] = fame.peek();
        }
        return answer;
  }
