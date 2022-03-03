import java.util.*;

public class Assignment1Pt2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char again;
        int size;
        String prompt;
        do{
            prompt = "Enter the size of the square matrix(positive & odd): ";
            size = getInt(in, prompt);
            while(size%2 == 0 || size < 0){
                System.out.println("Enter a positve odd integer!");
                size = getInt(in,prompt);
            }
            System.out.println("The square with size = " + size + " is: ");
            print(countingMatrix(size), size);
            System.out.println("The " + size + " x " + size + " square adds up to " + add(countingMatrix(size), size));
            
            System.out.println("Continue(Y/N)");
            again = getAgain(in);
        }while(again == 'Y' || again =='y');
    }

    //get integer value from user
    public static int getInt(Scanner in, String prompt){
        System.out.print(prompt);
        while(!in.hasNextInt()){
            in.next();
            System.out.println("Not an integer. Try again! ");
            System.out.print(prompt);
        }
        return in.nextInt();
    }

    //print matrix
    public static void print(int[][] matrix, int size){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.printf("%5s", matrix[row][col]);
            }
            System.out.println();
        }
    }

    //populate matrix
    public static int[][] countingMatrix(int size){
        int matrix[][] = new int[size][size];
        int num = 1;
        int row = 0;
        int col = size/2;
        while(num != (size * size) + 1){
            if(row < 0){
                row = size - 1;
            }
            if(col == size){
                col = 0;
            }
            if(matrix[row][col] != 0){
                if(row == (size - 1) && col == 0){
                    row = size - (size - 1);
                    col = size - 1;
                }
                else{
                    row+=2;
                    col--;
                }
            }
            matrix[row][col] = num;
            row--;
            col++;
            num++;
        }
        return matrix;
    } 

    //get sum of digonal because sum diagonal = sum rows = sum cols
    public static int add(int[][] matrix, int size){
        int sum = 0;
        sum = size * ((size * size) + 1)/2;
        return sum;
    }

    //get yes or no to continue from user
    public static char getAgain(Scanner in){
        char input = in.next().charAt(0);
        while(input != 'Y' && input != 'N' && input != 'y' && input != 'n'){
            System.out.println("Enter 'Y' for yes and 'N' for no");
            input = in.next().charAt(0);
        }
        return input;
    }
}   