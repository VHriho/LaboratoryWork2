import java.util.*;

public class Immutable extends Matrix{
    private final int m;
    private final int n;
    private final int[][] arr;


    //zero dimension immutable matrix
    public Immutable() {
        this.m = 0;
        this.n = 0;
        this.arr = new int[m][n];
    }

    //self-made dimension immutable matrix
    public Immutable(int row, int colum){
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

    //immutable matrix from copy of mutable
    public Immutable(Matrix matrix) {
        this.m = matrix.takeRows();
        this.n = matrix.takeColums();
        this.arr = new int[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++)
                arr[i][j] = matrix.takeElem(i, j);
        }
    }

    //immutable matrix from copy of another immutable matrix
    public Immutable(Immutable immutable){
        this.m = immutable.takeRows();
        this.n = immutable.takeColums();
        this.arr = new int[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++)
                arr[i][j] = immutable.takeElem(i, j);
        }
    }

    //use for generating new immutable matrix
    public Immutable(int[][] arrMatrix){
        this.m = arrMatrix.length;
        this.n = arrMatrix[0].length;
        this.arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = arrMatrix[i][j];
        }
    }
    //method of returning immutable matrix
    public int[][] takeImmutable(){
        return arr;
    }

    //method for taking rows of immutable matrix
    public int takeRows(){
        return m;
    }

    //override method for taking columns of immutable matrix
    public int takeColums(){
        return n;
    }


    //override method for taking element of immutable matrix
    public int takeElem(int row, int colum){
        try{
            if(row < 0 || colum < 0 || row >= m || row >= n)
                throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println( e + ": Row and colum index must be in bound of matrix");
        }
        return arr[row][colum];
    }

    //fill immutable matrix random elements
    public Immutable fillImmutRandomElem(){
        int[][] newArr = new int[m][n];
        Random fillRandom = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i][j] = fillRandom.nextInt(10);
            }
        }
        return new Immutable(newArr);
    }

    //set element in immutable matrix
    public Immutable setImmutElem(int row, int colum, int elem){
        if(row < this.m && colum < this.n && row >= 0 && colum >= 0){
            int[][] newArr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++){
                    newArr[i][j] = arr[i][j];
                }
            }
            newArr[row][colum] = elem;
            return new Immutable(newArr);
        }
        else
            throw new RuntimeException("Index of Row and Colum must be in bound of matrix");
    }

    //fill immutable matrix with entered value
    public Immutable fillImmutElem () {
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
        }
        return new Immutable(inputArr);
    }

    public int[] takeRowImmut(int row) {
        try{
            return arr[row];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println( e + ": Row index is incorrect");
        }
        return arr[row];
    }

    public int[] takeColumImmut(int colum){
        if (colum < n && colum >= 0) {
            int[] columArr = new int[m];
            for (int i = 0; i < m; i++)
                columArr[i] = arr[i][colum];
            return columArr;
        }
        else
            throw new ArrayIndexOutOfBoundsException("Colum index is incorrect");
    }

    //dimension of immutable matrix
    public HashMap<String, Integer> takeImmutDimension(){
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
        Immutable newMatrix = (Immutable) matrix;
        return (this.m == newMatrix.m && this.n == newMatrix.n && Arrays.deepEquals(this.arr, newMatrix.arr));
    }

    //override hash code method
    public int hashCode() {
        int hash = Objects.hash(Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(takeElem(0, 0)), 31);
        return hash;
    }

    //single immutable matrix
    public static Immutable singleImmutMatrix(int row, int colum){
        if (row == colum) {
            Matrix matrix = Matrix.singleMatrix(3, 3);
            return new Immutable(matrix);
        }
        else
            throw new RuntimeException("Matrix should be square");
    }

    //transpose matrix
    public Immutable transposeImmutableMatrix() {
        int[][] transpose = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        return new Immutable(transpose);
    }

    //method for visualise immutable matrix
    public void outputMatrix () {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}