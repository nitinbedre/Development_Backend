package com.example.group.artifact.web.rest;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.group.artifact.domain.Student;
import com.example.group.artifact.services.StudentService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/student")
public class StudentResource {

    @Autowired 
    StudentService studentService;

    public final Logger log = LoggerFactory.getLogger(StudentResource.class);
    @PostMapping("")
    public Student addStudent(@RequestBody Student student) {
        
        Student stud = studentService.addStudent(student);
        return stud;
    }
    
    public void authenticate() {
        // Authenticate auth
    }
    
    @GetMapping("")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    
    @PostMapping("/uploadCSV")
    public ResponseEntity getGreetings(@RequestBody MultipartFile[] files) throws IOException {
        long start = System.currentTimeMillis();
        for(MultipartFile file: files) {
            studentService.uploadFile(file);
        }
        long end = System.currentTimeMillis();
        log.info("Total time {}", (end - start));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
