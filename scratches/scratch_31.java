import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class Scratch {

    public class Node {
        public String text;
        AtomicInteger atomicInteger;

        public Node(String s, AtomicInteger atomicInteger) {
            this.text = s;
            this.atomicInteger = atomicInteger;
        }
    }

    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        Scratch scratch = new Scratch();

        scratch.testMethod();
        System.out.println("Done.");

    }

    public void testMethod() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();

        queue.offer(new Node("1", new AtomicInteger(2)));
        queue.offer(new Node("2", new AtomicInteger(2)));
        queue.offer(new Node("3", new AtomicInteger(2)));
        queue.offer(new Node("4", new AtomicInteger(2)));
        queue.offer(new Node("5", new AtomicInteger(2)));
        List<Future<String>> futures = new ArrayList<>();

        for (int i=0;i<10;i++) {
            Callable<String> pollTask = () -> {
                Node node = queue.peek();
                return onlyTwo(node, queue);
            };
            futures.add(executorService.submit(pollTask));
        }

        futures.parallelStream().forEach(integerFuture -> {
            try {
                System.out.println(integerFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

//        executorService.submit(pollTask);
        executorService.shutdown();
    }

    public String onlyTwo(Node node, ConcurrentLinkedQueue queue) {
        if (node.atomicInteger.decrementAndGet() == 1) {
            return node.text;
        } else if (node.atomicInteger.get() == 0) {
            queue.poll();
            return node.text;
        } else {
            return onlyTwo((Node) queue.peek(), queue);
        }
    }

}