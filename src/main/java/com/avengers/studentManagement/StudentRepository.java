package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int admnNo){

        return db.get(admnNo);
    }

    public String addStudent(Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student Added";
    }

    public String deleteStudent(int id){
        if(!db.containsKey(id))
            return "Invalid Id";
        db.remove(id);
        return "Student removed successfully";
    }

    public String updateStudent(int id,int age){
        if(!db.containsKey(id))
            return "Invalid id";
        db.get(id).setAge(age);
        return "Age updated successfully";

    }


}
