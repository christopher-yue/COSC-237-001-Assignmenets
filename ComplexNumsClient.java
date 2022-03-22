//import java.util.*;
public class ComplexNumsClient {
    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);
        String prompt = "Enter num(real imaginary): ";*/
        ComplexNums c1 = new ComplexNums(11.1, 22.2);
        //ComplexNums c2 = new ComplexNums(1.45, 3.56);
        System.out.println(c1.cAbs());
    }
}
