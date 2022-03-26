import java.util.Scanner;

public class MatrixClient {
    public static final int MAX = 20;
    public static final int LOW = 1;
    public static final int UP = 10;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCommands = 0;
        int size;
        int value;
        int tr;
        int choice;
        String prompt = "Enter the size of the square matrix: ";

        size = getInt(input, prompt);
        while(size < 0 || size > 20){
            System.out.println("INPUT ERROR!!! Invalid size. Positive and <= 20.");
            size = getInt(input, prompt);
        }

        Matrix first = new Matrix(size);
        Matrix second = new Matrix(size);
        Matrix result = new Matrix(size);

        menu();
        prompt = "Please enter your option:";
        choice = getInt(input, prompt);
        while(choice != 0){
            numCommands++;
            switch(choice){
                case 0:
                    break;
                case 1:
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    result = first.add(second);
                    System.out.println("The resulting matrix is:");
                    result.print();
                    break;
                case 2:
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    result = first.subtract(second);
                    System.out.println("The resulting matrix is:");
                    result.print();
                    break;
                case 3:
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    result = first.multiply(second);
                    System.out.println("The resulting matrix is:");
                    result.print();
                    break;
                case 4:
                    prompt = "Enter the multiplication constant: ";
                    value = getInt(input, prompt);
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    result = first.multiplyConst(value);
                    System.out.println("The resulting matrix is:");
                    result.print();
                    break;
                case 5:
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    result = first.transpose();
                    System.out.println("The resulting matrix is:");
                    result.print();
                    break;
                case 6:
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    tr = first.trace();
                    System.out.println("The trace for this matrix is: " + tr);
                    break;
                case 7:
                    first.init(LOW, UP);
                    System.out.println("The original matrix is:");
                    first.print();
                    result.copy(first);
                    System.out.println("The copy of this matrix is:");
                    result.print();
                    System.out.println("Testing for equality. Should be equal!!");
                    if(first.equals(result))
                        System.out.println("The matrices are equal!!");
                    else
                        System.out.println("Your program is a failure");//remove this later?
                    break;
                case 8:
                    first.init(LOW, UP);
                    second.init(LOW, UP);
                    System.out.println("First matrix is:");
                    first.print();
                    System.out.println("Second matrix is:");
                    second.print();
                    if(first.equals(second))
                        System.out.println("The matrices are equal!!");
                    else
                        System.out.println("The matrices are NOT equal!!");
                    break;
                default:
                    System.out.println("Enter an option from 0-8");
                    break;
            }
            System.out.printf("%30s%n%n", "Command number " + numCommands + " completed.");
            menu();
            prompt = "Please enter your option:";
            choice = getInt(input, prompt);
        }
        input.close();
        System.out.printf("%20s","Testing completed");
    }
    public static void menu(){
        System.out.printf("%s%n", "Your options are:");
        System.out.printf("%s%n", "-----------------");
        System.out.printf("%s%n", "1) Add 2 matrices");
        System.out.printf("%s%n", "2) Subtract 2 matrices");
        System.out.printf("%s%n", "3) Multiply 2 matrices");
        System.out.printf("%s%n", "4) Multiply matrix by a constant");
        System.out.printf("%s%n", "5) Transpose matrix");
        System.out.printf("%s%n", "6) Matrix trace");
        System.out.printf("%s%n", "7) Make a copy");
        System.out.printf("%s%n", "8) Test for equality");
        System.out.printf("%s%n", "0) EXIT");
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
