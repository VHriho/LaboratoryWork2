import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void constructorOfEmptyMatrix() {
        System.out.println("\n--Test of empty matrix--");
        Matrix matrix = new Matrix();
    }

    @Test
    void constructorOfSelfMadeMatrix() {
        System.out.println("\n--Test of self-made matrix--");
        Matrix matrix = new Matrix(3,3);
        System.out.println(matrix);
        try {
            Matrix newMatrix = new Matrix(-1,3);
            Matrix anoNewMatrix = new Matrix(3,-2);
        }catch (NegativeArraySizeException e){
            System.out.println( e + ": Row or colum value cannot be less then 0");
        }
    }

    @Test
    void constructorOfCopyMatrix() {
        System.out.println("\n--Test of copy matrix--");
        Matrix matrix = new Matrix(3,3);
        matrix.fillRandomElem();
        Matrix newMatrix = new Matrix(matrix);
        matrix.outputMatrix();
        System.out.println("-----");
        newMatrix.outputMatrix();
        System.out.println(matrix + " " + newMatrix);
        assertEquals(matrix, newMatrix);
    }

    @Test
    void fillRandomElemToMatrix() {
        System.out.println("\n--Test of fill random elem into matrix--");
        Matrix matrix = new Matrix(3, 3);
        matrix.fillRandomElem();
        Matrix newMatrix = new Matrix(2,2);
        newMatrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("-----");
        newMatrix.outputMatrix();
        System.out.println(matrix + " " + newMatrix);
    }

    @Test
    void setElemToMatrix() {
        System.out.println("\n--Test of set random elem into matrix--");
        Matrix matrix = new Matrix(3, 3);
        matrix.fillRandomElem();
        Matrix newMatrix = new Matrix(2,2);
        newMatrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("-----");
        newMatrix.outputMatrix();
        matrix.setElem(1,1,0);
        newMatrix.setElem(0,0,19);
        System.out.println("-----");
        matrix.outputMatrix();
        System.out.println("-----");
        newMatrix.outputMatrix();
        System.out.println(matrix + " " + newMatrix);
        try{
            matrix.setElem(-1,2,2);
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    @Test
    void takeElemOfMatrix() {
        try{
            System.out.println("\n--Test of taking elem of matrix--");
            Matrix matrix = new Matrix(3, 3);
            matrix.fillRandomElem(); //random fill
            Matrix newMatrix = new Matrix(2,2);
            newMatrix.fillRandomElem();
            matrix.outputMatrix();
            System.out.println("-----");
            newMatrix.outputMatrix();
            System.out.println(matrix + " " + newMatrix);
            System.out.println("Elem[0;0]: " + matrix.takeElem(0,0));
            System.out.println("Elem[1;1]: " +newMatrix.takeElem(1,1));
            matrix.takeElem(1,4);
            newMatrix.takeElem(-1, 4);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println( e + ": Row and colum index must be in bound of matrix");
        }
    }

    @Test
    void takeRowOfMatrix() {
            System.out.println("\n--Test of taking Row of matrix--");
            Matrix matrix = new Matrix(3, 3);
            matrix.fillRandomElem(); //random fill
            matrix.outputMatrix();
            System.out.print("Row 0: ");
            for(int i = 0; i < matrix.takeRow(0).length; i ++)
                System.out.print(matrix.takeRow(0)[i] + " ");
            System.out.println();
        try{
            System.out.print("Row -1: ");
            matrix.takeRow(-1);
        } catch (ArrayIndexOutOfBoundsException e){}
    }

    @Test
    void takeColumOfMatrix() {
        System.out.println("\n--Test of taking Colum of matrix--");
        Matrix matrix = new Matrix(3, 3);
        matrix.fillRandomElem(); //random fill
        matrix.outputMatrix();
        System.out.print("Colum 0: ");
        for(int i = 0; i < matrix.takeColum(0).length; i ++)
            System.out.print(matrix.takeColum(0)[i] + " ");
        System.out.println();
        try{
            System.out.print("Colum -1: ");
            matrix.takeColum(-1);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    @Test
    void takeDimensionOfMatrix(){
        System.out.println("--Test of dimension--");
        Matrix matrix = new Matrix(3,3);
        matrix.takeDimension().forEach((key, value) -> System.out.println(key + " : " +  value));
    }

    @Test
    void equalsMethod(){
        System.out.println("\n--Test of equals--");
        Matrix matrix = new Matrix(3,3);
        matrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("-----");
        Matrix newMatrix = new Matrix(matrix);
        newMatrix.outputMatrix();
        System.out.println("Is equal: " + newMatrix.equals(matrix));
        System.out.println("-----");
        newMatrix.fillRandomElem();
        newMatrix.outputMatrix();
        System.out.println("Is equal: " + newMatrix.equals(matrix));

    }

    @Test
    void hashCodeMethod(){
        System.out.println("\n--Test of hashCode--");
        Matrix matrix = new Matrix(3,3);
        matrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("HashCode: " + matrix.hashCode());
        System.out.println("-----");
        Matrix newMatrix = new Matrix(matrix);
        newMatrix.outputMatrix();
        System.out.println("HashCode: " + newMatrix.hashCode());
        System.out.println("-----");
        matrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("HashCode: " + matrix.hashCode());
        System.out.println("-----");
        newMatrix.fillRandomElem();
        newMatrix.outputMatrix();
        System.out.println("HashCode: " + newMatrix.hashCode());
    }

    @Test
    void singleMatrix(){
        System.out.println("\n--Test of single matrix--");
        Matrix.singleMatrix(3,3).outputMatrix();
        try{
            System.out.println(Matrix.singleMatrix(2,3));
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    @Test
    void transposeMatrix(){
        System.out.println("\n--Test of transpose--");
        Matrix matrix = new Matrix(3,3);
        matrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("-----");
        matrix.transposeMatrix().outputMatrix();
        System.out.println(matrix + " " + matrix.transposeMatrix());
    }

    @Test
    void supportTest(){
        System.out.println("\n--Test of support--");
        Matrix matrix = new Matrix(3,3);
        Matrix newMatrix = new Immutable(new Matrix(4,4));
        System.out.println(matrix + " " + newMatrix);
    }
}