package com.example.test1.Controller;

import com.example.test1.ApiRespones.ApiRespones;
import com.example.test1.Model.Student;
import com.example.test1.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ArrayList<Student> getStudent() {
        return studentService.getAll();
    }

    @PostMapping("/addstudent")
    public ResponseEntity addStudent(@RequestBody @Valid Student student,Errors errors) {
        if (errors.hasErrors()) {
            String errormessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success add student"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent( @PathVariable  String id, @RequestBody @Valid Student student){
        boolean isUpdate = studentService.updateStudent(id, student);
        if(isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success update student"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespones("Student not found"));
    }


    @DeleteMapping("/deletstudent/{id}")
    public ResponseEntity removeStudent(@PathVariable String id) {
        boolean isDelete =studentService.removeStudent(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiRespones("success removeStudent"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespones("Student not found"));
    }

    @GetMapping("/findStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        var t =   studentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

}
