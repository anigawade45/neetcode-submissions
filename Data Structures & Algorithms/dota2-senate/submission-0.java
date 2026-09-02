class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                radiant.offerLast(i);
            else
                dire.offerLast(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.getFirst() > dire.getFirst()) {
                radiant.pollFirst();
                dire.offerLast(dire.pollFirst() + n);
            } else if (radiant.getFirst() < dire.getFirst()) {
                dire.pollFirst();
                radiant.offerLast(radiant.pollFirst() + n);
            }
        }

        return radiant.size() > 0 ? "Radiant" : "Dire";
    }
}