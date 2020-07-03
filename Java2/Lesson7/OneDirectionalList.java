package Java2.Lesson7;

public class OneDirectionalList implements DirectionalList {
    private Node first;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null);
            return;
        }

        addNode(val, first);
    }

    private void addNode(String val, Node current) {
        if (current.getNext() == null) {
            current.setNext(new Node(val, null));
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
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }

        return false;
    }

    @Override
    public Node getFirst() {
        return first;
    }

}
