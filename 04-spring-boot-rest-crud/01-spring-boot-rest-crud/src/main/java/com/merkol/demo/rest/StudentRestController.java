package com.merkol.demo.rest;

import com.merkol.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    // define @PostConstruct to load the student data ... only one!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Metehan", "ERKOL"));
        theStudents.add(new Student("Abdullah", "ÇETİN"));
        theStudents.add(new Student("Mali", "YAZICI"));
    }
    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list
        if ( (studentId >= theStudents.size() || studentId < 0)) {
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return theStudents.get(studentId);
    }
}
