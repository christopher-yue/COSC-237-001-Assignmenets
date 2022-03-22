import java.util.*;
public class ComplexNums {
    private double real;
    private double imaginary;
    
    public ComplexNums(){
        real = 0;
        imaginary = 0;
    }
    public ComplexNums(double r, double i){
        real = r;
        imaginary = i;
    }

    public void read(Scanner in, String prompt){
        double num;
        int count = 0;
        String input;

        System.out.print(prompt);
        
        if(in.hasNextLine()){
            input = in.nextLine();
            Scanner read = new Scanner(input);
            System.out.println(input);
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
    /*
    Possible user errors
        - entering non double values ✔
        - entering negative number(s) ✔
        - entering nothing ✔
        - only entering one number ✔
        - entering more than two values ✔
    */
    
    public void print(){
        System.out.printf("(%.2f,%5.2f)", real , imaginary);
    }
    public String toString(){
        return String.format("(%.2f,%5.2f)", real, imaginary);
    }

    public double getReal(){
        return real;
    }
    public double getImaginary(){
        return imaginary;
    }
    
    public boolean equals(ComplexNums c){
        return (c.real == real && c.imaginary == imaginary);
    }

    public void copy(ComplexNums c){
        real = c.real;
        imaginary = c.imaginary;
    }
    public ComplexNums getCopy(){
        return new ComplexNums(real, imaginary);
    }

    public String add(ComplexNums c){
        //(a + c) + (b + d)i
        return String.format("(%.2f,%5.2f)", (real + c.real), (imaginary + c.imaginary));
    }
    
    public String subtract(ComplexNums c){
        //(a + c) + (b - d)i
        return String.format("(%.2f,%5.2f)", (real + c.real), (imaginary + c.imaginary));
    }
    
    public String multiply(ComplexNums c){
         //(a * c) + (a * d) + (b * c) + (b * d)
        return String.format("(%.2f,%5.2f)", (real * c.real) + ((imaginary * c.imaginary)*-1), (real * c.imaginary) + (imaginary * c.real));
    }
   
    public String divide(ComplexNums c){
        //((ac + bd)/(c^2 + d^2)) + ((bc - ad)/(c^2 + d^2))i
        return String.format("(%.2f,%5.2f)", ((real * c.real) + (imaginary * c.imaginary))/((c.real * c.real) + (c.imaginary * c.imaginary)), ((imaginary * c.real) - (real * c.imaginary))/((c.real * c.real)+(c.imaginary * c.imaginary)));
    }
    
    public String cAbs(){
        //sqrt(a^2 + b^2)
        return String.format("%.2f", Math.sqrt((real * real) + (imaginary * imaginary)));
    }
    

}
