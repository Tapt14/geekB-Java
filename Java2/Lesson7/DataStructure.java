package Java2.Lesson7;

public class DataStructure {
    public static void main(String[] args) {

        System.out.println("\nOnedirectionalList");

        DirectionalList directionalList = new OneDirectionalList();
        directionalList.add("val1");
        directionalList.add("val2");
        directionalList.add("val3");
        directionalList.add("val4");

        Node first = (Node) directionalList.getFirst();

        System.out.println(first);
        System.out.println(first.getNext());
        System.out.println(first.getNext().getNext());
        System.out.println(first.getNext().getNext().getNext());
        System.out.println(first.getNext().getNext().getNext().getNext());

        System.out.println("\nSize: " + directionalList.size());

        System.out.println("\nRemoved? - " + directionalList.remove("val6"));
        System.out.println("Removed? - " + directionalList.remove("val3"));
        System.out.println();

        directionalList.printList();

        System.out.println("\nBidirectionalList");


        DirectionalList directionalList2 = new BiDirectionalList();
        directionalList2.add("val21");
        directionalList2.add("val22");
        directionalList2.add("val23");
        directionalList2.add("val24");

        Node second = (Node) directionalList2.getFirst();

        System.out.println(second.getPrevious());
        System.out.println(second);
        System.out.println(second.getNext());
        System.out.println(second.getNext().getNext().getNext().getPrevious());
        System.out.println(second.getNext().getNext().getNext());
        System.out.println(second.getNext().getNext().getNext().getNext());

        System.out.println("\nSize: " + directionalList2.size());

        System.out.println("\nRemoved? - " + directionalList2.remove("val26"));
        System.out.println("Removed? - " + directionalList2.remove("val23"));
        System.out.println();

        directionalList2.printList();

        System.out.println("\nTask3");

        Node[] arrayNode = {new Node("val31"), new Node("val32"),new Node("val33"),new Node("val34") };

        DirectionalList directionalList3 = new BiDirectionalList(arrayNode);
        directionalList3.printList();

        System.out.println();
        DirectionalList directionalList4 = new BiDirectionalList();
        directionalList4.printList();

        System.out.println();
        DirectionalList directionalList5 = new OneDirectionalList();
        directionalList5.printList();

    }
}
