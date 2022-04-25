//Class: UnorderedArrayList extends
//Super class: ArrayListClass
public class UnorderedArrayList extends ArrayListClass {
   
    public UnorderedArrayList() {
        super();
    }

    public UnorderedArrayList(int size) {
        super(size);
    }

    //Bubble Sort
    public void bubbleSort() {
     for (int pass = 0; pass < length - 1; pass++) {
         for (int i = 0; i < length - 1; i++) {
             if (list[i] > list[i + 1]) {
                 int temp = list[i];
                 list[i] = list[i + 1];
                 list[i + 1] = temp;
             }
         }
     }
    }

    //implementation for abstract methods defined in ArrayListClass
    //unordered list --> linear search
    public int search(int searchItem) {
        for(int i = 0; i < length; i++)
            if(list[i] == searchItem)
                return i;
        return -1;
    }

    public void insertAt(int location, int insertItem) {
        if (location < 0 || location >= maxSize)
            System.err.println("The position of the item to be inserted is out of range.");
        else if (length >= maxSize)
            System.err.println("Cannot insert in a full list.");
        else {
            for (int i = length; i > location; i--)
                list[i] = list[i - 1];  //shift right
            list[location] = insertItem;
            length++;
        }
    }

    public void insertEnd(int insertItem) {
        if (length >= maxSize)
            System.err.println("Cannot insert in a full list.");
        else {
            list[length] = insertItem;
            length++;
        }
    }

    public void replaceAt(int location, int repItem)  {
        if (location < 0 || location >= length)
            System.err.println("The location of the item to be replaced is out of range.");
        else
            list[location] = repItem;
    }

    public void remove(int removeItem) {
        int i;
        if (length == 0)
            System.err.println("Cannot delete from an empty list.");
        else {
            i = search(removeItem);
            if (i != -1)
                removeAt(i);
            else
                System.out.println("Cannot delete! The item to be deleted is not in the list.");
        }
    }
    //adds info in original list and list2 into new unordered array list result
    public UnorderedArrayList merge(UnorderedArrayList list2){
        UnorderedArrayList result = new UnorderedArrayList(length + list2.length);
        for(int i = 0; i < length; i++){
            result.list[i] = list[i];
            result.length++;
        }
        for(int j = 0; j < list2.length; j++){
            result.list[length + j] = list2.list[j];
            result.length++;
        }
        return result;
    }
    //adds info in original list into list1 and list2
    //integers <= key go into list1
    //integers > key go into list2
    public void split(UnorderedArrayList list1, UnorderedArrayList list2, int key){
        list1.clearList();
        list2.clearList();
        int l1Counter = 0;
        int l2Counter = 0;
        for(int i = 0; i < length; i++){
            if(list[i] <= key){
                list1.list[l1Counter] = list[i];
                list1.length++;
                l1Counter++;
            }
            else{
                list2.list[l2Counter] = list[i];
                list2.length++;
                l2Counter++;
            }
        }
    }
}

