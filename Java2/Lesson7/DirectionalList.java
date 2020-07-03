package Java2.Lesson7;

public interface DirectionalList {

    void add(String val);

    boolean remove(String val);

    Object getFirst();

    default int size() {
        if (getFirst() == null) {
            return 0;
        }

        int size = 1;

        Node current = (Node) getFirst();
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    ;

    default void printList() {
        if (getFirst() != null) {

            Node current = (Node) getFirst();
            Node next = current.getNext();

            while (true) {
                System.out.println(current);
                if (next != null) {
                    current = next;
                    next = current.getNext();
                } else {
                    break;
                }
            }

        } else {
            System.out.println(getClass().getSimpleName() + "is empty!");
        }
    }

}
