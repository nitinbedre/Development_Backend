package com.example.group.artifact.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.group.artifact.domain.Student;
import com.example.group.artifact.domain.enumeration.Gender;
import com.example.group.artifact.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    
    public Student addStudent(Student student) {
        Student stud = studentRepository.save(student);
        return stud;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Async
    public void uploadFile(MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        List<Student> students = parseCSV(file);
        students = studentRepository.saveAll(students);
        long end = System.currentTimeMillis();
        log.info("time {}", (end - start));
    }

    private List<Student> parseCSV(MultipartFile file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        List<Student> students = new ArrayList<>();
        while((line = reader.readLine()) != null ) {
            String[] data = line.split(",");
            Student student = new Student();
            student.setName(data[0]);
            student.setRollNo(data[1]);
            student.setGender(Gender.MALE);
            student.setContactNo(data[2]);
            students.add(student);
        }
        return students;
    }

}
