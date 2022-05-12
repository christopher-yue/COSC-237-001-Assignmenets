public class DoubleLinkedList<T> implements DoubleLinkedListADT<T>{
    //Double linked list node class
    public class DoubleLinkedListNode<T>{
        T info;
        DoubleLinkedListNode<T> next;
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode(){
            info = null;
            next = null;
            back = null;
        }

        public String toString(){
            return info.toString();
        }
    }
    protected int count; //number of nodes
    protected DoubleLinkedListNode<T> first; //reference to first node
    protected DoubleLinkedListNode<T> last; //reference to last node

    //initializes double linked list with nothing in it
    public void initializeList() {
        count = 0;
        first = null;
        last = null;
    }

    //checks if double linked list is empty
    public boolean isEmptyList() {
        return (first == null);
    }

    //returns the first value in double linked list
    public T front() {
        return first.info;
    }

    //returns last value in double linked list
    public T back() {
        return last.info;
    }

    //returns length of double linked list
    public int length() {
        return count;
    }

    //prints double linked list
    public void print() {
        DoubleLinkedListNode<T> temp = first;
        while(temp != null){
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
    }
    //prints double linked list in reverse order
    public void reversePrint() {
        DoubleLinkedListNode<T> temp = last;
        while(temp != null){
            System.out.print(temp.info + " ");
            temp = temp.back;
        }
    }
    //searches for item in double linked list
    public boolean search(T searchItem) {
        DoubleLinkedListNode<T> temp = first;
        while(temp != null){
            if(temp.info == searchItem){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    //inserts item into linked list
    public void insertNode(T insertItem){
        boolean found;
        DoubleLinkedListNode<T> current;//moving reference 
        DoubleLinkedListNode<T> trailCurrent = null; //just before current
        // Set up node to be inserted
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
        newNode.info = insertItem;
        newNode.next = null;
        newNode.back = null;
        //if the list is empty, newNode is the only node
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        }
        else {
            found = false;
            current = first;
            //search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(insertItem) >= 0)
                    found = true;
                else {
                    trailCurrent = current;
                    current = current.next;
                }
            } 
            //insert new node before first
            if (current == first) {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
                count++;
            }
            else {
                //insert newNode between trailCurrent and current
                if (current != null) {
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    newNode.next = current;
                    current.back = newNode;
                }
                else {
                    //insert new node after last
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    last = newNode;
                }
                count++;
            }
        }
    }
    //inserts item to end of double linked list
    public void insertLast(T newItem)  {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(); 
        newNode.info = newItem;
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        count++;
    }
    //removes item from double linked list
    public void deleteNode(T deleteItem) {
        DoubleLinkedListNode<T> current; //moving reference 
        DoubleLinkedListNode<T> trailCurrent;//just before current 
        boolean found;
        if (first == null)
            System.err.println("Cannot delete from an empty list.");
        //if node to be deleted is the first node
        else if (first.info.equals(deleteItem)) {
            current = first;
            first = first.next;
            if (first != null)
                first.back = null;
            else
                last = null;
            count--;
        }
        else {
            found = false;
            current = first;
            //search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(deleteItem) >= 0)
                    found = true;
                else
                    current = current.next;
            }
            if (current == null)
                System.out.println("The item to be deleted is not in the list.");
            else if (current.info.equals(deleteItem)) {
                trailCurrent = current.back;
                trailCurrent.next = current.next;
                if (current.next != null)
                    current.next.back = trailCurrent;
                if (current == last)
                    last = trailCurrent;
                count--;
            }
            else
                System.out.println("The item to be deleted is not in list.");
        }
    }

    //toString for list as is
    public String toString() {
        DoubleLinkedListNode<T> current = first;
        String output = "[head]";
        while(current != null) {
            output += " - " + current.info;
            current = current.next;
        }
        return output + " - [tail]";
    }

    //toString (recursive) for list as is
    public String recursiveToString() {
        DoubleLinkedListNode<T> current = first;
        return recursiveString(current);
    }
    //recursiveToString helper
    public String recursiveString(DoubleLinkedListNode<T> node){
        if(node == null)
            return "[tail]";
        else{
            return node.info.toString() + " - " + recursiveString(node.next);
        }
    }

    //toString for list in reverse order
    public String backwardsString() {
        DoubleLinkedListNode<T> current = last;
        String output = "[tail]";
        while(current != null) {
            output += " - " + current.info;
            current = current.back;
        }
        return output + " - [head]";
    }

    //toString (recursive) for list in reverse order
    public String recursiveBackwardsString() {
        DoubleLinkedListNode<T> current = last;
        return "[tail] - " + backwardsRecursiveString(current);
    }
    //recursiveBackwardsString helper
    public String backwardsRecursiveString(DoubleLinkedListNode<T> node){
        if(node == null){
            return "[head]";
        }
        else{
            return node.info.toString() + " - " + backwardsRecursiveString(node.back);
        }
    }

    //creates a copy of a double linked list
    public void copy(DoubleLinkedList<T> otherList) {
        first = otherList.first;
    }

    //creates a copy of a double linked list in reverse order
    public void reversedCopy(DoubleLinkedList<T> otherList) {
        first = null;
        DoubleLinkedListNode<T> current = otherList.last;
        while(current != null){
            insertLast(current.info);
            current = current.back;
        }
    }
}