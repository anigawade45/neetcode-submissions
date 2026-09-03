class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new ArrayDeque<>();
        Deque<Integer> sandwich = new ArrayDeque<>();
        int len = students.length;

        for(int i=0;i<len;i++) {
            student.offer(students[i]);
            sandwich.push(sandwiches[len-i-1]);
        }

        int lastServed = 0;

        while(student.size() > 0 && student.size() > lastServed) {
            if(student.peek() == sandwich.peek()) {
                student.poll();
                sandwich.pop();
                lastServed = 0;
            } else {
                student.offer(student.poll());
                lastServed++;
            }
        }

        return student.size();
    }
}