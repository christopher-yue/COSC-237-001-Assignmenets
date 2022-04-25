import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class ArrayListClient {
    public static void main(String[] args){
        String fileName;
        int splitKey;
        String prompt;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the name of the file to be opened for the first list: ");
        fileName = in.next();
        list1 = read(fileName, in);
        System.out.print("Please input the name of the file to be opened for the second list: ");
        fileName = in.next();
        list2 = read(fileName, in);
        System.out.println("The first list is: ");
        print(list1);
        System.out.println("The second list is: ");
        print(list2);
        result = merge(list1, list2);
        System.out.println("The merged list is: ");
        print(result);
        prompt = "Enter the key for split: ";
        splitKey = getInt(in, prompt);
        split(list1, list2, result, splitKey);
        System.out.println("The first list after split is: ");
        print(list1);
        System.out.println("The second list after split is: ");
        print(list2);
        in.close();
    }
    public static ArrayList<Integer> read(String fileNameInput, Scanner in){
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean fileFound = false;
        String fileName = fileNameInput;
        while(!fileFound){
            File input = new File(fileName);
            Scanner read;
            try {
                read = new Scanner(input);
                while(read.hasNext()){
                    if(read.hasNextInt()){
                        list.add(read.nextInt());
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
    public static void print(ArrayList<Integer> list1){
        for(int i = 0; i < list1.size(); i++){
            System.out.printf("%4d", list1.get(i));
        }
        System.out.println();
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
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < list1.size(); i++){
            result.add(list1.get(i));
        }
        for(int i = 0; i < list2.size(); i++){
            result.add(list2.get(i));
        }
        bubblesort(result);
        return result;
    }
    public static void split(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3, int key){
        list1.clear();
        list2.clear();
        for(int i = 0; i < list3.size(); i++){
            if(list3.get(i) <= key){
                list1.add(list3.get(i));
            }
            else{
                list2.add(list3.get(i));
            }
        }
    }
    public static void bubblesort(ArrayList<Integer> list){
        Integer temp;
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j+1)){
                    temp = list.get(j);
                    list.set(j, list.get(j + 1) );
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
