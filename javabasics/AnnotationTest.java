package javabasics;

class AnnotationA {
    void show() {
        System.out.println("A");
    }
}

class AnnotationB extends AnnotationA {

    void show() {
        System.out.println("B");
    }
}

public class AnnotationTest {
    public static void main(String args[]) {
        short i = 10;
        int j = i;
        AnnotationB annotationB = new AnnotationB();
        annotationB.show();
        //upcasting
        AnnotationA annotationA =  new AnnotationB();
        annotationA.show();
        //downcasting
        AnnotationB annotationB1 = (AnnotationB) annotationA;
    }
}

