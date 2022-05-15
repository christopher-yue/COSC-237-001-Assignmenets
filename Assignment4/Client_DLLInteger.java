public class Client_DLLInteger {
    public static void main(String[] args) {
        DoubleLinkedList<Integer>list_1 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer>list_2 = new DoubleLinkedList<Integer>();
        int item;
        list_1.insertNode(1);
        list_1.insertNode(27);
        list_1.insertNode(1);
        list_1.insertNode(12);
        list_1.insertNode(1);
        list_1.insertNode(35);
        list_1.insertNode(1);
        list_1.insertNode(5);
        list_1.insertNode(1);
        list_1.insertNode(80);
        list_1.insertNode(1);
        list_1.insertNode(25);
        list_1.insertNode(1);
        System.out.println("Inserted in first list the numbers: 1, 27, 1, 12, 1, 35, 1, 5, 1, 80, 1, 25, 1");
        System.out.println("(Testing toString) First list sorted is: " + list_1);
        System.out.println("(Testing recursive toString) First list sorted is: [head] - " + list_1.recursiveToString());
        System.out.println("(Testing backwards) First list reversed (print) is: " + list_1.backwardsString());
        System.out.print("(Testing recursive backwards) First list reversed (print) is: " + list_1.recursiveBackwardsString());
        System.out.println(" - [head]");
        System.out.println("Will copy in second list only numbers that are not 1. List one destroyed.");
        while (!list_1.isEmptyList()) {
            item = list_1.front();
            list_1.deleteNode(item);
            if(item != 1)
                list_2.insertNode(item);
        }
        System.out.println("Second list should hold numbers that are not 1 " + list_2);
        System.out.println("First list should be empty. Nothing printed. ");
        list_1.print();
        System.out.print("(Testing equals) ");
        if(list_1.equals(list_2))
            System.out.println("The 2 lists are equals");
        else
            System.out.println("The 2 lists are NOT equals");
        System.out.print("(Testing copy) ");
        list_1.copy(list_2);
        System.out.println("First list after copy is: " + list_1);
        System.out.print("(Testing reversed copy) ");
        list_1.reversedCopy(list_2);
        System.out.println("Reversed copy of the second list is: " + list_1);
    }
}