import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableTest {

    @Test
    void constructorOfEmptyImmutableMatrix() {
        System.out.println("\n--Test of empty Immutable matrix--");
        Immutable immutable = new Immutable();
    }

    @Test
    void constructorOfSelfMadeImmutableMatrix() {
        System.out.println("\n--Test of self-made Immutable matrix--");
        Immutable immutable = new Immutable(2,2);
        System.out.println(immutable);
        try{
            Immutable newImmutable = new Immutable(2, -2);
        } catch (NegativeArraySizeException e){}
    }

    @Test
    void constructorOfCopyMatrix() {
        System.out.println("\n--Test of copy Immutable matrix--");
        Matrix matrix = new Matrix(2,2);
        matrix.fillRandomElem();
        matrix.outputMatrix();
        System.out.println("----");
        Immutable immutable = new Immutable(matrix);
        immutable.outputMatrix();
    }

    @Test
    void constructorCopyOfImmutableMatrix() {
        System.out.println("\n--Test of copy Immutable matrix--");
        Immutable immutable = new Immutable(3,3);
        Immutable newImmutable = new Immutable(immutable);
    }

    @Test
    void fillRandomElemToImmutableMatrix() {
        System.out.println("\n--Test of fill random elem into Immutable matrix--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = immutable.fillImmutRandomElem();
        newImmutable.outputMatrix();
        System.out.println(immutable + " " + newImmutable);
    }

    @Test
    void setElemToImmutableMatrix() {
        System.out.println("\n--Test of set elem into Immutable matrix--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = immutable.fillImmutRandomElem();
        newImmutable.outputMatrix();
        System.out.println("----");
        System.out.println("We set 1 in Row: 0 Colum: 0");
        Immutable anoImmt = newImmutable.setImmutElem(0,0,1);
        anoImmt.outputMatrix();
        System.out.println(newImmutable + " " + anoImmt);
        try{
            anoImmt = newImmutable.setImmutElem(0, -2, 3);
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    @Test
    void takeElemOfImmutableMatrix() {
        try{
            System.out.println("\n--Test of taking elem of Immutable matrix--");
            Matrix matrix = new Matrix(2,2);
            matrix.fillRandomElem();
            matrix.outputMatrix();
            System.out.println("----");
            Immutable immutable = new Immutable(matrix);
            immutable.outputMatrix();
            System.out.println("Elem[0;0]: " + immutable.takeElem(0,0));
            immutable.takeElem(-1,4);
        } catch (ArrayIndexOutOfBoundsException e){}
    }

    @Test
    void takeRowOfImmutableMatrix() {
        System.out.println("\n--Test of taking Row of Immutable matrix--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = immutable.fillImmutRandomElem();
        newImmutable.outputMatrix();
        newImmutable.takeRowImmut(0);
        System.out.println("----");
        for(int i = 0; i < newImmutable.takeRowImmut(0).length; i ++)
            System.out.print(newImmutable.takeRowImmut(0)[i] + " ");
        System.out.println();
        try{
            newImmutable.takeRowImmut(3);
        } catch (ArrayIndexOutOfBoundsException e){}
    }

    @Test
    void takeColumOfImmutableMatrix() {
        System.out.println("\n--Test of taking Colum of Immutable matrix--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = immutable.fillImmutRandomElem();
        newImmutable.outputMatrix();
        newImmutable.takeColumImmut(0);
        System.out.println("----");
        for(int i = 0; i < newImmutable.takeColumImmut(0).length; i ++)
            System.out.print(newImmutable.takeColumImmut(0)[i] + " ");
        System.out.println();
        System.out.println(immutable + " " + newImmutable);
        try{
            newImmutable.takeColumImmut(3);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    @Test
    void takeDimensionOfImmutableMatrix(){
        System.out.println("--Test of dimension--");
        Immutable immutable = new Immutable(2,2);
        immutable.outputMatrix();
        System.out.println("----");
        immutable.takeImmutDimension().forEach((key, value) -> System.out.println(key + " : " +  value));
    }

    @Test
    void equalsMethod(){
        System.out.println("\n--Test of equals--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = new Immutable(immutable);
        System.out.println(immutable + " " + newImmutable + " : " + immutable.equals(newImmutable));
        Immutable anoImmutable = newImmutable.fillImmutRandomElem();
        System.out.println(anoImmutable + " " + newImmutable + " : " +anoImmutable.equals(newImmutable));
    }

    @Test
    void hashCodeMethod(){
        System.out.println("\n--Test of hashCode--");
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = new Immutable(immutable);
        System.out.println(immutable + " " + newImmutable + " : " + immutable.hashCode() + " " + newImmutable.hashCode());
        Immutable anoImmutable = newImmutable.fillImmutRandomElem();
        System.out.println(anoImmutable + " " + newImmutable + " : " + anoImmutable.hashCode() + " " + newImmutable.hashCode());
    }

    @Test
    void singleImmutableMatrix(){
        System.out.println("\n--Test of single matrix--");
        Immutable newImmutable = Immutable.singleImmutMatrix(3,3);
        newImmutable.outputMatrix();
        try {
            Immutable immutable = Immutable.singleImmutMatrix(2,3);
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    @Test
    void transposeImmutableMatrix(){
        System.out.println("\n--Test of transpose--");
        Matrix matrix = new Matrix(3,3);
        matrix.fillRandomElem();
        Immutable immutable = new Immutable(matrix);
        Immutable newImmutable = immutable.fillImmutRandomElem();
        newImmutable.outputMatrix();
        System.out.println("-----");
        Immutable anoImmutable = newImmutable.transposeImmutableMatrix();
        anoImmutable.outputMatrix();
    }
}