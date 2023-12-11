package LiskovSubstitutionPrinciple;

/*
 * 
 * This is a good example on how not to do LSP.
 * As you can see from the below code, the subclasses take in extra contravariants compared to the superclass.
 * This will cause a issue when trying to declare the superclass as the subclass.
 * 
 */

import java.util.ArrayList;

public class LiskovSubstitution_Bad {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setSides(new ArrayList<Integer>() {{
            add(10);
            add(20);
        }});
        rectangle.setArea();
        System.out.println(rectangle.getArea());

        Square square = new Square();
        square.setSides(10);
        square.setArea();
        System.out.println(square.getArea());

        Shapes shape = new Square();
        shape.setSides(
            new ArrayList<Integer>() {{
                add(10);
            }}
        );
        shape.setArea();
    }
}

class Shapes {

    protected ArrayList<Integer> sides = new ArrayList<Integer>();
    protected int area;
    

    public void setSides(ArrayList<Integer> sides) {
        this.sides = sides;
    }

    public ArrayList<Integer> getSides() {
        return sides;
    }

    public int calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    public void setArea() {
        this.area = calculateArea();
        System.out.println("Area: " + this.area);
    }

    public int getArea() {
        return area;
    }

}

class Rectangle extends Shapes {


    public void setSides(ArrayList<Integer> sides) {
        super.setSides(sides);
    }

    public int calculateArea(int side1, int side2) {
        return side2 * side1;
    }

    public void setArea(int area) {
        this.area = area;
    }

}

class Square extends Shapes {
    
    public void setSides(int length) {
        ArrayList<Integer> sides = new ArrayList<Integer>();
        sides.add(length);
        super.setSides(sides);
    }

    public int calculateArea(int side1, int side2) {
        return side1 * side2;
    }

    public void setArea(int area) {
        this.area = area;
    }

}


