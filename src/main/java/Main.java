import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.util.*;
import java.lang.Object;

public class Main {
    public static void main(String[] args) {
        //fill entered element (Immutable)
        Immutable immutable = new Immutable(2,2);
        Immutable newImmutable = immutable.fillImmutElem();
        newImmutable.outputMatrix();
        System.out.println(immutable + " " + newImmutable);

        //fill entered element (Mutable)
//        Matrix matrix = new Immutable(2,2);
//        matrix.fillElem();
//        matrix.outputMatrix();
    }
}
