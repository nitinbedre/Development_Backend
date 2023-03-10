package com.example.group.artifact.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    
    private String name;

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

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + "]";
    }
    
    
}
