package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentservice;



    // get info
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){


        Student student =  studentservice.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    // adding the info
   @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){

        String response = studentservice.addStudent(student);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentservice.deleteStudent(id);

        if(response.equals("Invalid id")){
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(response,HttpStatus.GONE);
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
        String response =  studentservice.updatestudent(id,age);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }
}
