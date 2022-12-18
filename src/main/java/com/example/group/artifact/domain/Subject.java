package com.example.group.artifact.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    @Column(name="subject_name")
    private String subjectName;
    
    private String teacherName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", subjectName=" + subjectName + ", teacherName=" + teacherName + "]";
    }
    
    
    
}
