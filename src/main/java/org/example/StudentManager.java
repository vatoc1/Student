package org.example;

import java.util.*;
import java.util.stream.Collectors;




@FunctionalInterface
interface UpdateStudent {
    public void updateStudent(Student student);
}


public class StudentManager {
    private List<Student> studentsList = new ArrayList<>();

    // hashet for constant time  searching of id

   private  HashSet<Integer> idSet = new HashSet<>();

    public void addStudent(Student student) {
        if(student==null) {
            throw new NullPointerException("parameter cant be null");
        }
        if(idSet.contains(student.getId())) {
            throw new IllegalArgumentException("Student already exists");
        }
        studentsList.add(student);
        idSet.add(student.getId());

    }
    public void deleteStudent(Integer id) {
        if(!idSet.contains(id)) {
            throw new IllegalArgumentException("No such student there");

        }


        studentsList = studentsList.stream().filter((x)-> x.getId()!=id).collect(Collectors.toList());
        idSet.remove(id);

    }

    // passing UpdateStudent functional interface as parameter , because we don't know which parameter client wants to modify , so they pass function as parameter
    public void updateStudent(int id,UpdateStudent update) {
        if(!idSet.contains(id)) {
            throw new IllegalArgumentException("No such student");
        }
        Student student = null;
        for(Student i : studentsList) {
            if(i.getId()==id) {
                student =  i;
            }
        }
        update.updateStudent(student);
    }

    public void displayStudents() {
        studentsList.forEach(System.out::println);
    }

    public Student findStudent(int id)  throws IllegalArgumentException{
        Optional<Student> student = Optional.ofNullable(findHelper(id));
        Student student1 = student.orElseThrow(()-> new IllegalArgumentException("Student doesn't exist "));
        return student1;
    }

    //helper

    private Student findHelper(int id) {
        Student stud = null;
        for(Student i : studentsList) {
            if(i.getId()==id) {
                stud =i;
                break;
            }
        }
        return stud;
    }

}
