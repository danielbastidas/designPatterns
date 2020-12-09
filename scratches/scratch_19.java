import java.util.Stack;

class Scratch {
    public static void main(String[] args) {
        
    }

    static class MyQueue<Integer> {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public void enqueue(Integer value) {
            s1.push(value);
        }

        private void updateQueue() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }

        public Integer dequeue() {
            updateQueue();
            return s2.pop();
        }

        public Integer peek() {
            updateQueue();
            return s2.peek();
        }

    }
}