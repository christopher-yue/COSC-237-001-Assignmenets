import java.util.*;

public class Assignment1Pt2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char again = ' ';
        do{
            String prompt = "Enter the size of the square matrix(positive & odd): ";
            int size = getInt(in, prompt);
            while(size%2 == 0 || size < 0){
                if(size%2 == 0 && size < 0)
                    System.out.println("Enter a positve odd number!");
                else if(size %2 == 0)
                    System.out.println("Enter an odd number");
                else
                    System.out.println("Enter a positive number");
                size = getInt(in,prompt);
            }
            System.out.println("The square with size = " + size + " is: ");
            print(ocdMatrix(size), size);
            System.out.println("The " + size + " x " + size + "square adds up to " + add(ocdMatrix(size), size));
            
            System.out.println("Continue(Y/N)");
            again = in.next().charAt(0);
            again = again(again, in);
        }while(again == 'Y' || again =='y');
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
    public static void print(int[][] matrix, int size){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.printf("%5s", matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static int[][] ocdMatrix(int size){
        int matrix[][] = new int[size][size];
        int num = 1;
        int i = 0;
        int j = size/2;
        while(num != (size * size) + 1){
            if(i < 0){
                i = size - 1;
            }
            if(j == size){
                j = 0;
            }
            if(matrix[i][j] != 0){
                if(i == (size - 1) && j == 0){
                    i = size - (size - 1);
                    j = size - 1;
                }
                else{
                    i+=2;
                    j--;
                }
            }
            matrix[i][j] = num;
            i--;
            j++;
            num++;
        }
        return matrix;
    }
    public static int add(int[][] matrix, int size){
        int sum = 0;
        int row = 0;
        for(int col = 0; col < size; col++){
            sum += matrix[row][col];
        }
        
        return sum;
    }
    public static char again(char input, Scanner in){
        while(input != 'Y' && input != 'N' && input != 'y' && input != 'n'){
            System.out.println("(Y/y) = yes\n(N/n) = no");
            input = in.next().charAt(0);
        }
        return input;
    }
}   