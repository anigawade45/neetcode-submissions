class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long min = 0;
        long max = 0;
        
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        
        int answer = -1;
        
        while (min <= max) {
            long mid = min + (max - min) / 2;
            
            if (checkDays(weights, days, mid)) {
                answer = (int) mid;
                max = mid - 1; 
            } else {
                min = mid + 1; 
            }
        }
        
        return answer;
    }
    
    public static boolean checkDays(int[] arr, int days, long capacity) {
        int countDays = 1;
        long weightSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (weightSum + arr[i] > capacity) {
                countDays++;
                weightSum = arr[i];
            } else {
                weightSum += arr[i];
            }
        }
        
        return countDays <= days;
    }
}
