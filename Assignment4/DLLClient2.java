
public class Client_DLLString {
    public static void main(String[] args) {
    DoubleLinkedList<Integer>list_1 = new DoubleLinkedList<Integer>();
    DoubleLinkedList<Integer>list_2 = new DoubleLinkedList<Integer>();
    String item;
    list_1.insertNode(1);
    list_1.insertNode(2);
    list_1.insertNode(3);
    list_1.insertNode(4);
    list_1.insertNode(5);
    list_1.insertNode(6);
    list_1.insertNode(7);
    list_1.insertNode(8);
    list_1.insertNode(9);
    list_1.insertNode(10);
    list_1.insertNode(11);
    list_1.insertNode(12);
    list_1.insertNode(13);
    System.out.println("Inserted in first list the names: John, Ann, Paul, Joshua, Will, Emma, Peter, Linda, Joan, David, MIriam, Leah, Jane");
    System.out.println("(Testing toString) First list sorted is: " + list_1);
    System.out.println("(Testing recursive toString) First list sorted is: [head] - " + list_1.recursiveToString());
    System.out.println("(Testing backwards) First list reversed (print) is: " + list_1.backwardsString());
    System.out.print("(Testing recursive backwards) First list reversed (print) is: " + list_1.recursiveBackwardsString());
    System.out.println(" - [head]");
    System.out.println("Will copy in second list only names that don't start with J. List one destroyed.");
    while (!list_1.isEmptyList()) {
        item = list_1.front();
        list_1.deleteNode(item);
        if(item != 5)
            list_2.insertNode(item);
    }
    System.out.println("Second list should hold names that don't start with J (sorted): " + list_2);
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
