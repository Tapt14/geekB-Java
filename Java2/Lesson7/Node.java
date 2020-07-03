package Java2.Lesson7;

public class Node {

    private String val;
    private Node next;
    private Node previous;

    public Node(String val) {
        this.val = val;
    }

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(String val, Node next, Node previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

    public String getVal() {
        try {
            return val;
        }catch (Exception e) {
            return "null";
        }
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return getVal();
    }


}
