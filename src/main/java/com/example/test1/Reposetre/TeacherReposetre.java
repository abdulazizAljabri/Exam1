package com.example.test1.Reposetre;


import com.example.test1.Model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TeacherReposetre {
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAll() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }


    public Teacher findById(String id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }

    public boolean updateStudent(String id, Teacher teacher) {
        for (Teacher t : teachers) {
            if (t.getId().equals(id)) {
                t.setName(teacher.getName());
                t.setId(teacher.getId());
                t.setSalary(teacher.getSalary());
                return true;
            }
        }
        return false;
    }

//    public void removeTeacher(String id) {
//        for (int index = 0; index < teachers.size(); index++) {
//            if (teachers.get(index).getId().equals(id)) {
//                teachers.remove(index);
//            }
//        }
//    }
    public boolean removeTeacher(String id){
        for (int index = 0; index < teachers.size(); index++){
            if(teachers.get(index).getId().equals(id)){
                teachers.remove(index);
                return true;
            }
        }
        return false;
    }
}
