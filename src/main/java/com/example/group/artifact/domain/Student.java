package com.example.group.artifact.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.example.group.artifact.domain.enumeration.Gender;

import lombok.Data;

@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	private String name;
	
	private String rollNo;
	
	private String contactNo;
	
	private Gender gender;
	
	// private City city;
	
	// private Subject subject;
	
	private Date createdDate;
	
	private Date updatedDate;
	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", contactNo=" + contactNo + ", gender="
                + gender + /* "subject"+ subject+*/ "]";
    }
	
}
