package LiskovSubstitutionPrinciple;

/*
 * Let Z(x) be a proprety provable about objects x of type T.
 * Then Z(y) should be true for all objects y of type S, where S is a subtype of T.
 * 
 * A covariant is the return type of a method.
 * A contravariant is the input type of a method.
 * 
 * You are also not allowed to strengthen preconditions. 
 *  This means that, if a superclass method accepts an object of type T as a parameter,
 *  and say that no checks are done on T, we are not allowed to add those checks/improve the subclass that is inheriting from the superclass.
 * This is because the when replacing the superclass with the subclass, the subclass might not work, while the superclass might. And this
 * is inconsitency.
 * 
 * In Object-Oriented Analysis (OOA), invariants are used to describe the constraints and rules that must always hold true for an object or class. 
 * They are a key part of defining the behavior of objects and are used to ensure the integrity of the object's data representation
 * 
 * Same goes the other way around.
 * We are not allowed to weaken preconditions.
 * 
*/

import java.util.ArrayList;

public class LiskovSubstitution_Good {
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

    public int calculateArea() {
        return super.getSides().get(0) * super.getSides().get(1);
    }

    public void setArea() {
        this.area = this.calculateArea();
        System.out.println("Area: " + this.area);
    }

}

class Square extends Shapes {
    
    public void setSides(int length) {
        ArrayList<Integer> sides = new ArrayList<Integer>();
        sides.add(length);
        super.setSides(sides);
    }

    public int calculateArea() {
        return super.getSides().get(0) * super.getSides().get(0);
    }

    public void setArea() {
        this.area = this.calculateArea();
        System.out.println("Area: " + this.area);
    }

}

