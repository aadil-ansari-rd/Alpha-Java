/*
Problem Name: Deep Copy Constructor in Java
Problem Statement:
-----------------
Write a Java program to demonstrate the difference between shallow and deep 
copying using constructors in a class with array attributes.

The program should:
1. Define a 'Student' class with:
   - 'name' (String)
   - 'marks' (int array of size 3)
2. Implement a parameterized constructor to initialize 'name' and create a new 
   marks array.
3. Implement a copy constructor that performs a deep copy of the 'marks' array 
   to ensure the new object has its own copy of the array.
4. In the main method:
   - Create a Student object 'var1' with initial name and marks.
   - Create another Student object 'var2' using the copy constructor.
   - Print 'var2' name and marks.
   - Modify 'var1' name and marks.
   - Show that 'var2' remains unchanged to verify deep copy.

Example:
Input:
  var1.name = "Aadil"
  var1.marks = [70, 80, 90]
Modify:
  var1.name = "Rahat"
  var1.marks = [40, 50, 60]
Output:
  var2.name = "Aadil"
  var2.marks = 70 80 90

Explanation:
The copy constructor creates a separate copy of the array to prevent changes 
in the original object from affecting the copied object.
*/


public class Constructor2{
    public static void main(String[] args){
        Student s1 = new Student("Aadil" , 18);
        s1.marks[0]=70;
        s1.marks[1]=80;
        s1.marks[2]=90;

        Student s2 = new Student(s1);
        System.out.println(s2.name);
        for(int num : s2.marks){
            System.out.print(num + " ");
        }
        System.out.println();

        s1.name = "Rahat";
        s1.marks[0]=40;
        s1.marks[1]=50;
        s1.marks[2]=60;

        System.out.println(s2.name);
        System.out.println(s2.name);
        for(int num : s2.marks){
            System.out.print(num + " ");
        }
    }
}


class Student {
    String name; int age;
    int[] marks;

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        marks = new int[3];
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        marks = new int[3];
        this.marks = s.marks;
    }
}
