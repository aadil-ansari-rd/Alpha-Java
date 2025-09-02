/*
Problem Name: Parameterized and Copy Constructor in Java
Problem Statement:
-----------------
Write a Java program to demonstrate the use of parameterized and copy constructors 
in a class.

The program should:
1. Define a 'Student' class with two attributes: 'name' (String) and 'age' (int).
2. Implement a parameterized constructor to initialize the attributes.
3. Implement a copy constructor that creates a new Student object by copying 
   the attributes of an existing Student object.
4. In the main method:
   - Create a Student object 's1' using the parameterized constructor.
   - Create another Student object 's2' using the copy constructor with 's1'.
   - Print the attributes of 's2'.
   - Modify 's1' and show that 's2' remains unaffected.

Example:
Input: s1 = ("Aadil", 18)
Output:
Aadil
18
Aadil
18

Explanation:
The copy constructor performs a shallow copy of 's1' into 's2'. Changes to 's1' 
after copying do not affect 's2'.
*/


public class Constructor1{
    public static void main(String[] args){
        Student s1 = new Student("Aadil" , 18);
        Student s2 = new Student(s1);
        System.out.println(s2.name);
        System.out.println(s2.age);
        s1.name = "Rahat";
        s1.age = 24;
        System.out.println(s2.name);
        System.out.println(s2.age);

    }
}


class Student {
    String name;
    int age;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }
}
