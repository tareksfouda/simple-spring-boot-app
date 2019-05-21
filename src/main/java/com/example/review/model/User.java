package com.example.review.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(nullable = false)
    private String name;
 
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    
    @Column(nullable = true)
    private String major;
    
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;
    
    
 
    public User(String name, String password, List<Role> roles) {
        super();
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}