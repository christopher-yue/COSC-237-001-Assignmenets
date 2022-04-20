import java.io.*;
import java.util.*;
public class OrderedClient {
    public static void main(String[] args){
        String fileName;
        int splitKey;
        String prompt;
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the name of the file to be opened for the first list: ");
        fileName = in.next();
        OrderedArrayList list1 = read(fileName, in);
        System.out.print("Please input the name of the file to be opened for the second list: ");
        fileName = in.next();
        OrderedArrayList list2 = read(fileName, in);
        OrderedArrayList result = list1.merge(list2);
        System.out.println("The first list is: ");
        list1.print();
        System.out.println("The second list is: ");
        list2.print();
        System.out.println("The merged list is: ");
        result.print();
        prompt = "Enter the key for split: ";
        splitKey = getInt(in, prompt);
        result.split(list1, list2, splitKey);
        System.out.println("The first list after split is: ");
        list1.print();
        System.out.println("The second list after split is: ");
        list2.print();
        in.close();
    }
    public static OrderedArrayList read(String fileNameInput, Scanner in){
        OrderedArrayList list = new OrderedArrayList();
        boolean fileFound = false;
        String fileName = fileNameInput;
        while(!fileFound){
            File input = new File(fileName);
            Scanner read;
        
            try {
                read = new Scanner(input);
                int length = 0;
                while(read.hasNext()){
                    if(read.hasNextInt()){
                        list.list[length] = read.nextInt();
                        length++;
                        list.length = length;
                    }
                    else
                        read.next();
                }
                fileFound = true;
                read.close();
            } catch (FileNotFoundException e) {
                System.out.print("File not found! Enter a valid file name: ");
                fileName = in.next();
            }
        }
        return list;
    }
    public static int getInt(Scanner in, String prompt){
        System.out.print(prompt);
        while(!in.hasNextInt()){
            in.next();
            System.out.print("Not an integer. Try again! ");
            System.out.print(prompt);

        }
        return in.nextInt();
    }
}
