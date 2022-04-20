import java.util.Random;

public class Matrix {
    //data
    public final int MAX = 20;
    private int size;
    private int[][] table = new int[MAX][MAX];
    //default constructor
    public Matrix() {
        size = 0;
    }
    //alt constructor
    public Matrix(int s) {
        size = s;
    }
    //get the size of the matrix
    public int getSize() {
        return size;
    }
    //get a specific element in the matrix
    public int getElement(int r, int c) {
        if(r >= 0 && c >= 0 && r < MAX && c < MAX)
            return table[r][c];
        else
            return 0;
    }
    //set a sepcific element in the matrix to a particular value
    public void setElement(int r, int c, int value) {
        if(r >= 0 && c >= 0 && r < MAX && c < MAX)
            table[r][c] = value;
    }
    //initialize matrix with random numbers between a lower and upper limit
    public void init(int low, int up) {
        table = new int[size][size];
        Random rand = new Random();
        int randNum;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                randNum = rand.nextInt(up - low + 1) + low;
                table[row][col] = randNum;
            }
        }
    }
    //return sum of 2 matrices
    public Matrix add(Matrix a){
        Matrix sum = new Matrix(size);
        if(size == a.size){
            for(int row = 0; row < size; row++){
                for(int col = 0; col < size; col++){
                    sum.table[row][col] = table[row][col] + a.table[row][col];
                }
            }
        }
        return sum;
    }
    //return difference of 2 matrices
    public Matrix subtract(Matrix a) {
        Matrix difference = new Matrix(size);
        if(size == a.size){
            for(int row = 0; row < size; row++){
                for(int col = 0; col < size; col++){
                    difference.table[row][col] = table[row][col] - a.table[row][col];
                }
            }
        }
        return difference;
    }
    //return product of 2 matrices
    public Matrix multiply(Matrix a) {
        Matrix product = new Matrix(size);
        if(size == a.size){
            for(int row = 0; row < size; row++){
                for(int col = 0; col < size; col++){
                    for(int i = 0; i < size; i++){
                        product.table[row][col] += table[row][i] * a.table[i][col];
                    }
                }
            }
        }
        return product;
    }
    //check if matrices are equal
    public boolean equals(Matrix a){
        if(size != a.size)
            return false;
        else{
            for(int row = 0; row < size; row++){
                for(int col = 0; col < size; col++){
                    if(table[row][col] != a.table[row][col])
                        return false;
                }
            }
        }
        return true;
    }
    //return product of matrix multiplied by constant
    public Matrix multiplyConst(int whatConst) {
        Matrix product = new Matrix(size);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                product.table[row][col] = table[row][col] * whatConst;
            }
        }
        return product;
    }
    //return transposed matrix
    public Matrix transpose() {
        Matrix transposed = new Matrix(size);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                transposed.table[row][col] = table[col][row];
            }
        }
        return transposed;
    }
    //return trace of matrix
    public int trace(){
        int trace = 0;
        for(int row = 0; row < size; row++){
            trace += table[row][row];
        }
        return trace;
    }
    //print matrix
    public void print() {
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.printf("%5s", table[row][col]);
            }
            System.out.println();
        }
    }
    //create copy using matrix object
    public void copy(Matrix a){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                table[row][col] = a.table[row][col];
            }
        }
        size = a.size;
    }
    //get copy of matrix
    public Matrix getCopy(){
        Matrix copy = new Matrix(size);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                copy.table[row][col] = table[row][col];
            }
        }
        return copy;
    }
}