import java.util.*;

public class Client_DLLCalendar {
    public static void main(String[] args) {
        DoubleLinkedList<Date>list_1 = new DoubleLinkedList<Date>();
        DoubleLinkedList<Date>list_2 = new DoubleLinkedList<Date>();
        Calendar date = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        for(int i = 0; i <= 11; i++){
            date.set(Calendar.HOUR, i);
            list_1.insertNode(date.getTime());
        }
        System.out.println("(Testing toString) First list sorted is: " + list_1);
        System.out.println("(Testing recursive toString) First list sorted is: [head] - " + list_1.recursiveToString());
        System.out.println("(Testing backwards) First list reversed (print) is: " + list_1.backwardsString());
        System.out.print("(Testing recursive backwards) First list reversed (print) is: " + list_1.recursiveBackwardsString());
        System.out.println(" - [head]");
        System.out.println("Will copy in second list all values in first list. List one destroyed.");
        while(!list_1.isEmptyList()){
            list_2.insertNode(list_1.front());
            list_1.deleteNode(list_1.front());
        }
        System.out.println("Second list should hold the values that were in list 1 " + list_2);
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
