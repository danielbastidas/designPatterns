import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** How traversal of data structures happens and who makes it happen.
 * An object that facilitates the traversal of data structures
 * It is a behavioral pattern
 */
class Scratch {
    public static void main(String[] args) {
        Node<Character> e = new Node<>('e');
        Node<Character> f = new Node<>('f');
        Node<Character> d = new Node<>('d', e, f);
        Node<Character> b = new Node<>('b', d, null);
        Node<Character> c = new Node<>('c');
        Node<Character> a = new Node<>('a', b, c);

        Iterator<Node<Character>> iter = a.preOrder();
        while (iter.hasNext()) {
            System.out.print(iter.next().value+",");
        }
    }
}

class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        if (left != null) left.parent = this;
        if (right != null) right.parent = this;
    }

    public Iterator<Node<T>> preOrder()
    {
        List<Node<T>> preOrderList = new ArrayList<>();

        traverse(this, preOrderList);

        return preOrderList.iterator();
    }

    public void traverse(Node<T> node, List<Node<T>> preOrderedList) {
        preOrderedList.add(node);

        if (node.left != null) traverse(node.left, preOrderedList);
        if (node.right != null) traverse(node.right, preOrderedList);
        return;
    }
}