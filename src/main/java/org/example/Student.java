package org.example;


import lombok.Getter;
import lombok.Setter;


// used lombok dependency in order to generate getter and setter
@Getter
@Setter

public class Student {
    // for generating unique ID  - s
    private static int sequenceGenerator = 1;
    // id is final so it shouldn't be changed , @Setter annotation will not generate setId() method
    private final int id;
    private String firstName;
    private String lastName;
    private int age;
    private String course;
    public Student(String firstName,String lastName,int age ,String course) {
        id = sequenceGenerator;
        sequenceGenerator++;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age = age;
        this.course=course;



    }


    public String toString() {
        return "ID : " + id + ", firstname : " + firstName + ", lastname : " + lastName + ", age : " + age + " , course : " +course;
    }




}
