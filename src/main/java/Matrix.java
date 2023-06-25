import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;
import java.util.Objects;

public class Matrix {

    private final int m;
    private final int n;
    private final int[][] arr;

    //zero dimension matrix
    public Matrix() {
        this.m = 0;
        this.n = 0;
        this.arr = new int[m][n];
    }

    //self-made dimension of matrix
    public Matrix(int row, int colum) {
        try{
            if (row < 0 || colum < 0)
                throw new NegativeArraySizeException();
        }
        catch (NegativeArraySizeException e){
                System.out.println( e + ": Row or colum value cannot be less then 0");
        }
        this.m = row;
        this.n = colum;
        this.arr = new int[m][n];
    }

    //make copy of given matrix
    public Matrix(Matrix matrix){
        this.m = matrix.takeRows();
        this.n = matrix.takeColums();
        this.arr = new int[this.m][this.n];
        for (int i = 0; i < this.m; i++){
            for (int j = 0; j < this.n; j++)
                arr[i][j] = matrix.takeElem(i,j);
        }
    }

    //fill random element in matrix
    public void fillRandomElem() {
        Random fillRandom = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = fillRandom.nextInt(10);
        }
    }

    //fill with entered value
    public void fillElem () {
        Scanner input = new Scanner(System.in);
        int[][] inputArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter integer value of [" + i + "," + j + "] element of matrix: ");
                while(!input.hasNextInt()){
                    System.out.print("Invalid enter, try one more: ");
                    input.next();
                }
                inputArr[i][j] = input.nextInt();
            }
            System.arraycopy(inputArr[i], 0, arr[i], 0, m);
        }
    }

    //set element into matrix
    public void setElem(int row, int colum, int elem){
        if(row < this.m && colum < this.n && row >= 0 && colum >= 0)
            arr[row][colum] = elem;
        else
            throw new RuntimeException("Row and colum index must be in bound of matrix");
    }

    //method for returning matrix
    public int[][] takeMatrix(){
        return arr;
    }

    //return row of matrix
    public int takeRows(){
        return m;
    }

    //return vector == row which index was entered of
    public int[] takeRow(int row) {
        try{
            return arr[row];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println( e + ": Row index is incorrect");
        }
        return arr[row];
    }

    //return colum of matrix
    public int takeColums(){
        return n;
    }

    //return vector == colum which index was entered of
    public int[] takeColum(int colum){
        if (colum < n && colum >= 0) {
            int[] columArr = new int[m];
            for (int i = 0; i < m; i++)
                columArr[i] = arr[i][colum];
            return columArr;
        }
        else
            throw new ArrayIndexOutOfBoundsException("Colum index is incorrect");
    }



    //take element of matrix by row and colum index value
    public int takeElem(int row, int colum){
        try{
            if(row < 0 || colum < 0 || row >= m || row >= n)
                throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println( e + ": Row and colum index must be in bound of matrix");
        }
        return arr[row][colum];
    }

    //dimension of matrix
    public HashMap<String, Integer> takeDimension(){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Rows", this.takeRows());
        map.put("Columns", this.takeColums());
        return map;
    }

    //override equals method
    public boolean equals(Object matrix) {
        if (this == matrix)
            return true;
        if (getClass() != matrix.getClass())
            return false;
        Matrix newMatrix = (Matrix) matrix;
        return (this.m == newMatrix.m && this.n == newMatrix.n && Arrays.deepEquals(this.arr, newMatrix.arr));
    }

    //override hash code method
    public int hashCode() {
        int hash = Objects.hash(Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(takeElem(0, 0)), 31);
        return hash;
    }

    //static method of single matrix
    public static Matrix singleMatrix(int row, int colum) {
        Matrix singleMatrix = new Matrix(row, colum);
        if (row == colum) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colum; j++) {
                    if (i < j || i > j)
                        singleMatrix.arr[i][j] = 0;
                    else
                        singleMatrix.arr[i][j] = 1;
                }
            }
        }
        else
            throw new RuntimeException("Matrix should be square");
        return singleMatrix;
    }

    public Matrix transposeMatrix(){
        Matrix transpose = new Matrix(m ,n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 transpose.arr[j][i] = arr[i][j];
            }
        }
        return transpose;
    }

    //visualise matrix
    public void outputMatrix () {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
