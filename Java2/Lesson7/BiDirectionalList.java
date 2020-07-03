package Java2.Lesson7;

public class BiDirectionalList implements DirectionalList {

    private Node first;

    public BiDirectionalList() {
    }

    public BiDirectionalList(Node[] array) {
        for (Node n : array) {
            add(n.getVal());
        }
    }

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null, null);
        } else {
            addNode(val, first);
        }
    }

    private void addNode(String val, Node current) {
        if (current.getNext() == null) {
            current.setNext(new Node(val, null, current));
        } else {
            addNode(val, current.getNext());
        }
    }

    @Override
    public boolean remove(String val) {
        if (first.getVal().equals(val)) {
            if (first.getNext() == null) {
                first = null;
            } else {
                first = first.getNext();
            }
            return true;
        }

        Node current = first.getNext();
        Node prev = first;

        while (current != null) {
            if (current.getVal().equals(val)) {
                prev.setNext(current.getNext());
                current.getNext().setPrevious(prev);
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }

        return false;
    }

    @Override
    public Object getFirst() {

        return first;
    }
}
