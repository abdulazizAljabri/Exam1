package com.example.test1.Service;

import com.example.test1.Model.Teacher;
import com.example.test1.Reposetre.TeacherReposetre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherReposetre teacherReposetre;


    public ArrayList<Teacher> getTeacher(){
     return teacherReposetre.getAll();
    }
    public void addTeacher(Teacher teacher){
        teacherReposetre.addTeacher(teacher);
    }

    public void removeTeacher(String id){
        teacherReposetre.removeTeacher(id);
    }
    public void findTeacher(String id){
        teacherReposetre.findById(id);
    }

}
