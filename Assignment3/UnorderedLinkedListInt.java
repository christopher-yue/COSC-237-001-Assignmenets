//Class: UnorderedLinkedListInt extends
//Class: LinkedListIntClass
public class UnorderedLinkedListInt extends LinkedListIntClass {
    //Default constructor
    public UnorderedLinkedListInt() {
        super();
    }

    public boolean search(int searchItem)  {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null)
            if (current.info == searchItem)
                return true;
            else
               current = current.link;
        return false;
    }

    public void insertFirst(int newItem) {
        LinkedListNode newNode;  //variable to create the new node
        //create and insert newNode before first
        newNode = new LinkedListNode(newItem, first);
        first = newNode;
        if (last == null)
            last = newNode;
        count++;
    }

    public void insertLast(int newItem)  {
        LinkedListNode newNode; //variable to create the new node
        //create newNode
        newNode = new LinkedListNode(newItem, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        else {
            last.link = newNode;
            last = newNode;

        }
        count++;
    }

    public void deleteNode(int deleteItem) {
        LinkedListNode current; //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        boolean found;
        //Case 1; the list is empty
        if ( first == null)
            System.err.println("Cannot delete from an empty list.");
        else {
            //Case 2: the node to be deleted is first
            if (first.info == deleteItem) {
                first = first.link;
                if (first == null)  //the list had only one node
                    last = null;
                count--;
            }
            else {  //search the list for the given info
                found = false;
                trailCurrent = first; //trailCurrent points to first node
                current = first.link; //current points to second node
                while (current != null && !found) {
                    if (current.info == deleteItem)
                        found = true;
                    else {
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //Case 3; if found, delete the node
                if (found) {
                    count--;
                    trailCurrent.link = current.link;
                    if (last == current)  //node to be deleted was the last node
                       last = trailCurrent;
                }
                else
                   System.out.println("Item to be deleted is not in the list.");
            }
        }
    }
    //under construction
    public UnorderedLinkedListInt merge2(UnorderedLinkedListInt otherList){
        UnorderedLinkedListInt result = new UnorderedLinkedListInt();
        result.count = count + otherList.count;
        while(first != null){
            result.insertLast(first.info);
            first = first.link;
        }
        while(otherList.first != null){
            result.insertLast(otherList.first.info);
            otherList.first = otherList.first.link;
        }
        
        return result;
    }
    //under construction
    public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key){
        list1.first = null;
        list2.first = null;
        while(first.info <= key){
            list1.insertLast(first.info);
            first = first.link;
        }
        while(first != null){
            list2.insertLast(first.info);
            first = first.link;
        }
    }
}
/*
    public void print()  {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null) {//while more data to print
            System.out.print(current.info + " ");
            current = current.link;
        }
    }
*/