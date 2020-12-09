import java.util.LinkedList;

class Scratch {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>() {{
            add(3); add(4); add(5);
            add(7); add(8);
        }};

        System.out.println(linkedList.pollLast());//8
        System.out.println(linkedList.pollLast());//7
        System.out.println(linkedList.pollFirst());//3
        System.out.println(linkedList.pollLast());//5
        System.out.println(linkedList.pollFirst());//4

    }
}