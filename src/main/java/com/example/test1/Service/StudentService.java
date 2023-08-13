package com.example.test1.Service;
import com.example.test1.Model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class StudentService {

   private ArrayList <Student> students = new ArrayList<Student>();

    public ArrayList<Student> getAll(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public boolean updateStudent(String id,Student student){
        for(Student s : students){
            if(s.getId().equals(id)){
                s.setName(student.getName());
                s.setMajor(student.getMajor());
                s.setAge(student.getAge());
                s.setId(student.getId());
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(String id){
       for (int index = 0; index < students.size(); index++){
           if(students.get(index).getId().equals(id)){
               students.remove(index);
               return true;
           }
       }
       return false;
    }
    public Student findById(String id){
        for(Student student : students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

}
