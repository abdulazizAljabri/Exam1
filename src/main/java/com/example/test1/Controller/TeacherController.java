package com.example.test1.Controller;

import com.example.test1.ApiRespones.ApiRespones;
import com.example.test1.Model.Teacher;
import com.example.test1.Reposetre.TeacherReposetre;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherReposetre teacherReposetre;


    @GetMapping("/")
    public ArrayList<Teacher> getTeacherList() {
        return teacherReposetre.getAll();
    }

    @PostMapping("/addteacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher , Errors errors) {
        if (errors.hasErrors()) {
            String errormessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
        teacherReposetre.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success addTeacher"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher( @PathVariable String id,@RequestBody @Valid Teacher teacher){
        boolean isUpdate = teacherReposetre.updateStudent(id, teacher);
        if(isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success updateTeacher"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespones("Teacher not found"));
    }

@DeleteMapping("/delteteacher/{id}")
public ResponseEntity removeTeacher(@PathVariable String id) {
    boolean isDelete = teacherReposetre.removeTeacher(id);
    if (isDelete) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success removeTeacher"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespones("Teacher not found"));
}

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable String id) {
       var t =   teacherReposetre.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }
}
