/*
Problem Name: Method Overriding and Runtime Polymorphism in Java
Problem Statement:
-----------------
Write a Java program to demonstrate method overriding and runtime polymorphism 
in object-oriented programming.

The program should:
1. Define a 'Parent' class with a method 'print()' that prints "Parent".
2. Define a 'Child' class that extends 'Parent' and overrides the 'print()' 
   method to print "Child".
3. In the main method:
   - Create a 'Parent' reference pointing to a 'Child' object and call 'print()'.
   - Create a 'Parent' object and call 'print()'.
   - Create a 'Child' object and call 'print()'.
4. Observe how the method call resolves at runtime based on the actual object type.

Example Output:
Child
Parent
Child

Explanation:
- The first call demonstrates runtime polymorphism; the actual object type 
  determines which 'print()' method executes.
- The second call calls the method of the 'Parent' class.
- The third call calls the overridden method in 'Child'.
*/


class Parent {

    public void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    public void print() {
        System.out.println("Child");
    }
}

public class OverRide {

    public static void main(String[] args) {
        Parent ref = new Child();
        ref.print();

        Parent ref2 = new Parent();
        ref2.print();

        Child ref3 = new Child();
        ref3.print();

    }

}
