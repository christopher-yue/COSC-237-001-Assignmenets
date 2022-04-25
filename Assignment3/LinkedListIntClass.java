//Class: LinkedListIntClass implements
//Interface: LinkedListIntADT
//import java.util.*;
public abstract class LinkedListIntClass implements LinkedListIntADT {
    protected class LinkedListNode {
        public int info;
        public LinkedListNode link;
        //Default constructor
        public LinkedListNode() {
            info = 0;
            link = null;
        }

        //Alternate constructor
        public LinkedListNode(int elem, LinkedListNode ptr) {
            info = elem;
            link = ptr;
        }
    } //end class LinkedListNode

    //Instance variables of the class LinkedListIntClass
    protected LinkedListNode first; //address of the first node/list
    protected LinkedListNode last;  //address of the last node/list
    protected int count;  //number of nodes in the list

    //Default constructor
    public LinkedListIntClass() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmptyList() {
        return (first == null);
    }

    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    public void print()  {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null) {//while more data to print
            System.out.print(current.info + " ");
            current = current.link;
        }
    }

    public int length() {
        return count;
    }

    public int front()   {
        return first.info;
    }

    public int back()  {
        return last.info;
    }

    public abstract boolean search(int searchItem);
    public abstract void insertFirst(int newItem);
    public abstract void insertLast(int newItem);
    public abstract void deleteNode(int deleteItem);
}