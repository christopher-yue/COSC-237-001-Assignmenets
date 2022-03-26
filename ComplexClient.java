import java.util.Scanner;
public class ComplexClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Scanner cnum = new Scanner(System.in);
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        int choice;
        int num = 0;
        String prompt;

        menu();
        prompt = "Please enter your option: ";
        choice = getInt(in, prompt);

        while(choice != 0){
            num++;
            prompt = "Enter a complex number(real imaginary)";

            switch(choice){
                case 0:
                    break;
                case 1:
                    c1.read(cnum, prompt);
                    c2.read(cnum,prompt);
                    System.out.println("c1 = " + c1.toString());
                    System.out.println("c2 = " + c2.toString());
                    System.out.println("Result: " + c1.toString() + " + " + c2.toString() + " = " + c1.add(c2).toString());
                    break;
                case 2:
                    c1.read(cnum, prompt);
                    c2.read(cnum,prompt);
                    System.out.println("First complex number is " + c1.toString());
                    System.out.println("Second complex number is " + c2.toString());
                    System.out.println("Result: " + c1.toString() + " - " + c2.toString() + " = " + c1.subtract(c2).toString());
                    break;
                case 3:
                    c1.read(cnum, prompt);
                    c2.read(cnum,prompt);
                    System.out.println("First complex number is " + c1.toString());
                    System.out.println("Second complex number is " + c2.toString());
                    System.out.println("Result: " + c1.toString() + " * " + c2.toString() + " = " + c1.multiply(c2).toString());
                    break;
                case 4:
                    c1.read(cnum, prompt);
                    c2.read(cnum,prompt);
                    System.out.println("First complex number is " + c1.toString());
                    System.out.println("Second complex number is " + c2.toString());
                    System.out.println("Result: " + c1.toString() + " / " + c2.toString() + " = " + c1.divide(c2).toString());
                    break;
                case 5:
                    c1.read(cnum, prompt);
                    System.out.println("The complex number is " + c1.toString());
                    System.out.println("Result: |" + c1.toString() + "| = " + c1.cAbs());
                    break;
                case 6:
                    c1.read(cnum, prompt);
                    c2.read(cnum,prompt);
                    System.out.println("First complex number is " + c1.toString());
                    System.out.println("Second complex number is " + c2.toString());
                    if(c1.equals(c2))
                        System.out.println("The complex numbers are equal");
                    else
                        System.out.println("The complex numbers are NOT equal");
                    break;
                default:
                    System.out.println("Enter an option from 0-6");
            }
            System.out.printf("%30s%n%n", "Command number " + num + " completed.");
            menu();
            prompt = "Please enter your option: ";
            choice = getInt(in, prompt);
        }
        in.close();
        System.out.printf("%20s","Testing completed");
    }
    //print menu
    public static void menu(){
        System.out.printf("%s%n", "Your options for Complex arithmetic are:");
        System.out.printf("%s%n", "----------------------------------------");
        System.out.printf("%s%n", "1) Add 2 complex numbers");
        System.out.printf("%s%n", "2) Subtract 2 complex numbers");
        System.out.printf("%s%n", "3) Multiply 2 complex numbers");
        System.out.printf("%s%n", "4) Divide 2 complex numbers");
        System.out.printf("%s%n", "5) Absolute value of a complex number");
        System.out.printf("%s%n", "6) Compare 2 complex numbers");
        System.out.printf("%s%n", "0) EXIT");
    }
    //get integer value from user
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