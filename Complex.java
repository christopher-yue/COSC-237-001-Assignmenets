import java.util.Scanner;
public class Complex {
    private double real;
    private double imaginary;
    
    //default constructor
    public Complex(){
        real = 0;
        imaginary = 0;
    }
    //alt constructor
    public Complex(double r, double i){
        real = r;
        imaginary = i;
    }
    //get user input, convert it to string, create scanner with string as paramater, read the scanner for valid input, assing values to real and imaginary
    public void read(Scanner in, String prompt){
        double num;
        int count = 0;
        String input;

        System.out.print(prompt);
        
        if(in.hasNextLine()){
            input = in.nextLine();
            Scanner read = new Scanner(input);
            while(read.hasNext() && count != 2){
                if(read.hasNextDouble() && count == 0){
                    num = read.nextDouble();
                    real = (num >= 0) ? num : 0;
                    count++;
                }
                else if(count == 0){
                    real = 0;
                    if(read.hasNext())
                        read.next();
                    else
                        break;
                }
                if(read.hasNextDouble() && count == 1){
                    num = read.nextDouble();
                    imaginary = (num >= 0) ? num : 0;
                    count++;
                }
                else if(count == 1){
                    imaginary = 0;
                    if(read.hasNext())
                        read.next();
                    else
                        break;
                }
            }
            read.close();
        }
    }
    //print complex num
    public void print(){
        System.out.printf("(%.2f,%5.2f)", real , imaginary);
    }
    //convert complex num to string
    public String toString(){
        return String.format("(%.2f,%5.2f)", real, imaginary);
    }
    //return real part of complex num
    public double getReal(){
        return real;
    }
    //return imaginary part of complex num
    public double getImaginary(){
        return imaginary;
    }
    //return if complex nums are equal
    public boolean equals(Complex c){
        return (c.real == real && c.imaginary == imaginary);
    }
    //create copy using complex num object
    public void copy(Complex c){
        real = c.real;
        imaginary = c.imaginary;
    }
    //get copy of complex num
    public Complex getCopy(){
        return new Complex(real, imaginary);
    }
    //return sum of complex nums
    public Complex add(Complex c){
        return new Complex((real + c.real), (imaginary + c.imaginary));
    }
    //return difference of complex nums
    public Complex subtract(Complex c){
        return new Complex((real - c.real), (imaginary - c.imaginary));
    }
    //return product of complex nums
    public Complex multiply(Complex c){
        return new Complex((real * c.real) + ((imaginary * c.imaginary)*-1), (real * c.imaginary) + (imaginary * c.real));
    }
    //return quotient of complex nums
    public Complex divide(Complex c){
        return new Complex(((real * c.real) + (imaginary * c.imaginary))/((c.real * c.real) + (c.imaginary * c.imaginary)), ((imaginary * c.real) - (real * c.imaginary))/((c.real * c.real)+(c.imaginary * c.imaginary)));
    }
    //return absolute value of complex num
    public double cAbs(){
        return Math.sqrt((real * real) + (imaginary * imaginary));
    }
}
